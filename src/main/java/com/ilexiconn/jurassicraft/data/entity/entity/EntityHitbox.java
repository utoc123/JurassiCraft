package com.ilexiconn.jurassicraft.data.entity.entity;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityHitbox extends EntityLiving {
	EntityLiving parent;
	float offsetX;
	float offsetY;
	float offsetZ;
	float distanceFromParent;
	
	public EntityHitbox(World par1World, EntityLiving parent, float sizexz, float sizey, float offsetX, float offsetY ,float offsetZ)
    {
        super(par1World);
        this.parent = parent;
        this.setSize(sizexz, sizey);
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.offsetZ = offsetZ;
		this.posX = parent.posX + offsetX;
		this.posY = parent.posY + offsetY;
		this.posZ = parent.posZ + offsetZ;
		distanceFromParent = (float)Math.sqrt(Math.pow((this.posX - parent.posX), 2) + Math.pow((this.posZ - parent.posZ), 2));
    }
	
	public boolean canDespawn () {
		return false;
	}
	
	@Override
	public void onUpdate() {
/*		super.onUpdate();
		this.posX = parent.posX + (float) (distanceFromParent*(Math.cos(parent.rotationYawHead)));
		this.posY = parent.posY + offsetY;
		this.posZ = parent.posZ + (float) (distanceFromParent*(Math.sin(parent.rotationYawHead)));
		System.out.println("Hitbox is at " + this.posX + ", " + this.posY + ", " + this.posZ);*/
		
		super.onUpdate();
		this.posX = parent.posX + offsetX;
		this.posY = parent.posY + offsetY;
		this.posZ = parent.posZ + offsetZ;
//		System.out.println("Hitbox is at " + this.posX + ", " + this.posY + ", " + this.posZ);
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
		parent.attackEntityFrom(par1DamageSource, par2);
		super.attackEntityFrom(par1DamageSource, par2);
		return true;
	}
}
