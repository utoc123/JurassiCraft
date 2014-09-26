package to.uk.ilexiconn.jurassicraft.data.entity.entity;

import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.world.World;
import to.uk.ilexiconn.jurassicraft.Util;
import to.uk.ilexiconn.jurassicraft.data.entity.EntityJurassiCraftLandAggressive;
import to.uk.ilexiconn.jurassicraft.data.entity.IDinosaur;

public class EntityCearadactylus extends EntityJurassiCraftLandAggressive implements IDinosaur
{

    public EntityCearadactylus(World world)
    {
        super(world, (byte) 16);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIWander(this, this.getCreatureSpeed()));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, this.getCreatureSpeed()));
        this.tasks.addTask(5, new EntityAITempt(this, 1.2D * this.getCreatureSpeed(), Items.beef, false));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
    }

    public String getLivingSound()
    {
        if (this.rand.nextInt(2) == 0)
        {
            return Util.getDinoByID(this.getCreatureID()).livingSound1;
        }
        else
        {
            return Util.getDinoByID(this.getCreatureID()).livingSound2;
        }
    }

    public String getHurtSound()
    {
        return Util.getDinoByID(this.getCreatureID()).hurtSound;
    }

    public String getDeathSound()
    {
        return Util.getDinoByID(this.getCreatureID()).deathSound;
    }
}
