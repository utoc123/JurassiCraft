package com.rafamv.bygoneage.items.drops;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import com.rafamv.bygoneage.BygoneAge;
import com.rafamv.bygoneage.items.dnaitems.AnyDNASource;
import com.rafamv.bygoneage.registry.BygoneAgeItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class UintatheriumMeatRaw extends ItemFood implements AnyDNASource {

	public UintatheriumMeatRaw(int hunger, float saturation, boolean isWolfFood) {
		super(hunger, saturation, isWolfFood);
		this.setCreativeTab(BygoneAge.bygoneAgeTab);
	}

	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean flag) {
		list.add(EnumChatFormatting.GRAY + "DNA can be extracted.");
	}

	@Override
	public boolean isAnalyzed(ItemStack itemStack) {
		if (itemStack.hasTagCompound()) {
			if (itemStack.getTagCompound().hasKey("Analyzed")) {
				return itemStack.getTagCompound().getBoolean("Analyzed");
			}
		}
		return false;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack itemStack) {
		return 40;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(BygoneAge.MODID + ":" + BygoneAgeItems.uintatheriumMeatRaw.getUnlocalizedName().substring(5));
	}
}