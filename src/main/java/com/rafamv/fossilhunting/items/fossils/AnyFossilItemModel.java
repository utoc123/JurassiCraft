package com.rafamv.fossilhunting.items.fossils;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.rafamv.fossilhunting.FossilHunting;
import com.rafamv.fossilhunting.blocks.FHBlocks;
import com.rafamv.fossilhunting.enums.FossilInformation;
import com.rafamv.fossilhunting.tileentity.TileEntityGhostBlock;
import com.rafamv.fossilhunting.tileentity.fossils.TileEntityFossil;

public class AnyFossilItemModel extends Item {

	public AnyFossilItemModel() {
		this.setMaxStackSize(1);
		this.setCreativeTab(FossilHunting.fossilHuntingTab);
	}

	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean flag) {
		if (itemStack.hasTagCompound()) {
			if (itemStack.getTagCompound().hasKey("fossilID")) {
				if ((itemStack.getTagCompound().hasKey("tilted")) && (itemStack.getTagCompound().hasKey("year"))) {
					if (itemStack.getTagCompound().getBoolean("tilted")) {
						list.add(FossilInformation.getChatColor(FossilInformation.values()[itemStack.getTagCompound().getByte("fossilID")].getDiet()) + "Angled, " + String.valueOf(itemStack.getTagCompound().getDouble("year")) + " MYA");
					} else {
						list.add(FossilInformation.getChatColor(FossilInformation.values()[itemStack.getTagCompound().getByte("fossilID")].getDiet()) + "Horizontal, " + String.valueOf(itemStack.getTagCompound().getDouble("year")) + " MYA");
					}
				} else {
					if (itemStack.getTagCompound().hasKey("tilted")) {
						if (itemStack.getTagCompound().getBoolean("tilted")) {
							list.add(FossilInformation.getChatColor(FossilInformation.values()[itemStack.getTagCompound().getByte("fossilID")].getDiet()) + "Angled" + String.valueOf(itemStack.getTagCompound().getDouble("year")) + " MYA");
						} else {
							list.add(FossilInformation.getChatColor(FossilInformation.values()[itemStack.getTagCompound().getByte("fossilID")].getDiet()) + "Horizontal, " + String.valueOf(itemStack.getTagCompound().getDouble("year")) + " MYA");
						}
					}
					if (itemStack.getTagCompound().hasKey("year")) {
						list.add(FossilInformation.getChatColor(FossilInformation.values()[itemStack.getTagCompound().getByte("fossilID")].getDiet()) + String.valueOf(itemStack.getTagCompound().getDouble("year")) + " MYA");
					}
				}
			}
		} else {
			list.add(EnumChatFormatting.GRAY + "Not defined yet");
		}
	}

	public TileEntityFossil setFossilDataFromItem(World world, int x, int y, int z, EntityPlayer player, ItemStack itemStack, TileEntityFossil fossil) {
		if (itemStack.getTagCompound() != null) {
			if (itemStack.getTagCompound().hasKey("fossilID")) {
				fossil.setFossilID(itemStack.getTagCompound().getByte("fossilID"));
			}
			if (itemStack.getTagCompound().hasKey("year")) {
				fossil.setYearOfExistence(itemStack.getTagCompound().getDouble("year"));
			}
			if (itemStack.getTagCompound().hasKey("tilted")) {
				fossil.setTilted(itemStack.getTagCompound().getBoolean("tilted"));
			}
			if (itemStack.getTagCompound().hasKey("length")) {
				fossil.setLength(itemStack.getTagCompound().getDouble("length"));
			}
			if (itemStack.getTagCompound().hasKey("height")) {
				fossil.setHeight(itemStack.getTagCompound().getDouble("height"));
			}
			if (itemStack.getTagCompound().hasKey("weight")) {
				fossil.setWeight(itemStack.getTagCompound().getDouble("weight"));
			}
			switch (MathHelper.floor_double(player.rotationYaw * 4.0F / 360.0F + 0.5D)) {
				case 0:
					fossil.setForgeDirection(ForgeDirection.SOUTH.ordinal());
					break;
				case 1:
					fossil.setForgeDirection(ForgeDirection.WEST.ordinal());
					break;
				case 2:
					fossil.setForgeDirection(ForgeDirection.NORTH.ordinal());
					break;
				case 3:
					fossil.setForgeDirection(ForgeDirection.EAST.ordinal());
					break;
				default:
					fossil.setForgeDirection(ForgeDirection.SOUTH.ordinal());
			}
			return fossil;
		} else {
			return null;
		}
	}

	protected boolean checkPlacementAtNorthBetween(World world, ItemStack itemStack, int x, int y, int z, int posX, int posZ) {
		if (itemStack.hasTagCompound()) {
			if (itemStack.getTagCompound().getBoolean("tilted")) {
				for (int i = 1; i <= posX; i++) {
					for (int j = 1; j <= 2; j++) {
						for (int k = 1; k <= posZ; k++) {
							if (!world.isAirBlock((x - i + 1), (y + j - 1), (z - k + 1))) {
								return false;
							}
						}
					}
				}
			} else {
				for (int i = 1; i <= posX; i++) {
					for (int j = 1; j <= 1; j++) {
						for (int k = 1; k <= posZ; k++) {
							if (!world.isAirBlock((x - i + 1), (y + j - 1), (z - k + 1))) {
								return false;
							}
						}
					}
				}
			}
		} else {
			for (int i = 1; i <= posX; i++) {
				for (int j = 1; j <= 1; j++) {
					for (int k = 1; k <= posZ; k++) {
						if (!world.isAirBlock((x - i + 1), (y + j - 1), (z - k + 1))) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	protected void placeGhostBlocksAtNorthBetween(World world, ItemStack itemStack, int x, int y, int z, int posX, int posZ) {
		if (itemStack.hasTagCompound()) {
			if (itemStack.getTagCompound().hasKey("tilted")) {
				if (itemStack.getTagCompound().getBoolean("tilted")) {
					for (int i = 1; i <= posX; i++) {
						for (int j = 1; j <= 2; j++) {
							for (int k = 1; k <= posZ; k++) {
								if ((i == 1 && j == 1 && k == 1) || (i == 1 && j == 2)) {

								} else {
									world.setBlock((x - i + 1), (y + j - 1), (z - k + 1), FHBlocks.blockFHFossilGhost);
									TileEntity tileEntity = (TileEntity) world.getTileEntity((x - i + 1), (y + j - 1), (z - k + 1));
									if (tileEntity instanceof TileEntityGhostBlock) {
										TileEntityGhostBlock ghostBlock = (TileEntityGhostBlock) tileEntity;
										ghostBlock.setMainPosition(x, y, z);
									}
								}
							}
						}
					}
				} else {
					for (int i = 1; i <= posX; i++) {
						for (int j = 1; j <= 1; j++) {
							for (int k = 1; k <= posZ; k++) {
								if (i == 1 && j == 1 && k == 1) {
								} else {
									world.setBlock((x - i + 1), (y + j - 1), (z - k + 1), FHBlocks.blockFHFossilGhost);
									TileEntity tileEntity = (TileEntity) world.getTileEntity((x - i + 1), (y + j - 1), (z - k + 1));
									if (tileEntity instanceof TileEntityGhostBlock) {
										TileEntityGhostBlock ghostBlock = (TileEntityGhostBlock) tileEntity;
										ghostBlock.setMainPosition(x, y, z);
									}
								}
							}
						}
					}
				}
			}
		} else {
			for (int i = 1; i <= posX; i++) {
				for (int j = 1; j <= 1; j++) {
					for (int k = 1; k <= posZ; k++) {
						if (i == 1 && j == 1 && k == 1) {
						} else {
							world.setBlock((x - i + 1), (y + j - 1), (z - k + 1), FHBlocks.blockFHFossilGhost);
							TileEntity tileEntity = (TileEntity) world.getTileEntity((x - i + 1), (y + j - 1), (z - k + 1));
							if (tileEntity instanceof TileEntityGhostBlock) {
								TileEntityGhostBlock ghostBlock = (TileEntityGhostBlock) tileEntity;
								ghostBlock.setMainPosition(x, y, z);
							}
						}
					}
				}
			}
		}
	}

	protected boolean checkPlacementAtEastBetween(World world, ItemStack itemStack, int x, int y, int z, int posX, int posZ) {
		if (itemStack.hasTagCompound()) {
			if (itemStack.getTagCompound().getBoolean("tilted")) {
				for (int i = 1; i <= posX; i++) {
					for (int j = 1; j <= 2; j++) {
						for (int k = 1; k <= posZ; k++) {
							if (!world.isAirBlock((x + i - 1), (y + j - 1), (z - k + 1))) {
								return false;
							}
						}
					}
				}
			} else {
				for (int i = 1; i <= posX; i++) {
					for (int j = 1; j <= 1; j++) {
						for (int k = 1; k <= posZ; k++) {
							if (!world.isAirBlock((x + i - 1), (y + j - 1), (z - k + 1))) {
								return false;
							}
						}
					}
				}
			}
		} else {
			for (int i = 1; i <= posX; i++) {
				for (int j = 1; j <= 1; j++) {
					for (int k = 1; k <= posZ; k++) {
						if (!world.isAirBlock((x + i - 1), (y + j - 1), (z - k + 1))) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	protected void placeGhostBlocksAtEastBetween(World world, ItemStack itemStack, int x, int y, int z, int posX, int posZ) {
		if (itemStack.hasTagCompound()) {
			if (itemStack.getTagCompound().hasKey("tilted")) {
				if (itemStack.getTagCompound().getBoolean("tilted")) {
					for (int i = 1; i <= posX; i++) {
						for (int j = 1; j <= 2; j++) {
							for (int k = 1; k <= posZ; k++) {
								if ((i == 1 && j == 1 && k == 1) || (k == 1 && j == 2)) {

								} else {
									world.setBlock((x + i - 1), (y + j - 1), (z - k + 1), FHBlocks.blockFHFossilGhost);
									TileEntity tileEntity = (TileEntity) world.getTileEntity((x + i - 1), (y + j - 1), (z - k + 1));
									if (tileEntity instanceof TileEntityGhostBlock) {
										TileEntityGhostBlock ghostBlock = (TileEntityGhostBlock) tileEntity;
										ghostBlock.setMainPosition(x, y, z);
									}
								}
							}
						}
					}
				} else {
					for (int i = 1; i <= posX; i++) {
						for (int j = 1; j <= 1; j++) {
							for (int k = 1; k <= posZ; k++) {
								if (i == 1 && j == 1 && k == 1) {
								} else {
									world.setBlock((x + i - 1), (y + j - 1), (z - k + 1), FHBlocks.blockFHFossilGhost);
									TileEntity tileEntity = (TileEntity) world.getTileEntity((x + i - 1), (y + j - 1), (z - k + 1));
									if (tileEntity instanceof TileEntityGhostBlock) {
										TileEntityGhostBlock ghostBlock = (TileEntityGhostBlock) tileEntity;
										ghostBlock.setMainPosition(x, y, z);
									}
								}
							}
						}
					}
				}
			}
		} else {
			for (int i = 1; i <= posX; i++) {
				for (int j = 1; j <= 1; j++) {
					for (int k = 1; k <= posZ; k++) {
						if (i == 1 && j == 1 && k == 1) {
						} else {
							world.setBlock((x + i - 1), (y + j - 1), (z - k + 1), FHBlocks.blockFHFossilGhost);
							TileEntity tileEntity = (TileEntity) world.getTileEntity((x + i - 1), (y + j - 1), (z - k + 1));
							if (tileEntity instanceof TileEntityGhostBlock) {
								TileEntityGhostBlock ghostBlock = (TileEntityGhostBlock) tileEntity;
								ghostBlock.setMainPosition(x, y, z);
							}
						}
					}
				}
			}
		}
	}

	protected boolean checkPlacementAtSouthBetween(World world, ItemStack itemStack, int x, int y, int z, int posX, int posZ) {
		if (itemStack.hasTagCompound()) {
			if (itemStack.getTagCompound().getBoolean("tilted")) {
				for (int i = 1; i <= posX; i++) {
					for (int j = 1; j <= 2; j++) {
						for (int k = 1; k <= posZ; k++) {
							if (!world.isAirBlock((x + i - 1), (y + j - 1), (z + k - 1))) {
								return false;
							}
						}
					}
				}
			} else {
				for (int i = 1; i <= posX; i++) {
					for (int j = 1; j <= 1; j++) {
						for (int k = 1; k <= posZ; k++) {
							if (!world.isAirBlock((x + i - 1), (y + j - 1), (z + k - 1))) {
								return false;
							}
						}
					}
				}
			}
		} else {
			for (int i = 1; i <= posX; i++) {
				for (int j = 1; j <= 1; j++) {
					for (int k = 1; k <= posZ; k++) {
						if (!world.isAirBlock((x + i - 1), (y + j - 1), (z + k - 1))) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	protected void placeGhostBlocksAtSouthBetween(World world, ItemStack itemStack, int x, int y, int z, int posX, int posZ) {
		if (itemStack.hasTagCompound()) {
			if (itemStack.getTagCompound().hasKey("tilted")) {
				if (itemStack.getTagCompound().getBoolean("tilted")) {
					for (int i = 1; i <= posX; i++) {
						for (int j = 1; j <= 2; j++) {
							for (int k = 1; k <= posZ; k++) {
								if ((i == 1 && j == 1 && k == 1) || (i == 1 && j == 2)) {

								} else {
									world.setBlock((x + i - 1), (y + j - 1), (z + k - 1), FHBlocks.blockFHFossilGhost);
									TileEntity tileEntity = (TileEntity) world.getTileEntity((x + i - 1), (y + j - 1), (z + k - 1));
									if (tileEntity instanceof TileEntityGhostBlock) {
										TileEntityGhostBlock ghostBlock = (TileEntityGhostBlock) tileEntity;
										ghostBlock.setMainPosition(x, y, z);
									}
								}
							}
						}
					}
				} else {
					for (int i = 1; i <= posX; i++) {
						for (int j = 1; j <= 1; j++) {
							for (int k = 1; k <= posZ; k++) {
								if (i == 1 && j == 1 && k == 1) {

								} else {
									world.setBlock((x + i - 1), (y + j - 1), (z + k - 1), FHBlocks.blockFHFossilGhost);
									TileEntity tileEntity = (TileEntity) world.getTileEntity((x + i - 1), (y + j - 1), (z + k - 1));
									if (tileEntity instanceof TileEntityGhostBlock) {
										TileEntityGhostBlock ghostBlock = (TileEntityGhostBlock) tileEntity;
										ghostBlock.setMainPosition(x, y, z);
									}
								}
							}
						}
					}
				}
			}
		} else {
			for (int i = 1; i <= posX; i++) {
				for (int j = 1; j <= 1; j++) {
					for (int k = 1; k <= posZ; k++) {
						if (i == 1 && j == 1 && k == 1) {

						} else {
							world.setBlock((x + i - 1), (y + j - 1), (z + k - 1), FHBlocks.blockFHFossilGhost);
							TileEntity tileEntity = (TileEntity) world.getTileEntity((x + i - 1), (y + j - 1), (z + k - 1));
							if (tileEntity instanceof TileEntityGhostBlock) {
								TileEntityGhostBlock ghostBlock = (TileEntityGhostBlock) tileEntity;
								ghostBlock.setMainPosition(x, y, z);
							}
						}
					}
				}
			}
		}
	}

	protected boolean checkPlacementAtWestBetween(World world, ItemStack itemStack, int x, int y, int z, int posX, int posZ) {
		if (itemStack.hasTagCompound()) {
			if (itemStack.getTagCompound().getBoolean("tilted")) {
				for (int i = 1; i <= posX; i++) {
					for (int j = 1; j <= 2; j++) {
						for (int k = 1; k <= posZ; k++) {
							if (!world.isAirBlock((x - i + 1), (y + j - 1), (z + k - 1))) {
								return false;
							}
						}
					}
				}
			} else {
				for (int i = 1; i <= posX; i++) {
					for (int j = 1; j <= 1; j++) {
						for (int k = 1; k <= posZ; k++) {
							if (!world.isAirBlock((x - i + 1), (y + j - 1), (z + k - 1))) {
								return false;
							}
						}
					}
				}
			}
		} else {
			for (int i = 1; i <= posX; i++) {
				for (int j = 1; j <= 1; j++) {
					for (int k = 1; k <= posZ; k++) {
						if (!world.isAirBlock((x - i + 1), (y + j - 1), (z + k - 1))) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	protected void placeGhostBlocksAtWestBetween(World world, ItemStack itemStack, int x, int y, int z, int posX, int posZ) {
		if (itemStack.hasTagCompound()) {
			if (itemStack.getTagCompound().hasKey("tilted")) {
				if (itemStack.getTagCompound().getBoolean("tilted")) {
					for (int i = 1; i <= posX; i++) {
						for (int j = 1; j <= 2; j++) {
							for (int k = 1; k <= posZ; k++) {
								if ((i == 1 && j == 1 && k == 1) || (k == 1 && j == 2)) {

								} else {
									world.setBlock((x - i + 1), (y + j - 1), (z + k - 1), FHBlocks.blockFHFossilGhost);
									TileEntity tileEntity = (TileEntity) world.getTileEntity((x - i + 1), (y + j - 1), (z + k - 1));
									if (tileEntity instanceof TileEntityGhostBlock) {
										TileEntityGhostBlock ghostBlock = (TileEntityGhostBlock) tileEntity;
										ghostBlock.setMainPosition(x, y, z);
									}
								}
							}
						}
					}
				} else {
					for (int i = 1; i <= posX; i++) {
						for (int j = 1; j <= 1; j++) {
							for (int k = 1; k <= posZ; k++) {
								if (i == 1 && j == 1 && k == 1) {

								} else {
									world.setBlock((x - i + 1), (y + j - 1), (z + k - 1), FHBlocks.blockFHFossilGhost);
									TileEntity tileEntity = (TileEntity) world.getTileEntity((x - i + 1), (y + j - 1), (z + k - 1));
									if (tileEntity instanceof TileEntityGhostBlock) {
										TileEntityGhostBlock ghostBlock = (TileEntityGhostBlock) tileEntity;
										ghostBlock.setMainPosition(x, y, z);
									}
								}
							}
						}
					}
				}
			}
		} else {
			for (int i = 1; i <= posX; i++) {
				for (int j = 1; j <= 1; j++) {
					for (int k = 1; k <= posZ; k++) {
						if (i == 1 && j == 1 && k == 1) {

						} else {
							world.setBlock((x - i + 1), (y + j - 1), (z + k - 1), FHBlocks.blockFHFossilGhost);
							TileEntity tileEntity = (TileEntity) world.getTileEntity((x - i + 1), (y + j - 1), (z + k - 1));
							if (tileEntity instanceof TileEntityGhostBlock) {
								TileEntityGhostBlock ghostBlock = (TileEntityGhostBlock) tileEntity;
								ghostBlock.setMainPosition(x, y, z);
							}
						}
					}
				}
			}
		}
	}
}
