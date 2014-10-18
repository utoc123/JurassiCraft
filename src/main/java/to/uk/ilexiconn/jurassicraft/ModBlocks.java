package to.uk.ilexiconn.jurassicraft;

import cpw.mods.fml.common.eventhandler.EventPriority;
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
import to.uk.ilexiconn.jurassicraft.block.fence.BlockSecurityFenceHighBase;
import to.uk.ilexiconn.jurassicraft.block.fence.BlockSecurityFenceHighGrid;
import to.uk.ilexiconn.jurassicraft.block.fence.BlockSecurityFenceHighPole;
import to.uk.ilexiconn.jurassicraft.block.fence.BlockSecurityFenceLowBase;
import to.uk.ilexiconn.jurassicraft.block.fence.BlockSecurityFenceLowGrid;
import to.uk.ilexiconn.jurassicraft.block.fence.BlockSecurityFenceLowPole;
import to.uk.ilexiconn.jurassicraft.block.fence.BlockSecurityFenceMain;
import to.uk.ilexiconn.jurassicraft.block.fence.BlockSecurityFenceMediumBase;
import to.uk.ilexiconn.jurassicraft.block.fence.BlockSecurityFenceMediumGrid;
import to.uk.ilexiconn.jurassicraft.block.fence.BlockSecurityFenceMediumPole;
import to.uk.ilexiconn.jurassicraft.item.ItemBlockCultivate;
import to.uk.ilexiconn.jurassicraft.item.ItemBlockFossilClayOre;
import to.uk.ilexiconn.llib.content.ContentHandler;
import to.uk.ilexiconn.llib.content.ContentType;
import to.uk.ilexiconn.llib.content.OverrideRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@ContentHandler(modid = "jurassicraft", type = ContentType.BLOCK, priority = EventPriority.HIGH)
public class ModBlocks
{

    @OverrideRegistry
    public static Block clayFossilOre;
    @OverrideRegistry
    public static Fluid cultivateFluid;
    @OverrideRegistry
    public static Block cultivateLiquid;
    @OverrideRegistry
    public static Block cultivateBottomOff;
    @OverrideRegistry
    public static Block cultivateBottomOn;
    public static Block cultivateTopOff;
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
    public static Block securityFenceBase;
    public static Block securityFenceLowPole;
    public static Block securityFenceLowBase;
    public static Block securityFenceLowFence;
    public static Block securityFenceMediumPole;
    public static Block securityFenceMediumBase;
    public static Block securityFenceMediumFence;
    public static Block securityFenceHighPole;
    public static Block securityFenceHighBase;
    public static Block securityFenceHighFence;

    public void init()
    {
        cultivateBottomOff = new BlockCultivateBottom(false);
        cultivateTopOff = new BlockCultivateTop(false);
        cultivateBottomOn = new BlockCultivateBottom(true);
        cultivateTopOn = new BlockCultivateTop(true);
        dnaExtractor = new BlockDNAExtractor();
        dnaCombinator = new BlockDNACombinator();
        gypsumBlock = new BlockGypsumBlock();
        gypsumBrick = new BlockGypsumBrick();
        gypsumCobblestone = new BlockGypsumCobblestone();
        amberOre = new BlockAmberOre();
        fossilOre = new BlockFossilOre();
        sandstoneFossilOre = new BlockFossilSandstoneOre();
        clayFossilOre = new BlockFossilClayOre();
        dinoPad = new BlockDinoPad();
        securityFenceBase = new BlockSecurityFenceMain();
        securityFenceLowPole = new BlockSecurityFenceLowPole();
        securityFenceLowBase = new BlockSecurityFenceLowBase();
        securityFenceLowFence = new BlockSecurityFenceLowGrid();
        securityFenceMediumPole = new BlockSecurityFenceMediumPole();
        securityFenceMediumBase = new BlockSecurityFenceMediumBase();
        securityFenceMediumFence = new BlockSecurityFenceMediumGrid();
        securityFenceHighPole = new BlockSecurityFenceHighPole();
        securityFenceHighBase = new BlockSecurityFenceHighBase();
        securityFenceHighFence = new BlockSecurityFenceHighGrid();
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
