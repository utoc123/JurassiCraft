package com.ilexiconn.jurassicraft.data.entity.render;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.ilexiconn.jurassicraft.JurassiCraft;
import com.ilexiconn.jurassicraft.data.entity.Dinosaur;
import com.ilexiconn.jurassicraft.data.entity.RenderDinosaur;
import com.ilexiconn.jurassicraft.data.entity.entity.EntityVelociraptor;
import com.ilexiconn.jurassicraft.data.entity.model.ModelVelociraptor;

public class RenderVelociraptor extends RenderDinosaur
{
    public RenderVelociraptor(Dinosaur dino)
    {
        super(new ModelVelociraptor(), dino, 1f);
    }

    public ResourceLocation getEntityTexture(Entity var1)
    {
    	EntityVelociraptor ank = (EntityVelociraptor)var1;
    	switch(ank.texid)
    	{
    	case 0:
    		default:
        return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/velociraptor1.png");
    	case 1:
        return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/velociraptor2.png");
    	}
    }
}
