package com.ilexiconn.jurassicraft.data.entity.render;

import com.ilexiconn.jurassicraft.Util;
import com.ilexiconn.jurassicraft.data.entity.Dinosaur;
import com.ilexiconn.jurassicraft.data.entity.RenderDinosaur;
import com.ilexiconn.jurassicraft.data.entity.model.ModelCoelacanth;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderCoelacanth extends RenderDinosaur
{
    public RenderCoelacanth(Dinosaur dino)
    {
        super(new ModelCoelacanth(), dino, 0.2f);
    }

    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return new ResourceLocation(Util.getModId() + "textures/entity/coelacanth.png");
    }
}
