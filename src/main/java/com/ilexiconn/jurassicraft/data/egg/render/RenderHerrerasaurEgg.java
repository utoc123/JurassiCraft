package com.ilexiconn.jurassicraft.data.egg.render;

import com.ilexiconn.jurassicraft.Util;
import com.ilexiconn.jurassicraft.data.egg.model.ModelEgg;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderHerrerasaurEgg extends RenderLiving
{
    public RenderHerrerasaurEgg()
    {
        super(new ModelEgg(), 0.7f);
    }

    protected ResourceLocation getEntityTexture(Entity var1)
    {
        return new ResourceLocation(Util.getModId() + "textures/eggs/herrerasaurEgg.png");
    }
}
