package com.rafamv.fossilhunting.blocks.fossils;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import com.rafamv.fossilhunting.enums.FossilInformation;
import com.rafamv.fossilhunting.items.FHItems;
import com.rafamv.fossilhunting.items.FossilBreaker;
import com.rafamv.fossilhunting.tileentity.fossils.TileEntityFossilCoronicerasRotiforme;
import com.rafamv.fossilhunting.tileentity.fossils.TileEntityFossilPlesiosaurus;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FossilModelSpinosaurus extends AnyFossilModel implements ITileEntityProvider {

	public FossilModelSpinosaurus() {

	}

	public TileEntity createNewTileEntity(World world, int metadata) {
		try {
			return new TileEntityFossilCoronicerasRotiforme();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
