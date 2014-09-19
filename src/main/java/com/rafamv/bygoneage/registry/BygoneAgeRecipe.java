package com.rafamv.bygoneage.registry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class BygoneAgeRecipe {

	public static void registryAll() {
		GameRegistry.addSmelting(new ItemStack(BygoneAgeItems.arsinoitheriumMeatRaw), new ItemStack(BygoneAgeItems.arsinoitheriumMeatCooked), 0.1F);
		GameRegistry.addSmelting(new ItemStack(BygoneAgeItems.uintatheriumMeatRaw), new ItemStack(BygoneAgeItems.uintatheriumMeatCooked), 0.1F);
		GameRegistry.addSmelting(new ItemStack(BygoneAgeItems.titanisThighRaw), new ItemStack(BygoneAgeItems.titanisThighCooked), 0.1F);
		GameRegistry.addSmelting(new ItemStack(BygoneAgeItems.basilosaurusMeatRaw), new ItemStack(BygoneAgeItems.basilosaurusMeatCooked), 0.1F);

		GameRegistry.addShapelessRecipe(new ItemStack(BygoneAgeItems.emptyVial, 1), new Object[] { Items.glass_bottle });
		GameRegistry.addRecipe(new ItemStack(Items.leather_helmet, 1), new Object[] { "LLL", "L L", 'L', BygoneAgeItems.leptictidiumHide });
		GameRegistry.addRecipe(new ItemStack(Items.leather_chestplate, 1), new Object[] { "L L", "LLL", "LLL", 'L', BygoneAgeItems.leptictidiumHide });
		GameRegistry.addRecipe(new ItemStack(Items.leather_leggings, 1), new Object[] { "LLL", "L L", "L L", 'L', BygoneAgeItems.leptictidiumHide });
		GameRegistry.addRecipe(new ItemStack(Items.leather_boots, 1), new Object[] { "L L", "L L", 'L', BygoneAgeItems.leptictidiumHide });
		GameRegistry.addRecipe(new ItemStack(BygoneAgeItems.microship, 4), new Object[] { "IRI", "RGR", "IRI", 'G', Items.gold_ingot, 'I', Items.iron_ingot, 'R', Items.redstone });
		GameRegistry.addRecipe(new ItemStack(BygoneAgeItems.analyzer, 1), new Object[] { " I ", "ICI", " I ", 'I', Items.iron_ingot, 'C', BygoneAgeItems.microship });
		GameRegistry.addRecipe(new ItemStack(BygoneAgeBlocks.hatchery, 1), new Object[] { "GGG", "GGG", "ICI", 'G', Blocks.glass, 'I', Blocks.iron_block, 'C', BygoneAgeItems.microship });
		GameRegistry.addRecipe(new ItemStack(BygoneAgeBlocks.centrifuge, 1), new Object[] { "III", "ICI", "III", 'I', Items.iron_ingot, 'C', BygoneAgeItems.microship });
		GameRegistry.addRecipe(new ItemStack(BygoneAgeBlocks.dnaExtractor, 1), new Object[] { "IIG", "ICG", "III", 'G', Blocks.glass, 'I', Items.iron_ingot, 'C', BygoneAgeItems.microship });
		GameRegistry.addRecipe(new ItemStack(BygoneAgeBlocks.dnaExtractor, 1), new Object[] { "GII", "GCI", "III", 'G', Blocks.glass, 'I', Items.iron_ingot, 'C', BygoneAgeItems.microship });

		GameRegistry.addRecipe(new ItemStack(BygoneAgeItems.appleOnStick, 1), new Object[] { "  S", " SW", "SRW", 'S', Items.stick, 'W', Items.string, 'R', Items.apple });
		GameRegistry.addRecipe(new ItemStack(BygoneAgeItems.appleOnStick, 1), new Object[] { "S  ", "WS ", "WRS", 'S', Items.stick, 'W', Items.string, 'R', Items.apple });
		GameRegistry.addRecipe(new ItemStack(BygoneAgeItems.carrotOnStick, 1), new Object[] { "  S", " SW", "SRW", 'S', Items.stick, 'W', Items.string, 'R', Items.carrot });
		GameRegistry.addRecipe(new ItemStack(BygoneAgeItems.carrotOnStick, 1), new Object[] { "S  ", "WS ", "WRS", 'S', Items.stick, 'W', Items.string, 'R', Items.carrot });
		GameRegistry.addRecipe(new ItemStack(BygoneAgeItems.potatoOnStick, 1), new Object[] { "  S", " SW", "SRW", 'S', Items.stick, 'W', Items.string, 'R', Items.potato });
		GameRegistry.addRecipe(new ItemStack(BygoneAgeItems.potatoOnStick, 1), new Object[] { "S  ", "WS ", "WRS", 'S', Items.stick, 'W', Items.string, 'R', Items.potato });
		GameRegistry.addRecipe(new ItemStack(BygoneAgeItems.wheatOnStick, 1), new Object[] { "  S", " SW", "SRW", 'S', Items.stick, 'W', Items.string, 'R', Items.wheat });
		GameRegistry.addRecipe(new ItemStack(BygoneAgeItems.wheatOnStick, 1), new Object[] { "S  ", "WS ", "WRS", 'S', Items.stick, 'W', Items.string, 'R', Items.wheat });
		GameRegistry.addRecipe(new ItemStack(BygoneAgeItems.beefOnStick, 1), new Object[] { "  S", " SW", "SRW", 'S', Items.stick, 'W', Items.string, 'R', Items.beef });
		GameRegistry.addRecipe(new ItemStack(BygoneAgeItems.beefOnStick, 1), new Object[] { "S  ", "WS ", "WRS", 'S', Items.stick, 'W', Items.string, 'R', Items.beef });
		//GameRegistry.addRecipe(new ItemStack(BygoneAgeItems.fishOnStick, 1), new Object[] { "  S", " SW", "SRW", 'S', Items.stick, 'W', Items.string, 'R', Items.fish });
		//GameRegistry.addRecipe(new ItemStack(BygoneAgeItems.fishOnStick, 1), new Object[] { "S  ", "WS ", "WRS", 'S', Items.stick, 'W', Items.string, 'R', Items.fish });
		GameRegistry.addRecipe(new ItemStack(BygoneAgeItems.porkOnStick, 1), new Object[] { "  S", " SW", "SRW", 'S', Items.stick, 'W', Items.string, 'R', Items.porkchop });
		GameRegistry.addRecipe(new ItemStack(BygoneAgeItems.porkOnStick, 1), new Object[] { "S  ", "WS ", "WRS", 'S', Items.stick, 'W', Items.string, 'R', Items.porkchop });
	}
}
