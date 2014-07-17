package com.ilexiconn.jurassicraft.data.entity.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import com.ilexiconn.jurassicraft.data.entity.EntityDinosaurWaterCreature;

public class EntityTylosaurus extends EntityDinosaurWaterCreature {

   public EntityTylosaurus(World var1) {
      super(var1, 14);
   }

   protected void func_110147_ax() {
       super.applyEntityAttributes();
       this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25.0D);
   }

   protected boolean canAttackEntity(Entity entity) 
   {
	   if(!(entity instanceof EntityDinosaurWaterCreature))
	   {
		   return entity instanceof EntityLiving || super.canAttackEntity(entity) || entity instanceof EntityPlayer;
	   }
	   else
	   {
		   return false;
	   }
   }

   protected int getAttackStrength() {
      return 12;
   }
}
