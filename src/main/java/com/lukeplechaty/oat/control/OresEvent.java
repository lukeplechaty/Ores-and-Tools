package com.lukeplechaty.oat.control;
import com.lukeplechaty.oat.setBlocks;
import com.lukeplechaty.oat.setItems;
import com.lukeplechaty.oat.blocks.BlockFlax;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
public class OresEvent
{
	@SubscribeEvent
	public void bonemealUsed(BonemealEvent event)
	{
		if(event.getWorld().getBlockState(event.getPos())==setBlocks.crop)
		{
			((BlockFlax)setBlocks.crop).grow(event.getWorld(),event.getPos(),event.getBlock());
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
				if(item.getItem()==setItems.mortarandpestle)
				{
					ItemStack newitem=new ItemStack(setItems.mortarandpestle,2,item.getItemDamage()+1);
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