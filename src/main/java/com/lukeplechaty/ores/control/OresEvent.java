package com.lukeplechaty.ores.control;
import com.lukeplechaty.ores.Ores;
import com.lukeplechaty.ores.blocks.BlockFlax;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.BonemealEvent;
public class OresEvent
{
	@SubscribeEvent
	public void bonemealUsed(BonemealEvent event)
	{
		if(Ores.debug)System.out.println("adding event bonemeal");
		if(event.world.getBlock(event.x,event.y,event.z)==Ores.crop)
		{
			((BlockFlax)Ores.crop).fertilize(event.world,event.x,event.y,event.z);
		}
	}
	@SubscribeEvent
	public void onPlayerItemCrafted(ItemCraftedEvent event)
	{
		for(int slot=0;slot<event.craftMatrix.getSizeInventory();slot++)
		{
			ItemStack item=event.craftMatrix.getStackInSlot(slot);
			if(item!=null)
			{
				if(item.getItem()==Ores.mortarandpestle)
				{
					ItemStack newitem=new ItemStack(Ores.mortarandpestle,2,item.getItemDamage()+1);
					if(newitem.getItemDamage()>=newitem.getMaxDamage())
					{
						newitem.stackSize--;
					}
					event.craftMatrix.setInventorySlotContents(slot,newitem);
				}
			}
		}
	}
	
}