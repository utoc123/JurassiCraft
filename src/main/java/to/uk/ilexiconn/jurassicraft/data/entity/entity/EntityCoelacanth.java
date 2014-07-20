package to.uk.ilexiconn.jurassicraft.data.entity.entity;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

import to.uk.ilexiconn.jurassicraft.data.entity.EntityDinosaurWaterCreature;

public class EntityCoelacanth extends EntityDinosaurWaterCreature {

   public EntityCoelacanth(World var1) {
      super(var1, 5);
   }

   protected boolean canAttackEntity(Entity entity) 
   {
	   return false;
   }
}
