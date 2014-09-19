package com.rafamv.bygoneage.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import com.rafamv.bygoneage.BygoneAge;
import com.rafamv.bygoneage.registry.BygoneAgeItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Analyzer extends Item {

	public Analyzer() {
		this.setMaxStackSize(1);
		this.setCreativeTab(BygoneAge.bygoneAgeTab);
	}

	@Override
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
		if (!itemStack.hasTagCompound()) {
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("Owner", player.getCommandSenderName());
			itemStack.setTagCompound(compound);
		}
	}

	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean flag) {
		if (itemStack.hasTagCompound()) {
			if (itemStack.getTagCompound().hasKey("Owner")) {
				list.add(EnumChatFormatting.GRAY + "Owner: " + itemStack.getTagCompound().getString("Owner"));
			}
		} else {
			list.add(EnumChatFormatting.GRAY + "Device used to scan prehistoric creatures.");
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(BygoneAge.MODID + ":" + BygoneAgeItems.analyzer.getUnlocalizedName().substring(5));
	}
}
