package com.lukeplechaty.oat.render;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
public class RenderItem implements IRenderFactory<Entity>
{
	protected final String texter;
	public RenderItem(String texter)
	{
		this.texter=texter;
	}
	public Render<Entity> createRenderFor(RenderManager manager)
	{
		return new RenderItems(manager,this.texter);
	}
	class RenderItems extends Render<Entity>
	{
		protected final String texter;
		private final ModelItem itemModel = new ModelItem();
		protected RenderItems(RenderManager renderManager,String texter)
		{
			super(renderManager);
			this.texter=texter;
		}
		protected ResourceLocation getEntityTexture(Entity entity)
		{
			return new ResourceLocation("oat","textures/items/"+this.texter);
		}
		public void doRender(Entity entity, double x, double y, double z, float entityYaw, float partialTicks)
	    {
	        GlStateManager.pushMatrix();
	        this.bindEntityTexture(entity);
	        GlStateManager.translate((float)x, (float)y, (float)z);
	        GlStateManager.enableRescaleNormal();
	        GlStateManager.rotate(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
	        GlStateManager.rotate((float)(this.renderManager.options.thirdPersonView == 2 ? -1 : 1) * this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
	        GlStateManager.rotate(180,0,0,1.0f);
	        GlStateManager.disableRescaleNormal();
			this.itemModel.render(entity,0,0,0,0,0,0.05F);
	        GlStateManager.popMatrix();
	        super.doRender(entity, x, y, z, entityYaw, partialTicks);
	    }
	}
}