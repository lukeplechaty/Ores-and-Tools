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
	public void getSubItems(Item i, CreativeTabs c, List l)
	{
	    for (int x=0;x<names.length;x++)
	    {
	        l.add(new ItemStack(this,1,x));
	    }
	}
	public IIcon getIconFromDamage(int i)
	{
		return textures[i];
	}
	public String getUnlocalizedName(ItemStack i)
	{
		return names[i.getItemDamage()];
	}
	public void registerIcons(IIconRegister register)
	{
	    for (int x=0;x<names.length;x++)
	    {
	    	this.textures[x] = register.registerIcon("ores:"+names[x]);
	    }
	}
}
