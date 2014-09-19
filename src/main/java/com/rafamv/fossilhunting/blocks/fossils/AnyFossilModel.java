package com.rafamv.fossilhunting.blocks.fossils;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.rafamv.fossilhunting.enums.FossilInformation;
import com.rafamv.fossilhunting.items.RockPick;
import com.rafamv.fossilhunting.items.SledgeHammer;
import com.rafamv.fossilhunting.tileentity.fossils.TileEntityFossil;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AnyFossilModel extends Block {

	public AnyFossilModel() {
		super(Material.rock);
		this.setLightOpacity(0);
		this.setHardness(1.0f);
		this.setResistance(1.0f);
		this.setStepSound(soundTypeStone);		
		this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f);
	}

	@Override
	public boolean canPlaceBlockOnSide(World world, int x, int y, int z, int side) {
		return false;
	}

	@Override
	public boolean canDropFromExplosion(Explosion explosion) {
		return false;
	}

	@Override
	public int quantityDropped(Random a) {
		return 0;
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		return null;
	}

	public ItemStack setFossilItemData(ItemStack fossil, TileEntityFossil tileEntityfossil) {
		NBTTagCompound compound = new NBTTagCompound();
		compound.setByte("fossilID", (byte) tileEntityfossil.getFossilID());
		compound.setDouble("year", tileEntityfossil.getYearOfExistence());
		compound.setBoolean("tilted", tileEntityfossil.isTilted());
		compound.setDouble("height", tileEntityfossil.getHeight());
		compound.setDouble("weight", tileEntityfossil.getWeight());
		compound.setDouble("length", tileEntityfossil.getLength());
		fossil.setTagCompound(compound);
		return fossil;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			if (player.getHeldItem() != null) {
				return changeFossilAngle(world, x, y, z, player, player.getHeldItem().getItem());
			} else {
				if (!player.isSneaking()) {
					TileEntity tileentity = (TileEntity) world.getTileEntity(x, y, z);
					if (tileentity instanceof TileEntityFossil) {
						TileEntityFossil fossil = (TileEntityFossil) tileentity;
						if (fossil.hasSign()) {
							// player.openGui(FossilHunting.instance,
							// FHBlocks.guiIDFHDisplay, world, x, y, z);
						} else {
							player.addChatMessage(new ChatComponentText(FossilInformation.values()[fossil.getFossilID()].getFossilName() + " is a " + FossilInformation.values()[fossil.getFossilID()].getDiet().toLowerCase() + " "
									+ FossilInformation.values()[fossil.getFossilID()].getTypeOfCreature().toLowerCase() + " that lived in the " + fossil.getGeologicEra(fossil.getYearOfExistence()) + ", " + fossil.getYearOfExistenceString() + ". Weight: " + fossil.getWeight() + ", length: "
									+ fossil.getLength() + ", height: " + fossil.getHeight()));
						}
						return true;
					}
				} else {
					if (player.getHeldItem() != null) {
						if (player.getHeldItem().getUnlocalizedName().equals(new ItemStack(Items.gold_ingot).getUnlocalizedName())) {
							TileEntity tileentity = (TileEntity) world.getTileEntity(x, y, z);
							if (tileentity instanceof TileEntityFossil) {
								TileEntityFossil fossil = (TileEntityFossil) tileentity;
								if (fossil.hasSign()) {
									//player.addChatMessage(new ChatComponentText("This display has already a sign!"));
								} else {
									if (!player.capabilities.isCreativeMode) {
										//player.inventory.consumeInventoryItem(player.getHeldItem().getItem());
									}
									fossil.setSign(true);
									return true;
								}
							}
						}
					}
				}
			}
		}
		return false;
	}

	public boolean changeFossilAngle(World world, int x, int y, int z, EntityPlayer player, Item tool) {
		if (tool instanceof SledgeHammer || tool instanceof RockPick) {
			if (world.getBlock(x, y, z) instanceof AnyFossilModel) {
				TileEntity tileentity = world.getTileEntity(x, y, z);
				if (tileentity instanceof TileEntityFossil) {
					TileEntityFossil fossil = (TileEntityFossil) tileentity;
					if (fossil.isTilted()) {
						fossil.setTilted(false);
						player.addChatMessage(new ChatComponentText("Position changed to horizontal. Please replace this fossil."));
					} else {
						fossil.setTilted(true);
						player.addChatMessage(new ChatComponentText("Position changed to tilted. Please replace this fossil."));
					}
					if (player.getHeldItem().getItemDamage() >= player.getHeldItem().getMaxDamage()) {
						player.getHeldItem().stackSize--;
					} else {
						player.getHeldItem().setItemDamage(player.getHeldItem().getItemDamage() + 1);
					}
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		if (tileEntity instanceof TileEntityFossil) {
			TileEntityFossil fossil = (TileEntityFossil) tileEntity;
			int posX = FossilInformation.values()[fossil.getFossilID()].getXBound();
			int posZ = FossilInformation.values()[fossil.getFossilID()].getZBound();
			ForgeDirection direction = fossil.getForgeDirection();
			if (direction == ForgeDirection.SOUTH) {
				posX = FossilInformation.values()[fossil.getFossilID()].getXBound();
				posZ = FossilInformation.values()[fossil.getFossilID()].getZBound();
				System.out.println("Direction 0 (South): " + direction);
				removeGhostBlocksAtSouthBetween(world, fossil, x, y, z, posX, posZ);
			} else if (direction == ForgeDirection.WEST) {
				posX = FossilInformation.values()[fossil.getFossilID()].getZBound();
				posZ = FossilInformation.values()[fossil.getFossilID()].getXBound();
				System.out.println("Direction 1 (West): " + direction);
				removeGhostBlocksAtWestBetween(world, fossil, x, y, z, posX, posZ);
			} else if (direction == ForgeDirection.NORTH) {
				posX = FossilInformation.values()[fossil.getFossilID()].getXBound();
				posZ = FossilInformation.values()[fossil.getFossilID()].getZBound();
				System.out.println("Direction 2 (North): " + direction);
				removeGhostBlocksAtNorthBetween(world, fossil, x, y, z, posX, posZ);
			} else if (direction == ForgeDirection.EAST) {
				posX = FossilInformation.values()[fossil.getFossilID()].getZBound();
				posZ = FossilInformation.values()[fossil.getFossilID()].getXBound();
				System.out.println("Direction 3 (East): " + direction);
				removeGhostBlocksAtEastBetween(world, fossil, x, y, z, posX, posZ);
			}
		}
	}

	public void removeGhostBlocksAtNorthBetween(World world, TileEntityFossil fossil, int x, int y, int z, int posX, int posZ) {
		if (fossil.isTilted()) {
			for (int i = 1; i <= posX; i++) {
				for (int j = 1; j <= 2; j++) {
					for (int k = 1; k <= posZ; k++) {
						if (i == 1 && j == 1 && k == 1) {
							TileEntity tileentity = world.getTileEntity(x, y, z);
							if (tileentity instanceof TileEntityFossil) {
								ItemStack fossilItemStack = FossilInformation.getItemStackFromFossil(fossil.getFossilID());
								fossilItemStack = setFossilItemData(fossilItemStack, fossil);
								Entity fossilEntity = new EntityItem(world, x, y, z, fossilItemStack);
								world.spawnEntityInWorld(fossilEntity);
								world.removeTileEntity((x - i + 1), (y + j - 1), (z - k + 1));
								world.setBlockToAir((x - i + 1), (y + j - 1), (z - k + 1));
							}
						} else {
							world.removeTileEntity((x - i + 1), (y + j - 1), (z - k + 1));
							world.setBlockToAir((x - i + 1), (y + j - 1), (z - k + 1));
						}
					}
				}
			}
		} else {
			for (int i = 1; i <= posX; i++) {
				for (int j = 1; j <= 1; j++) {
					for (int k = 1; k <= posZ; k++) {
						if (i == 1 && j == 1 && k == 1) {
							TileEntity tileentity = world.getTileEntity(x, y, z);
							if (tileentity instanceof TileEntityFossil) {
								ItemStack fossilItemStack = FossilInformation.getItemStackFromFossil(fossil.getFossilID());
								fossilItemStack = setFossilItemData(fossilItemStack, fossil);
								Entity fossilEntity = new EntityItem(world, x, y, z, fossilItemStack);
								world.spawnEntityInWorld(fossilEntity);
								world.removeTileEntity((x - i + 1), (y + j - 1), (z - k + 1));
								world.setBlockToAir((x - i + 1), (y + j - 1), (z - k + 1));
							}
						} else {
							world.removeTileEntity((x - i + 1), (y + j - 1), (z - k + 1));
							world.setBlockToAir((x - i + 1), (y + j - 1), (z - k + 1));
						}
					}
				}
			}
		}
	}

	public void removeGhostBlocksAtEastBetween(World world, TileEntityFossil fossil, int x, int y, int z, int posX, int posZ) {
		if (fossil.isTilted()) {
			for (int i = 1; i <= posX; i++) {
				for (int j = 1; j <= 2; j++) {
					for (int k = 1; k <= posZ; k++) {
						if (i == 1 && j == 1 && k == 1) {
							TileEntity tileentity = world.getTileEntity(x, y, z);
							if (tileentity instanceof TileEntityFossil) {
								ItemStack fossilItemStack = FossilInformation.getItemStackFromFossil(fossil.getFossilID());
								fossilItemStack = setFossilItemData(fossilItemStack, fossil);
								Entity fossilEntity = new EntityItem(world, x, y, z, fossilItemStack);
								world.spawnEntityInWorld(fossilEntity);
								world.removeTileEntity((x + i - 1), (y + j - 1), (z - k + 1));
								world.setBlockToAir((x + i - 1), (y + j - 1), (z - k + 1));
							}
						} else {
							world.removeTileEntity((x + i - 1), (y + j - 1), (z - k + 1));
							world.setBlockToAir((x + i - 1), (y + j - 1), (z - k + 1));
						}
					}
				}
			}
		} else {
			for (int i = 1; i <= posX; i++) {
				for (int j = 1; j <= 1; j++) {
					for (int k = 1; k <= posZ; k++) {
						if (i == 1 && j == 1 && k == 1) {
							TileEntity tileentity = world.getTileEntity(x, y, z);
							if (tileentity instanceof TileEntityFossil) {
								ItemStack fossilItemStack = FossilInformation.getItemStackFromFossil(fossil.getFossilID());
								fossilItemStack = setFossilItemData(fossilItemStack, fossil);
								Entity fossilEntity = new EntityItem(world, x, y, z, fossilItemStack);
								world.spawnEntityInWorld(fossilEntity);
								world.removeTileEntity((x + i - 1), (y + j - 1), (z - k + 1));
								world.setBlockToAir((x + i - 1), (y + j - 1), (z - k + 1));
							}
						} else {
							world.removeTileEntity((x + i - 1), (y + j - 1), (z - k + 1));
							world.setBlockToAir((x + i - 1), (y + j - 1), (z - k + 1));
						}
					}
				}
			}
		}
	}

	public void removeGhostBlocksAtSouthBetween(World world, TileEntityFossil fossil, int x, int y, int z, int posX, int posZ) {
		if (fossil.isTilted()) {
			for (int i = 1; i <= posX; i++) {
				for (int j = 1; j <= 2; j++) {
					for (int k = 1; k <= posZ; k++) {
						if (i == 1 && j == 1 && k == 1) {
							TileEntity tileentity = world.getTileEntity(x, y, z);
							if (tileentity instanceof TileEntityFossil) {
								ItemStack fossilItemStack = FossilInformation.getItemStackFromFossil(fossil.getFossilID());
								fossilItemStack = setFossilItemData(fossilItemStack, fossil);
								Entity fossilEntity = new EntityItem(world, x, y, z, fossilItemStack);
								world.spawnEntityInWorld(fossilEntity);
								world.removeTileEntity((x + i - 1), (y + j - 1), (z + k - 1));
								world.setBlockToAir((x + i - 1), (y + j - 1), (z + k - 1));
							}
						} else {
							world.removeTileEntity((x + i - 1), (y + j - 1), (z + k - 1));
							world.setBlockToAir((x + i - 1), (y + j - 1), (z + k - 1));
						}
					}
				}
			}
		} else {
			for (int i = 1; i <= posX; i++) {
				for (int j = 1; j <= 1; j++) {
					for (int k = 1; k <= posZ; k++) {
						if (i == 1 && j == 1 && k == 1) {
							TileEntity tileentity = world.getTileEntity(x, y, z);
							if (tileentity instanceof TileEntityFossil) {
								ItemStack fossilItemStack = FossilInformation.getItemStackFromFossil(fossil.getFossilID());
								fossilItemStack = setFossilItemData(fossilItemStack, fossil);
								Entity fossilEntity = new EntityItem(world, x, y, z, fossilItemStack);
								world.spawnEntityInWorld(fossilEntity);
								world.removeTileEntity((x + i - 1), (y + j - 1), (z + k - 1));
								world.setBlockToAir((x + i - 1), (y + j - 1), (z + k - 1));
							}
						} else {
							world.removeTileEntity((x + i - 1), (y + j - 1), (z + k - 1));
							world.setBlockToAir((x + i - 1), (y + j - 1), (z + k - 1));
						}
					}
				}
			}
		}
	}

	public void removeGhostBlocksAtWestBetween(World world, TileEntityFossil fossil, int x, int y, int z, int posX, int posZ) {
		if (fossil.isTilted()) {
			for (int i = 1; i <= posX; i++) {
				for (int j = 1; j <= 2; j++) {
					for (int k = 1; k <= posZ; k++) {
						if (i == 1 && j == 1 && k == 1) {
							TileEntity tileentity = world.getTileEntity(x, y, z);
							if (tileentity instanceof TileEntityFossil) {
								ItemStack fossilItemStack = FossilInformation.getItemStackFromFossil(fossil.getFossilID());
								fossilItemStack = setFossilItemData(fossilItemStack, fossil);
								Entity fossilEntity = new EntityItem(world, x, y, z, fossilItemStack);
								world.spawnEntityInWorld(fossilEntity);
								world.removeTileEntity((x - i + 1), (y + j - 1), (z + k - 1));
								world.setBlockToAir((x - i + 1), (y + j - 1), (z + k - 1));
							}
						} else {
							world.removeTileEntity((x - i + 1), (y + j - 1), (z + k - 1));
							world.setBlockToAir((x - i + 1), (y + j - 1), (z + k - 1));
						}
					}
				}
			}
		} else {
			for (int i = 1; i <= posX; i++) {
				for (int j = 1; j <= 1; j++) {
					for (int k = 1; k <= posZ; k++) {
						if (i == 1 && j == 1 && k == 1) {
							TileEntity tileentity = world.getTileEntity(x, y, z);
							if (tileentity instanceof TileEntityFossil) {
								ItemStack fossilItemStack = FossilInformation.getItemStackFromFossil(fossil.getFossilID());
								fossilItemStack = setFossilItemData(fossilItemStack, fossil);
								Entity fossilEntity = new EntityItem(world, x, y, z, fossilItemStack);
								world.spawnEntityInWorld(fossilEntity);
								world.removeTileEntity((x - i + 1), (y + j - 1), (z + k - 1));
								world.setBlockToAir((x - i + 1), (y + j - 1), (z + k - 1));
							}
						} else {
							world.removeTileEntity((x - i + 1), (y + j - 1), (z + k - 1));
							world.setBlockToAir((x - i + 1), (y + j - 1), (z + k - 1));
						}
					}
				}
			}
		}
	}
}
