package to.uk.ilexiconn.jurassicraft;

import to.uk.ilexiconn.jurassicraft.tile.TileCultivate;
import to.uk.ilexiconn.jurassicraft.tile.TileDNACombinator;
import to.uk.ilexiconn.jurassicraft.tile.TileDNAExtractor;
import to.uk.ilexiconn.jurassicraft.tile.TileDinoPad;
import to.uk.ilexiconn.jurassicraft.tile.TileEgg;
import to.uk.ilexiconn.jurassicraft.tile.TileSecurityFence;
import to.uk.ilexiconn.jurassicraft.tile.TileSecurityFenceHighBase;
import to.uk.ilexiconn.jurassicraft.tile.TileSecurityFenceHighGrid;
import to.uk.ilexiconn.jurassicraft.tile.TileSecurityFenceHighPole;
import to.uk.ilexiconn.jurassicraft.tile.TileSecurityFenceLowBase;
import to.uk.ilexiconn.jurassicraft.tile.TileSecurityFenceLowGrid;
import to.uk.ilexiconn.jurassicraft.tile.TileSecurityFenceLowPole;
import to.uk.ilexiconn.jurassicraft.tile.TileSecurityFenceMediumBase;
import to.uk.ilexiconn.jurassicraft.tile.TileSecurityFenceMediumGrid;
import to.uk.ilexiconn.jurassicraft.tile.TileSecurityFenceMediumPole;
import to.uk.ilexiconn.llib.content.ContentHandler;
import to.uk.ilexiconn.llib.content.ContentType;
import cpw.mods.fml.common.registry.GameRegistry;

@ContentHandler(modid = "jurassicraft", type = ContentType.TILEENTITY)
public class ModTileEntities
{
    public void init()
    {
    	GameRegistry.registerTileEntity(TileDNACombinator.class, "jurassicraft:dna_combinator");
    	GameRegistry.registerTileEntity(TileDNAExtractor.class, "jurassicraft:dna_extractor");
    	GameRegistry.registerTileEntity(TileCultivate.class, "jurassicraft:cultivator");
    	GameRegistry.registerTileEntity(TileEgg.class, "jurassicraft:tile_egg");
    	GameRegistry.registerTileEntity(TileDinoPad.class, "jurassicraft:dino_pad");
    	GameRegistry.registerTileEntity(TileSecurityFence.class, "jurassicraft:securityFenceBase");
    	GameRegistry.registerTileEntity(TileSecurityFenceHighBase.class, "jurassicraft:BlockSecurityFenceHighBase");
    	GameRegistry.registerTileEntity(TileSecurityFenceHighGrid.class, "jurassicraft:BlockSecurityFenceHighGrid");
    	GameRegistry.registerTileEntity(TileSecurityFenceHighPole.class, "jurassicraft:BlockSecurityFenceHighPole");
    	GameRegistry.registerTileEntity(TileSecurityFenceMediumBase.class, "jurassicraft:BlockSecurityFenceMediumBase");
    	GameRegistry.registerTileEntity(TileSecurityFenceMediumGrid.class, "jurassicraft:BlockSecurityFenceMediumGrid");
    	GameRegistry.registerTileEntity(TileSecurityFenceMediumPole.class, "jurassicraft:BlockSecurityFenceMediumPole");
    	GameRegistry.registerTileEntity(TileSecurityFenceLowBase.class, "jurassicraft:BlockSecurityFenceLowBase");
    	GameRegistry.registerTileEntity(TileSecurityFenceLowGrid.class, "jurassicraft:BlockSecurityFenceLowGrid");
    	GameRegistry.registerTileEntity(TileSecurityFenceLowPole.class, "jurassicraft:BlockSecurityFenceLowPole");
    }
}
