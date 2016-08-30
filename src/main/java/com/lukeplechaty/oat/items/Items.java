package com.lukeplechaty.oat.items;
import com.lukeplechaty.oat.Oat;
import com.lukeplechaty.oat.setBlocks;
import com.lukeplechaty.oat.setItems;
import com.lukeplechaty.oat.entity.EntityDynamite;
import com.lukeplechaty.oat.entity.EntityGrenade;
import com.lukeplechaty.oat.entity.EntityRock;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
public class Items extends Item
{
	public Items(String name)
	{
		super();
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Oat.tabOres);
	}
	public boolean showDurabilityBar(ItemStack stack)
	{
		return false;
	}
	@Override
	public EnumActionResult onItemUse(ItemStack itemstack,EntityPlayer EntityPlayer,World world,BlockPos pos,EnumHand hand,EnumFacing facing,float hitX,float hitY,float hitZ)
	{
		if(itemstack.getItem()==setItems.item_seed)
		{
			if(!EntityPlayer.canPlayerEdit(pos,facing,itemstack)||!EntityPlayer.canPlayerEdit(pos.down(),facing,itemstack))
			{
				return EnumActionResult.FAIL;
			}
			Block block=world.getBlockState(pos).getBlock();
			if(block==Blocks.FARMLAND&&world.isAirBlock(pos.up()))
			{
				world.setBlockState(pos.up(),setBlocks.crop.getDefaultState());
				itemstack.stackSize--;
				return EnumActionResult.SUCCESS;
			}
			else
			{
				return EnumActionResult.FAIL;
			}
		}
		return EnumActionResult.FAIL;
	}
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStack, World world, EntityPlayer player, EnumHand hand)
    {
    	if(itemStack.getItem()==setItems.item_rock)
    	{
    		if (!player.capabilities.isCreativeMode)
    		{
    			--itemStack.stackSize;
    		}
    		world.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
    		if (!world.isRemote)
    		{
    			EntityRock entity = new EntityRock(world, player);
    			entity.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
    			world.spawnEntityInWorld(entity);
    		}
    		player.addStat(StatList.getObjectUseStats(this));
    		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStack);
    	}
    	if(itemStack.getItem()==setItems.item_dynamite)
    	{
    		if (!player.capabilities.isCreativeMode)
    		{
    			--itemStack.stackSize;
    		}
    		world.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
    		if (!world.isRemote)
    		{
    			EntityDynamite entity = new EntityDynamite(world, player);
    			entity.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.0F, 1.0F);
    			world.spawnEntityInWorld(entity);
    		}
    		player.addStat(StatList.getObjectUseStats(this));
    		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStack);
    	}
    	if(itemStack.getItem()==setItems.item_grenade)
    	{
    		if (!player.capabilities.isCreativeMode)
    		{
    			--itemStack.stackSize;
    		}
    		world.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
    		if (!world.isRemote)
    		{
    			EntityGrenade entity = new EntityGrenade(world, player);
    			entity.amount=itemStack.getItemDamage();
    			entity.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.0F, 1.0F);
    			world.spawnEntityInWorld(entity);
    		}
    		player.addStat(StatList.getObjectUseStats(this));
    		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStack);
    	}
    	return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemStack);
    }
}