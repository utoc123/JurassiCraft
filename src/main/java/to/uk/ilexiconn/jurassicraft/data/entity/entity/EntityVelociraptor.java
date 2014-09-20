package to.uk.ilexiconn.jurassicraft.data.entity.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.world.World;
import thehippomaster.AnimationAPI.AnimationAPI;
import to.uk.ilexiconn.jurassicraft.data.animation.AIVelociraptorLeap;
import to.uk.ilexiconn.jurassicraft.data.animation.AIVelociraptorRoar;
import to.uk.ilexiconn.jurassicraft.data.animation.AIVelociraptorTwitchHead;
import to.uk.ilexiconn.jurassicraft.data.entity.EntityDinosaurCreature;
import to.uk.ilexiconn.jurassicraft.data.entity.EntityDinosaurMonster;

public class EntityVelociraptor extends EntityDinosaurMonster
{
    public boolean leaping = false;
    public int timeSinceLeap;
	public int texid;

    public EntityVelociraptor(World par1World)
    {
        super(par1World, 2);
        float moveSpeed = 1.3F;
        setSize(1.9F, 1.5F);
        tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityPlayer.class, moveSpeed + 0.4F, false));
        tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityDinosaurCreature.class, moveSpeed + 0.4F, true));
        tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, moveSpeed));
        tasks.addTask(0, new EntityAISwimming(this));

        tasks.addTask(2, new AIVelociraptorTwitchHead(this));
        tasks.addTask(2, new AIVelociraptorRoar(this));
        tasks.addTask(2, new AIVelociraptorLeap(this));
        
//      tasks.addTask(1, new EntityAIPanic(this, 2.0D));
        tasks.addTask(3, new EntityAITempt(this, 1.25D, Items.beef, false));
        tasks.addTask(5, new EntityAIWander(this, 1.0D));
        tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        tasks.addTask(7, new EntityAILookIdle(this));
        targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityDinosaurCreature.class, 0, false));
        texid = rand.nextInt(2);

    }

    public void onLivingUpdate()
    {
        //Leap AI
        float distanceFromTarget;
        if (getAttackTarget() != null)
            distanceFromTarget = (float) Math.sqrt(Math.pow((posX - getAttackTarget().posX), 2) + Math.pow((posZ - getAttackTarget().posZ), 2));
        else
            distanceFromTarget = -1;
        if (distanceFromTarget >= 5 && distanceFromTarget <= 6 && onGround && timeSinceLeap == 0)
            AnimationAPI.sendAnimPacket(this, 3);
        if (onGround == true) setLeaping(false);
        if (timeSinceLeap != 0) timeSinceLeap--;

        //Misc
        super.onLivingUpdate();
    }

    
    public void setLeaping(boolean l) {
    	this.leaping = l;
    }
    
	public int getAttackStrength(Entity par1Entity)
	{
		return 50;
	}

    public String getLivingSound()
    {
        if(animID == 0 && this.getAttackTarget() == null) AnimationAPI.sendAnimPacket(this, 2);
        int I = rand.nextInt(4)+1;
        if(I == 1) return "jurassicraft:RapHiss01";
        if(I == 2) return "jurassicraft:RapHiss02";
        if(I == 3) return "jurassicraft:RapHiss03";
        else return "jurassicraft:RapBark03";
    }

    public String getHurtSound()
    {
//        if(animID == 0)AnimationAPI.sendAnimPacket(this, 2);
        return super.getHurtSound();
    }

    public String getDeathSound()
    {
        if(animID == 0)AnimationAPI.sendAnimPacket(this, 2);
        return super.getDeathSound();
    }
}
