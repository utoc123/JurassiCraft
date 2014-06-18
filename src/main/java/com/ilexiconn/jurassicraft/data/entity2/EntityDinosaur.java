package com.ilexiconn.jurassicraft.data.entity2;

import com.ilexiconn.jurassicraft.data.entity.EntityAgeableMob;
import com.ilexiconn.jurassicraft.data.entity2.gender.Gender;
import net.minecraft.world.World;

public abstract class EntityDinosaur extends EntityAgeableMob
{
    private Gender gender;

    public EntityDinosaur(World par1World)
    {
        super(par1World);
    }

    public Gender getGender()
    {
        return gender;
    }

    public void setGender(Gender gender)
    {
        this.gender = gender;
    }
}
