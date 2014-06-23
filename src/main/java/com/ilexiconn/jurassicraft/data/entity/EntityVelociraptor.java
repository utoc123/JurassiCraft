package com.ilexiconn.jurassicraft.data.entity;

import com.ilexiconn.jurassicraft.data.ai.MowzieAIWander;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityVelociraptor extends EntityAgeableMob
{
    public int textureID;
    private int conversionTime = 0;
    public boolean isRoaring = false;
    public float frame = 0;
    
    public EntityVelociraptor(World par1World)
    {
        super(par1World);
        float moveSpeed = 1.3F;
        this.setSize(1.9F, 1.5F);
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, moveSpeed + 0.2F, false));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityStegosaur.class, moveSpeed, true));
        this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, moveSpeed));
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.25D, Items.beef, false));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
        this.tasks.addTask(0, new EntityAIWander(this, 1.3D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityStegosaur.class, 0, false));
        this.experienceValue = 1000;
        textureID = rand.nextInt(3) + 1;
    }
    /**
     * Determines if an entity can be despawned, used on idle far away entities
     */
    protected boolean canDespawn()
    {
        return false;
    }
    
    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound nbttag)
    {
        super.writeEntityToNBT(nbttag);
        nbttag.setInteger("texture", textureID);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound nbttag)
    {
        super.readEntityFromNBT(nbttag);
        nbttag.getInteger("texture");
    }
    @SideOnly(Side.CLIENT)
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(160.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25000000298023224D);
        //this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(5.0D);
    }


    protected boolean isAIEnabled()
    {
        return true;
    }

    public void onLivingUpdate()
    {
        if (this.worldObj.isDaytime() && !this.worldObj.isRemote && !this.isChild())
        {
            float var1 = this.getBrightness(100.0F);

            if (var1 > 0.5F && this.rand.nextFloat() * 30.0F < (var1 - 0.4F) * 2.0F && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)))
            {
                this.setFire(-99);
            }
        }
        frame += 0.1;
        super.onLivingUpdate();
    }


    public int getAttackStrength(Entity par1Entity)
    {
        return 40;
    }

    protected String getLivingSound()
    {
//    	if(isRoaring == false){
 //   		isRoaring = true;
    		int I = rand.nextInt(1)+1;
    		if(I == 1)
    		{
    			return "jurassicraft:trex1";
    		}
    		else
    		{
    			return "jurassicraft:trex2";
    		}
//    	}
//    	return null;
    }

    protected String getHurtSound()
    {
        return "jurassicraft:trex3";
    }

    protected String getDeathSound()
    {
        return "jurassicraft:trex3";
    }

    protected void dropFewItems(boolean par1, int par2)
    {

    }

    public EntityVelociraptor spawnBabyAnimal(EntityAgeable par1EntityAgeable)
    {
        return new EntityVelociraptor(this.worldObj);
    }

    public EntityAgeable createChild(EntityAgeable par1EntityAgeable)
    {
        return this.spawnBabyAnimal(par1EntityAgeable);
    }

	public float spiderScaleAmount() {
		return 1.2F;
	}
}
