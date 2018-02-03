package com.lukeplechaty.oat;
import com.lukeplechaty.oat.entity.EntityDynamite;
import com.lukeplechaty.oat.entity.EntityGrenade;
import com.lukeplechaty.oat.entity.EntityRock;
import com.lukeplechaty.oat.render.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.registries.IForgeRegistry;

public class setEntites
{
	public static void init()
	{}
	
	public static void register(IForgeRegistry<EntityEntry> event)
	{
		ModelResourceLocation res0 = new ModelResourceLocation(EntityRock.GetRegistryName(), "entity");
		EntityEntry entry0 = EntityEntryBuilder.create().entity(EntityRock.class).id(res0, 0).name(EntityRock.GetRegistryName()).tracker(15, 80, true).build();
		ModelResourceLocation res1 = new ModelResourceLocation(EntityGrenade.GetRegistryName(), "entity");
		EntityEntry entry1 = EntityEntryBuilder.create().entity(EntityGrenade.class).id(res1, 1).name(EntityGrenade.GetRegistryName()).tracker(15, 80, true).build();
		ModelResourceLocation res2 = new ModelResourceLocation(EntityDynamite.GetRegistryName(), "entity");
		EntityEntry entry2 = EntityEntryBuilder.create().entity(EntityDynamite.class).id(res2, 2).name(EntityDynamite.GetRegistryName()).tracker(15, 80, true).build();
		event.registerAll(entry0, entry1, entry2);
	}
	
	public static void registerRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityRock.class, new RenderItem("item_rock.png"));
		RenderingRegistry.registerEntityRenderingHandler(EntityDynamite.class, new RenderItem("item_dynamite.png"));
		RenderingRegistry.registerEntityRenderingHandler(EntityGrenade.class, new RenderItem("item_grenade.png"));
	}
}
