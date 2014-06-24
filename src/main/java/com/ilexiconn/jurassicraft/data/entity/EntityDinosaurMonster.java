package com.ilexiconn.jurassicraft.data.entity;

import com.ilexiconn.jurassicraft.Util;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import thehippomaster.AnimationAPI.IAnimatedEntity;

public abstract class EntityDinosaurMonster extends EntityMob implements IAnimatedEntity
{
    public int animID;
    public int animTick;
    public float scaleAmount;
    public int frame;

    public double speed = Util.getEntityParser().getCurrentDino().dinoSpeed;
    
    public EntityDinosaurMonster(World world)
    {
        super(world);
        setSize(Util.getEntityParser().getCurrentDino().hitboxSizeXZ, Util.getEntityParser().getCurrentDino().hitboxSizeY);
        setScaleAmount(Util.getEntityParser().getCurrentDino().dinoScale);
        getNavigator().setAvoidsWater(true);
    }

    public boolean isAIEnabled()
    {
        return true;
    }

    public void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(Util.getEntityParser().getCurrentDino().dinoHealth);
        getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(Util.getEntityParser().getCurrentDino().dinoSpeed);
    }

    public String getLivingSound()
    {
        int I = rand.nextInt(1)+1;
        if(I == 1)
        {
            return Util.getEntityParser().getCurrentDino().livingSound1;
        }
        else
        {
            return Util.getEntityParser().getCurrentDino().livingSound2;
        }
    }

    public String getHurtSound()
    {
        return Util.getEntityParser().getCurrentDino().hurtSound;
    }

    public String getDeathSound()
    {
        return Util.getEntityParser().getCurrentDino().deathSound;
    }

    public float getSoundVolume()
    {
        return 0.4F;
    }

    public int getAnimTick()
    {
        return animTick;
    }

    public int getAnimID()
    {
        return animID;
    }

    public void setAnimID(int id)
    {
        animID = id;
    }

    public void setAnimTick(int tick)
    {
        animTick = tick;
    }

    public void setScaleAmount(float scaleAmount)
    {
        this.scaleAmount = scaleAmount;
    }

    public float getScaleAmount()
    {
        return scaleAmount;
    }

    public Item getDropItem()
    {
        return Util.getEntityParser().getCurrentMeat();
    }

    public void onUpdate()
    {
        super.onUpdate();
        if(animID != 0) animTick++;
        frame++;
    }
}
