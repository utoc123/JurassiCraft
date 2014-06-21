package com.ilexiconn.jurassicraft.data.entity;

//import com.ilexiconn.jurassicraft.data.animation.AIAnkylosaurTailSlam;
//import com.ilexiconn.jurassicraft.data.animation.AIAnkylosaurTailWhip;

//import thehippomaster.AnimationAPI.AnimationAPI;
//import thehippomaster.AnimationAPI.IAnimatedEntity;
//import thehippomaster.AnimationExample.AIHeadBang;
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

public class EntityAnkylosaur extends EntityAnimal /*implements IAnimatedEntity*/
{
    public final int textureID;

    private int animID;
	private int animTick;
	
	public int frame;
	
    public EntityAnkylosaur(World par1World)
    {
        super(par1World);
        setSize(2F, 1.5F);
        getNavigator().setAvoidsWater(true);
        tasks.addTask(0, new EntityAISwimming(this));
        tasks.addTask(1, new EntityAIPanic(this, 2.0D));
//    	tasks.addTask(2, new AIAnkylosaurTailWhip(this));
//    	tasks.addTask(2, new AIAnkylosaurTailSlam(this));
        tasks.addTask(2, new EntityAIMate(this, 1.0D));
        tasks.addTask(3, new EntityAITempt(this, 1.25D, Items.wheat, false));
        tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
        tasks.addTask(5, new EntityAIWander(this, 1.0D));
        tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        tasks.addTask(7, new EntityAILookIdle(this));
        textureID = rand.nextInt(3) + 1;
    }
    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound nbttag)
    {
        super.writeEntityToNBT(nbttag);
        nbttag.setInteger("texture", textureID);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound nbttag)
    {
        super.readEntityFromNBT(nbttag);
        nbttag.getInteger("texture");
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
    public void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(160.0D);
        getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20000000298023224D);
    }
    
    public void onLivingUpdate() {
    	frame++;
    	super.onLivingUpdate();
    }

    public String getLivingSound()
    {
    	int I = rand.nextInt(1)+1;
    	if(I == 1)
    	{
    		return "jurassicraft:ankylo1";
    	}
    	else
    	{
            return "jurassicraft:ankylo2";
    	}
    }

    public String getHurtSound()
    {
		return "jurassicraft:ankylo1";
    }

    public String getDeathSound()
    {
        return "jurassicraft:ankylo2";
    }

    public void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
    {
        playSound("", 0.15F, 1.0F);
    }

    public float getSoundVolume()
    {
        return 0.4F;
    }

    public Item getDropItem()
    {
        return Items.leather;
    }

    public void dropFewItems(boolean par1, int par2)
    {
        int j = rand.nextInt(3) + rand.nextInt(1 + par2);
        int k;

        for (k = 0; k < j; ++k)
        {
            dropItem(Items.leather, 1);
        }

        j = rand.nextInt(3) + 1 + rand.nextInt(1 + par2);

        for (k = 0; k < j; ++k)
        {
            if (isBurning())
            {
                dropItem(Items.cooked_beef, 1);
            }
            else
            {
                dropItem(Items.beef, 1);
            }
        }
    }

    public EntityAnkylosaur createChild(EntityAgeable par1EntityAgeable)
    {
        return new EntityAnkylosaur(worldObj);
    }

	public float spiderScaleAmount() {
		return 1.5F;
	}
	/*
	//Animation API methods
	//Set the animID field to the id in the parameter.
	public void setAnimID(int id) {
		animID = id;
	}
	
	//Set the animTick field to the tick in the parameter.
	public void setAnimTick(int tick) {
		animTick = tick;
	}
	
	//Return the animID.
	public int getAnimID() {
		return animID;
	}

	//Return the animTick.
	public int getAnimTick() {
		return animTick;
	}
	
	public void onUpdate() {
		super.onUpdate();
		//increment the animTick if there is an animation playing
		if(animID != 0) animTick++;
	}
	
	public boolean attackEntityAsMob(Entity entity) {
		if(animID == 0) AnimationAPI.sendAnimPacket(this, 1);
		return true;
	}*/
}