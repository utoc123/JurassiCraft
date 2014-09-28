package to.uk.ilexiconn.jurassicraft.entity.dinosaur;

import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.world.World;
import thehippomaster.AnimationAPI.AnimationAPI;
import to.uk.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIFollowFood;
import to.uk.ilexiconn.jurassicraft.ai.JurassiCraftEntityAITargetIfNonTamed;
import to.uk.ilexiconn.jurassicraft.animation.AITyrannosaurusRoar;
import to.uk.ilexiconn.jurassicraft.entity.EntityJurassiCraftLandAggressive;
import to.uk.ilexiconn.jurassicraft.entity.IDinosaur;
import to.uk.ilexiconn.jurassicraft.utility.ControlledParam;

public class EntityTyrannosaurus extends EntityJurassiCraftLandAggressive implements IDinosaur
{

    private int stepCount = 0;
    private float shakeCount = 0;
    public ControlledParam roarCount = new ControlledParam(0F, 0F, 0.5F, 0F);
    public ControlledParam roarTiltDegree = new ControlledParam(0F, 0F, 1F, 0F);

    public EntityTyrannosaurus(World world)
    {
        super(world, (byte) 6);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIWander(this, this.getCreatureSpeed()));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(2, new AITyrannosaurusRoar(this));
        this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, this.getCreatureSpeed()));
        this.tasks.addTask(5, new JurassiCraftEntityAIFollowFood(this, 1.2D * this.getCreatureSpeed()));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(5, new JurassiCraftEntityAITargetIfNonTamed(this, EntityTriceratops.class, 0));
        this.targetTasks.addTask(5, new JurassiCraftEntityAITargetIfNonTamed(this, EntityParasaurolophus.class, 0));
    }

    public String getLivingSound()
    {
        // if(isRoaring == false){
        // isRoaring = true;
        int I = rand.nextInt(3) + 1;
        if (I == 1)
        {
            this.playSound("jurassicraft:trex1", 5.0F, this.getSoundPitch());
            if (animID == 0 && this.getAttackTarget() == null)
            {
                AnimationAPI.sendAnimPacket(this, 1);
            }
            /*
			 * else if(this.getAttackTarget() != null) {
			 * roarCount.thereAndBack(0F, 0.1F, 1, 40);
			 * System.out.println(roarCount.change); }
			 */
            return null;
        }
        else if (I == 2)
        {
            this.playSound("jurassicraft:trex2", 5.0F, this.getSoundPitch());
            return null;
        }
        else
        {
            return null;
        }
        // }
        // return null;
    }

    public String getHurtSound()
    {
        this.playSound("jurassicraft:trex3", 5.0F, this.getSoundPitch());
        return null;
    }

    public String getDeathSound()
    {
        this.playSound("jurassicraft:trex3", 5.0F, this.getSoundPitch());
        return null;
    }

    public void onUpdate()
    {
        super.onUpdate();
        roarCount.update();
        roarTiltDegree.update();
        if (animID == 1 && animTick == 22)
            this.roarTiltDegree.thereAndBack(0F, 0.1F, 1F, 20);
    }
}
