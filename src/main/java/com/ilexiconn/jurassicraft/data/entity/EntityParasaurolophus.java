package com.ilexiconn.jurassicraft.data.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityParasaurolophus extends EntityAnimal
{
    public int textureID;
    public boolean booleanThinger = false;

    public EntityParasaurolophus(World world)
    {
        super(world);
        this.setSize(3F, 3F);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.25D, Items.wheat, false));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
    }
    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer par1EntityPlayer)
    {
    	System.out.println(this.booleanThinger);
    	return true;
    }
    
    public boolean isAIEnabled()
    {
        return true;
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
        nbttag.setBoolean("bool", booleanThinger);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound nbttag)
    {
        super.readEntityFromNBT(nbttag);
        textureID = nbttag.getInteger("texture");
        booleanThinger = nbttag.getBoolean("bool");
    	System.out.println("Im getting called too :P");

    }
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(160.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20000000298023224D);
    }

    protected String getLivingSound()
    {
    	int I = rand.nextInt(1)+1;
    	if(I == 1)
    	{
    		return "jurassicraft:para1";
    	}
    	else
    	{
            return "jurassicraft:para2";
    	}
    }

    protected String getHurtSound()
    {
		return "jurassicraft:para1";
    }

    protected String getDeathSound()
    {
        return "jurassicraft:para2";
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
    {
        this.playSound("", 0.15F, 1.0F);
    }

    protected float getSoundVolume()
    {
        return 0.4F;
    }

    protected Item getDropItem()
    {
        return Items.leather;
    }

    protected void dropFewItems(boolean par1, int par2)
    {
        int j = this.rand.nextInt(3) + this.rand.nextInt(1 + par2);
        int k;

        for (k = 0; k < j; ++k)
        {
            this.dropItem(Items.leather, 1);
        }

        j = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + par2);

        for (k = 0; k < j; ++k)
        {
            if (this.isBurning())
            {
                this.dropItem(Items.cooked_beef, 1);
            }
            else
            {
                this.dropItem(Items.beef, 1);
            }
        }
    }

    public EntityParasaurolophus createChild(EntityAgeable par1EntityAgeable)
    {
        return new EntityParasaurolophus(this.worldObj);
    }

    public float spiderScaleAmount()
    {
        if (booleanThinger != true)
        {
        textureID = rand.nextInt(3)+1;
        System.out.println("Im getting called :P");
        booleanThinger = true;
        }
        return 2.1F;
    }
}