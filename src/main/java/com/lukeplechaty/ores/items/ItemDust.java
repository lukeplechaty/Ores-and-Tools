package com.lukeplechaty.ores.items;
import java.util.List;
import com.lukeplechaty.ores.Ores;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
public class ItemDust extends Item
{
    private String[] names=new String[]{
    		"dust_iron",
    		"dust_gold",
    		"dust_tin",
    		"dust_copper",
    		"dust_silver",
    		"dust_lead",
    		"dust_nickel",
    		"dust_platinum",
    		"dust_aluminum",
    		"dust_mithril",
    		"dust_cobalt",
    		"dust_ardite",
    		"dust_yellorium",
    		"dust_flour",
    		"dust_sodium",
    		"dust_sulfur",
    		"dust_charcoal"};
	private IIcon[] textures=new IIcon[names.length];
	public ItemDust()
	{
		super();
		if(Ores.debug)System.out.println("adding items");
		setUnlocalizedName("itemdust");
		setCreativeTab(Ores.tabOres);
		setHasSubtypes(true);
		setMaxDamage(0);
	}
	public void getSubItems(Item item, CreativeTabs tab, List list)
	{
	    for (int amount=0;amount<names.length;amount++)
	    {
	        list.add(new ItemStack(this,1,amount));
	    }
	}
	public IIcon getIconFromDamage(int meta)
	{
		return textures[meta];
	}
	public String getUnlocalizedName(ItemStack itemStack)
	{
		return names[itemStack.getItemDamage()];
	}
	public void registerIcons(IIconRegister register)
	{
	    for (int amount=0;amount<names.length;amount++)
	    {
	    	this.textures[amount] = register.registerIcon("ores:"+names[amount]);
	    }
	}
}
