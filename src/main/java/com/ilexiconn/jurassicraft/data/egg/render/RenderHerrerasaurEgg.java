package com.ilexiconn.jurassicraft.data.egg.render;

import com.ilexiconn.jurassicraft.Util;
import com.ilexiconn.jurassicraft.data.egg.model.ModelEgg;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderHerrerasaurEgg extends RenderLiving
{
    public ResourceLocation eggTexture = new ResourceLocation(Util.getModId() + "textures/eggs/herrerasaurEgg.png");

    public RenderHerrerasaurEgg()
    {
        super(new ModelEgg(), 0.2f);
    }

    public ResourceLocation getEntityTexture(Entity entity)
    {
        return eggTexture;
    }
}
