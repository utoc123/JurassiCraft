package com.rafamv.fossilhunting.items.fossils;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.rafamv.fossilhunting.FossilHunting;
import com.rafamv.fossilhunting.blocks.FHBlocks;
import com.rafamv.fossilhunting.tileentity.TileEntityEncasedFossilBlock;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EncasedFossil extends AnyFossilItem {
	
	public EncasedFossil() {
		
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(FossilHunting.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
	
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		if (!world.isRemote) {
			if (par7 == 0) {
				--par5;
			}

			if (par7 == 1) {
				++par5;
			}

			if (par7 == 2) {
				--par6;
			}

			if (par7 == 3) {
				++par6;
			}

			if (par7 == 4) {
				--par4;
			}

			if (par7 == 5) {
				++par4;
			}

			if (!player.canPlayerEdit(par4, par5, par6, par7, itemStack)) {
				return false;
			} else {
				if (world.isAirBlock(par4, par5, par6)) {
					world.setBlock(par4, par5, par6, FHBlocks.blockFHEncasedFossilBlock);
					TileEntity tileentity = (TileEntity) world.getTileEntity(par4, par5, par6);
					if (tileentity instanceof TileEntityEncasedFossilBlock) {
						TileEntityEncasedFossilBlock encasedFossil = (TileEntityEncasedFossilBlock) tileentity;
						encasedFossil.setFossilID(itemStack.getItemDamage());
					}
				}
				if (!player.capabilities.isCreativeMode) {
					itemStack.stackSize--;
				}
				return true;
			}
		} else {
			return false;
		}
	}
	
}
