package com.ilexiconn.jurassicraft.data.entity.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.ilexiconn.jurassicraft.Util;
import com.ilexiconn.jurassicraft.data.entity.model.ModelCoelacanth;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderCoelacanth extends RenderLiving
{
    public ResourceLocation CoelacanthTexture = new ResourceLocation(Util.getModId() + "textures/entity/coelacanth.png");

    public RenderCoelacanth()
    {
        super(new ModelCoelacanth(), 1f);
    }

    public ResourceLocation getEntityTexture(Entity entity)
    {
        return CoelacanthTexture;
    }
}
