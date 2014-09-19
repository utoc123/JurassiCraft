package com.rafamv.fossilhunting.crafting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

import com.rafamv.fossilhunting.enums.FossilInformation;
import com.rafamv.fossilhunting.items.FHItems;

public class CleaningTableCraftingManager {

	private static final CleaningTableCraftingManager instance = new CleaningTableCraftingManager();
	private List recipes = new ArrayList();

	public static final CleaningTableCraftingManager getInstance() {
		return instance;
	}

	private CleaningTableCraftingManager() {
		recipes = new ArrayList();
		for (int fossilID = 0; fossilID <= FossilInformation.values().length; fossilID++) {
			this.addRecipe(new ItemStack(FHItems.itemDEXCoveredFossil, 1, fossilID), new Object[] { "T", "F", 'T', new ItemStack(FHItems.itemDEXRockPick, 1, OreDictionary.WILDCARD_VALUE), 'F', new ItemStack(FHItems.itemDEXEncasedFossil, 1, fossilID)});
			this.addRecipe(new ItemStack(FHItems.itemFHFossil, 1, fossilID), new Object[] { "T", "F", 'T', new ItemStack(FHItems.itemDEXChisel, 1, OreDictionary.WILDCARD_VALUE), 'F', new ItemStack(FHItems.itemDEXCoveredFossil, 1, fossilID)});
			this.addRecipe(new ItemStack(FHItems.itemFHFossil, 1, fossilID), new Object[] { "T", "F", 'T', new ItemStack(FHItems.itemDEXBrush, 1, OreDictionary.WILDCARD_VALUE), 'F', new ItemStack(FHItems.itemDEXCoveredFossil, 1, fossilID)});
		}
		Collections.sort(this.recipes, new CleaningTableRecipeSorter(this));
	}

	public CleaningTableShapedRecipes addRecipe(ItemStack par1ItemStack, Object... par2ArrayOfObj) {
		String s = "";
		int i = 0;
		int j = 0;
		int k = 0;

		if (par2ArrayOfObj[i] instanceof String[]) {
			String[] astring = (String[]) ((String[]) par2ArrayOfObj[i++]);

			for (int l = 0; l < astring.length; ++l) {
				String s1 = astring[l];
				++k;
				j = s1.length();
				s = s + s1;
			}
		} else {
			while (par2ArrayOfObj[i] instanceof String) {
				String s2 = (String) par2ArrayOfObj[i++];
				++k;
				j = s2.length();
				s = s + s2;
			}
		}

		HashMap hashmap;

		for (hashmap = new HashMap(); i < par2ArrayOfObj.length; i += 2) {
			Character character = (Character) par2ArrayOfObj[i];
			ItemStack itemstack1 = null;

			if (par2ArrayOfObj[i + 1] instanceof Item) {
				itemstack1 = new ItemStack((Item) par2ArrayOfObj[i + 1]);
			} else if (par2ArrayOfObj[i + 1] instanceof Block) {
				itemstack1 = new ItemStack((Block) par2ArrayOfObj[i + 1], 1, 32767);
			} else if (par2ArrayOfObj[i + 1] instanceof ItemStack) {
				itemstack1 = (ItemStack) par2ArrayOfObj[i + 1];
			}

			hashmap.put(character, itemstack1);
		}

		ItemStack[] aitemstack = new ItemStack[j * k];

		for (int i1 = 0; i1 < j * k; ++i1) {
			char c0 = s.charAt(i1);

			if (hashmap.containsKey(Character.valueOf(c0))) {
				aitemstack[i1] = ((ItemStack) hashmap.get(Character.valueOf(c0))).copy();
			} else {
				aitemstack[i1] = null;
			}
		}

		CleaningTableShapedRecipes shapedrecipes = new CleaningTableShapedRecipes(j, k, aitemstack, par1ItemStack);
		this.recipes.add(shapedrecipes);
		return shapedrecipes;
	}

	public ItemStack findMatchingRecipe(InventoryCrafting par1InventoryCrafting, World par2World) {
		int i = 0;
		ItemStack itemstack = null;
		ItemStack itemstack1 = null;
		int j;

		for (j = 0; j < par1InventoryCrafting.getSizeInventory(); ++j) {
			ItemStack itemstack2 = par1InventoryCrafting.getStackInSlot(j);

			if (itemstack2 != null) {
				if (i == 0) {
					itemstack = itemstack2;
				}

				if (i == 1) {
					itemstack1 = itemstack2;
				}

				++i;
			}
		}

		if (i == 2 && itemstack.getItem() == itemstack1.getItem() && itemstack.stackSize == 1 && itemstack1.stackSize == 1 && itemstack.getItem().isRepairable()) {
			Item item = itemstack.getItem();
			int j1 = item.getMaxDamage() - itemstack.getItemDamageForDisplay();
			int k = item.getMaxDamage() - itemstack1.getItemDamageForDisplay();
			int l = j1 + k + item.getMaxDamage() * 5 / 100;
			int i1 = item.getMaxDamage() - l;

			if (i1 < 0) {
				i1 = 0;
			}

			return new ItemStack(itemstack.getItem(), 1, i1);
		} else {
			for (j = 0; j < this.recipes.size(); ++j) {
				IRecipe irecipe = (IRecipe) this.recipes.get(j);

				if (irecipe.matches(par1InventoryCrafting, par2World)) {
					return irecipe.getCraftingResult(par1InventoryCrafting);
				}
			}

			return null;
		}
	}

	public List getRecipeList() {
		return this.recipes;
	}

}