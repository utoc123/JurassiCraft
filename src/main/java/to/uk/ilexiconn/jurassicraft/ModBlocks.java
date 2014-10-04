package to.uk.ilexiconn.jurassicraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import to.uk.ilexiconn.jurassicraft.block.BlockAmberOre;
import to.uk.ilexiconn.jurassicraft.block.BlockCultivateBottom;
import to.uk.ilexiconn.jurassicraft.block.BlockCultivateTop;
import to.uk.ilexiconn.jurassicraft.block.BlockDNACombinator;
import to.uk.ilexiconn.jurassicraft.block.BlockDNAExtractor;
import to.uk.ilexiconn.jurassicraft.block.BlockDinoPad;
import to.uk.ilexiconn.jurassicraft.block.BlockFossilClayOre;
import to.uk.ilexiconn.jurassicraft.block.BlockFossilOre;
import to.uk.ilexiconn.jurassicraft.block.BlockFossilSandstoneOre;
import to.uk.ilexiconn.jurassicraft.block.BlockGypsumBlock;
import to.uk.ilexiconn.jurassicraft.block.BlockGypsumBrick;
import to.uk.ilexiconn.jurassicraft.block.BlockGypsumCobblestone;
import to.uk.ilexiconn.jurassicraft.block.BlockStuffFluid;
import to.uk.ilexiconn.jurassicraft.item.ItemBlockCultivate;
import to.uk.ilexiconn.jurassicraft.item.ItemBlockFossilClayOre;
import to.uk.ilexiconn.llib.content.ContentHandler;
import to.uk.ilexiconn.llib.content.ContentType;
import to.uk.ilexiconn.llib.content.OverrideRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@ContentHandler(modid = "jurassicraft", type = ContentType.BLOCK)
public class ModBlocks
{
    @OverrideRegistry
    public static Block cultivateBottomOff;
    public static Block cultivateTopOff;
    @OverrideRegistry
    public static Block cultivateBottomOn;
    public static Block cultivateTopOn;
    public static Block dnaExtractor;
    public static Block dnaCombinator;
    public static Block gypsumBlock;
    public static Block gypsumBrick;
    public static Block gypsumCobblestone;
    public static Block amberOre;
    public static Block fossilOre;
    public static Block sandstoneFossilOre;
    public static Block dinoPad;
    @OverrideRegistry
    public static Block clayFossilOre;
    @OverrideRegistry
    public static Fluid cultivateFluid;
    @OverrideRegistry
    public static Block cultivateLiquid;

    public void init()
    {
        new ModCreativeTabs();
        
        cultivateBottomOff = new BlockCultivateBottom(false);
        cultivateTopOff = new BlockCultivateTop(false);
        cultivateBottomOn = new BlockCultivateBottom(true);
        cultivateTopOn = new BlockCultivateTop(true);
        dnaExtractor = new BlockDNAExtractor();
        dnaCombinator = new BlockDNACombinator();
        amberOre = new BlockAmberOre();
        fossilOre = new BlockFossilOre();
        sandstoneFossilOre = new BlockFossilSandstoneOre();
        dinoPad = new BlockDinoPad();
        clayFossilOre = new BlockFossilClayOre();
        gypsumBlock = new BlockGypsumBlock();
        gypsumBrick = new BlockGypsumBrick();
        gypsumCobblestone = new BlockGypsumCobblestone();

        gameRegistry();
    }

    public void gameRegistry()
    {
        GameRegistry.registerBlock(cultivateBottomOff, ItemBlockCultivate.class, "cultivateOff");
        GameRegistry.registerBlock(cultivateBottomOn, ItemBlockCultivate.class, "cultivateOn");
        GameRegistry.registerBlock(clayFossilOre, ItemBlockFossilClayOre.class, "clayFossilOre");

        cultivateFluid = new Fluid("cultivate").setLuminosity(5).setViscosity(1);
        FluidRegistry.registerFluid(cultivateFluid);

        cultivateLiquid = new BlockStuffFluid(cultivateFluid, Material.water).setBlockName("culivateFluid").setCreativeTab(null);
        GameRegistry.registerBlock(cultivateLiquid, "culivateFluid");
    }
}
