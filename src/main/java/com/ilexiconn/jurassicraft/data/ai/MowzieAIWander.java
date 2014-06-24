package com.ilexiconn.jurassicraft.data.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.Vec3;

public class MowzieAIWander extends EntityAIBase
{
    private EntityCreature entity;
    private double xPosition;
    private double yPosition;
    private double zPosition;
    private double speed;
    private int xzRange;
    private int yRange;

    public MowzieAIWander(EntityCreature par1EntityCreature, double par2, int xzRange, int yRange)
    {
        entity = par1EntityCreature;
        speed = par2;
        setMutexBits(1);
        this.xzRange = xzRange;
        this.yRange = yRange;
    }

    public boolean shouldExecute()
    {
        if (entity.getAge() >= 100)
        {
            return false;
        }
        else if (entity.getRNG().nextInt(120) != 0)
        {
            return false;
        }
        else
        {
            Vec3 vec3 = RandomPositionGenerator.findRandomTarget(entity, xzRange, yRange);
            System.out.println("Destination coord is " + vec3.xCoord + ", " + vec3.yCoord + ", " + vec3.zCoord + ".");
            xPosition = vec3.xCoord;
            yPosition = vec3.yCoord;
            zPosition = vec3.zCoord;
            return true;
        }
    }

    public boolean continueExecuting()
    {
        return !entity.getNavigator().noPath();
    }

    public void startExecuting()
    {
        entity.getNavigator().tryMoveToXYZ(xPosition, yPosition, zPosition, speed);
    }
}