package com.ilexiconn.jurassicraft.data.entity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.world.World;

public class EntityHitbox extends EntityLiving {
	EntityLiving parent;
	float offsetX;
	float offsetY;
	float offsetZ;
	
	public EntityHitbox(World par1World, EntityLiving parent, float sizexz, float sizey)
    {
        super(par1World);
        this.parent = parent;
        this.setSize(sizexz, sizey);
    }
	
	public void onUpdate() {
		this.posX = parent.posX + offsetX;
		this.posY = parent.posY + offsetY;
		this.posZ = parent.posZ + offsetZ;
	}
}
