package com.lukeplechaty.oat.control;
import com.lukeplechaty.oat.Oat;
import com.lukeplechaty.oat.setBlocks;
import com.lukeplechaty.oat.setEntites;
import com.lukeplechaty.oat.setItems;
import com.lukeplechaty.oat.blocks.BlockFlax;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;

@Mod.EventBusSubscriber
public class Events
{
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	{
		setBlocks.register(event.getRegistry());
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		setItems.register(event.getRegistry());
		setBlocks.registerItemBlocks(event.getRegistry());
	}
	
	@SubscribeEvent
	public static void registerEntities(RegistryEvent.Register<EntityEntry> event)
	{
		setEntites.register(event.getRegistry());
	}
	
	@SubscribeEvent
	public static void registerModel(ModelRegistryEvent event)
	{
		Oat.proxy.init();
	}
	
	@SubscribeEvent
	public void bonemealUsed(BonemealEvent event)
	{
		if(event.getWorld().getBlockState(event.getPos()) == setBlocks.crop)
		{
			((BlockFlax)setBlocks.crop).grow(event.getWorld(), event.getPos(), event.getBlock());
		}
	}
	
	@SubscribeEvent
	public void onPlayerItemCrafted(ItemCraftedEvent event)
	{
		for(int slot = 0; slot < event.craftMatrix.getSizeInventory(); slot++)
		{
			ItemStack item = event.craftMatrix.getStackInSlot(slot);
			if(item != null)
			{
				if(item.getItem() == setItems.mortar_and_pestle)
				{
					ItemStack newitem = new ItemStack(setItems.mortar_and_pestle, 2, item.getItemDamage() + 1);
					if(newitem.getItemDamage() >= newitem.getMaxDamage())
					{
						newitem.shrink(1);
					}
					event.craftMatrix.setInventorySlotContents(slot, newitem);
				}
			}
		}
	}
}
