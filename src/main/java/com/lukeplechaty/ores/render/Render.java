package com.lukeplechaty.ores.render;
import cpw.mods.fml.client.registry.RenderingRegistry;
public class Render
{
	public static int OreBlockRenderPass;
	public static int BlockOverlayRenderID;
	public static void setCustomRenderers()
	{
		BlockOverlayRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new BlockOverlayRender());
	}
}
