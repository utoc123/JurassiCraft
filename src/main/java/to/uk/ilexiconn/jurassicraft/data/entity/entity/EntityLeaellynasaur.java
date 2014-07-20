package to.uk.ilexiconn.jurassicraft.data.entity.entity;

import to.uk.ilexiconn.jurassicraft.data.entity.EntityDinosaurCreature;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.world.World;

public class EntityLeaellynasaur extends EntityDinosaurCreature
{
	public int texid;

    public EntityLeaellynasaur(World world)
    {
        super(world, 9);
        tasks.addTask(0, new EntityAISwimming(this));
        tasks.addTask(1, new EntityAIPanic(this, 2.0D));
        tasks.addTask(2, new EntityAIMate(this, 1.0D));
        tasks.addTask(3, new EntityAITempt(this, 1.25D, Items.wheat, false));
        tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
        tasks.addTask(5, new EntityAIWander(this, 1.0D));
        tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        tasks.addTask(7, new EntityAILookIdle(this));
        texid = rand.nextInt(2);

    }

    public EntityLeaellynasaur createChild(EntityAgeable entity)
    {
        return new EntityLeaellynasaur(worldObj);
    }
}