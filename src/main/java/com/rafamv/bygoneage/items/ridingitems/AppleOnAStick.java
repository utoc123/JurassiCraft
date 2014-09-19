package com.rafamv.bygoneage.items.ridingitems;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import com.rafamv.bygoneage.BygoneAge;
import com.rafamv.bygoneage.registry.BygoneAgeItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AppleOnAStick extends Item {

	public AppleOnAStick() {
		this.setMaxStackSize(1);
		this.setMaxDamage(8000);
		this.setCreativeTab(BygoneAge.bygoneAgeTab);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldRotateAroundWhenRendering() {
		return true;
	}

	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean flag) {
		list.add(EnumChatFormatting.GRAY + "Used to ride some creatures.");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(BygoneAge.MODID + ":" + BygoneAgeItems.appleOnStick.getUnlocalizedName().substring(5));
	}
}
