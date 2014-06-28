package com.ilexiconn.jurassicraft.data.entity.render;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.ilexiconn.jurassicraft.JurassiCraft;
import com.ilexiconn.jurassicraft.data.entity.Dinosaur;
import com.ilexiconn.jurassicraft.data.entity.RenderDinosaur;
import com.ilexiconn.jurassicraft.data.entity.model.ModelTyrannosaurus;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderTyrannosaurus extends RenderDinosaur
{
    public RenderTyrannosaurus(Dinosaur dino)
    {
        super(new ModelTyrannosaurus(), dino, 1f);
    }

    public ResourceLocation getEntityTexture(Entity var1)
    {
        return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/tyrannosaurus1.png");
    }
}
