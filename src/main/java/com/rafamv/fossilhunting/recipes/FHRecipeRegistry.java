package com.rafamv.fossilhunting.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.OreDictionary;

import com.rafamv.fossilhunting.blocks.FHBlocks;
import com.rafamv.fossilhunting.items.FHItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class FHRecipeRegistry {
	
	public static void mainRegistry() {
		GameRegistry.addSmelting(FHItems.itemDEXGypsumPowder, new ItemStack(FHItems.itemDEXPlasterPowder, 1), 5);
		GameRegistry.addSmelting(FHBlocks.blockFHGypsumCobblestoneBlock, new ItemStack(FHBlocks.blockFHGypsumBlock, 1), 5);

		GameRegistry.addRecipe(new ItemStack(FHBlocks.blockFHGypsumBrick, 4), new Object[] {"GG ", "GG ", "   ", 'G', FHBlocks.blockFHGypsumBlock});
		GameRegistry.addRecipe(new ItemStack(FHBlocks.blockFHGypsumBrick, 4), new Object[] {" GG", " GG", "   ", 'G', FHBlocks.blockFHGypsumBlock});
		GameRegistry.addRecipe(new ItemStack(FHBlocks.blockFHGypsumBrick, 4), new Object[] {"   ", " GG", " GG", 'G', FHBlocks.blockFHGypsumBlock});
		GameRegistry.addRecipe(new ItemStack(FHBlocks.blockFHGypsumBrick, 4), new Object[] {"   ", "GG ", "GG ", 'G', FHBlocks.blockFHGypsumBlock});
		
		GameRegistry.addRecipe(new ItemStack(FHBlocks.blockFHCleaningTableBlock, 1), new Object[] {"E  ", "SSS", "P P", 'E', FHItems.itemDEXDinosaurEncyclopedia.setContainerItem(FHItems.itemDEXDinosaurEncyclopedia), 'P', Blocks.planks, 'S', Blocks.wooden_slab});
		GameRegistry.addRecipe(new ItemStack(FHBlocks.blockFHCleaningTableBlock, 1), new Object[] {" E ", "SSS", "P P", 'E', FHItems.itemDEXDinosaurEncyclopedia.setContainerItem(FHItems.itemDEXDinosaurEncyclopedia), 'P', Blocks.planks, 'S', Blocks.wooden_slab});
		GameRegistry.addRecipe(new ItemStack(FHBlocks.blockFHCleaningTableBlock, 1), new Object[] {"  E", "SSS", "P P", 'E', FHItems.itemDEXDinosaurEncyclopedia.setContainerItem(FHItems.itemDEXDinosaurEncyclopedia), 'P', Blocks.planks, 'S', Blocks.wooden_slab});
		
		GameRegistry.addShapelessRecipe(new ItemStack(FHBlocks.blockFHCleaningTableBlock, 1), new Object[] {FHBlocks.blockFHPaleontologyTableBlock});
		GameRegistry.addShapelessRecipe(new ItemStack(FHBlocks.blockFHPaleontologyTableBlock, 1), new Object[] {FHBlocks.blockFHCleaningTableBlock});
		
		GameRegistry.addRecipe(new ItemStack(FHBlocks.blockFHBarrelBlock, 1), new Object[] {"PSP", "P P", "PSP", 'P', Blocks.planks, 'S', Blocks.wooden_slab});

		GameRegistry.addRecipe(new ItemStack(FHItems.itemDEXMagnifier, 1), new Object[] {"  G", " I ", "I  ", 'I', Items.iron_ingot, 'G', Blocks.glass});
		GameRegistry.addRecipe(new ItemStack(FHItems.itemDEXMagnifier, 1), new Object[] {"G  ", " I ", "  I", 'I', Items.iron_ingot, 'G', Blocks.glass_pane});
		GameRegistry.addRecipe(new ItemStack(FHItems.itemDEXRockPick, 1), new Object[] {"II ", " SI", "S  ", 'I', Items.iron_ingot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(FHItems.itemDEXRockPick, 1), new Object[] {" II", "IS ", "  S", 'I', Items.iron_ingot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(FHItems.itemDEXSledgeHammer, 1), new Object[] {"ISI", "ISI", " S ", 'I', Items.iron_ingot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(FHItems.itemDEXBrush, 1), new Object[] {"  W", " S ", "S  ", 'W', Blocks.wool, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(FHItems.itemDEXBrush, 1), new Object[] {"W  ", " S ", "   ", 'W', Blocks.wool, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(FHItems.itemDEXBrush, 1), new Object[] {" FF", " SF", "   ", 'F', Items.feather, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(FHItems.itemDEXBrush, 1), new Object[] {"FF ", "FS ", "   ", 'F', Items.feather, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(FHItems.itemDEXBrush, 1), new Object[] {"   ", " FF", " SF", 'F', Items.feather, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(FHItems.itemDEXBrush, 1), new Object[] {"   ", "FF ", "FS ", 'F', Items.feather, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(FHItems.itemDEXChisel, 1), new Object[] {"SI ", "   ", "   ", 'I', Items.iron_ingot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(FHItems.itemDEXChisel, 1), new Object[] {"IS ", "   ", "   ", 'I', Items.iron_ingot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(FHItems.itemDEXChisel, 1), new Object[] {" IS", "   ", "   ", 'I', Items.iron_ingot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(FHItems.itemDEXChisel, 1), new Object[] {" SI", "   ", "   ", 'I', Items.iron_ingot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(FHItems.itemDEXChisel, 1), new Object[] {"   ", "SI ", "   ", 'I', Items.iron_ingot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(FHItems.itemDEXChisel, 1), new Object[] {"   ", "IS ", "   ", 'I', Items.iron_ingot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(FHItems.itemDEXChisel, 1), new Object[] {"   ", " IS", "   ", 'I', Items.iron_ingot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(FHItems.itemDEXChisel, 1), new Object[] {"   ", " SI", "   ", 'I', Items.iron_ingot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(FHItems.itemDEXChisel, 1), new Object[] {"   ", "   ", "SI ", 'I', Items.iron_ingot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(FHItems.itemDEXChisel, 1), new Object[] {"   ", "   ", "IS ", 'I', Items.iron_ingot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(FHItems.itemDEXChisel, 1), new Object[] {"   ", "   ", " IS", 'I', Items.iron_ingot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(FHItems.itemDEXChisel, 1), new Object[] {"   ", "   ", " SI" , 'I', Items.iron_ingot, 'S', Items.stick});
		
		GameRegistry.addShapelessRecipe(new ItemStack(FHItems.itemDEXDinosaurEncyclopedia, 1), new Object[] {FHItems.itemDEXMagnifier, Items.book});
		GameRegistry.addShapelessRecipe(new ItemStack(FHItems.itemDEXGypsumPowder, 2), new Object[] {FHBlocks.blockFHGypsumCobblestoneBlock, new ItemStack(FHItems.itemDEXSledgeHammer, 1, OreDictionary.WILDCARD_VALUE)});
		GameRegistry.addShapelessRecipe(new ItemStack(FHItems.itemDEXBucketWithPlaster, 1), new Object[] {FHItems.itemDEXPlasterPowder, new ItemStack(Items.water_bucket.setContainerItem(null))});
		GameRegistry.addShapelessRecipe(new ItemStack(FHItems.itemDEXPlasterAndBandage, 1), new Object[] {new ItemStack(FHItems.itemDEXBucketWithPlaster.setContainerItem(Items.bucket)), Items.paper});

	}
}


/*
		OLD RECIPE

		GameRegistry.addRecipe(new ItemStack(FHBlocks.blockFHGypsumBrick, 4), new Object[] {"GGG", "GGG", "GGG", 'G', FHBlocks.blockFHGypsumBlock});
		GameRegistry.addRecipe(new ItemStack(FHBlocks.blockFHPaleontologyTableBlock, 1), new Object[] {"ET ", "SSS", "P P", 'E', FHItems.itemDEXDinosaurEncyclopedia.setContainerItem(FHItems.itemDEXDinosaurEncyclopedia), 'T', FHItems.itemDEXBrush, 'P', Blocks.planks, 'S', Blocks.wooden_slab});
		GameRegistry.addRecipe(new ItemStack(FHBlocks.blockFHPaleontologyTableBlock, 1), new Object[] {"E T", "SSS", "P P", 'E', FHItems.itemDEXDinosaurEncyclopedia.setContainerItem(FHItems.itemDEXDinosaurEncyclopedia), 'T', FHItems.itemDEXBrush, 'P', Blocks.planks, 'S', Blocks.wooden_slab});
		GameRegistry.addRecipe(new ItemStack(FHBlocks.blockFHPaleontologyTableBlock, 1), new Object[] {" ET", "SSS", "P P", 'E', FHItems.itemDEXDinosaurEncyclopedia.setContainerItem(FHItems.itemDEXDinosaurEncyclopedia), 'T', FHItems.itemDEXBrush, 'P', Blocks.planks, 'S', Blocks.wooden_slab});
		GameRegistry.addRecipe(new ItemStack(FHBlocks.blockFHPaleontologyTableBlock, 1), new Object[] {"TE ", "SSS", "P P", 'E', FHItems.itemDEXDinosaurEncyclopedia.setContainerItem(FHItems.itemDEXDinosaurEncyclopedia), 'T', FHItems.itemDEXBrush, 'P', Blocks.planks, 'S', Blocks.wooden_slab});
		GameRegistry.addRecipe(new ItemStack(FHBlocks.blockFHPaleontologyTableBlock, 1), new Object[] {"T E", "SSS", "P P", 'E', FHItems.itemDEXDinosaurEncyclopedia.setContainerItem(FHItems.itemDEXDinosaurEncyclopedia), 'T', FHItems.itemDEXBrush, 'P', Blocks.planks, 'S', Blocks.wooden_slab});
		GameRegistry.addRecipe(new ItemStack(FHBlocks.blockFHPaleontologyTableBlock, 1), new Object[] {" TE", "SSS", "P P", 'E', FHItems.itemDEXDinosaurEncyclopedia.setContainerItem(FHItems.itemDEXDinosaurEncyclopedia), 'T', FHItems.itemDEXBrush, 'P', Blocks.planks, 'S', Blocks.wooden_slab});

		GameRegistry.addRecipe(new ItemStack(FHBlocks.blockFHPaleontologyTableBlock, 1), new Object[] {"ET ", "SSS", "P P", 'E', FHItems.itemDEXDinosaurEncyclopedia.setContainerItem(FHItems.itemDEXDinosaurEncyclopedia), 'T', FHItems.itemDEXChisel, 'P', Blocks.planks, 'S', Blocks.wooden_slab});
		GameRegistry.addRecipe(new ItemStack(FHBlocks.blockFHPaleontologyTableBlock, 1), new Object[] {"E T", "SSS", "P P", 'E', FHItems.itemDEXDinosaurEncyclopedia.setContainerItem(FHItems.itemDEXDinosaurEncyclopedia), 'T', FHItems.itemDEXChisel, 'P', Blocks.planks, 'S', Blocks.wooden_slab});
		GameRegistry.addRecipe(new ItemStack(FHBlocks.blockFHPaleontologyTableBlock, 1), new Object[] {" ET", "SSS", "P P", 'E', FHItems.itemDEXDinosaurEncyclopedia.setContainerItem(FHItems.itemDEXDinosaurEncyclopedia), 'T', FHItems.itemDEXChisel, 'P', Blocks.planks, 'S', Blocks.wooden_slab});
		GameRegistry.addRecipe(new ItemStack(FHBlocks.blockFHPaleontologyTableBlock, 1), new Object[] {"TE ", "SSS", "P P", 'E', FHItems.itemDEXDinosaurEncyclopedia.setContainerItem(FHItems.itemDEXDinosaurEncyclopedia), 'T', FHItems.itemDEXChisel, 'P', Blocks.planks, 'S', Blocks.wooden_slab});
		GameRegistry.addRecipe(new ItemStack(FHBlocks.blockFHPaleontologyTableBlock, 1), new Object[] {"T E", "SSS", "P P", 'E', FHItems.itemDEXDinosaurEncyclopedia.setContainerItem(FHItems.itemDEXDinosaurEncyclopedia), 'T', FHItems.itemDEXChisel, 'P', Blocks.planks, 'S', Blocks.wooden_slab});
		GameRegistry.addRecipe(new ItemStack(FHBlocks.blockFHPaleontologyTableBlock, 1), new Object[] {" TE", "SSS", "P P", 'E', FHItems.itemDEXDinosaurEncyclopedia.setContainerItem(FHItems.itemDEXDinosaurEncyclopedia), 'T', FHItems.itemDEXChisel, 'P', Blocks.planks, 'S', Blocks.wooden_slab});

		GameRegistry.addRecipe(new ItemStack(FHBlocks.blockFHCleaningTableBlock, 1), new Object[] {"ET ", "SSS", "P P", 'E', FHItems.itemDEXDinosaurEncyclopedia.setContainerItem(FHItems.itemDEXDinosaurEncyclopedia), 'T', FHItems.itemDEXRockPick, 'P', Blocks.planks, 'S', Blocks.wooden_slab});
		GameRegistry.addRecipe(new ItemStack(FHBlocks.blockFHCleaningTableBlock, 1), new Object[] {"E T", "SSS", "P P", 'E', FHItems.itemDEXDinosaurEncyclopedia.setContainerItem(FHItems.itemDEXDinosaurEncyclopedia), 'T', FHItems.itemDEXRockPick, 'P', Blocks.planks, 'S', Blocks.wooden_slab});
		GameRegistry.addRecipe(new ItemStack(FHBlocks.blockFHCleaningTableBlock, 1), new Object[] {"TE ", "SSS", "P P", 'E', FHItems.itemDEXDinosaurEncyclopedia.setContainerItem(FHItems.itemDEXDinosaurEncyclopedia), 'T', FHItems.itemDEXRockPick, 'P', Blocks.planks, 'S', Blocks.wooden_slab});
		GameRegistry.addRecipe(new ItemStack(FHBlocks.blockFHCleaningTableBlock, 1), new Object[] {" ET", "SSS", "P P", 'E', FHItems.itemDEXDinosaurEncyclopedia.setContainerItem(FHItems.itemDEXDinosaurEncyclopedia), 'T', FHItems.itemDEXRockPick, 'P', Blocks.planks, 'S', Blocks.wooden_slab});
		GameRegistry.addRecipe(new ItemStack(FHBlocks.blockFHCleaningTableBlock, 1), new Object[] {"T E", "SSS", "P P", 'E', FHItems.itemDEXDinosaurEncyclopedia.setContainerItem(FHItems.itemDEXDinosaurEncyclopedia), 'T', FHItems.itemDEXRockPick, 'P', Blocks.planks, 'S', Blocks.wooden_slab});
		GameRegistry.addRecipe(new ItemStack(FHBlocks.blockFHCleaningTableBlock, 1), new Object[] {" TE", "SSS", "P P", 'E', FHItems.itemDEXDinosaurEncyclopedia.setContainerItem(FHItems.itemDEXDinosaurEncyclopedia), 'T', FHItems.itemDEXRockPick, 'P', Blocks.planks, 'S', Blocks.wooden_slab});
		
		GameRegistry.addRecipe(new ItemStack(FHBlocks.blockFHCleaningTableBlock, 1), new Object[] {"ET ", "SSS", "P P", 'E', FHItems.itemDEXDinosaurEncyclopedia.setContainerItem(FHItems.itemDEXDinosaurEncyclopedia), 'T', FHItems.itemDEXSledgeHammer, 'P', Blocks.planks, 'S', Blocks.wooden_slab});
		GameRegistry.addRecipe(new ItemStack(FHBlocks.blockFHCleaningTableBlock, 1), new Object[] {"E T", "SSS", "P P", 'E', FHItems.itemDEXDinosaurEncyclopedia.setContainerItem(FHItems.itemDEXDinosaurEncyclopedia), 'T', FHItems.itemDEXSledgeHammer, 'P', Blocks.planks, 'S', Blocks.wooden_slab});
		GameRegistry.addRecipe(new ItemStack(FHBlocks.blockFHCleaningTableBlock, 1), new Object[] {"TE ", "SSS", "P P", 'E', FHItems.itemDEXDinosaurEncyclopedia.setContainerItem(FHItems.itemDEXDinosaurEncyclopedia), 'T', FHItems.itemDEXSledgeHammer, 'P', Blocks.planks, 'S', Blocks.wooden_slab});
		GameRegistry.addRecipe(new ItemStack(FHBlocks.blockFHCleaningTableBlock, 1), new Object[] {" ET", "SSS", "P P", 'E', FHItems.itemDEXDinosaurEncyclopedia.setContainerItem(FHItems.itemDEXDinosaurEncyclopedia), 'T', FHItems.itemDEXSledgeHammer, 'P', Blocks.planks, 'S', Blocks.wooden_slab});
		GameRegistry.addRecipe(new ItemStack(FHBlocks.blockFHCleaningTableBlock, 1), new Object[] {"T E", "SSS", "P P", 'E', FHItems.itemDEXDinosaurEncyclopedia.setContainerItem(FHItems.itemDEXDinosaurEncyclopedia), 'T', FHItems.itemDEXSledgeHammer, 'P', Blocks.planks, 'S', Blocks.wooden_slab});
		GameRegistry.addRecipe(new ItemStack(FHBlocks.blockFHCleaningTableBlock, 1), new Object[] {" TE", "SSS", "P P", 'E', FHItems.itemDEXDinosaurEncyclopedia.setContainerItem(FHItems.itemDEXDinosaurEncyclopedia), 'T', FHItems.itemDEXSledgeHammer, 'P', Blocks.planks, 'S', Blocks.wooden_slab});
		

*/