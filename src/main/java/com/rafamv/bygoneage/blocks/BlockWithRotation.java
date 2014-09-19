package com.rafamv.bygoneage.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.rafamv.bygoneage.tileentity.TileEntityWithRotations;

public class BlockWithRotation extends Block {

	public BlockWithRotation(Material blockMaterial) {
		super(blockMaterial);
	}

	@Override
	public boolean hasTileEntity(int metadata) {
		return true;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack itemStack) {
		if (!world.isRemote) {
			TileEntity tileEntity = world.getTileEntity(x, y, z);
			if (tileEntity != null) {
				if (tileEntity instanceof TileEntityWithRotations) {
					TileEntityWithRotations tileEntityRotation = (TileEntityWithRotations) tileEntity;
					int placementDirection = MathHelper.floor_double(player.rotationYaw * 4.0F / 360.0F + 0.5D);
					switch (placementDirection) {
						case 1:
							tileEntityRotation.setForgeDirection(ForgeDirection.WEST.ordinal());
							break;
						case 2:
							tileEntityRotation.setForgeDirection(ForgeDirection.NORTH.ordinal());
							break;
						case 3:
							tileEntityRotation.setForgeDirection(ForgeDirection.EAST.ordinal());
							break;
						case 4:
							tileEntityRotation.setForgeDirection(ForgeDirection.SOUTH.ordinal());
							break;
						default:
							tileEntityRotation.setForgeDirection(ForgeDirection.SOUTH.ordinal());
					}
				}
			}
		}
	}
	
}
