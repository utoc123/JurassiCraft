package com.rafamv.fossilhunting.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.rafamv.fossilhunting.FossilHunting;
import com.rafamv.fossilhunting.enums.FossilInformation;
import com.rafamv.fossilhunting.tileentity.TileEntityBarrel;

public class Barrel extends BlockContainer {

	public Barrel() {
		super(Material.wood);
		this.setHardness(1.5f);
		this.setResistance(2.0f);
		this.setLightOpacity(0);
		this.setStepSound(soundTypeMetal);
		this.setBlockBounds(0.1f, 0.0f, 0.1f, 0.9f, 1.0f, 0.9f);
		this.setCreativeTab(FossilHunting.fossilHuntingTab);
	}
	
	@Override
	public boolean hasTileEntity(int metadata) {
		return true;
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
	public int quantityDropped(int metadata, int fortune, Random random) {
		return 0;
	}

	@Override
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player) {
		if (!world.isRemote) {
			if (player.getHeldItem() != null) {
				if (player.getHeldItem().getItem().equals(Items.water_bucket)) {
					TileEntity tileentity = world.getTileEntity(x, y, z);
					if (tileentity instanceof TileEntityBarrel) {
						TileEntityBarrel barrel = (TileEntityBarrel) tileentity;
						if (barrel.validWaterValue(barrel.getWaterStored() + barrel.getWaterUsed())) {
							player.inventory.consumeInventoryItem(player.getHeldItem().getItem());
							player.inventory.addItemStackToInventory(new ItemStack(Items.bucket, 1));
							barrel.increaseWaterStored(barrel.getWaterUsed());
							barrel.updateEntity();
							((EntityPlayerMP) player).sendContainerToPlayer(player.inventoryContainer);
						} else {
							player.addChatMessage(new ChatComponentText("The barrel is full."));
						}
					}
				} else if (player.getHeldItem().getItem().equals(Items.bucket)) {
					TileEntity tileentity = world.getTileEntity(x, y, z);
					if (tileentity instanceof TileEntityBarrel) {
						TileEntityBarrel barrel = (TileEntityBarrel) tileentity;
						if (barrel.validWaterValue(barrel.getWaterStored() - barrel.getWaterUsed())) {
							player.getHeldItem().stackSize--;
							player.inventory.addItemStackToInventory(new ItemStack(Items.water_bucket, 1));
							barrel.decreaseWaterStored(barrel.getWaterUsed());
							barrel.updateEntity();
							((EntityPlayerMP) player).sendContainerToPlayer(player.inventoryContainer);
						} else {
							if (barrel.getWaterStored() <= 0) {
								player.addChatMessage(new ChatComponentText("The barrel is empty."));
							} else {
								player.addChatMessage(new ChatComponentText("There is not enough water to fill your bucket."));
							}
						}
					}
				}
			}
		}
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (!player.isSneaking()) {
			player.openGui(FossilHunting.instance, FHBlocks.guiIDFHBarrelBlock, world, x, y, z);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		TileEntity tileentity = (TileEntity) world.getTileEntity(x, y, z);
		if (tileentity instanceof TileEntityBarrel) {
			Random random = new Random();
			TileEntityBarrel barrel = (TileEntityBarrel) tileentity;
			for (int j = 0; j < barrel.getSizeInventory(); ++j) {
				ItemStack itemstack = barrel.getStackInSlot(j);
				if (itemstack != null) {
					float f = random.nextFloat() * 0.8F + 0.1F;
					float f1 = random.nextFloat() * 0.8F + 0.1F;
					float f2 = random.nextFloat() * 0.8F + 0.1F;
					while (itemstack.stackSize > 0) {
						int k1 = random.nextInt(21) + 10;
						if (k1 > itemstack.stackSize) {
							k1 = itemstack.stackSize;
						}
						itemstack.stackSize -= k1;
						EntityItem entityitem = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float) z + f2), new ItemStack(itemstack.getItem(), k1, itemstack.getItemDamage()));
						if (itemstack.hasTagCompound()) {
							entityitem.getEntityItem().setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
						}
						float f3 = 0.05F;
						entityitem.motionX = (double) ((float) random.nextGaussian() * f3);
						entityitem.motionY = (double) ((float) random.nextGaussian() * f3 + 0.2F);
						entityitem.motionZ = (double) ((float) random.nextGaussian() * f3);
						world.spawnEntityInWorld(entityitem);
					}
				}
			}
			int value = random.nextInt(10);
			if (value >= 8) {
				if (barrel.getWaterStored() > 4) {
					world.setBlock(x, y, z, Blocks.water, 0, 2);
				}
				value = random.nextInt(7);
				for (int i = 0; i <= value; i++) {
					float f = random.nextFloat() * 0.8F + 0.1F;
					float f1 = random.nextFloat() * 0.8F + 0.1F;
					float f2 = random.nextFloat() * 0.8F + 0.1F;
					ItemStack itemStack = new ItemStack(Blocks.planks);
					EntityItem entityPlanks = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float) z + f2), itemStack);
					world.spawnEntityInWorld(entityPlanks);
				}
			} else {
				ItemStack itemBarrel = new ItemStack(FHBlocks.blockFHBarrelBlock);
				float f = random.nextFloat() * 0.8F + 0.1F;
				float f1 = random.nextFloat() * 0.8F + 0.1F;
				float f2 = random.nextFloat() * 0.8F + 0.1F;
				EntityItem entityBarrel = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float) z + f2), itemBarrel);
				if (barrel.hasWater()) {
					NBTTagCompound compound = new NBTTagCompound();
					compound.setByte("WaterStoredInBarrel", (byte) barrel.getWaterStored());
					entityBarrel.getEntityItem().setTagCompound(compound);
				}
				entityBarrel.motionX = (double) ((float) random.nextGaussian() * 0.05F);
				entityBarrel.motionY = (double) ((float) random.nextGaussian() * 0.07F);
				entityBarrel.motionZ = (double) ((float) random.nextGaussian() * 0.05F);
				world.spawnEntityInWorld(entityBarrel);
			}
		}
		super.breakBlock(world, x, y, z, block, meta);
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack) {
		if (!world.isRemote) {
			int l = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.F) + 0.5D) & 3;
			if (l == 0) {
				world.setBlockMetadataWithNotify(x, y, z, 2, 2);
			}
			if (l == 1) {
				world.setBlockMetadataWithNotify(x, y, z, 5, 2);
			}
			if (l == 2) {
				world.setBlockMetadataWithNotify(x, y, z, 3, 2);
			}
			if (l == 3) {
				world.setBlockMetadataWithNotify(x, y, z, 4, 2);
			}
			if (itemstack.hasTagCompound()) {
				NBTTagCompound compound = itemstack.getTagCompound();
				if (compound.hasKey("WaterStoredInBarrel")) {
					TileEntity tileentity = (TileEntity) world.getTileEntity(x, y, z);
					if (tileentity instanceof TileEntityBarrel) {
						TileEntityBarrel barrel = (TileEntityBarrel) tileentity;
						barrel.setWaterStored(compound.getByte("WaterStoredInBarrel"));
					}
				}
			}
		}
	}

	private void setDefaultDirection(World world, int x, int y, int z) {
		if (!world.isRemote) {
			Block b1 = world.getBlock(x, y, z - 1);
			Block b2 = world.getBlock(x, y, z + 1);
			Block b3 = world.getBlock(x - 1, y, z);
			Block b4 = world.getBlock(x + 1, y, z);
			byte b0 = 3;
			if (b1.func_149730_j() && !b2.func_149730_j()) {
				b0 = 3;
			}
			if (b2.func_149730_j() && !b1.func_149730_j()) {
				b0 = 2;
			}
			if (b3.func_149730_j() && !b4.func_149730_j()) {
				b0 = 5;
			}
			if (b4.func_149730_j() && !b3.func_149730_j()) {
				b0 = 4;
			}
			world.setBlockMetadataWithNotify(x, y, x, b0, 2);
		}
	}

	public TileEntity createNewTileEntity(World world, int metadata) {
		try {
			return new TileEntityBarrel();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
