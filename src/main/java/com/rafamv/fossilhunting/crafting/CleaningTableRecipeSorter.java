package com.rafamv.fossilhunting.crafting;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class CleaningTableRecipeSorter implements Comparator {
	
	final CleaningTableCraftingManager cleaningTable;
	
	public CleaningTableRecipeSorter(CleaningTableCraftingManager cleaningTableCraftingManager) {
		this.cleaningTable = cleaningTableCraftingManager;
	}
	
	public int compareRecipes(IRecipe irecipe1, IRecipe irecipe2) {
		return irecipe1 instanceof CleaningTableShapelessRecipes && irecipe2 instanceof CleaningTableShapedRecipes ? 1: (irecipe2 instanceof CleaningTableShapelessRecipes && irecipe1 instanceof CleaningTableShapedRecipes ? -1 : (irecipe2.getRecipeSize() < irecipe1.getRecipeSize() ? -1 : (irecipe2.getRecipeSize() > irecipe1.getRecipeSize() ? 1 : 0)));
	}
	
	@Override
	public int compare(Object o1, Object o2) {
		return this.compareRecipes((IRecipe)o1, (IRecipe)o2);
	}
}