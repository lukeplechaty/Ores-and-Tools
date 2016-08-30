package com.lukeplechaty.oat;
import com.lukeplechaty.oat.entity.EntityDynamite;
import com.lukeplechaty.oat.entity.EntityGrenade;
import com.lukeplechaty.oat.entity.EntityRock;
import com.lukeplechaty.oat.render.RenderItem;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
public class setEntites
{
	public static void init(){}
	public static void register()
	{
		EntityRegistry.registerModEntity(EntityRock.class,"entity_rock",0,"oat",15,80,true);
		EntityRegistry.registerModEntity(EntityDynamite.class,"entity_dynamite",1,"oat",15,80,true);
		EntityRegistry.registerModEntity(EntityGrenade.class,"entity_grenade",2,"oat",15,80,true);
	}
	public static void registerRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityRock.class,new RenderItem("item_rock.png"));
		RenderingRegistry.registerEntityRenderingHandler(EntityDynamite.class,new RenderItem("item_dynamite.png"));
		RenderingRegistry.registerEntityRenderingHandler(EntityGrenade.class,new RenderItem("item_grenade.png"));
	}
}
