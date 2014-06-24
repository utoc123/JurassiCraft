package com.ilexiconn.jurassicraft.data.entity.render;

import com.ilexiconn.jurassicraft.Util;
import com.ilexiconn.jurassicraft.data.entity.RenderDinosaurWaterMonster;
import com.ilexiconn.jurassicraft.data.entity.model.ModelCoelacanth;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderCoelacanth extends RenderDinosaurWaterMonster
{
    public RenderCoelacanth()
    {
        super(new ModelCoelacanth(), 1f);
    }

    public ResourceLocation getEntityTexture(Entity entity)
    {
        return new ResourceLocation(Util.getModId() + "textures/entity/coelacanth.png");
    }
}
