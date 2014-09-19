package com.rafamv.fossilhunting.crafting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;

import com.rafamv.fossilhunting.enums.FossilInformation;
import com.rafamv.fossilhunting.items.FHItems;

public class PaleontologyTableCraftingManager {

	private static final PaleontologyTableCraftingManager instance = new PaleontologyTableCraftingManager();
	private List recipes = new ArrayList();

	public static final PaleontologyTableCraftingManager getInstance() {
		return instance;
	}

	private PaleontologyTableCraftingManager() {
		recipes = new ArrayList();
		this.addShapelessRecipe(new ItemStack(FHItems.itemDEXFossilCoronicerasRotiforme, 1),	new Object[] {	new ItemStack(FHItems.itemFHFossil, 1, FossilInformation.CORONICERASROTIFORME.getFossilID())	});
		this.addShapelessRecipe(new ItemStack(FHItems.itemDEXFossilCompsognathus, 1),			new Object[] {	new ItemStack(FHItems.itemFHFossil, 1, FossilInformation.COMPSOGNATHUS.getFossilID())			});
		this.addShapelessRecipe(new ItemStack(FHItems.itemDEXFossilVelociraptor, 1),			new Object[] {	new ItemStack(FHItems.itemFHFossil, 1, FossilInformation.VELOCIRAPTOR.getFossilID()),			new ItemStack(FHItems.itemFHFossil, 1, FossilInformation.VELOCIRAPTOR.getFossilID())		});
		this.addShapelessRecipe(new ItemStack(FHItems.itemDEXFossilTyrannosaurusRex, 1), 		new Object[] {	new ItemStack(FHItems.itemFHFossil, 1, FossilInformation.TYRANNOSAURUSREX.getFossilID()),		new ItemStack(FHItems.itemFHFossil, 1, FossilInformation.TYRANNOSAURUSREX.getFossilID()),	new ItemStack(FHItems.itemFHFossil, 1, FossilInformation.TYRANNOSAURUSREX.getFossilID()),	new ItemStack(FHItems.itemFHFossil, 1, FossilInformation.TYRANNOSAURUSREX.getFossilID())});
		this.addShapelessRecipe(new ItemStack(FHItems.itemDEXFossilStegosaurus, 1), 			new Object[] {	new ItemStack(FHItems.itemFHFossil, 1, FossilInformation.STEGOSAURUS.getFossilID()), 			new ItemStack(FHItems.itemFHFossil, 1, FossilInformation.STEGOSAURUS.getFossilID()), 		new ItemStack(FHItems.itemFHFossil, 1, FossilInformation.STEGOSAURUS.getFossilID())		});
		this.addShapelessRecipe(new ItemStack(FHItems.itemDEXFossilAnkylosaurus, 1), 			new Object[] {	new ItemStack(FHItems.itemFHFossil, 1, FossilInformation.ANKYLOSAURUS.getFossilID()), 		new ItemStack(FHItems.itemFHFossil, 1, FossilInformation.ANKYLOSAURUS.getFossilID()), 	new ItemStack(FHItems.itemFHFossil, 1, FossilInformation.ANKYLOSAURUS.getFossilID())		});
		
		/*
		this.addShapelessRecipe(new ItemStack(FHItems.itemDEXFossilStegosaurus, 1), new Object[] {new ItemStack(FHItems.itemFHFossil, 1, FossilInformation.VELOCIRAPTOR.getFossilID()), new ItemStack(FHItems.itemFHFossil, 1, FossilInformation.VELOCIRAPTOR.getFossilID())});
		this.addShapelessRecipe(new ItemStack(FHItems.itemDEXFossilTyrannosaurusRex, 1), new Object[] {new ItemStack(FHItems.itemFHFossil, 1, FossilInformation.VELOCIRAPTOR.getFossilID()), new ItemStack(FHItems.itemFHFossil, 1, FossilInformation.VELOCIRAPTOR.getFossilID())});
		this.addShapelessRecipe(new ItemStack(FHItems.itemDEXFossilTriceratops, 1), new Object[] {new ItemStack(FHItems.itemFHFossil, 1, FossilInformation.VELOCIRAPTOR.getFossilID()), new ItemStack(FHItems.itemFHFossil, 1, FossilInformation.VELOCIRAPTOR.getFossilID())});
		this.addShapelessRecipe(new ItemStack(FHItems.itemDEXFossilBrachiosaurus, 1), new Object[] {new ItemStack(FHItems.itemFHFossil, 1, FossilInformation.VELOCIRAPTOR.getFossilID()), new ItemStack(FHItems.itemFHFossil, 1, FossilInformation.VELOCIRAPTOR.getFossilID())});
		this.addShapelessRecipe(new ItemStack(FHItems.itemDEXFossilParasaurolophus, 1), new Object[] {new ItemStack(FHItems.itemFHFossil, 1, FossilInformation.VELOCIRAPTOR.getFossilID()), new ItemStack(FHItems.itemFHFossil, 1, FossilInformation.VELOCIRAPTOR.getFossilID())});
		this.addShapelessRecipe(new ItemStack(FHItems.itemDEXFossilAllosaurus, 1), new Object[] {new ItemStack(FHItems.itemFHFossil, 1, FossilInformation.VELOCIRAPTOR.getFossilID()), new ItemStack(FHItems.itemFHFossil, 1, FossilInformation.VELOCIRAPTOR.getFossilID())});
		this.addShapelessRecipe(new ItemStack(FHItems.itemDEXFossilSpinosaurus, 1), new Object[] {new ItemStack(FHItems.itemFHFossil, 1, FossilInformation.VELOCIRAPTOR.getFossilID()), new ItemStack(FHItems.itemFHFossil, 1, FossilInformation.VELOCIRAPTOR.getFossilID())});
		this.addShapelessRecipe(new ItemStack(FHItems.itemDEXFossilDilophosaurus, 1), new Object[] {new ItemStack(FHItems.itemFHFossil, 1, FossilInformation.VELOCIRAPTOR.getFossilID()), new ItemStack(FHItems.itemFHFossil, 1, FossilInformation.VELOCIRAPTOR.getFossilID())});
		this.addShapelessRecipe(new ItemStack(FHItems.itemDEXFossilArchaeopteryx, 1), new Object[] {new ItemStack(FHItems.itemFHFossil, 1, FossilInformation.VELOCIRAPTOR.getFossilID()), new ItemStack(FHItems.itemFHFossil, 1, FossilInformation.VELOCIRAPTOR.getFossilID())});
		this.addShapelessRecipe(new ItemStack(FHItems.itemDEXFossilAnkylosaurus, 1), new Object[] {new ItemStack(FHItems.itemFHFossil, 1, FossilInformation.VELOCIRAPTOR.getFossilID()), new ItemStack(FHItems.itemFHFossil, 1, FossilInformation.VELOCIRAPTOR.getFossilID())});
		*/
		
		Collections.sort(this.recipes, new PaleontologyTableRecipeSorter(this));
	}

	public void addShapelessRecipe(ItemStack par1ItemStack, Object... par2ArrayOfObj) {
		ArrayList arraylist = new ArrayList();
		Object[] aobject = par2ArrayOfObj;
		int i = par2ArrayOfObj.length;

		for (int j = 0; j < i; ++j) {
			Object object1 = aobject[j];

			if (object1 instanceof ItemStack) {
				arraylist.add(((ItemStack) object1).copy());
			} else if (object1 instanceof Item) {
				arraylist.add(new ItemStack((Item) object1));
			} else {
				if (!(object1 instanceof Block)) {
					throw new RuntimeException("Invalid shapeless recipe!");
				}

				arraylist.add(new ItemStack((Block) object1));
			}
		}

		this.recipes.add(new ShapelessRecipes(par1ItemStack, arraylist));
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