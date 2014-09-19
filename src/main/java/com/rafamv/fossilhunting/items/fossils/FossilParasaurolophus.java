package com.rafamv.fossilhunting.items.fossils;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.rafamv.fossilhunting.FossilHunting;
import com.rafamv.fossilhunting.blocks.FHBlocks;
import com.rafamv.fossilhunting.enums.FossilInformation;
import com.rafamv.fossilhunting.tileentity.fossils.TileEntityFossil;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FossilParasaurolophus extends AnyFossilItemModel {

	public FossilParasaurolophus() {

	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(FossilHunting.MODID + ":" + FossilInformation.ANKYLOSAURUS.getIconName());
	}

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10) {
		if (!world.isRemote) {
			if (par7 == 0) {
				--y;
			}

			if (par7 == 1) {
				++y;
			}

			if (par7 == 2) {
				--z;
			}

			if (par7 == 3) {
				++z;
			}

			if (par7 == 4) {
				--x;
			}

			if (par7 == 5) {
				++x;
			}

			if (!player.canPlayerEdit(x, y, z, par7, itemStack)) {
				return false;
			} else {
				int posX = FossilInformation.ANKYLOSAURUS.getXBound();
				int posZ = FossilInformation.ANKYLOSAURUS.getZBound();
				int direction = MathHelper.floor_double(player.rotationYaw * 4.0F / 360.0F + 0.5D);
				if (direction == 0) {
					posX = FossilInformation.ANKYLOSAURUS.getXBound();
					posZ = FossilInformation.ANKYLOSAURUS.getZBound();
					System.out.println("Direction 0 (South): " + direction);
					if (checkPlacementAtSouthBetween(world, itemStack, x, y, z, posX, posZ)) {
						placeGhostBlocksAtSouthBetween(world, itemStack, x, y, z, posX, posZ);
						world.setBlock(x, y, z, FHBlocks.blockFHFossilModelAnkylosaurus);
						TileEntity tileentity = (TileEntity) world.getTileEntity(x, y, z);
						if (tileentity instanceof TileEntityFossil) {
							TileEntityFossil fossil = (TileEntityFossil) tileentity;
							setInformation(world, player, itemStack, x, y, z, fossil);
						} else {
							return false;
						}
					} else {
						return false;
					}
				} else if (direction == 1) {
					posX = FossilInformation.ANKYLOSAURUS.getZBound();
					posZ = FossilInformation.ANKYLOSAURUS.getXBound();
					System.out.println("Direction 1 (West): " + direction);
					if (checkPlacementAtWestBetween(world, itemStack, x, y, z, posX, posZ)) {
						placeGhostBlocksAtWestBetween(world, itemStack, x, y, z, posX, posZ);
						world.setBlock(x, y, z, FHBlocks.blockFHFossilModelAnkylosaurus);
						TileEntity tileentity = (TileEntity) world.getTileEntity(x, y, z);
						if (tileentity instanceof TileEntityFossil) {
							TileEntityFossil fossil = (TileEntityFossil) tileentity;
							setInformation(world, player, itemStack, x, y, z, fossil);
						} else {
							return false;
						}
					} else {
						return false;
					}
				} else if (direction == 2) {
					posX = FossilInformation.ANKYLOSAURUS.getXBound();
					posZ = FossilInformation.ANKYLOSAURUS.getZBound();
					System.out.println("Direction 2 (North): " + direction);
					if (checkPlacementAtNorthBetween(world, itemStack, x, y, z, posX, posZ)) {
						placeGhostBlocksAtNorthBetween(world, itemStack, x, y, z, posX, posZ);
						world.setBlock(x, y, z, FHBlocks.blockFHFossilModelAnkylosaurus);
						TileEntity tileentity = (TileEntity) world.getTileEntity(x, y, z);
						if (tileentity instanceof TileEntityFossil) {
							TileEntityFossil fossil = (TileEntityFossil) tileentity;
							setInformation(world, player, itemStack, x, y, z, fossil);
						} else {
							return false;
						}
					} else {
						return false;
					}
				} else if (direction == 3) {
					posX = FossilInformation.ANKYLOSAURUS.getZBound();
					posZ = FossilInformation.ANKYLOSAURUS.getXBound();
					System.out.println("Direction 3 (East): " + direction);
					if (checkPlacementAtEastBetween(world, itemStack, x, y, z, posX, posZ)) {
						placeGhostBlocksAtEastBetween(world, itemStack, x, y, z, posX, posZ);
						world.setBlock(x, y, z, FHBlocks.blockFHFossilModelAnkylosaurus);
						TileEntity tileentity = (TileEntity) world.getTileEntity(x, y, z);
						if (tileentity instanceof TileEntityFossil) {
							TileEntityFossil fossil = (TileEntityFossil) tileentity;
							setInformation(world, player, itemStack, x, y, z, fossil);
						} else {
							return false;
						}
					} else {
						return false;
					}
				} else {
					return false;
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

	public void setInformation(World world, EntityPlayer player, ItemStack itemStack, int x, int y, int z, TileEntityFossil fossil) {
		if (!itemStack.hasTagCompound()) {
			fossil.setFossilDataFirstTime(world, x, y, z, player, FossilInformation.ANKYLOSAURUS.getFossilID(), 0.75D, 0.9D);
		} else {
			fossil = (TileEntityFossil) setFossilDataFromItem(world, x, y, z, player, itemStack, fossil);
		}
	}

}
