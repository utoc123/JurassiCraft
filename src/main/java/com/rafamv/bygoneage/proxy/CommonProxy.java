package com.rafamv.bygoneage.proxy;

import com.rafamv.bygoneage.tileentity.TileEntityCentrifuge;
import com.rafamv.bygoneage.tileentity.TileEntityDNAExtractor;
import com.rafamv.bygoneage.tileentity.TileEntityHatchery;

import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {

	public void registerRender() {

	}

	public void registerTileEntitySpecialRender() {

	}

	public void tileEntityRegistry() {
		GameRegistry.registerTileEntity(TileEntityHatchery.class, "TileEntityHatchery");
		GameRegistry.registerTileEntity(TileEntityCentrifuge.class, "TileEntityCentrifuge");
		GameRegistry.registerTileEntity(TileEntityDNAExtractor.class, "TileEntityDNAExtractor");
	}

}
