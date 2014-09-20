package to.uk.ilexiconn.jurassicraft.data.entity.entity;

import to.uk.ilexiconn.jurassicraft.data.entity.EntityDinosaurCreature;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityTriceratops extends EntityDinosaurCreature
{
    /** AI task for player control. */
    private final EntityAIControlledByPlayer aiControlledByPlayer;
    public float SitLevel;
	public int texid;

    
    public EntityTriceratops(World world)
    {
        super(world, 4);
        tasks.addTask(0, new EntityAISwimming(this));
        tasks.addTask(1, new EntityAIPanic(this, 2.0D));
        tasks.addTask(2, new EntityAIMate(this, 1.0D));
        tasks.addTask(3, new EntityAITempt(this, 1.25D, Items.wheat, false));
        tasks.addTask(4, new EntityAITempt(this, 1.2D, Items.carrot_on_a_stick, false));
        tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
        tasks.addTask(5, new EntityAIWander(this, 1.0D));
        tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        tasks.addTask(7, new EntityAILookIdle(this));
        tasks.addTask(0, this.aiControlledByPlayer = new EntityAIControlledByPlayer(this, 1.2F));
        this.SitLevel = 4.3F;
        texid = rand.nextInt(2);

    }
    
    public void updateRiderPosition()
    {
        if (this.riddenByEntity instanceof EntityPlayer)
        {
            this.riddenByEntity.setPosition(this.posX, this.posY + this.SitLevel + this.riddenByEntity.getYOffset(), this.posZ);
        }
    }
    
    /**
     * returns true if all the conditions for steering the entityOLD are met. For Triceratopss, this is true if it is being ridden
     * by a player and the player is holding a rotten flesh
     */
    public boolean canBeSteered()
    {
        ItemStack itemstack = ((EntityPlayer)this.riddenByEntity).getHeldItem();
        return itemstack != null && itemstack.getItem() == Items.carrot_on_a_stick;
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, Byte.valueOf((byte)0));
    }
    
    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return true;
    }
    
    protected void updateAITasks()
    {
        super.updateAITasks();
    }
    
    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a Triceratops.
     */
    public boolean interact(EntityPlayer par1EntityPlayer)
    {
        if (super.interact(par1EntityPlayer))
        {
            return true;
        }
        else if (!this.worldObj.isRemote && (this.riddenByEntity == null || this.riddenByEntity == par1EntityPlayer))
        {
            par1EntityPlayer.mountEntity(this);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Return the AI task for player control.
     */
    public EntityAIControlledByPlayer getAIControlledByPlayer()
    {
        return this.aiControlledByPlayer;
    }
    
    public EntityTriceratops createChild(EntityAgeable entity)
    {
        return new EntityTriceratops(worldObj);
    }
}