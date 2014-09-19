package com.rafamv.fossilhunting.blocks;

import java.util.Random;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.rafamv.fossilhunting.FossilHunting;
import com.rafamv.fossilhunting.handler.FHFossilIDHandler;
import com.rafamv.fossilhunting.items.FHItems;
import com.rafamv.fossilhunting.items.PlasterAndBandage;
import com.rafamv.fossilhunting.tileentity.TileEntityEncasedFossilBlock;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FossilBlock extends AnyFossilBlock {
	
    public FossilBlock() {
		this.setHardness(0.5f);
		this.setResistance(1.0f);
		this.setCreativeTab(FossilHunting.fossilHuntingTab);
	}

	@Override
	protected boolean canSilkHarvest() {
        return false;
    }

	@Override
	@SideOnly(Side.CLIENT)
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {		
		if (!world.isRemote && player.getHeldItem() != null) {
			if (player.getHeldItem().getItem() instanceof PlasterAndBandage) {
				if (!player.capabilities.isCreativeMode) {
					player.inventory.consumeInventoryItem(player.getHeldItem().getItem());
				}
				Random random = new Random();
				if (random.nextInt(100) > 30) {
					world.setBlock(x, y, z, FHBlocks.blockFHEncasedFossilBlock);
					TileEntityEncasedFossilBlock encasedFossil = (TileEntityEncasedFossilBlock) world.getTileEntity(x, y, z);
					encasedFossil.setFossilID(FHFossilIDHandler.getID(x, y, z));
				}
				return true;
			}
		}
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(FossilHunting.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
	
}
