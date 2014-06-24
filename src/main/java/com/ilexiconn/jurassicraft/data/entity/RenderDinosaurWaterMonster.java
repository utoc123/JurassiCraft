package com.ilexiconn.jurassicraft.data.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.EntityLivingBase;
import org.lwjgl.opengl.GL11;

public abstract class RenderDinosaurWaterMonster extends RenderLiving
{
    public RenderDinosaurWaterMonster(ModelBase model, float shadow)
    {
        super(model, shadow);
    }

    public void preRenderCallback(EntityLivingBase entity, float scale)
    {
        EntityDinosaurWaterMonster dino = (EntityDinosaurWaterMonster) entity;
        GL11.glScalef(dino.getScaleAmount(), dino.getScaleAmount(), dino.getScaleAmount());
    }
}
