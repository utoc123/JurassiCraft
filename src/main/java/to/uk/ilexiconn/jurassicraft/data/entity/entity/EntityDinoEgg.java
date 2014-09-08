package to.uk.ilexiconn.jurassicraft.data.entity.entity;

import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.Util;
import to.uk.ilexiconn.jurassicraft.data.entity.Dinosaur;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class EntityDinoEgg extends Entity implements IEntityAdditionalSpawnData
{
	public String dino;
	public int spawnTime;
	public int currentSpawnTime;
	public boolean froze;
	public boolean dried;

	public int rockAmount;
	
	/**
	 * Gegy's TODO: CLIENT - SERVER STUFF
	 * Spawning in wrong place
	 * Disappearing
	 * Suitable Environments
	 **/

	public EntityDinoEgg(World world) 
	{
		super(world);
		this.setSize(0.5F, 0.5F);
	}

	public EntityDinoEgg(World world, String dino, int spawnTime)
	{
		this(world);
		this.dino = dino;
		this.spawnTime = spawnTime;
	}

	public EntityDinoEgg(World world, String dino, int spawnTime, double x, double y, double z)
	{
		this(world, dino, spawnTime);
		this.setPosition(x + 0.5F, y, z + 0.5F);
	}

	public boolean attackEntityFrom(DamageSource damage, float amount)
	{
		if(!this.isEntityInvulnerable())
		{
			if(worldObj.isRemote)
			{
				if(amount > 0)
				{
					Minecraft mc = Minecraft.getMinecraft();

					Random random = new Random();

					for (int currentParticle = 0; currentParticle < 50; ++currentParticle)
					{
						float f3 = MathHelper.randomFloatClamp(random, 0.0F, ((float)Math.PI * 2F));
						double d5 = (double)MathHelper.randomFloatClamp(random, 0.75F, 1.0F);
						double velY = 0.20000000298023224D + 1 / 100.0D;
						double velX = (double)(MathHelper.cos(f3) * 0.2F) * d5 * d5 * (1 + 0.2D);
						double velZ = (double)(MathHelper.sin(f3) * 0.2F) * d5 * d5 * (1 + 0.2D);
						mc.theWorld.spawnParticle("blockdust_" + Block.getIdFromBlock(Blocks.sandstone) + "_0", (double)((float)this.posX), (double)((float)this.posY), (double)((float)this.posZ), velX, velY, velZ);
					}
				}
			}

			this.setDead();
		}

		return super.attackEntityFrom(damage, amount);
	}

	/** 
	 * Returns a boundingBox used to collide the entity with other entities and blocks. This enables the entity to be 
	 * pushable on contact, like boats or minecarts. 
	 */ 
	public AxisAlignedBB getCollisionBox(Entity entity) 
	{ 
		return entity.boundingBox; 
	} 

	/** 
	 * returns the bounding box for this entity 
	 */ 
	public AxisAlignedBB getBoundingBox() 
	{ 
		return null; 
	} 

	public boolean canBePushed()
	{
		return true;
	}

	public boolean canBeCollidedWith()
	{
		return !this.isDead;
	}

	protected boolean canTriggerWalking()
	{
		return false;
	}

	public void onUpdate()
	{
		super.onUpdate();

		if(worldObj.isRemote)
		{
			if(this.dataWatcher.getWatchableObjectInt(25) == 0)
			{
				froze = false;
			}
			else
			{
				froze = true;
			}
			
			if(this.dataWatcher.getWatchableObjectInt(26) == 0)
			{
				dried = false;
			}
			else
			{
				dried = true;
			}
			
			this.currentSpawnTime = this.dataWatcher.getWatchableObjectInt(27);
		}

		if(!this.onGround)
		{
			this.motionY -= 0.05F;
		}

		if(motionY < -0.8F)
		{
			this.motionY = -0.8F;
		}

		if(this.onGround)
		{
			this.motionX *= 0.5F;
			this.motionZ *= 0.5F;
		}
		else
		{
			this.motionX *= 0.7F;
			this.motionZ *= 0.7F;
		}

		if(!worldObj.isRemote)
		{
			int amountToIncrease = 0;

			boolean warm = worldObj.getBlockLightValue((int) posX, (int) posY, (int) posZ) > 6;
			boolean overheat = worldObj.getBlockLightValue((int) posX, (int) posY, (int) posZ) > 10;
			
			Dinosaur dinosaur = Util.getDinoByID(Util.getDinoIDByName(dino));
			
			if(dinosaur.waterCreature)
			{
				if(!isWet())
				{
					if(overheat)
					{
						amountToIncrease = -2;
					}
					else
					{
						amountToIncrease = -1;
					}
				}
			}
			else
			{
				if(warm && !this.isWet())
				{
					amountToIncrease = 1;
				}
				else
				{
					if(!warm && this.isWet())
					{
						amountToIncrease = -2;
					}
					else
					{
						amountToIncrease = -1;
					}
				}
			}

			currentSpawnTime += amountToIncrease;

			if(currentSpawnTime < -500)
			{
				if(dinosaur.waterCreature)
				{
					dried = true;
				}
				else
				{
					froze = true;
				}
			}
			
			if(currentSpawnTime >= spawnTime)
			{
				Class dinoToSpawnClass = Util.getDinoClass(dino);

				try 
				{

					Entity dinoToSpawn = (Entity) dinoToSpawnClass.getConstructor(World.class).newInstance(worldObj);
					dinoToSpawn.setPosition(this.posX, this.posY, this.posZ);

					worldObj.spawnEntityInWorld(dinoToSpawn);

					attackEntityFrom(DamageSource.generic, 0F);
				} 
				catch (InstantiationException e)
				{
					e.printStackTrace();
				}
				catch (IllegalAccessException e) 
				{
					e.printStackTrace();
				}
				catch (IllegalArgumentException e) 
				{
					e.printStackTrace();
				}
				catch (InvocationTargetException e) 
				{
					e.printStackTrace();
				}
				catch (NoSuchMethodException e) 
				{
					e.printStackTrace();
				} 
				catch (SecurityException e) 
				{
					e.printStackTrace();
				}	
			}			
		}

		if(currentSpawnTime < (spawnTime - 100))
		{
			if(!this.dried && !this.froze)
			{
				if(this.rotationPitch >= 5)
				{
					rockAmount = -1;
				}
				else if(this.rotationPitch <= -5)
				{
					rockAmount = 1;
				}
				
				this.rotationPitch += (rockAmount / 2.0F);
			}
		}
		
		if(!worldObj.isRemote)
		{
			this.dataWatcher.updateObject(25, froze ? 1 : 0);
			this.dataWatcher.updateObject(26, dried ? 1 : 0);
			this.dataWatcher.updateObject(27, currentSpawnTime);
		}

		this.moveEntity(this.motionX, this.motionY, this.motionZ);
	}

	public void fall(float fallDistance)
	{
		super.fall(fallDistance);

		if(fallDistance > 10 && this.onGround)
		{
			attackEntityFrom(DamageSource.fall, 1F);
		}
	}

	@Override
	protected void entityInit()
	{
		this.dataWatcher.addObject(25, 0);
		this.dataWatcher.addObject(26, 0);
		this.dataWatcher.addObject(27, rockAmount);
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound nbt)
	{
		this.spawnTime = nbt.getInteger("SpawnTime");
		this.currentSpawnTime = nbt.getInteger("CurrentSpawnTime");
		this.dino = nbt.getString("Dino");
		this.froze = nbt.getBoolean("Froze");
		this.dried = nbt.getBoolean("Dried");
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound nbt)
	{
		nbt.setInteger("SpawnTime", spawnTime);
		nbt.setInteger("CurrentSpawnTime", currentSpawnTime);
		nbt.setString("Dino", dino);
		nbt.setBoolean("Froze", froze);
		nbt.setBoolean("Dried", dried);
	}

	public ResourceLocation getTexture() 
	{
		return new ResourceLocation(JurassiCraft.getModId() + "textures/eggs/egg" + dino + ".png");
	}

	@Override
	public void writeSpawnData(ByteBuf buffer)
	{
		buffer.writeInt(Util.getDinoIDByName(dino));
	}

	@Override
	public void readSpawnData(ByteBuf additionalData) 
	{
		dino = Util.getDinoByID(additionalData.readInt()).name;
	}
}
