package to.uk.ilexiconn.jurassicraft.data.entity.entity;

import java.lang.reflect.InvocationTargetException;

import to.uk.ilexiconn.jurassicraft.Util;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityDinoEgg extends Entity
{
	public String dino;
	public int spawnTime;
	public int currentSpawnTime;
	
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
		this.setPosition(x, y, z);
	}
	
	public boolean canBePushed()
	{
		return true;
	}
	
	public boolean canBeCollidedWith()
	{
		return true;
	}
	
	public void onUpdate()
	{
		super.onUpdate();
		
		currentSpawnTime++;
		
		if(!worldObj.isRemote)
		{
			if(currentSpawnTime >= spawnTime)
			{
				Class dinoToSpawnClass = Util.getDinoClass(dino);
				
				try 
				{
					Entity dinoToSpawn = (Entity) dinoToSpawnClass.getConstructor(World.class).newInstance(worldObj);
					dinoToSpawn.setPosition(posX, posY, posZ);
					worldObj.spawnEntityInWorld(dinoToSpawn);
					this.setDead();
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
	}
	
	@Override
	protected void entityInit()
	{
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound nbt)
	{
		this.spawnTime = nbt.getInteger("SpawnTime");
		this.currentSpawnTime = nbt.getInteger("CurrentSpawnTime");
		this.dino = nbt.getString("Dino");
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound nbt)
	{
		nbt.setInteger("SpawnTime", spawnTime);
		nbt.setInteger("CurrentSpawnTime", currentSpawnTime);
		nbt.setString("Dino", dino);
	}
}
