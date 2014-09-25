package to.uk.ilexiconn.jurassicraft.data.entity.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import to.uk.ilexiconn.jurassicraft.Util;
import to.uk.ilexiconn.jurassicraft.data.entity.Dinosaur;
import to.uk.ilexiconn.jurassicraft.data.entity.EntitySwimming;

public class EntityCoelacanth extends EntitySwimming {

    public EntityCoelacanth(World world) {
        super(world, (byte) 5);
        Dinosaur dino = Util.getDinoByID(5);
        //this.setSize(dino.xzHitbox, dino.yHitbox);
        this.setSize(1.0F, 1.0F);

        this.swimRadius = 8.0F;
        this.swimRadiusHeight = 4.0F;

        this.swimSpeed = 0.4F;
        this.jumpOnLand = false;
    }

    @Override
    protected Entity findEntityToAttack() {
        return null;
    }

    @Override
    protected String getLivingSound() {
        return null;
    }

    @Override
    protected String getHurtSound() {
        return null;
    }

    @Override
    protected String getDeathSound() {
        return null;
    }

    @Override
    public Item getDropItem() {
        return Util.getMeat(5);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        Dinosaur dino = Util.getDinoByID(5);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10);
    }

}
