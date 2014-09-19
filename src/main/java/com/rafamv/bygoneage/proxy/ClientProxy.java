package com.rafamv.bygoneage.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

import com.rafamv.bygoneage.client.renderer.entity.RenderArsinoitherium;
import com.rafamv.bygoneage.client.renderer.entity.RenderBasilosaurus;
import com.rafamv.bygoneage.client.renderer.entity.RenderDeinotherium;
import com.rafamv.bygoneage.client.renderer.entity.RenderLeptictidium;
import com.rafamv.bygoneage.client.renderer.entity.RenderMammoth;
import com.rafamv.bygoneage.client.renderer.entity.RenderMoeritherium;
import com.rafamv.bygoneage.client.renderer.entity.RenderTitanisWalleri;
import com.rafamv.bygoneage.client.renderer.entity.RenderUintatherium;
import com.rafamv.bygoneage.client.renderer.model.ModelArsinoitherium;
import com.rafamv.bygoneage.client.renderer.model.ModelBasilosaurus;
import com.rafamv.bygoneage.client.renderer.model.ModelDeinotherium;
import com.rafamv.bygoneage.client.renderer.model.ModelLeptictidium;
import com.rafamv.bygoneage.client.renderer.model.ModelMammoth;
import com.rafamv.bygoneage.client.renderer.model.ModelMoeritherium;
import com.rafamv.bygoneage.client.renderer.model.ModelParaceratherium;
import com.rafamv.bygoneage.client.renderer.model.ModelTitanisWalleri;
import com.rafamv.bygoneage.client.renderer.model.ModelUintatherium;
import com.rafamv.bygoneage.client.renderer.tileentity.RenderItemCentrifuge;
import com.rafamv.bygoneage.client.renderer.tileentity.RenderItemDNAExtractor;
import com.rafamv.bygoneage.client.renderer.tileentity.RenderItemHatchery;
import com.rafamv.bygoneage.client.renderer.tileentity.RenderTileEntityCentrifuge;
import com.rafamv.bygoneage.client.renderer.tileentity.RenderTileEntityDNAExtractor;
import com.rafamv.bygoneage.client.renderer.tileentity.RenderTileEntityHatchery;
import com.rafamv.bygoneage.entity.creatures.EntityArsinoitherium;
import com.rafamv.bygoneage.entity.creatures.EntityBasilosaurus;
import com.rafamv.bygoneage.entity.creatures.EntityDeinotherium;
import com.rafamv.bygoneage.entity.creatures.EntityLeptictidium;
import com.rafamv.bygoneage.entity.creatures.EntityMammoth;
import com.rafamv.bygoneage.entity.creatures.EntityMoeritherium;
import com.rafamv.bygoneage.entity.creatures.EntityTitanisWalleri;
import com.rafamv.bygoneage.entity.creatures.EntityUintatherium;
import com.rafamv.bygoneage.registry.BygoneAgeBlocks;
import com.rafamv.bygoneage.tileentity.TileEntityCentrifuge;
import com.rafamv.bygoneage.tileentity.TileEntityDNAExtractor;
import com.rafamv.bygoneage.tileentity.TileEntityHatchery;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRender() {
		RenderingRegistry.registerEntityRenderingHandler(EntityLeptictidium.class, new RenderLeptictidium(new ModelLeptictidium(), 0.4F));
		RenderingRegistry.registerEntityRenderingHandler(EntityMoeritherium.class, new RenderMoeritherium(new ModelMoeritherium(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityUintatherium.class, new RenderUintatherium(new ModelUintatherium(), 0.6F));
		RenderingRegistry.registerEntityRenderingHandler(EntityArsinoitherium.class, new RenderArsinoitherium(new ModelArsinoitherium(), 0.65F));
		RenderingRegistry.registerEntityRenderingHandler(EntityTitanisWalleri.class, new RenderTitanisWalleri(new ModelTitanisWalleri(), 0.50F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBasilosaurus.class, new RenderBasilosaurus(new ModelBasilosaurus(), 0.80F));
		RenderingRegistry.registerEntityRenderingHandler(EntityMammoth.class, new RenderMammoth(new ModelMammoth(), 0.80F));
		RenderingRegistry.registerEntityRenderingHandler(EntityDeinotherium.class, new RenderDeinotherium(new ModelDeinotherium(), 0.80F));
		//RenderingRegistry.registerEntityRenderingHandler(EntityParaceratherium.class, new RenderParaceratherium(new ModelParaceratherium(), 0.80F));

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BygoneAgeBlocks.hatchery), new RenderItemHatchery(new RenderTileEntityHatchery(), new TileEntityHatchery()));
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BygoneAgeBlocks.centrifuge), new RenderItemCentrifuge(new RenderTileEntityCentrifuge(), new TileEntityCentrifuge()));
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BygoneAgeBlocks.dnaExtractor), new RenderItemDNAExtractor(new RenderTileEntityDNAExtractor(), new TileEntityDNAExtractor()));
	}

	@Override
	public void registerTileEntitySpecialRender() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHatchery.class, new RenderTileEntityHatchery());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCentrifuge.class, new RenderTileEntityCentrifuge());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDNAExtractor.class, new RenderTileEntityDNAExtractor());
	}

}
