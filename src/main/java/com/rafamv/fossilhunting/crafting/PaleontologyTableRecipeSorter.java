package com.rafamv.fossilhunting.crafting;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class PaleontologyTableRecipeSorter implements Comparator {
	
	final PaleontologyTableCraftingManager paleontologyTable;
	
	public PaleontologyTableRecipeSorter(PaleontologyTableCraftingManager paleontologyTableCraftingManager) {
		this.paleontologyTable = paleontologyTableCraftingManager;
	}
	
	public int compareRecipes(IRecipe irecipe1, IRecipe irecipe2) {
		return irecipe1 instanceof PaleontologyTableShapelessRecipes && irecipe2 instanceof PaleontologyTableShapedRecipes ? 1: (irecipe2 instanceof PaleontologyTableShapelessRecipes && irecipe1 instanceof PaleontologyTableShapedRecipes ? -1 : (irecipe2.getRecipeSize() < irecipe1.getRecipeSize() ? -1 : (irecipe2.getRecipeSize() > irecipe1.getRecipeSize() ? 1 : 0)));
	}
	
	@Override
	public int compare(Object o1, Object o2) {
		return this.compareRecipes((IRecipe)o1, (IRecipe)o2);
	}
}