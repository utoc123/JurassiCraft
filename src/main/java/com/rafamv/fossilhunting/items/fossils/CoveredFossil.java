package com.rafamv.fossilhunting.items.fossils;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import com.rafamv.fossilhunting.FossilHunting;
import com.rafamv.fossilhunting.enums.FossilInformation;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CoveredFossil extends AnyFossilItem {

	public CoveredFossil() {
		this.setCreativeTab(FossilHunting.fossilHuntingTab);
	}

	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean flag) {
		list.add(FossilInformation.getChatColor(FossilInformation.values()[itemStack.getItemDamage()].getDiet()) + FossilInformation.values()[itemStack.getItemDamage()].getFamily());
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		if (world.isRemote) {
			if (player.capabilities.isCreativeMode) {
				if (player.isSneaking()) {
					if (itemStack.getItemDamage() < itemStack.getMaxDamage()) {
						itemStack.setItemDamage(itemStack.getItemDamage() + 1);
					} else {
						itemStack.setItemDamage(0);
					}
					player.addChatMessage(new ChatComponentText("New fossil: " + FossilInformation.values()[itemStack.getItemDamage()].getFossilName()));
					return itemStack;
				}
				return itemStack;
			} else {
				return itemStack;
			}
		}
		return itemStack;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(FossilHunting.MODID + ":" + this.getUnlocalizedName().substring(5));
	}

}
