package com.rafamv.bygoneage.items.dnaitems;

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

public class PrehistoricSkin extends Item implements AnyDNASource {

	public PrehistoricSkin() {
		this.setCreativeTab(BygoneAge.bygoneAgeTab);
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
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean flag) {
		list.add(EnumChatFormatting.GRAY + "DNA can be extracted.");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(BygoneAge.MODID + ":" + BygoneAgeItems.prehistoricSkin.getUnlocalizedName().substring(5));
	}

}
