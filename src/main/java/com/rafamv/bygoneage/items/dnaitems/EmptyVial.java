package com.rafamv.bygoneage.items.dnaitems;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

import com.rafamv.bygoneage.BygoneAge;
import com.rafamv.bygoneage.entity.EntityBygoneAgeAnimated;
import com.rafamv.bygoneage.entity.EntityBygoneAgeCreature;
import com.rafamv.bygoneage.handler.BygoneAgeDNAHandler;
import com.rafamv.bygoneage.registry.BygoneAgeItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EmptyVial extends Item {

	public EmptyVial() {
		this.setCreativeTab(BygoneAge.bygoneAgeTab);
	}

	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean flag) {
		list.add(EnumChatFormatting.GRAY + "Used to get saliva.");
	}

	@Override
	public boolean itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase entity) {
		if (entity.worldObj.isRemote) {
			return false;
		}
		if (entity instanceof EntityBygoneAgeCreature || entity instanceof EntityChicken || entity instanceof EntityPig || entity instanceof EntityCow || entity instanceof EntitySheep) {
			ItemStack salivaSample = new ItemStack(BygoneAgeItems.salivaSample, 1);
			NBTTagCompound compound = new NBTTagCompound();	
			compound.setString("CreatureName", BygoneAgeDNAHandler.getAnimalName(entity));
			if (entity instanceof EntityChicken || entity instanceof EntityPig || entity instanceof EntityCow || entity instanceof EntitySheep) {
				compound.setString("RNAHelix1", BygoneAgeDNAHandler.generateNewRNA(18));
				compound.setString("RNAHelix2", BygoneAgeDNAHandler.createNewRNAFrom(compound.getString("RNAHelix1")));
			} else {
				compound.setString("RNAHelix1", ((EntityBygoneAgeCreature) entity).getGeneticCode());
				compound.setString("RNAHelix2", BygoneAgeDNAHandler.createNewRNAFrom(compound.getString("RNAHelix1")));
			}
			salivaSample.setTagCompound(compound);
			itemstack.stackSize--;
			if (itemstack.stackSize <= 0) {
				itemstack = (ItemStack) null;
			}
			player.inventory.addItemStackToInventory(salivaSample);
			((EntityPlayerMP) player).sendContainerToPlayer(player.inventoryContainer);
			return true;
		}
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(BygoneAge.MODID + ":" + BygoneAgeItems.emptyVial.getUnlocalizedName().substring(5));
	}

}
