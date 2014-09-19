package com.rafamv.bygoneage.items.dnaitems;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import com.rafamv.bygoneage.BygoneAge;
import com.rafamv.bygoneage.enums.BygoneAgeGeneticsInformation;
import com.rafamv.bygoneage.handler.BygoneAgeDNAHandler;
import com.rafamv.bygoneage.registry.BygoneAgeItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SalivaSample extends Item implements AnyDNASample {

	public SalivaSample() {
		this.setMaxStackSize(1);
		this.setCreativeTab(BygoneAge.bygoneAgeTab);
	}

	@Override
    public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
		if (!itemStack.hasTagCompound()) {
			NBTTagCompound compound = new NBTTagCompound();
			compound.setBoolean("Centrifugated", false);
			itemStack.setTagCompound(compound);
		}
    }

	@Override
	public boolean isCentrifuged(ItemStack itemStack) {
		if (itemStack.hasTagCompound()) {
			if (itemStack.getTagCompound().hasKey("Centrifugated")) {
				return itemStack.getTagCompound().getBoolean("Centrifugated");
			}
		}
		return false;
	}

	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean flag) {
		if (itemStack.hasTagCompound()) {
			if (itemStack.getTagCompound().hasKey("CreatureName")) {
				list.add(EnumChatFormatting.GRAY + itemStack.getTagCompound().getString("CreatureName"));
			}
			if (isCentrifuged(itemStack)) {
				if (itemStack.getTagCompound().hasKey("RNAHelix1")) {
					list.add(EnumChatFormatting.GREEN + itemStack.getTagCompound().getString("RNAHelix1"));
				}
				if (itemStack.getTagCompound().hasKey("RNAHelix2")) {
					list.add(EnumChatFormatting.GREEN + itemStack.getTagCompound().getString("RNAHelix2"));
				}
			}
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(BygoneAge.MODID + ":" + BygoneAgeItems.salivaSample.getUnlocalizedName().substring(5));
	}
}
