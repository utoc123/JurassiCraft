package to.uk.ilexiconn.jurassicraft.data.entity.entity;

import java.util.List;

import to.uk.ilexiconn.jurassicraft.data.entity.EntityDinosaurMonster;
import to.uk.ilexiconn.jurassicraft.data.entity.model.MowzieModelRenderer;
import to.uk.ilexiconn.jurassicraft.data.utility.ControlledParam;
import net.minecraft.entity.Entity;
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
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityTyrannosaurus extends EntityDinosaurMonster
{   
	public int texid;
	private int stepCount = 0;
	private float shakeCount = 0;
	public ControlledParam roarCount = new ControlledParam(0F, 0F, 0.5F, 0F);

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
        roarCount.update();
        if (this.moveForward != 0 && stepCount == 0) {
    		this.playSound("jurassicraft:footstep", 5.0F, 1.0F);
    		Entity target = this.getAttackTarget();
    		if (target instanceof EntityPlayer) {
    			((EntityPlayer) target).addVelocity(0, -5, 0); //How come this doesn't do anything??
//    			System.out.println("Boom");//The print works! Why doesn't THAT^^?
    		}
/*    		double radius = 3D;
    		List<EntityPlayer> near = location.getWorld().getEntities();
    		for(Entity e : near) {
    		    if(e.getLocation().distance(location) <= radius) 
    		        e.damage(9001);
    		}*/
    		stepCount = 15;
        }
        else {
        	if(stepCount > 0) stepCount -= this.moveForward;
        	if(stepCount < 0) stepCount = 0;
        }
    }
    
    public String getLivingSound()
    {
//    	if(isRoaring == false){
 //   		isRoaring = true;
    		int I = rand.nextInt(3)+1;
    		if(I == 1)
    		{
    	        this.playSound("jurassicraft:trex1", 5.0F, 1.0F);
        		roarCount.thereAndBack(0F, 0.1F, 1, 40);
    	        return null;
    		}
    		else if(I == 2)
    		{
    	        this.playSound("jurassicraft:trex2", 5.0F, 1.0F);
    	        return null;
    		}
    		else
    		{
    			return null;
    		}
//    	}
//    	return null;
    }

    public String getHurtSound()
    {
        this.playSound("jurassicraft:trex3", 5.0F, 1.0F);
        return null;
    }

    public String getDeathSound()
    {
        this.playSound("jurassicraft:trex3", 5.0F, 1.0F);
        return null;
    }
    
    public EntityTyrannosaurus spawnBabyAnimal(EntityAgeable par1EntityAgeable)
    {
        return new EntityTyrannosaurus(this.worldObj);
    }
}
