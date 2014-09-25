package to.uk.ilexiconn.jurassicraft.data;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.Util;
import to.uk.ilexiconn.jurassicraft.data.block.BlockAmberOre;
import to.uk.ilexiconn.jurassicraft.data.block.BlockCultivateBottom;
import to.uk.ilexiconn.jurassicraft.data.block.BlockCultivateTop;
import to.uk.ilexiconn.jurassicraft.data.block.BlockDNACombinator;
import to.uk.ilexiconn.jurassicraft.data.block.BlockDNAExtractor;
import to.uk.ilexiconn.jurassicraft.data.block.BlockFossilClayOre;
import to.uk.ilexiconn.jurassicraft.data.block.BlockFossilOre;
import to.uk.ilexiconn.jurassicraft.data.block.BlockFossilSandstoneOre;
import to.uk.ilexiconn.jurassicraft.data.block.BlockStuffFluid;
import to.uk.ilexiconn.jurassicraft.data.block.GhostBlock;
import to.uk.ilexiconn.jurassicraft.data.entity.RenderDinoEgg;
import to.uk.ilexiconn.jurassicraft.data.entity.entity.EntityDinoEgg;
import to.uk.ilexiconn.jurassicraft.data.gui.GuiHandler;
import to.uk.ilexiconn.jurassicraft.data.item.ItemAmber;
import to.uk.ilexiconn.jurassicraft.data.item.ItemBlockCultivate;
import to.uk.ilexiconn.jurassicraft.data.item.ItemDinoBone;
import to.uk.ilexiconn.jurassicraft.data.item.ItemFossil;
import to.uk.ilexiconn.jurassicraft.data.tile.TileCultivate;
import to.uk.ilexiconn.jurassicraft.data.tile.TileDNACombinator;
import to.uk.ilexiconn.jurassicraft.data.tile.TileDNAExtractor;
import to.uk.ilexiconn.jurassicraft.data.tile.render.CultivateRenderer;
import to.uk.ilexiconn.jurassicraft.data.tile.render.DNACombinatorRenderer;
import to.uk.ilexiconn.jurassicraft.data.tile.render.DNAExtractorRenderer;
import to.uk.ilexiconn.jurassicraft.data.tile.render.RenderCultivateItem;
import to.uk.ilexiconn.jurassicraft.data.tile.render.RenderDNACombinatorItem;
import to.uk.ilexiconn.jurassicraft.data.tile.render.RenderDNAExtractorItem;
import to.uk.ilexiconn.jurassicraft.data.world.gen.WorldGenAmberOre;
import to.uk.ilexiconn.jurassicraft.data.world.gen.WorldGenFossilOre;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public final class Data extends Util
{
    public static Fluid fluid;
    public static Block stuffFluid;

    public void init()
    {
    	/** Creativetabs */
        { 
            addCreativeTab(0, new CreativeTabs("fossilTab")
            {
                public Item getTabIconItem()
                {
                    return Item.getItemFromBlock(getBlock(0));
                }
            });
        }
        
    	/** Blocks */
        {
            addBlockWithSubBlocks(0, new BlockCultivateBottom(false), TileCultivate.class, ItemBlockCultivate.class, true);
            addBlock(1, new BlockCultivateTop(false));
            addBlockWithSubBlocks(2, new BlockCultivateBottom(true), TileCultivate.class, ItemBlockCultivate.class, false);
            addBlock(3, new BlockCultivateTop(true));
            addBlockWithTileEntity(4, new BlockDNAExtractor(), TileDNAExtractor.class, true);
            addBlockWithTileEntity(5, new BlockDNACombinator(), TileDNACombinator.class, true);
            addBlock(6, new BlockAmberOre());
            addBlock(7, new BlockFossilOre());
            addBlock(8, new GhostBlock("cultivate_idle", getBlock(1), 1f, new int[]{-1}, -1, 2, 0f, -1f, 0f, 1f, 1f, 1f).setBlockName("cultivate_top"));
            addBlock(9, new BlockFossilSandstoneOre());
            addBlock(10, new BlockFossilClayOre(""));
            addBlock(11, new BlockFossilClayOre("_stained_brown"));
            addBlock(12, new BlockFossilClayOre("_stained_orange"));
            addBlock(13, new BlockFossilClayOre("_stained_red"));
            addBlock(14, new BlockFossilClayOre("_stained_silver"));
            addBlock(15, new BlockFossilClayOre("_stained_white"));
            addBlock(16, new BlockFossilClayOre("_stained_yellow"));
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
            addShapedRecipe(new ItemStack(getBlock(3)), "IFI", "IFI", 'I', Items.iron_ingot, 'F', getItem(2));

            for (int i = 0; i < BlockCultivateBottom.colors.length; i++)
            {
                addShapelessRecipe(new ItemStack(getBlock(0), 1, i), new ItemStack(Items.dye, 1, i), new ItemStack(getBlock(0)));
                addShapedRecipe(new ItemStack(getBlock(0), 1, i), "GDG", "GWG", "III", 'I', Items.iron_ingot, 'G', Blocks.glass, 'D', new ItemStack(Items.dye, 1, i), 'W', Items.water_bucket);
            }
        }
        
        /** Entities */
        {
			EntityRegistry.registerModEntity(EntityDinoEgg.class, "dino_egg", Util.entityId, JurassiCraft.instance, 64, 1, true);
        }

        { /** Other test stuff */

            fluid = new Fluid("stuff").setLuminosity(5).setViscosity(1);
            FluidRegistry.registerFluid(fluid);

            stuffFluid = new BlockStuffFluid(fluid, Material.water).setBlockName("stuffBlock").setCreativeTab(null);
            GameRegistry.registerBlock(stuffFluid, "stuffFluid");

            fluid.setUnlocalizedName(stuffFluid.getUnlocalizedName());
        }
    }

    @SideOnly(Side.CLIENT)
    public void initClient()
    {
    	/** Block Renderers */
        { 
            addBlockRenderer(TileCultivate.class, new CultivateRenderer());
            addBlockRenderer(TileDNAExtractor.class, new DNAExtractorRenderer());
            addBlockRenderer(TileDNACombinator.class, new DNACombinatorRenderer());
        }
        
        /** Item Renderers */
        {
            addItemRenderer(Item.getItemFromBlock(getBlock(0)), new RenderCultivateItem());
            addItemRenderer(Item.getItemFromBlock(getBlock(4)), new RenderDNAExtractorItem());
            addItemRenderer(Item.getItemFromBlock(getBlock(5)), new RenderDNACombinatorItem());
        }
        
        /** Entity Renderers */
        {
        	RenderingRegistry.registerEntityRenderingHandler(EntityDinoEgg.class, new RenderDinoEgg());
        }
    }
}
