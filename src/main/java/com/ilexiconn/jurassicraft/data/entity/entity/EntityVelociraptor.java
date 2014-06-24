package com.ilexiconn.jurassicraft.data.entity.entity;

import com.ilexiconn.jurassicraft.data.animation.AIVelociraptorLeap;
import com.ilexiconn.jurassicraft.data.animation.AIVelociraptorRoar;
import com.ilexiconn.jurassicraft.data.animation.AIVelociraptorTwitchHead;
import com.ilexiconn.jurassicraft.data.entity.EntityDinosaurMonster;

import thehippomaster.AnimationAPI.AnimationAPI;
import thehippomaster.AnimationAPI.IAnimatedEntity;
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
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityVelociraptor extends EntityDinosaurMonster
{
    public boolean isRoaring = false;
    
    private float distanceFromTarget;
    public boolean leaping;
    public int timeSinceLeap;
    
    public EntityVelociraptor(World world)
    {
        super(world);
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityPlayer.class, speed + 0.4F, false));
//        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityStegosaur.class, moveSpeed + 0.4F, true));
        this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, speed));
        this.tasks.addTask(0, new EntityAISwimming(this));
        
        this.tasks.addTask(2, new AIVelociraptorTwitchHead(this));
        this.tasks.addTask(2, new AIVelociraptorRoar(this));
        this.tasks.addTask(2, new AIVelociraptorLeap(this));
        
//       this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
//        this.tasks.addTask(3, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.25D, Items.beef, false));
//        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
//        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityStegosaur.class, 0, false));
        this.experienceValue = 1000;
    }

    protected boolean canDespawn()
    {
        return false;
    }
    
    public void readEntityFromNBT(NBTTagCompound nbttag)
    {
        super.readEntityFromNBT(nbttag);
        nbttag.getInteger("texture");
    }

    public void onLivingUpdate()
    {
    	//Leap AI
        if (this.getAttackTarget() != null) {
        	distanceFromTarget = (float)Math.sqrt(Math.pow((this.posX - this.getAttackTarget().posX), 2) + Math.pow((this.posZ - this.getAttackTarget().posZ), 2));
        }
        else {
        	distanceFromTarget = -1;
        }
        if (distanceFromTarget >= 5 && distanceFromTarget <=6  && onGround && timeSinceLeap == 0) AnimationAPI.sendAnimPacket(this, 3);
        if (onGround) leaping = false;
        if (timeSinceLeap != 0) timeSinceLeap--;
        
        //Misc
        frame += 0.1;
        super.onLivingUpdate();
    }
    
    public float getRenderYawOffsetChange() {
    	float change = this.prevRenderYawOffset - this.renderYawOffset;
//    	System.out.println(change);
    	return change;
    }

    public int getAttackStrength(Entity par1Entity)
    {
        return 10;
    }

    @Override
	public String getLivingSound()
    {
//    	if(isRoaring == false){
 //   		isRoaring = true;
    		if(animID == 0)AnimationAPI.sendAnimPacket(this, 2);
    		int I = rand.nextInt(4)+1;
    		if(I == 1) {
    			return "jurassicraft:RapHiss01";
    		}
    		if(I == 2) {
    			return "jurassicraft:RapHiss02";
    		}
    		if(I == 3) {
    			return "jurassicraft:RapHiss02";
    		}
    		else
    		{
    			return "jurassicraft:RapBark03";
    		}
//    	}
//    	return null;
    }

    @Override
    public String getHurtSound()
    {
		if(animID == 0)AnimationAPI.sendAnimPacket(this, 2);
        return "jurassicraft:RapAttack01";
    }

    @Override
    public String getDeathSound()
    {
		if(animID == 0)AnimationAPI.sendAnimPacket(this, 2);
        return "jurassicraft:RapAttack02";
    }

    public EntityVelociraptor spawnBabyAnimal(EntityAgeable par1EntityAgeable)
    {
        return new EntityVelociraptor(this.worldObj);
    }

	public float spiderScaleAmount() {
		return 1.2F;
	}
	
	//Animation API Methods
	@Override
	public void setAnimID(int id) {
		animID = id;		
	}
	@Override
	public void setAnimTick(int tick) {
		animTick = tick;
	}
	@Override
	public int getAnimID() {
		return animID;
	}
	@Override
	public int getAnimTick() {
		return animTick;
	}
	public void onUpdate() {
		super.onUpdate();
		//increment the animTick if there is an animation playing
		if(animID != 0) animTick++;
	}
}
