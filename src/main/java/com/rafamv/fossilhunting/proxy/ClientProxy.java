package com.rafamv.fossilhunting.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

import com.rafamv.fossilhunting.blocks.FHBlocks;
import com.rafamv.fossilhunting.client.renderer.tileentity.RenderItemBarrel;
import com.rafamv.fossilhunting.client.renderer.tileentity.RenderItemCleaningTable;
import com.rafamv.fossilhunting.client.renderer.tileentity.RenderItemEncasedFossil;
import com.rafamv.fossilhunting.client.renderer.tileentity.RenderItemPaleontologyTable;
import com.rafamv.fossilhunting.client.renderer.tileentity.RenderTileEntityBarrel;
import com.rafamv.fossilhunting.client.renderer.tileentity.RenderTileEntityCleaningTable;
import com.rafamv.fossilhunting.client.renderer.tileentity.RenderTileEntityEncasedFossil;
import com.rafamv.fossilhunting.client.renderer.tileentity.RenderTileEntityPaleontologyTable;
import com.rafamv.fossilhunting.client.renderer.tileentity.fossils.RenderFossilAllosaurus;
import com.rafamv.fossilhunting.client.renderer.tileentity.fossils.RenderFossilAnkylosaurus;
import com.rafamv.fossilhunting.client.renderer.tileentity.fossils.RenderFossilArchaeopteryx;
import com.rafamv.fossilhunting.client.renderer.tileentity.fossils.RenderFossilBrachiosaurus;
import com.rafamv.fossilhunting.client.renderer.tileentity.fossils.RenderFossilCompsognathus;
import com.rafamv.fossilhunting.client.renderer.tileentity.fossils.RenderFossilCoronicerasRotiforme;
import com.rafamv.fossilhunting.client.renderer.tileentity.fossils.RenderFossilParasaurolophus;
import com.rafamv.fossilhunting.client.renderer.tileentity.fossils.RenderFossilPlesiosaurus;
import com.rafamv.fossilhunting.client.renderer.tileentity.fossils.RenderFossilSpinosaurus;
import com.rafamv.fossilhunting.client.renderer.tileentity.fossils.RenderFossilStegosaurus;
import com.rafamv.fossilhunting.client.renderer.tileentity.fossils.RenderFossilTriceratops;
import com.rafamv.fossilhunting.client.renderer.tileentity.fossils.RenderFossilTyrannosaurusRex;
import com.rafamv.fossilhunting.client.renderer.tileentity.fossils.RenderFossilVelociraptor;
import com.rafamv.fossilhunting.items.FHItems;
import com.rafamv.fossilhunting.tileentity.TileEntityBarrel;
import com.rafamv.fossilhunting.tileentity.TileEntityCleaningTable;
import com.rafamv.fossilhunting.tileentity.TileEntityEncasedFossilBlock;
import com.rafamv.fossilhunting.tileentity.TileEntityPaleontologyTable;
import com.rafamv.fossilhunting.tileentity.fossils.TileEntityFossilAllosaurus;
import com.rafamv.fossilhunting.tileentity.fossils.TileEntityFossilAnkylosaurus;
import com.rafamv.fossilhunting.tileentity.fossils.TileEntityFossilArchaeopteryx;
import com.rafamv.fossilhunting.tileentity.fossils.TileEntityFossilBrachiosaurus;
import com.rafamv.fossilhunting.tileentity.fossils.TileEntityFossilCompsognathus;
import com.rafamv.fossilhunting.tileentity.fossils.TileEntityFossilCoronicerasRotiforme;
import com.rafamv.fossilhunting.tileentity.fossils.TileEntityFossilParasaurolophus;
import com.rafamv.fossilhunting.tileentity.fossils.TileEntityFossilPlesiosaurus;
import com.rafamv.fossilhunting.tileentity.fossils.TileEntityFossilSpinosaurus;
import com.rafamv.fossilhunting.tileentity.fossils.TileEntityFossilStegosaurus;
import com.rafamv.fossilhunting.tileentity.fossils.TileEntityFossilTriceratops;
import com.rafamv.fossilhunting.tileentity.fossils.TileEntityFossilTyrannosaurusRex;
import com.rafamv.fossilhunting.tileentity.fossils.TileEntityFossilVelociraptor;

import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends ServerProxy {

	@Override
	public void registerRender() {
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(FHBlocks.blockFHBarrelBlock), new RenderItemBarrel(new RenderTileEntityBarrel(), new TileEntityBarrel()));
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(FHBlocks.blockFHCleaningTableBlock), new RenderItemCleaningTable(new RenderTileEntityCleaningTable(), new TileEntityCleaningTable()));
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(FHBlocks.blockFHPaleontologyTableBlock), new RenderItemPaleontologyTable(new RenderTileEntityPaleontologyTable(), new TileEntityPaleontologyTable()));
		MinecraftForgeClient.registerItemRenderer(FHItems.itemDEXEncasedFossil, new RenderItemEncasedFossil(new RenderTileEntityEncasedFossil(), new TileEntityEncasedFossilBlock()));
	}

	@Override
	public void registerTileEntitySpecialRender() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFossilAllosaurus.class, new RenderFossilAllosaurus());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFossilAnkylosaurus.class, new RenderFossilAnkylosaurus());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFossilArchaeopteryx.class, new RenderFossilArchaeopteryx());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFossilBrachiosaurus.class, new RenderFossilBrachiosaurus());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFossilParasaurolophus.class, new RenderFossilParasaurolophus());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFossilSpinosaurus.class, new RenderFossilSpinosaurus());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFossilStegosaurus.class, new RenderFossilStegosaurus());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFossilTriceratops.class, new RenderFossilTriceratops());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFossilTyrannosaurusRex.class, new RenderFossilTyrannosaurusRex());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFossilPlesiosaurus.class, new RenderFossilPlesiosaurus());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFossilCompsognathus.class, new RenderFossilCompsognathus());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFossilCoronicerasRotiforme.class, new RenderFossilCoronicerasRotiforme());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFossilVelociraptor.class, new RenderFossilVelociraptor());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBarrel.class, new RenderTileEntityBarrel());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCleaningTable.class, new RenderTileEntityCleaningTable());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPaleontologyTable.class, new RenderTileEntityPaleontologyTable());
	}

}
