package to.uk.ilexiconn.jurassicraft.data.entity.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import to.uk.ilexiconn.jurassicraft.data.entity.EntityDinosaurWaterMonster;

public class EntityTylosaurus extends EntityDinosaurWaterMonster {

   public EntityTylosaurus(World var1) {
      super(var1, 14);
   }

   protected void func_110147_ax() {
       super.applyEntityAttributes();
       this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25.0D);
   }

   protected boolean canAttackEntity(Entity entity) 
   {
	   if(!(entity instanceof EntityDinosaurWaterMonster))
	   {
		   return entity instanceof EntityLiving || super.canAttackEntity(entity) || entity instanceof EntityPlayer;
	   }
	   else
	   {
		   return false;
	   }
   }

}
