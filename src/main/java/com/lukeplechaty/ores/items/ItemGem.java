package com.lukeplechaty.ores.items;
import java.util.List;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import com.lukeplechaty.ores.Ores;
public class ItemGem extends Item
{
    private String[] names=new String[]{
    		"gem_certus_quartz",
    		"gem_sapphire",
    		"gem_ruby",
    		"gem_peridot"};
	private IIcon[] textures=new IIcon[names.length];
	public ItemGem()
	{
		super();
		if(Ores.debug)System.out.println("adding items");
		setUnlocalizedName("itemgem");
		setCreativeTab(Ores.tabOres);
		setHasSubtypes(true);
		setMaxDamage(0);
	}
	public void getSubItems(Item item, CreativeTabs tab, List list)
	{
	    for (int amount=0;amount<textures.length;amount++)
	    {
	        list.add(new ItemStack(this,1,amount));
	    }
	}
	public IIcon getIconFromDamage(int i)
	{
		return textures[i];
	}
	public String getUnlocalizedName(ItemStack itemStack)
	{
		return names[itemStack.getItemDamage()];
	}
	public void registerIcons(IIconRegister register)
	{
	    for (int amount=0;amount<textures.length;amount++)
	    {
	    	this.textures[amount] = register.registerIcon("ores:"+names[amount]);
	    }
	}
}