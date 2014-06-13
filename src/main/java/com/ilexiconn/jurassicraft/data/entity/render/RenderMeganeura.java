package com.ilexiconn.jurassicraft.data.entity.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.ilexiconn.jurassicraft.Util;
import com.ilexiconn.jurassicraft.data.entity.model.ModelMeganeura;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderMeganeura extends RenderLiving
{
    public ResourceLocation MeganeuraTexture = new ResourceLocation(Util.getModId() + "textures/entity/Meganeura.png");

    public RenderMeganeura()
    {
        super(new ModelMeganeura(), 1f);
    }

    public ResourceLocation getEntityTexture(Entity entity)
    {
        return MeganeuraTexture;
    }
}
