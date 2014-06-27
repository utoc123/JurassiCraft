package com.ilexiconn.jurassicraft.data.entity.entity;

import com.ilexiconn.jurassicraft.data.entity.EntityDinosaurWaterMonster;

import net.minecraft.block.material.Material;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityCoelacanth extends EntityDinosaurWaterMonster
{
    public float LiopleurodonPitch;
    public float prevLiopleurodonPitch;
    public float LiopleurodonYaw;
    public float prevLiopleurodonYaw;
    public float LiopleurodonRotation;
    public float prevLiopleurodonRotation;
    public float tentacleAngle;
    public float lastTentacleAngle;
    private float randomMotionSpeed;
    private float rotationVelocity;
    private float field_70871_bB;
    private float randomMotionVecX;
    private float randomMotionVecY;
    private float randomMotionVecZ;

    public EntityCoelacanth(World par1World, int dinoID)
    {
        super(par1World, dinoID);
        this.setSize(0.5F, 0.5F);
        this.rotationVelocity = 1.0F / (this.rand.nextFloat() + 1.0F) * 0.2F;
    }
    /**
     * Determines if an entityOLD can be despawned, used on idle far away entities
     */

    protected boolean canTriggerWalking()
    {
        return false;
    }

    protected void dropFewItems(boolean par1, int par2)
    {

    }

    public boolean isInWater()
    {
        return this.worldObj.handleMaterialAcceleration(this.boundingBox.expand(0.0D, -0.6000000238418579D, 0.0D), Material.water, this);
    }

    public void onLivingUpdate()
    {
        super.onLivingUpdate();
        this.prevLiopleurodonPitch = this.LiopleurodonPitch;
        this.prevLiopleurodonYaw = this.LiopleurodonYaw;
        this.prevLiopleurodonRotation = this.LiopleurodonRotation;
        this.lastTentacleAngle = this.tentacleAngle;
        this.LiopleurodonRotation += this.rotationVelocity;

        if (this.LiopleurodonRotation > ((float) Math.PI * 2F))
        {
            this.LiopleurodonRotation -= ((float) Math.PI * 2F);

            if (this.rand.nextInt(10) == 0)
            {
                this.rotationVelocity = 1.0F / (this.rand.nextFloat() + 1.0F) * 0.2F;
            }
        }

        if (this.isInWater())
        {
            float f;

            if (this.LiopleurodonRotation < (float) Math.PI)
            {
                f = this.LiopleurodonRotation / (float) Math.PI;
                this.tentacleAngle = MathHelper.sin(f * f * (float) Math.PI) * (float) Math.PI * 0.25F;

                if ((double) f > 0.75D)
                {
                    this.randomMotionSpeed = 1.0F;
                    this.field_70871_bB = 1.0F;
                }
                else
                {
                    this.field_70871_bB *= 0.8F;
                }
            }
            else
            {
                this.tentacleAngle = 0.0F;
                this.randomMotionSpeed *= 0.9F;
                this.field_70871_bB *= 0.99F;
            }

            if (!this.worldObj.isRemote)
            {
                this.motionX = (double) (this.randomMotionVecX * this.randomMotionSpeed);
                this.motionY = (double) (this.randomMotionVecY * this.randomMotionSpeed);
                this.motionZ = (double) (this.randomMotionVecZ * this.randomMotionSpeed);
            }

            f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.renderYawOffset += (-((float) Math.atan2(this.motionX, this.motionZ)) * 180.0F / (float) Math.PI - this.renderYawOffset) * 0.1F;
            this.rotationYaw = this.renderYawOffset;
            this.LiopleurodonYaw += (float) Math.PI * this.field_70871_bB * 1.5F;
            this.LiopleurodonPitch += (-((float) Math.atan2((double) f, this.motionY)) * 180.0F / (float) Math.PI - this.LiopleurodonPitch) * 0.1F;
        }
        else
        {
            this.tentacleAngle = MathHelper.abs(MathHelper.sin(this.LiopleurodonRotation)) * (float) Math.PI * 0.25F;

            if (!this.worldObj.isRemote)
            {
                this.motionX = 0.0D;
                this.motionY -= 0.08D;
                this.motionY *= 0.9800000190734863D;
                this.motionZ = 0.0D;
            }

            this.LiopleurodonPitch = (float) ((double) this.LiopleurodonPitch + (double) (-90.0F - this.LiopleurodonPitch) * 0.02D);
        }
    }

    public void moveEntityWithHeading(float par1, float par2)
    {
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
    }

    protected void updateEntityActionState()
    {
        ++this.entityAge;

        if (this.entityAge > 100)
        {
            this.randomMotionVecX = this.randomMotionVecY = this.randomMotionVecZ = 0.0F;
        }
        else if (this.rand.nextInt(50) == 0 || !this.inWater || this.randomMotionVecX == 0.0F && this.randomMotionVecY == 0.0F && this.randomMotionVecZ == 0.0F)
        {
            float f = this.rand.nextFloat() * (float) Math.PI * 2.0F;
            this.randomMotionVecX = MathHelper.cos(f) * 0.2F;
            this.randomMotionVecY = -0.1F + this.rand.nextFloat() * 0.2F;
            this.randomMotionVecZ = MathHelper.sin(f) * 0.2F;
        }

        this.despawnEntity();
    }

    public boolean getCanSpawnHere()
    {
        return this.posY > 45.0D && this.posY < 63.0D && super.getCanSpawnHere();
    }
}
