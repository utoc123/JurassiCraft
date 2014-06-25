package com.ilexiconn.jurassicraft.data.entity.render;

import com.ilexiconn.jurassicraft.JurassiCraft;
import com.ilexiconn.jurassicraft.data.entity.Dinosaur;
import com.ilexiconn.jurassicraft.data.entity.RenderDinosaur;
import com.ilexiconn.jurassicraft.data.entity.model.ModelVelociraptor;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderVelociraptor extends RenderDinosaur
{
    public RenderVelociraptor(Dinosaur dino)
    {
        super(new ModelVelociraptor(), dino, 1f);
    }

    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/velociraptor1.png");
    }
}
