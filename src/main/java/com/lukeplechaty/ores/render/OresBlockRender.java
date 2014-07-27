package com.lukeplechaty.ores.render;
import cpw.mods.fml.client.registry.RenderingRegistry;
public class OresBlockRender
{
	public static int renderPass;
	public static int OverlayRenderType;
	public static void setCustomRenderers()
	{
		OverlayRenderType = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new OverlayRender());
	}
}
