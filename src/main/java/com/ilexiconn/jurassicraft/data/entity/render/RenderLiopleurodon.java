package com.ilexiconn.jurassicraft.data.entity.render;

import com.ilexiconn.jurassicraft.Util;
import com.ilexiconn.jurassicraft.data.entity.model.ModelLiopleurodon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderLiopleurodon extends RenderLiving
{
    public ResourceLocation liopleurodonTexture = new ResourceLocation(Util.getModId() + "textures/entity/liopleurodon.png");

    public RenderLiopleurodon()
    {
        super(new ModelLiopleurodon(), 1f);
    }

    public ResourceLocation getEntityTexture(Entity entity)
    {
        return liopleurodonTexture;
    }
}
