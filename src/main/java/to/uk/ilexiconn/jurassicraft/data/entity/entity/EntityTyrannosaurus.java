package to.uk.ilexiconn.jurassicraft.data.entity.entity;

import to.uk.ilexiconn.jurassicraft.data.entity.EntityDinosaurMonster;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.world.World;

public class EntityTyrannosaurus extends EntityDinosaurMonster
{   
	public int texid;

    public EntityTyrannosaurus(World par1World)
    {
        super(par1World, 6);
        float moveSpeed = 1.3F;
        this.setSize(5F, 6F);
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, moveSpeed + 0.2F, false));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityStegosaur.class, moveSpeed, true));
        this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, moveSpeed));
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.25D, Items.beef, false));
        this.tasks.addTask(0, new EntityAIWander(this, 1.3D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityStegosaur.class, 0, false));
        this.experienceValue = 1000;   
        texid = rand.nextInt(2);
    
    }

    public void onLivingUpdate()
    {
        super.onLivingUpdate();
    }

    public String getLivingSound()
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

    public String getHurtSound()
    {
        return "jurassicraft:trex3";
    }

    public String getDeathSound()
    {
        return "jurassicraft:trex3";
    }

    public EntityTyrannosaurus spawnBabyAnimal(EntityAgeable par1EntityAgeable)
    {
        return new EntityTyrannosaurus(this.worldObj);
    }
}
