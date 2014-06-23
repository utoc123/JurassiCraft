package com.ilexiconn.jurassicraft.data.entity.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.ilexiconn.jurassicraft.JurassiCraft;
import com.ilexiconn.jurassicraft.data.entity.EntityTriceratops;
import com.ilexiconn.jurassicraft.data.entity.model.ModelTriceratops;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderTriceratops extends RenderLiving
{
    public ResourceLocation TriceratopsTexture1 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/triceratops1.png");
    public ResourceLocation TriceratopsTexture2 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/triceratops2.png");

    public RenderTriceratops()
    {
        super(new ModelTriceratops(), 1f);
    }

    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityTriceratops entityTriceratops = (EntityTriceratops) entity;
        switch (entityTriceratops.textureID)
        {
            case 2:
                return TriceratopsTexture1;
            case 1:
                return TriceratopsTexture2;
            case 3:
                return TriceratopsTexture1;
            case 4:
                return TriceratopsTexture2;
            default:
                return null;
        }
    }
    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void scaleSpider(EntityTriceratops par1EntityTriceratops, float par2)
    {
    	float f = par1EntityTriceratops.spiderScaleAmount();
        GL11.glScalef(f, f, f);
    }
    
    
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.scaleSpider((EntityTriceratops)par1EntityLivingBase, par2);
    }
}
