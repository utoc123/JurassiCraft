package com.ilexiconn.jurassicraft.data.entity.render;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.ilexiconn.jurassicraft.JurassiCraft;
import com.ilexiconn.jurassicraft.data.entity.Dinosaur;
import com.ilexiconn.jurassicraft.data.entity.RenderDinosaur;
import com.ilexiconn.jurassicraft.data.entity.model.ModelMeganeura;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderMeganeura extends RenderDinosaur
{
    public RenderMeganeura(Dinosaur dino)
    {
        super(new ModelMeganeura(), dino, 1f);
    }

    public ResourceLocation getEntityTexture(Entity entity)
    {
        return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/meganeura1.png");
    }
}
