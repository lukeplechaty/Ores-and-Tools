package com.lukeplechaty.oat.render;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelItem extends ModelBase
{
	public ModelRenderer Renderer;
	
	public ModelItem()
	{
		this.textureWidth = 16;
		this.textureHeight = 16;
		this.Renderer = new ModelRenderer(this, 0, 0);
		this.Renderer.addBox(-8, -8, -8, 16, 16, 0, 0);
	}
	
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
	{
		this.Renderer.render(scale);
	}
}
