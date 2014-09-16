package to.uk.ilexiconn.jurassicraft.data.entity.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import to.uk.ilexiconn.jurassicraft.DinoEntry;
import to.uk.ilexiconn.jurassicraft.data.entity.Dinosaur;
import to.uk.ilexiconn.jurassicraft.data.entity.EntitySwimming;

public class EntityCoelacanth extends EntitySwimming {

    public EntityCoelacanth(World world) {
        super(world);
        Dinosaur dino = DinoEntry.getDinoByID(5);
        this.setSize(dino.xzHitbox, dino.yHitbox);

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
        return DinoEntry.getMeat(5);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        Dinosaur dino = DinoEntry.getDinoByID(5);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(dino.health);
    }

}
