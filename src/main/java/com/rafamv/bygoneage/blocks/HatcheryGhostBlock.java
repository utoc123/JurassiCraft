package com.rafamv.bygoneage.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.rafamv.bygoneage.BygoneAge;
import com.rafamv.bygoneage.enums.BygoneAgeGuiInformation;
import com.rafamv.bygoneage.tileentity.TileEntityHatchery;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class HatcheryGhostBlock extends Block {

	private Random random = new Random();

	public HatcheryGhostBlock(Material blockMaterial) {
		super(blockMaterial);
		this.setHardness(5.0F);
		this.setResistance(6.0F);
		this.setBlockBounds(0.0f, -1.0f, 0.0f, 1.0f, 0.5f, 1.0f);
	}

	@Override
	public boolean canPlaceBlockOnSide(World world, int x, int y, int z, int side) {
		return false;
	}

	@Override
	public int quantityDropped(Random a) {
		return 0;
	}

	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		return new ItemStack(world.getBlock(x, y - 1, z));
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
		return true;
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block oldblock, int oldMetadata) {
		TileEntity tileEntity = world.getTileEntity(x, y - 1, z);
		if (tileEntity instanceof TileEntityHatchery) {
			TileEntityHatchery tileEntityHatchery = (TileEntityHatchery) tileEntity;
			if (tileEntityHatchery.hasItems()) {
				for (int i = 0; i < tileEntityHatchery.getSizeInventory(); i++) {
					ItemStack itemstack = tileEntityHatchery.getStackInSlot(i);
					if (itemstack != null) {
						float f = this.random.nextFloat() * 0.8F + 0.1F;
						float f1 = this.random.nextFloat() * 0.8F + 0.1F;
						float f2 = this.random.nextFloat() * 0.8F + 0.1F;
						while (itemstack.stackSize > 0) {
							int j = this.random.nextInt(21) + 10;
							if (j > itemstack.stackSize) {
								j = itemstack.stackSize;
							}
							itemstack.stackSize -= j;
							EntityItem item = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float) z + f2), new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));
							if (itemstack.hasTagCompound()) {
								item.getEntityItem().setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
							}
							world.spawnEntityInWorld(item);
						}
					}
				}
				world.func_147453_f(x, y, z, oldblock);
			}
		}
		world.setBlockToAir(x, y - 1, z);
		world.removeTileEntity(x, y - 1, z);
		super.breakBlock(world, x, y, z, oldblock, oldMetadata);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (world.isRemote) {
			return true;
		} else if (!player.isSneaking()) {
			TileEntity tileEntity = world.getTileEntity(x, y - 1, z);
			if (tileEntity instanceof TileEntityHatchery) {
				TileEntityHatchery tileEntityHatchery = (TileEntityHatchery) tileEntity;
				if (tileEntityHatchery.isUseableByPlayer(player)) {
					player.openGui(BygoneAge.instance, BygoneAgeGuiInformation.HATCHERY.getGuiId(), world, x, y - 1, z);
					return true;
				} else {
					FMLClientHandler.instance().getClient().thePlayer.openGui(BygoneAge.instance, BygoneAgeGuiInformation.HATCHERYPROCESS.getGuiId(), world, x, y - 1, z);
					return true;
				}
			}
		}
		return false;
	}

}
