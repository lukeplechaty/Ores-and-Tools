package com.lukeplechaty.ores.render;
import org.lwjgl.opengl.GL11;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
public class BlockOverlayRender implements ISimpleBlockRenderingHandler
{
	public void renderInventoryBlock(Block block,int metadata,int modelId,RenderBlocks renderer)
	{
		drawAll(block,renderer,metadata);
	}
	private void drawAll(Block block,RenderBlocks renderer,int metadata)
	{
		Tessellator tessellator=Tessellator.instance;
		GL11.glPushMatrix();
		GL11.glTranslatef(-0.5F,-0.5F,-0.5F);
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F,-1.0F,0.0F);
		renderer.renderFaceYNeg(block,0.0D,0.0D,0.0D,renderer.getBlockIconFromSideAndMetadata(Blocks.stone,0,metadata));
		renderer.renderFaceYNeg(block,0.0D,0.0D,0.0D,renderer.getBlockIconFromSideAndMetadata(block,0,metadata));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F,1.0F,0.0F);
		renderer.renderFaceYPos(block,0.0D,0.0D,0.0D,renderer.getBlockIconFromSideAndMetadata(Blocks.stone,1,metadata));
		renderer.renderFaceYPos(block,0.0D,0.0D,0.0D,renderer.getBlockIconFromSideAndMetadata(block,1,metadata));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F,0.0F,-1.0F);
		renderer.renderFaceXNeg(block,0.0D,0.0D,0.0D,renderer.getBlockIconFromSideAndMetadata(Blocks.stone,2,metadata));
		renderer.renderFaceXNeg(block,0.0D,0.0D,0.0D,renderer.getBlockIconFromSideAndMetadata(block,2,metadata));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F,0.0F,1.0F);
		renderer.renderFaceXPos(block,0.0D,0.0D,0.0D,renderer.getBlockIconFromSideAndMetadata(Blocks.stone,3,metadata));
		renderer.renderFaceXPos(block,0.0D,0.0D,0.0D,renderer.getBlockIconFromSideAndMetadata(block,3,metadata));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(-1.0F,0.0F,0.0F);
		renderer.renderFaceZNeg(block,0.0D,0.0D,0.0D,renderer.getBlockIconFromSideAndMetadata(Blocks.stone,4,metadata));
		renderer.renderFaceZNeg(block,0.0D,0.0D,0.0D,renderer.getBlockIconFromSideAndMetadata(block,4,metadata));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(1.0F,0.0F,0.0F);
		renderer.renderFaceZPos(block,0.0D,0.0D,0.0D,renderer.getBlockIconFromSideAndMetadata(Blocks.stone,5,metadata));
		renderer.renderFaceZPos(block,0.0D,0.0D,0.0D,renderer.getBlockIconFromSideAndMetadata(block,5,metadata));
		tessellator.draw();
		GL11.glTranslatef(0.5F,0.5F,0.5F);
		GL11.glPopMatrix();
	}
	public boolean renderWorldBlock(IBlockAccess world,int x,int y,int z,Block block,int modelId,RenderBlocks renderer)
	{
		if(Render.OreBlockRenderPass==0)
		{
			renderer.renderStandardBlock(Blocks.stone,x,y,z);
		}
		else
		{
			renderer.renderStandardBlock(block,x,y,z);
		}
		return true;
	}
	public boolean shouldRender3DInInventory(int modelId)
	{
		return true;
	}
	public int getRenderId()
	{
		return Render.BlockOverlayRenderID;
	}
	
}
