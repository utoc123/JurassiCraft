package com.ilexiconn.jurassicraft.data.entity.render;

import com.ilexiconn.jurassicraft.JurassiCraft;
import com.ilexiconn.jurassicraft.data.entity.EntityHerrerasaur;
import com.ilexiconn.jurassicraft.data.entity.model.ModelHerrerasaur;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderHerrerasaur extends RenderLiving
{
    public ResourceLocation herrerasaurTexture1 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/herrerasaur1.png");
    public ResourceLocation herrerasaurTexture2 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/herrerasaur2.png");

    public RenderHerrerasaur()
    {
        super(new ModelHerrerasaur(), 1f);
    }

    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityHerrerasaur entityHerrerasaur = (EntityHerrerasaur) entity;
        switch (entityHerrerasaur.textureID)
        {
            case 2:
                return herrerasaurTexture1;
            case 1:
                return herrerasaurTexture2;
            case 3:
                return herrerasaurTexture1;
            case 4:
                return herrerasaurTexture2;
            default:
                return null;
        }
    }
}
