package com.ilexiconn.jurassicraft.data.entity2;

import com.ilexiconn.jurassicraft.data.entity.EntityAgeableMob;
import com.ilexiconn.jurassicraft.data.entity2.gender.Gender;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import java.util.Random;

public class EntityDinosaur extends EntityAgeableMob
{
    private Gender gender;

    public EntityDinosaur(World par1World)
    {
        super(par1World);
        setGender(new Random().nextInt(2) == 0 ? Gender.MALE : Gender.FEMALE);
    }

    public Gender getGender()
    {
        return gender;
    }

    public void setGender(Gender gender)
    {
        this.gender = gender;
    }

    public void writeEntityToNBT(NBTTagCompound nbt)
    {
        super.writeEntityToNBT(nbt);
        nbt.setInteger("gender", getGender() == Gender.MALE ? 0 : 1);
    }

    public void readEntityFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        setGender(nbt.getInteger("gender") == 0 ? Gender.MALE : Gender.FEMALE);
    }

    public EntityAgeable createChild(EntityAgeable entity)
    {
        return createChild((EntityDinosaur) entity);
    }

    public EntityAgeable createChild(EntityDinosaur entity)
    {
        if (getGender() != entity.getGender()) return new EntityDinosaur(worldObj);
        else return null;
    }
}