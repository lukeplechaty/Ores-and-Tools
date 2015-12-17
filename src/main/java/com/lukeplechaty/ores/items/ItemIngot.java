package com.lukeplechaty.ores.items;
import java.util.List;
import com.lukeplechaty.ores.Ores;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
public class ItemIngot extends Item
{
    private String[] names=new String[]{
    		"ingot_tin",
    		"ingot_copper",
    		"ingot_silver",
    		"ingot_lead",
    		"ingot_nickel",
    		"ingot_platinum",
    		"ingot_aluminum",
    		"ingot_mithril",
    		"ingot_cobalt",
    		"ingot_ardite",
    		"ingot_yellorium"};
	private IIcon[] textures=new IIcon[names.length];
	public ItemIngot()
	{
		super();
		if(Ores.debug)System.out.println("adding items");
		setUnlocalizedName("itemingot");
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
