package com.rafamv.fossilhunting.items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.rafamv.fossilhunting.FossilHunting;
import com.rafamv.fossilhunting.blocks.EncasedFossilBlock;
import com.rafamv.fossilhunting.tileentity.TileEntityEncasedFossilBlock;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FossilBreaker extends ItemPickaxe {

	public FossilBreaker(ToolMaterial material) {
		super(material);
		this.setMaxStackSize(1);
		this.setCreativeTab(FossilHunting.fossilHuntingTab);
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase p_150894_7_) {
		if (!world.isRemote) {
			if (itemStack != null) {
				if (world.getBlock(x, y, z) instanceof EncasedFossilBlock) {
					TileEntity tileentity = world.getTileEntity(x, y, z);
					if (tileentity instanceof TileEntityEncasedFossilBlock) {
						TileEntityEncasedFossilBlock tileEntityfossil = (TileEntityEncasedFossilBlock) tileentity;
						ItemStack fossil = new ItemStack(FHItems.itemDEXEncasedFossil, 1, (tileEntityfossil.getFossilID()));
						Entity fossilEntity = new EntityItem(world, x, y, z, fossil);
						world.spawnEntityInWorld(fossilEntity);
						world.setBlockToAir(x, y, z);
						if (itemStack.getItemDamage() >= itemStack.getMaxDamage()) {
							itemStack.stackSize--;
						} else {
							itemStack.setItemDamage(itemStack.getItemDamage() + 1);
						}
						return true;
					}
				} else if (world.getBlock(x, y, z) instanceof Block) {
					if (itemStack.getItemDamage() >= itemStack.getMaxDamage()) {
						itemStack.stackSize--;
					} else {
						itemStack.setItemDamage(itemStack.getItemDamage() + 1);
					}
					return true;
				}
			}
		}
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(FossilHunting.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
	
}
