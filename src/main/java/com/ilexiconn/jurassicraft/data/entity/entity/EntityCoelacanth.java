package com.ilexiconn.jurassicraft.data.entity.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import com.ilexiconn.jurassicraft.data.entity.EntityDinosaurWaterCreature;

public class EntityCoelacanth extends EntityDinosaurWaterCreature {

   public EntityCoelacanth(World var1) {
      super(var1, 5);
   }

   protected boolean canAttackEntity(Entity entity) 
   {
	   return false;
   }
}
