package to.uk.ilexiconn.jurassicraft;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import to.uk.ilexiconn.jurassicraft.data.block.BlockCultivateBottom;
import to.uk.ilexiconn.jurassicraft.data.block.BlockCultivateTop;
import to.uk.ilexiconn.jurassicraft.data.item.ItemBlockCultivate;
import to.uk.ilexiconn.llib.content.ContentHandler;
import to.uk.ilexiconn.llib.content.ContentType;
import to.uk.ilexiconn.llib.content.OverrideRegistry;

@ContentHandler(modid = "jurassicraft", type = ContentType.BLOCK)
public class ModBlocks
{
    @OverrideRegistry
    public static Block cultivateBottomOff;
    public static Block cultivateTopOff;
    @OverrideRegistry
    public static Block cultivateBottomOn;
    public static Block cultivateTopOn;

    public void init()
    {
        cultivateBottomOff = new BlockCultivateBottom(false);
        cultivateTopOff = new BlockCultivateTop(false);
        cultivateBottomOn = new BlockCultivateBottom(true);
        cultivateTopOn = new BlockCultivateTop(true);

        gameRegistry();
    }

    public void gameRegistry()
    {
        GameRegistry.registerBlock(cultivateBottomOff, ItemBlockCultivate.class, "cultivateOff");
        GameRegistry.registerBlock(cultivateBottomOn, ItemBlockCultivate.class, "cultivateOn");
    }
}
