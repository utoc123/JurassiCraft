package com.rafamv.fossilhunting.proxy;

import com.rafamv.fossilhunting.FossilHunting;
import com.rafamv.fossilhunting.handler.FHGuiHandler;
import com.rafamv.fossilhunting.tileentity.TileEntityBarrel;
import com.rafamv.fossilhunting.tileentity.TileEntityCleaningTable;
import com.rafamv.fossilhunting.tileentity.TileEntityEncasedFossilBlock;
import com.rafamv.fossilhunting.tileentity.TileEntityGhostBlock;
import com.rafamv.fossilhunting.tileentity.TileEntityPaleontologyTable;
import com.rafamv.fossilhunting.tileentity.fossils.TileEntityFossilAllosaurus;
import com.rafamv.fossilhunting.tileentity.fossils.TileEntityFossilAnkylosaurus;
import com.rafamv.fossilhunting.tileentity.fossils.TileEntityFossilArchaeopteryx;
import com.rafamv.fossilhunting.tileentity.fossils.TileEntityFossilBrachiosaurus;
import com.rafamv.fossilhunting.tileentity.fossils.TileEntityFossilCompsognathus;
import com.rafamv.fossilhunting.tileentity.fossils.TileEntityFossilCoronicerasRotiforme;
import com.rafamv.fossilhunting.tileentity.fossils.TileEntityFossilDilophosaurus;
import com.rafamv.fossilhunting.tileentity.fossils.TileEntityFossilParasaurolophus;
import com.rafamv.fossilhunting.tileentity.fossils.TileEntityFossilPlesiosaurus;
import com.rafamv.fossilhunting.tileentity.fossils.TileEntityFossilSpinosaurus;
import com.rafamv.fossilhunting.tileentity.fossils.TileEntityFossilStegosaurus;
import com.rafamv.fossilhunting.tileentity.fossils.TileEntityFossilTriceratops;
import com.rafamv.fossilhunting.tileentity.fossils.TileEntityFossilTyrannosaurusRex;
import com.rafamv.fossilhunting.tileentity.fossils.TileEntityFossilVelociraptor;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ServerProxy {
	
	public void registerRender() {
		
	}
	
	public void registerTileEntitySpecialRender() {
		
	}

	public void registerNetwork(){
		NetworkRegistry.INSTANCE.registerGuiHandler(FossilHunting.instance, new FHGuiHandler());
	}
	
	public void tileEntityRegistry() {
		GameRegistry.registerTileEntity(TileEntityBarrel.class, "BarrelTileEntity");
		GameRegistry.registerTileEntity(TileEntityPaleontologyTable.class, "PaleontologyTableTileEntity");
		GameRegistry.registerTileEntity(TileEntityCleaningTable.class, "CleaningTableTileEntity");
		GameRegistry.registerTileEntity(TileEntityEncasedFossilBlock.class, "EncasedFossilBlockTileEntity");
		GameRegistry.registerTileEntity(TileEntityGhostBlock.class, "TileEntityGhostBlock");
		GameRegistry.registerTileEntity(TileEntityFossilAllosaurus.class, "TileEntityFossilAllosaurus");
		GameRegistry.registerTileEntity(TileEntityFossilAnkylosaurus.class, "TileEntityFossilAnkylosaurus");
		GameRegistry.registerTileEntity(TileEntityFossilArchaeopteryx.class, "TileEntityFossilArchaeopteryx");
		GameRegistry.registerTileEntity(TileEntityFossilBrachiosaurus.class, "TileEntityFossilBrachiosaurus");
		GameRegistry.registerTileEntity(TileEntityFossilCompsognathus.class, "TileEntityFossilCompsognathus");
		GameRegistry.registerTileEntity(TileEntityFossilCoronicerasRotiforme.class, "TileEntityFossilCoronicerasRotiforme");
		GameRegistry.registerTileEntity(TileEntityFossilDilophosaurus.class, "TileEntityFossilDilophosaurus");
		GameRegistry.registerTileEntity(TileEntityFossilParasaurolophus.class, "TileEntityFossilParasaurolophus");
		GameRegistry.registerTileEntity(TileEntityFossilPlesiosaurus.class, "TileEntityFossilPlesiosaurus");
		GameRegistry.registerTileEntity(TileEntityFossilSpinosaurus.class, "TileEntityFossilSpinosaurus");
		GameRegistry.registerTileEntity(TileEntityFossilStegosaurus.class, "TileEntityFossilStegosaurus");
		GameRegistry.registerTileEntity(TileEntityFossilTriceratops.class, "TileEntityFossilTriceratops");
		GameRegistry.registerTileEntity(TileEntityFossilTyrannosaurusRex.class, "TileEntityFossilTyrannosaurusRex");
		GameRegistry.registerTileEntity(TileEntityFossilVelociraptor.class, "TileEntityFossilVelociraptor");

	}
}
