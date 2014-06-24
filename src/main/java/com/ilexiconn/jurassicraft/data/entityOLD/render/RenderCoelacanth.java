package com.ilexiconn.jurassicraft.data.entityOLD.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.ilexiconn.jurassicraft.Util;
import com.ilexiconn.jurassicraft.data.entityOLD.model.ModelCoelacanth;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderCoelacanth extends RenderLiving
{
    public ResourceLocation CoelacanthTexture = new ResourceLocation(Util.getModId() + "textures/entityOLD/coelacanth.png");

    public RenderCoelacanth()
    {
        super(new ModelCoelacanth(), 1f);
    }

    public ResourceLocation getEntityTexture(Entity entity)
    {
        return CoelacanthTexture;
    }
}
