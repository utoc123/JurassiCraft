package to.uk.ilexiconn.jurassicraft;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import to.uk.ilexiconn.jurassicraft.block.BlockCultivateBottom;
import to.uk.ilexiconn.llib.content.ContentHandler;
import to.uk.ilexiconn.llib.content.ContentType;
import cpw.mods.fml.common.registry.GameRegistry;

@ContentHandler(modid = "jurassicraft", type = ContentType.UNDEFINED)
public class ModRecipes
{
    public void init()
    {
        for (int i = 0; i < BlockCultivateBottom.colors.length; i++)
        {
    		GameRegistry.addSmelting(ModBlocks.gypsumCobblestone, new ItemStack(ModBlocks.gypsumBlock, 1), 5);

            GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.cultivateBottomOff, 1, i), new ItemStack(Items.dye, 1, i), new ItemStack(ModBlocks.cultivateBottomOff));
            GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.cultivateBottomOff, 1, i), "GDG", "GWG", "III", 'I', Items.iron_ingot, 'G', Blocks.glass, 'D', new ItemStack(Items.dye, 1, i), 'W', Items.water_bucket);
    		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.dnaCombinator, 1), "III", "IRI", "III", 'I', Items.iron_ingot, 'R', Items.redstone);
    		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.dnaExtractor, 1), "IIG", "IRG", "III", 'G', Blocks.glass, 'I', Items.iron_ingot, 'R', Items.redstone);
            
    		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.gypsumBrick, 1), "BB", "BB", 'B', ModBlocks.gypsumBlock);

    		GameRegistry.addShapedRecipe(new ItemStack(ModItems.gypsumPowder, 2), "TG", 'T', Items.stone_pickaxe.setContainerItem(Items.stone_pickaxe), 'G', ModBlocks.gypsumCobblestone);
    		GameRegistry.addShapedRecipe(new ItemStack(ModItems.gypsumPowder, 2), "TG", 'T', Items.iron_pickaxe.setContainerItem(Items.iron_pickaxe), 'G', ModBlocks.gypsumCobblestone);
    		GameRegistry.addShapedRecipe(new ItemStack(ModItems.gypsumPowder, 2), "TG", 'T', Items.diamond_pickaxe.setContainerItem(Items.diamond_pickaxe), 'G', ModBlocks.gypsumCobblestone);
    		
    		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.growthSerum, 1), Items.water_bucket.setContainerItem(Items.bucket), new ItemStack(Items.beef, 1),  new ItemStack(Items.bone, 1),  new ItemStack(Items.golden_carrot, 1));
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.growthSerum, 1), Items.water_bucket.setContainerItem(Items.bucket), new ItemStack(Items.fish, 1),  new ItemStack(Items.bone, 1),  new ItemStack(Items.golden_carrot, 1));
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.growthSerum, 1), Items.water_bucket.setContainerItem(Items.bucket), new ItemStack(Items.porkchop, 1),  new ItemStack(Items.bone, 1),  new ItemStack(Items.golden_carrot, 1));
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.growthSerum, 1), Items.water_bucket.setContainerItem(Items.bucket), new ItemStack(Items.chicken, 1),  new ItemStack(Items.bone, 1),  new ItemStack(Items.golden_carrot, 1));
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.growthSerum, 1), Items.water_bucket.setContainerItem(Items.bucket), new ItemStack(Items.cooked_beef, 1),  new ItemStack(Items.bone, 1),  new ItemStack(Items.golden_carrot, 1));
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.growthSerum, 1), Items.water_bucket.setContainerItem(Items.bucket), new ItemStack(Items.cooked_fished, 1),  new ItemStack(Items.bone, 1),  new ItemStack(Items.golden_carrot, 1));
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.growthSerum, 1), Items.water_bucket.setContainerItem(Items.bucket), new ItemStack(Items.cooked_porkchop, 1),  new ItemStack(Items.bone, 1),  new ItemStack(Items.golden_carrot, 1));
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.growthSerum, 1), Items.water_bucket.setContainerItem(Items.bucket), new ItemStack(Items.cooked_chicken, 1),  new ItemStack(Items.bone, 1),  new ItemStack(Items.golden_carrot, 1));
        }
    }
}
