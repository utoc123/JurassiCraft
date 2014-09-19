package com.rafamv.fossilhunting.entity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
	
public class EntityCoronicerasRotiforme extends EntityAnimal {
	
	    private float field_70926_e;
	    private float field_70924_f;
	    /** true if the bear is wet else false */
	    private boolean isShaking;
	    private boolean field_70928_h;
	    /**
	     * This time increases while bear is shaking and emitting water particles.
	     */
	    private float timeBearIsShaking;
	    private float prevTimeBearIsShaking;
	    private static final String __OBFID = "CL_00001654";
	 
	     
	    public EntityCoronicerasRotiforme(World par1World) {
	        super(par1World);
	        this.setSize(0.6F, 0.8F);
	        this.getNavigator().setAvoidsWater(true);
	        this.tasks.addTask(1, new EntityAISwimming(this));
	        this.tasks.addTask(2, new EntityAILeapAtTarget(this, 0.4F));
	        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, 1.0D, true));
	        this.tasks.addTask(4, new EntityAIMate(this, 1.0D));
	        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
	        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
	        this.tasks.addTask(7, new EntityAILookIdle(this));
	        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
	    }
	 
	    protected void applyEntityAttributes()
	    {
	        super.applyEntityAttributes();
	        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30000001192092896D);
	 
	        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(12.0D);
	    }
	 
	    /**
	     * Returns true if the newer Entity AI code should be run
	     */
	    public boolean isAIEnabled()
	    {
	        return true;
	    }
	 
	    /**
	     * Sets the active target the Task system uses for tracking
	     */
	    public void setAttackTarget(EntityLivingBase par1EntityLivingBase)
	    {
	        super.setAttackTarget(par1EntityLivingBase);
	 
	        if (par1EntityLivingBase == null)
	        {
	            this.setAngry(false);
	        }
	        else
	        {
	            this.setAngry(true);
	        }
	    }
	 
	    /**
	     * main AI tick function, replaces updateEntityActionState
	     */
	    protected void updateAITick()
	    {
	        this.dataWatcher.updateObject(18, Float.valueOf(this.getHealth()));
	    }
	 
	    protected void entityInit()
	    {
	        super.entityInit();
	        this.dataWatcher.addObject(18, new Float(this.getHealth()));
	        this.dataWatcher.addObject(19, new Byte((byte)0));
	        this.dataWatcher.addObject(20, new Byte((byte)BlockColored.func_150032_b(1)));
	    }
	 
	    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
	    {
	        this.playSound("mob.wolf.step", 0.15F, 1.0F);
	    }
	 
	    /**
	     * (abstract) Protected helper method to write subclass entity data to NBT.
	     */
	    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	    {
	        super.writeEntityToNBT(par1NBTTagCompound);
	        par1NBTTagCompound.setBoolean("Angry", this.isAngry());
	    }
	 
	    /**
	     * (abstract) Protected helper method to read subclass entity data from NBT.
	     */
	    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	    {
	        super.readEntityFromNBT(par1NBTTagCompound);
	        this.setAngry(par1NBTTagCompound.getBoolean("Angry"));
	    }
	 
	    /**
	     * Returns the sound this mob makes while it's alive.
	     */
	    protected String getLivingSound()
	    {
	        return this.isAngry() ? "mob.wolf.growl" : (this.rand.nextInt(3) == 0 ? (this.dataWatcher.getWatchableObjectFloat(18) < 10.0F ? "mob.wolf.whine" : "mob.wolf.panting") : "mob.wolf.bark");
	    }
	 
	    /**
	     * Returns the sound this mob makes when it is hurt.
	     */
	    protected String getHurtSound()
	    {
	        return "mob.wolf.hurt";
	    }
	 
	    /**
	     * Returns the sound this mob makes on death.
	     */
	    protected String getDeathSound()
	    {
	        return "mob.wolf.death";
	    }
	 
	    /**
	     * Returns the volume for the sounds this mob makes.
	     */
	    protected float getSoundVolume()
	    {
	        return 0.4F;
	    }
	 
	    protected Item getDropItem()
	    {
	        return Item.getItemById(-1);
	    }
	 
	    /**
	     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
	     * use this to react to sunlight and start to burn.
	     */
	    public void onLivingUpdate()
	    {
	        super.onLivingUpdate();
	 
	        if (!this.worldObj.isRemote && this.isShaking && !this.field_70928_h && !this.hasPath() && this.onGround)
	        {
	            this.field_70928_h = true;
	            this.timeBearIsShaking = 0.0F;
	            this.prevTimeBearIsShaking = 0.0F;
	            this.worldObj.setEntityState(this, (byte)8);
	        }
	    }
	 
	    /**
	     * Called to update the entity's position/logic.
	     */
	    public void onUpdate()
	    {
	        super.onUpdate();
	 
	        if (this.isWet())
	        {
	            this.isShaking = true;
	            this.field_70928_h = false;
	            this.timeBearIsShaking = 0.0F;
	            this.prevTimeBearIsShaking = 0.0F;
	        }
	        else if ((this.isShaking || this.field_70928_h) && this.field_70928_h)
	        {
	            if (this.timeBearIsShaking == 0.0F)
	            {
	                this.playSound("mob.wolf.shake", this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
	            }
	 
	            this.prevTimeBearIsShaking = this.timeBearIsShaking;
	            this.timeBearIsShaking += 0.05F;
	 
	            if (this.prevTimeBearIsShaking >= 2.0F)
	            {
	                this.isShaking = false;
	                this.field_70928_h = false;
	                this.prevTimeBearIsShaking = 0.0F;
	                this.timeBearIsShaking = 0.0F;
	            }
	 
	            if (this.timeBearIsShaking > 0.4F)
	            {
	                float f = (float)this.boundingBox.minY;
	                int i = (int)(MathHelper.sin((this.timeBearIsShaking - 0.4F) * (float)Math.PI) * 7.0F);
	 
	                for (int j = 0; j < i; ++j)
	                {
	                    float f1 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width * 0.5F;
	                    float f2 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width * 0.5F;
	                    this.worldObj.spawnParticle("splash", this.posX + (double)f1, (double)(f + 0.8F), this.posZ + (double)f2, this.motionX, this.motionY, this.motionZ);
	                }
	            }
	        }
	    }
	 
	    @SideOnly(Side.CLIENT)
	    public boolean getBearShaking()
	    {
	        return this.isShaking;
	    }
	 
	    /**
	     * Used when calculating the amount of shading to apply while the wolf is shaking.
	     */
	    @SideOnly(Side.CLIENT)
	    public float getShadingWhileShaking(float par1)
	    {
	        return 0.75F + (this.prevTimeBearIsShaking + (this.timeBearIsShaking - this.prevTimeBearIsShaking) * par1) / 2.0F * 0.25F;
	    }
	 
	    @SideOnly(Side.CLIENT)
	    public float getShakeAngle(float par1, float par2)
	    {
	        float f2 = (this.prevTimeBearIsShaking + (this.timeBearIsShaking - this.prevTimeBearIsShaking) * par1 + par2) / 1.8F;
	 
	        if (f2 < 0.0F)
	        {
	            f2 = 0.0F;
	        }
	        else if (f2 > 1.0F)
	        {
	            f2 = 1.0F;
	        }
	 
	        return MathHelper.sin(f2 * (float)Math.PI) * MathHelper.sin(f2 * (float)Math.PI * 11.0F) * 0.15F * (float)Math.PI;
	    }
	 
	    public float getEyeHeight()
	    {
	        return this.height * 0.8F;
	    }
	 
	    @SideOnly(Side.CLIENT)
	    public float getInterestedAngle(float par1)
	    {
	        return (this.field_70924_f + (this.field_70926_e - this.field_70924_f) * par1) * 0.15F * (float)Math.PI;
	    }
	 
	    /**
	     * Called when the entity is attacked.
	     */
	    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2)
	    {
	        if (this.isEntityInvulnerable())
	        {
	            return false;
	        }
	        else
	        {
	            Entity entity = par1DamageSource.getEntity();
	 
	            if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow))
	            {
	                par2 = (par2 + 1.0F) / 2.0F;
	            }
	 
	            return super.attackEntityFrom(par1DamageSource, par2);
	        }
	    }
	 
	    public boolean attackEntityAsMob(Entity par1Entity)
	    {
	        int i =  2;
	        return par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float)i);
	    }
	 
	    @SideOnly(Side.CLIENT)
	    public void handleHealthUpdate(byte par1)
	    {
	        if (par1 == 8)
	        {
	            this.field_70928_h = true;
	            this.timeBearIsShaking = 0.0F;
	            this.prevTimeBearIsShaking = 0.0F;
	        }
	        else
	        {
	            super.handleHealthUpdate(par1);
	        }
	    }
	 
	    /**
	     * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
	     * the animal type)
	     */
	    public boolean isBreedingItem(ItemStack par1ItemStack)
	    {
	        return par1ItemStack == null ? false : (!(par1ItemStack.getItem() instanceof ItemFood) ? false : ((ItemFood)par1ItemStack.getItem()).isWolfsFavoriteMeat());
	    }
	 
	    /**
	     * Will return how many at most can spawn in a chunk at once.
	     */
	    public int getMaxSpawnedInChunk()
	    {
	        return 8;
	    }
	 
	    /**
	     * Determines whether this wolf is angry or not.
	     */
	    public boolean isAngry()
	    {
//	        return (this.dataWatcher.getWatchableObjectByte(16) & 2) != 0;
	        return false;
	    }
	 
	    /**
	     * Sets whether this wolf is angry or not.
	     */
	    public void setAngry(boolean par1)
	    {
	        byte b0 = this.dataWatcher.getWatchableObjectByte(16);
	 
	        if (par1)
	        {
	            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | 2)));
	        }
	        else
	        {
	            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 & -3)));
	        }
	    }
	 
	    public EntityCoronicerasRotiforme createChild(EntityAgeable par1EntityAgeable)
	    {
	    	EntityCoronicerasRotiforme entitybear = new EntityCoronicerasRotiforme(this.worldObj);
	         return entitybear;
	    }
	 
	    public void func_70918_i(boolean par1)
	    {
	        if (par1)
	        {
	            this.dataWatcher.updateObject(19, Byte.valueOf((byte)1));
	        }
	        else
	        {
	            this.dataWatcher.updateObject(19, Byte.valueOf((byte)0));
	        }
	    }
	 
	    /**
	     * Returns true if the mob is currently able to mate with the specified mob.
	     */
	    public boolean canMateWith(EntityAnimal par1EntityAnimal)
	    {
	        if (par1EntityAnimal == this)
	        {
	            return false;
	        }
	        else if (!(par1EntityAnimal instanceof EntityCoronicerasRotiforme))
	        {
	            return false;
	        }
	        else
	        {
	        	EntityCoronicerasRotiforme entitybear = (EntityCoronicerasRotiforme)par1EntityAnimal;
	            return this.isInLove() && entitybear.isInLove();
	        }
	    }
	 
	  
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*
	private boolean looksWithInterest;

	
	public static final double baseHealth = EnumDinoType.Stegosaurus.Health0;
	public static final double baseDamage = EnumDinoType.Stegosaurus.Strength0; 
	public static final double baseSpeed = EnumDinoType.Stegosaurus.Speed0;
	
	public static final double maxHealth = EnumDinoType.Stegosaurus.HealthMax; 
	public static final double maxDamage = EnumDinoType.Stegosaurus.StrengthMax; 
	public static final double maxSpeed = EnumDinoType.Stegosaurus.SpeedMax;
	 

	public EntityCompsognathus(World world) {
		// super(world);
		this.looksWithInterest = false;
		this.setSize(1.0F, 0.8F);

		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAILeapAtTarget(this, 0.4F));
		this.tasks.addTask(3, new DinoAIAttackOnCollide(this, 1.0D, true));
		this.tasks.addTask(4, new DinoAIFollowOwner(this, 1.0F, 5.0F, 2.0F));
		this.tasks.addTask(7, new DinoAIEat(this, 24));
		this.tasks.addTask(7, new DinoAIWander(this, 1.0D));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(9, new EntityAILookIdle(this));

	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(baseSpeed);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(baseHealth);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(baseDamage);
	}

	public void onUpdate() {
		super.onUpdate();
		if (this.looksWithInterest) {
			this.numTicksToChaseTarget = 10;
		}
	}

	public float getEyeHeight() {
		return this.height * 0.8F;
	}

	public boolean attackEntityFrom(DamageSource var1, int var2) {
		Entity var3 = var1.getEntity();
		this.setSitting(false);

		if (var3 != null && !(var3 instanceof EntityPlayer) && !(var3 instanceof EntityArrow)) {
			var2 = (var2 + 1) / 2;
		}

		if (!super.attackEntityFrom(var1, var2)) {
			return false;
		} else {
			if (!this.isTamed() && !this.isSelfAngry()) {
				if (var3 instanceof EntityPlayer) {
					this.setSelfAngry(true);
					this.entityToAttack = var3;
				}

				if (var3 instanceof EntityArrow && ((EntityArrow) var3).shootingEntity != null) {
					var3 = ((EntityArrow) var3).shootingEntity;
				}

				if (var3 instanceof EntityLiving) {
					;
				}
			} else if (var3 != this && var3 != null) {
				if (this.isTamed() && var3 instanceof EntityPlayer && ((EntityPlayer) var3).username.equalsIgnoreCase(this.getOwnerName())) {
					return true;
				}

				this.entityToAttack = var3;
			}

			return true;
		}
	}

	protected Entity findPlayerToAttack() {
		return this.isSelfAngry() ? this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D) : null;
	}

	public boolean interact(EntityPlayer var1) {
		return super.interact(var1);
	}

	public boolean getCanSpawnHere() {
		return this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).size() == 0 && !this.worldObj.isAnyLiquid(this.boundingBox);
	}

	private float updateRotation(float var1, float var2, float var3) {
		float var4;

		for (var4 = var2 - var1; var4 < -180.0F; var4 += 360.0F) {
			;
		}

		while (var4 >= 180.0F) {
			var4 -= 360.0F;
		}

		if (var4 > var3) {
			var4 = var3;
		}

		if (var4 < -var3) {
			var4 = -var3;
		}

		return var1 + var4;
	}

	public void applyEntityCollision(Entity var1) {
		if (var1 instanceof EntityLiving && !(var1 instanceof EntityPlayer) && this.riddenByEntity != null && this.onGround) {
			this.onKillEntity((EntityLiving) var1);
			((EntityLiving) var1).attackEntityFrom(DamageSource.causeMobDamage(this), 10);
		} else {
			super.applyEntityCollision(var1);
		}
	}
*/
