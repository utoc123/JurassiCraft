package to.uk.ilexiconn.jurassicraft.entity.dinosaur;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import thehippomaster.AnimationAPI.AnimationAPI;
import to.uk.ilexiconn.jurassicraft.Util;
import to.uk.ilexiconn.jurassicraft.entity.Dinosaur;
import to.uk.ilexiconn.jurassicraft.entity.EntitySwimming;
import to.uk.ilexiconn.jurassicraft.entity.NewEntitySwimming;
import to.uk.ilexiconn.jurassicraft.utility.ControlledParam;

public class EntityTylosaurus extends NewEntitySwimming {

    public EntityTylosaurus(World world)
    {
        super(world, (byte) 14);
        
        Dinosaur dino = Util.getDinoByID(14);
        //this.setSize(dino.xzHitbox, dino.yHitbox);
        this.setSize(1.0F, 1.0F);

        this.swimRadius = 16.0F;
        this.swimRadiusHeight = 10.0F;

        this.swimSpeed = 0.6F;

        this.jumpOnLand = false;
        this.attackInterval = 1;
        this.isAgressive = true;
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        Dinosaur dino = Util.getDinoByID(14);
        //this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(dino.health);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10);
    }

    @Override
    public Item getDropItem()
    {
        return Util.getMeat(14);
    }

    @Override
    protected Entity findEntityToAttack()
    {
        AxisAlignedBB area = this.boundingBox.expand(16.0D, 16.0D, 16.0D);

        EntityPlayer player = (EntityPlayer) super.findEntityToAttack();
        if (player != null)
            return player;

        return this.worldObj.findNearestEntityWithinAABB(EntityAnimal.class, area, this);
    }
    
    public void onUpdate() {
    	super.onUpdate();
    }
}
