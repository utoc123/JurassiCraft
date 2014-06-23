package com.ilexiconn.jurassicraft.data.entity.render;

import com.ilexiconn.jurassicraft.Util;
import com.ilexiconn.jurassicraft.data.entity.entity.EntityDimetrodon;
import com.ilexiconn.jurassicraft.data.entity.model.ModelDimetrodon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderDimetrodon extends RenderLiving
{
    public ResourceLocation DimetrodonTextureW = new ResourceLocation(Util.getModId() + "textures/entity/dimetrodon1.png");
    public ResourceLocation DimetrodonTextureT = new ResourceLocation(Util.getModId() + "textures/entity/dimetrodon2.png");
	
    public RenderDimetrodon()
    {   
    	super(new ModelDimetrodon(), 1f);
    }

    public ResourceLocation getEntityTexture(Entity entity)
    {
    	EntityDimetrodon dimetrodon = (EntityDimetrodon)entity;
    	return dimetrodon.isTamed() ? DimetrodonTextureT : DimetrodonTextureW;
    }
}
