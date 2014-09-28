package to.uk.ilexiconn.jurassicraft.entity.dinosaur;

import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.world.World;
import thehippomaster.AnimationAPI.AnimationAPI;
import to.uk.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIFollowFood;
import to.uk.ilexiconn.jurassicraft.animation.AIVelociraptorLeap;
import to.uk.ilexiconn.jurassicraft.animation.AIVelociraptorRoar;
import to.uk.ilexiconn.jurassicraft.animation.AIVelociraptorTwitchHead;
import to.uk.ilexiconn.jurassicraft.entity.EntityJurassiCraftLandAggressive;
import to.uk.ilexiconn.jurassicraft.entity.IDinosaur;

public class EntityVelociraptor extends EntityJurassiCraftLandAggressive implements IDinosaur
{
    public boolean leaping = false;
    public int timeSinceLeap;
    public int texid;

    public EntityVelociraptor(World world)
    {
        super(world, (byte) 2);
        this.getNavigator().setAvoidsWater(true);
        tasks.addTask(0, new EntityAISwimming(this));
        tasks.addTask(1, new EntityAIMoveTowardsRestriction(this, this.getCreatureSpeed()));
        this.tasks.addTask(2, this.aiSit);
        tasks.addTask(2, new AIVelociraptorTwitchHead(this));
        tasks.addTask(2, new AIVelociraptorRoar(this));
        tasks.addTask(2, new AIVelociraptorLeap(this));
        tasks.addTask(4, new JurassiCraftEntityAIFollowFood(this, 1.1D * this.getCreatureSpeed()));
        tasks.addTask(5, new EntityAIWander(this, 0.8D * this.getCreatureSpeed()));
        tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        tasks.addTask(7, new EntityAILookIdle(this));
        targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
    }

    public void onLivingUpdate()
    {
        // Leap AI
        float distanceFromTarget;
        if (getAttackTarget() != null)
            distanceFromTarget = (float) Math.sqrt(Math.pow((posX - getAttackTarget().posX), 2) + Math.pow((posZ - getAttackTarget().posZ), 2));
        else
            distanceFromTarget = -1;
        if (distanceFromTarget >= 5 && distanceFromTarget <= 6 && onGround && timeSinceLeap == 0)
            AnimationAPI.sendAnimPacket(this, 3);
        if (onGround == true)
            setLeaping(false);
        if (timeSinceLeap != 0)
            timeSinceLeap--;

        // Misc
        super.onLivingUpdate();
    }

    public void setLeaping(boolean l)
    {
        this.leaping = l;
    }

    public String getLivingSound()
    {
        if (animID == 0 && this.getAttackTarget() == null)
            AnimationAPI.sendAnimPacket(this, 2);
        int I = rand.nextInt(4) + 1;
        if (I == 1)
            return "jurassicraft:RapHiss01";
        if (I == 2)
            return "jurassicraft:RapHiss02";
        if (I == 3)
            return "jurassicraft:RapHiss03";
        else
            return "jurassicraft:RapBark03";
    }

    public String getHurtSound()
    {
        // if(animID == 0)AnimationAPI.sendAnimPacket(this, 2);
        return super.getHurtSound();
    }

    public String getDeathSound()
    {
        if (animID == 0)
            AnimationAPI.sendAnimPacket(this, 2);
        return super.getDeathSound();
    }
}
