package to.uk.ilexiconn.jurassicraft;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import to.uk.ilexiconn.jurassicraft.block.BlockCultivateBottom;
import to.uk.ilexiconn.llib.content.ContentHandler;
import to.uk.ilexiconn.llib.content.ContentType;

@ContentHandler(modid = "jurassicraft", type = ContentType.UNDEFINED)
public class ModRecipes
{
    public void init()
    {
        for (int i = 0; i < BlockCultivateBottom.colors.length; i++)
        {
            GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.cultivateBottomOff, 1, i), new ItemStack(Items.dye, 1, i), new ItemStack(ModBlocks.cultivateBottomOff));
            GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.cultivateBottomOff, 1, i), "GDG", "GWG", "III", 'I', Items.iron_ingot, 'G', Blocks.glass, 'D', new ItemStack(Items.dye, 1, i), 'W', Items.water_bucket);
        }
    }
}
