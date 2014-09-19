package com.rafamv.bygoneage.items;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import com.rafamv.bygoneage.BygoneAge;
import com.rafamv.bygoneage.entity.EntityBygoneAgeCreature;
import com.rafamv.bygoneage.entity.creatures.EntityArsinoitherium;
import com.rafamv.bygoneage.entity.creatures.EntityBasilosaurus;
import com.rafamv.bygoneage.entity.creatures.EntityDeinotherium;
import com.rafamv.bygoneage.entity.creatures.EntityLeptictidium;
import com.rafamv.bygoneage.entity.creatures.EntityMammoth;
import com.rafamv.bygoneage.entity.creatures.EntityMoeritherium;
import com.rafamv.bygoneage.entity.creatures.EntityTitanisWalleri;
import com.rafamv.bygoneage.entity.creatures.EntityUintatherium;
import com.rafamv.bygoneage.enums.BygoneAgeMobsInformation;
import com.rafamv.bygoneage.handler.BygoneAgeDNAHandler;
import com.rafamv.bygoneage.registry.BygoneAgeItems;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BygoneAgeSpawnEgg extends Item {

	private static Random random = new Random();

	public BygoneAgeSpawnEgg() {
		this.setCreativeTab(BygoneAge.bygoneAgeTab);
		this.setHasSubtypes(true);
	}

	@Override
	public String getItemStackDisplayName(ItemStack itemStack) {
		return StatCollector.translateToLocal(this.getUnlocalizedName() + "." + BygoneAgeMobsInformation.values()[itemStack.getItemDamage()].getCreatureName() + ".name").trim();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack itemStack, int metadata) {
        Random random = new Random(BygoneAgeMobsInformation.values()[itemStack.getItemDamage()].getCreatureName().hashCode());
        int primaryColor = random.nextInt() * 16777215;
		return primaryColor;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (int i = 4; i < BygoneAgeMobsInformation.values().length; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int hitX, float hitY, float hitZ, float metadata) {
		if (world.isRemote) {
			return true;
		} else {
			Block block = world.getBlock(x, y, z);
			x += Facing.offsetsXForSide[hitX];
			y += Facing.offsetsYForSide[hitX];
			z += Facing.offsetsZForSide[hitX];
			double yTranslation = 0.0D;
			if (hitX == 1 && block.getRenderType() == 11) {
				yTranslation = 0.5D;
			}
			EntityBygoneAgeCreature creature = (EntityBygoneAgeCreature) spawnCreature(world, player, itemStack, (double) x + 0.5D, (double) y + yTranslation, (double) z + 0.5D);
			if (creature != null) {
				if (creature instanceof EntityLivingBase && itemStack.hasDisplayName()) {
					((EntityLiving) creature).setCustomNameTag(itemStack.getDisplayName());
				}
				if (!player.capabilities.isCreativeMode) {
					itemStack.stackSize--;
					if (itemStack.stackSize <= 0) {
						itemStack = (ItemStack) null;
					}
				}
			}
			return true;
		}
	}

	public static EntityBygoneAgeCreature spawnCreature(World world, EntityPlayer player, ItemStack itemStack, double x, double y, double z) {
		EntityBygoneAgeCreature creature = null;
		String mobName = BygoneAgeMobsInformation.values()[itemStack.getItemDamage()].getCreatureName();
		if (mobName == BygoneAgeMobsInformation.LEPTICTIDIUM.getCreatureName()) {
			creature = new EntityLeptictidium(world);
		} else if (mobName == BygoneAgeMobsInformation.MOERITHERIUM.getCreatureName()) {
			creature = new EntityMoeritherium(world);
		} else if (mobName == BygoneAgeMobsInformation.UINTATHERIUM.getCreatureName()) {
			creature = new EntityUintatherium(world);
		} else if (mobName == BygoneAgeMobsInformation.ARSINOITHERIUM.getCreatureName()) {
			creature = new EntityArsinoitherium(world);
		} else if (mobName == BygoneAgeMobsInformation.TITANISWALLERI.getCreatureName()) {
			creature = new EntityTitanisWalleri(world);
		} else if (mobName == BygoneAgeMobsInformation.BASILOSAURUS.getCreatureName()) {
			creature = new EntityBasilosaurus(world);
		} else if (mobName == BygoneAgeMobsInformation.MAMMOTH.getCreatureName()) {
			creature = new EntityMammoth(world);
		} else if (mobName == BygoneAgeMobsInformation.DEINOTHERIUM.getCreatureName()) {
			creature = new EntityDeinotherium(world);
		} else {
			creature = new EntityLeptictidium(world);
		}
		String rna1 = BygoneAgeDNAHandler.generateNewRNA(18);
		String rna2 = BygoneAgeDNAHandler.generateNewRNA(18);
		String rna3 = BygoneAgeDNAHandler.generateNewRNA(18);
		String rna4 = BygoneAgeDNAHandler.generateNewRNA(18);
		creature.createGeneticCode(rna1, rna2, rna3, rna4);
		creature.setGenetics(BygoneAgeDNAHandler.calculateDNAQuality(rna1, BygoneAgeDNAHandler.createNewRNAFrom(rna1)), BygoneAgeDNAHandler.calculateDNAQuality(rna2, BygoneAgeDNAHandler.createNewRNAFrom(rna2)), BygoneAgeDNAHandler.calculateDNAQuality(rna3, BygoneAgeDNAHandler.createNewRNAFrom(rna3)), BygoneAgeDNAHandler.calculateDNAQuality(rna4, BygoneAgeDNAHandler.createNewRNAFrom(rna4)));
		creature.setLocationAndAngles(x, y, z, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
		creature.rotationYawHead = creature.rotationYaw;
		creature.renderYawOffset = creature.rotationYaw;
		if (player.isSneaking()) {
			creature.setFullGrowth();
		}
		world.spawnEntityInWorld(creature);
		creature.playLivingSound();
		return creature;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(BygoneAge.MODID + ":" + BygoneAgeItems.spawnEgg.getUnlocalizedName().substring(5));
	}

}
