package com.ilexiconn.jurassicraft.data.entity.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.ilexiconn.jurassicraft.Util;
import com.ilexiconn.jurassicraft.data.entity.entity.EntityLiopleurodon;
import com.ilexiconn.jurassicraft.data.entity.model.ModelLiopleurodon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderLiopleurodon extends RenderLiving
{
    public ResourceLocation liopleurodonTexture1 = new ResourceLocation(Util.getModId() + "textures/entity/liopleurodon1.png");
    public ResourceLocation liopleurodonTexture2 = new ResourceLocation(Util.getModId() + "textures/entity/liopleurodon2.png");

    public RenderLiopleurodon()
    {
        super(new ModelLiopleurodon(), 1f);
    }

    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityLiopleurodon entityLiopleurodon = (EntityLiopleurodon) entity;
        switch (entityLiopleurodon.TextureID)
        {
            case 2:
                return liopleurodonTexture1;
            case 1:
                return liopleurodonTexture2;
            case 3:
                return liopleurodonTexture1;
            case 4:
                return liopleurodonTexture2;
            default:
                return null;
        }    }
}
