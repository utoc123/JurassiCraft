package to.uk.ilexiconn.jurassicraft.data;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.Util;
import to.uk.ilexiconn.jurassicraft.data.block.BlockAmberOre;
import to.uk.ilexiconn.jurassicraft.data.block.BlockAnalyzer;
import to.uk.ilexiconn.jurassicraft.data.block.BlockCultivate;
import to.uk.ilexiconn.jurassicraft.data.block.BlockFossilClayOre;
import to.uk.ilexiconn.jurassicraft.data.block.BlockFossilOre;
import to.uk.ilexiconn.jurassicraft.data.block.BlockFossilSandstoneOre;
import to.uk.ilexiconn.jurassicraft.data.block.GhostBlock;
import to.uk.ilexiconn.jurassicraft.data.entity.RenderDinoEgg;
import to.uk.ilexiconn.jurassicraft.data.entity.entity.EntityDinoEgg;
import to.uk.ilexiconn.jurassicraft.data.gui.GuiHandler;
import to.uk.ilexiconn.jurassicraft.data.item.ItemAmber;
import to.uk.ilexiconn.jurassicraft.data.item.ItemDinoBone;
import to.uk.ilexiconn.jurassicraft.data.item.ItemFossil;
import to.uk.ilexiconn.jurassicraft.data.tile.TileAnalyzer;
import to.uk.ilexiconn.jurassicraft.data.tile.TileCultivate;
import to.uk.ilexiconn.jurassicraft.data.tile.render.CultivateRenderer;
import to.uk.ilexiconn.jurassicraft.data.tile.render.CultivateRenderer3D;
import to.uk.ilexiconn.jurassicraft.data.world.gen.WorldGenAmberOre;
import to.uk.ilexiconn.jurassicraft.data.world.gen.WorldGenFossilOre;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public final class Data extends Util
{
    public void init()
    {
    	/** Creativetabs */
        { 
            addCreativeTab(0, new CreativeTabs("fossilTab")
            {
                public Item getTabIconItem()
                {
                    return Item.getItemFromBlock(getBlock(1));
                }
            });
        }
        
    	/** Blocks */
        { 
            addBlockWithTileEntity(0, new BlockCultivate(true), TileCultivate.class, true);
            addBlockWithTileEntity(1, new BlockCultivate(false), TileCultivate.class, false);
            addBlockWithTileEntity(2, new BlockAnalyzer(true), TileAnalyzer.class, true);
            addBlockWithTileEntity(3, new BlockAnalyzer(false), TileAnalyzer.class, false);
            addBlock(4, new BlockAmberOre());
            addBlock(5, new BlockFossilOre());
            addBlock(6, new GhostBlock("cultivate_idle", getBlock(1), 1f, new int[]{-1}, -1, 2, 0f, -1f, 0f, 1f, 1f, 1f).setBlockName("cultivate_top"));
            addBlock(7, new BlockFossilSandstoneOre());
            addBlock(8, new BlockFossilClayOre(""));
            addBlock(9, new BlockFossilClayOre("_stained_brown"));
            addBlock(10, new BlockFossilClayOre("_stained_orange"));
            addBlock(11, new BlockFossilClayOre("_stained_red"));
            addBlock(12, new BlockFossilClayOre("_stained_silver"));
            addBlock(13, new BlockFossilClayOre("_stained_white"));
            addBlock(14, new BlockFossilClayOre("_stained_yellow"));
        }
        
    	/** Items */
        { 
            addItem(1, new ItemAmber());
            addItem(2, new ItemFossil());
            addItem(3, new ItemDinoBone());
        }
        
    	/** Tile entities */
        { 
        }
        
    	/** World Generators */
        { 
            addWorldGenerator(new WorldGenFossilOre(), 1);
            addWorldGenerator(new WorldGenAmberOre(), 2);
        }
        
    	/** Other stuff */
        {
            addGuiHandler(new GuiHandler());
        }
        
       	/** Recipes */
        {
            addShapedRecipe(new ItemStack(getBlock(1)), "GGG", "GCG", "III", 'G', Blocks.glass, 'C', new ItemStack(Items.dye, 1, 2), 'I', Items.iron_ingot);
            addShapedRecipe(new ItemStack(getBlock(3)), "IFI", "IFI", 'I', Items.iron_ingot, 'F', getItem(2));
        }
        
        /** Entities */
        {
        	int entityId = EntityRegistry.findGlobalUniqueEntityId();
			EntityRegistry.registerModEntity(EntityDinoEgg.class, "dino_egg", entityId, JurassiCraft.instance, 64, 1, true);
        }
    }

    @SideOnly(Side.CLIENT)
    public void initClient()
    {
    	/** Block Renderers */
        { 
            addBlockRenderer(TileCultivate.class, new CultivateRenderer());
        }
        
        /** Item Renderers */
        {
            addItemRenderer(Item.getItemFromBlock(getBlock(1)), new CultivateRenderer3D());
        }
        
        /** Entity Renderers */
        {
        	RenderingRegistry.registerEntityRenderingHandler(EntityDinoEgg.class, new RenderDinoEgg());
        }
    }
}
