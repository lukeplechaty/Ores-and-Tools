package com.lukeplechaty.ores.items;
import java.util.List;
import com.lukeplechaty.ores.Ores;
import com.lukeplechaty.ores.entity.EntityChunk;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
public class ItemChunk extends Item
{
    private String[] names=new String[]{
    		"chunk_iron",
    		"chunk_gold",
    		"chunk_tin",
    		"chunk_copper",
    		"chunk_silver",
    		"chunk_lead",
    		"chunk_nickel",
    		"chunk_platinum",
    		"chunk_aluminum",
    		"chunk_mithril",
    		"chunk_cobalt",
    		"chunk_ardite",
    		"chunk_yellorium"};
	private IIcon[] textures=new IIcon[names.length];
	public ItemChunk()
	{
		super();
		if(Ores.debug)System.out.println("adding items");
		setUnlocalizedName("itemchunk");
		setCreativeTab(Ores.tabOres);
		setHasSubtypes(true);
		setMaxDamage(0);
	}
	public boolean hasCustomEntity(ItemStack itemstack)
	{
		return true;
	}
	public Entity createEntity(World world,Entity entity,ItemStack itemstack)
	{
		return new EntityChunk(world,(EntityItem)entity,itemstack);
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
