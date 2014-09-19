package com.rafamv.fossilhunting;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.rafamv.fossilhunting.blocks.FHBlocks;
import com.rafamv.fossilhunting.entity.FHEntities;
import com.rafamv.fossilhunting.handler.FHCraftingHandler;
import com.rafamv.fossilhunting.handler.FHFossilIDHandler;
import com.rafamv.fossilhunting.items.FHItems;
import com.rafamv.fossilhunting.proxy.ServerProxy;
import com.rafamv.fossilhunting.recipes.FHRecipeRegistry;
import com.rafamv.fossilhunting.world.WorldGenFH;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = FossilHunting.MODID, name = FossilHunting.NAME, version = FossilHunting.VERSION)
public class FossilHunting {

	public static final String MODID = "fossilhunting";
	public static final String VERSION = "Beta v0.8";
	public static final String NAME = "Fossil Hunting";
	public static CreativeTabs fossilHuntingTab;
	public static FHFossilIDHandler fossilIDHandler;

	@Instance(MODID)
	public static FossilHunting instance;

	@SidedProxy(clientSide = "com.rafamv.fossilhunting.proxy.ClientProxy", serverSide = "com.rafamv.fossilhunting.proxy.ServerProxy")
	public static ServerProxy fhProxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent preEvent) {

		fossilHuntingTab = new CreativeTabs("FossilHuntingTab") {
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem() {
				return FHItems.itemFHFossil;
			}
		};

		fossilIDHandler = new FHFossilIDHandler();
		FHBlocks.mainRegistry();
		FHItems.mainRegistry();
		fhProxy.registerRender();
		fhProxy.registerTileEntitySpecialRender();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		GameRegistry.registerWorldGenerator(new WorldGenFH(), 1);
		fhProxy.registerNetwork();
		fhProxy.tileEntityRegistry();
		
		FHRecipeRegistry.mainRegistry();
		FHEntities.mainRegistry();

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent postEvent) {
		FMLCommonHandler.instance().bus().register(new FHCraftingHandler());
	}

}
