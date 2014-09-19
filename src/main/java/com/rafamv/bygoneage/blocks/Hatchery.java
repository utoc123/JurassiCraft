package com.rafamv.bygoneage.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.rafamv.bygoneage.BygoneAge;
import com.rafamv.bygoneage.enums.BygoneAgeGuiInformation;
import com.rafamv.bygoneage.registry.BygoneAgeBlocks;
import com.rafamv.bygoneage.tileentity.TileEntityHatchery;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Hatchery extends Block implements ITileEntityProvider {

	private Random random = new Random();

	public Hatchery(Material blockMaterial) {
		super(blockMaterial);
		this.setHardness(5.0F);
		this.setResistance(6.0F);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.5F, 1.0F);
		this.setCreativeTab(BygoneAge.bygoneAgeTab);
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
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return (world.getBlock(x, y, z).isReplaceable(world, x, y, z) && world.getBlock(x, y + 1, z).isReplaceable(world, x, y, z) && !(world.getBlock(x, y - 1, z) instanceof BlockSlab) && !(world.getBlock(x, y - 1, z) instanceof BlockStairs) && !(world.getBlock(x, y - 1, z) instanceof BlockAir));
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (world.isRemote) {
			return true;
		} else if (!player.isSneaking()) {
			TileEntity tileEntity = world.getTileEntity(x, y, z);
			if (tileEntity instanceof TileEntityHatchery) {
				TileEntityHatchery tileEntityHatchery = (TileEntityHatchery) tileEntity;
				if (tileEntityHatchery.isUseableByPlayer(player)) {
					player.openGui(BygoneAge.instance, BygoneAgeGuiInformation.HATCHERY.getGuiId(), world, x, y, z);
					return true;
				} else {
					FMLClientHandler.instance().getClient().thePlayer.openGui(BygoneAge.instance, BygoneAgeGuiInformation.HATCHERYPROCESS.getGuiId(), world, x, y, z);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata) {
		world.setBlock(x, y + 1, z, BygoneAgeBlocks.hatcheryGhostBlock);
		return metadata;
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block oldblock, int oldMetadata) {
		TileEntity tileEntity = world.getTileEntity(x, y, z);
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
		world.setBlockToAir(x, y + 1, z);
		super.breakBlock(world, x, y, z, oldblock, oldMetadata);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		try {
			return new TileEntityHatchery();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
