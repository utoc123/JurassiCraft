package com.ilexiconn.jurassicraft.data.entity.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.ilexiconn.jurassicraft.JurassiCraft;
import com.ilexiconn.jurassicraft.data.entity.EntityGallimimus;
import com.ilexiconn.jurassicraft.data.entity.model.ModelGallimimus;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGallimimus extends RenderLiving
{
    public ResourceLocation GallimimusTexture1 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Gallimimus1.png");
    public ResourceLocation GallimimusTexture2 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Gallimimus2.png");

    public RenderGallimimus()
    {
        super(new ModelGallimimus(), 1f);
    }

    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityGallimimus entityGallimimus = (EntityGallimimus) entity;
        switch (entityGallimimus.textureID)
        {
            case 2:
                return GallimimusTexture1;
            case 1:
                return GallimimusTexture2;
            case 3:
                return GallimimusTexture1;
            case 4:
                return GallimimusTexture2;
            default:
                return null;
        }
    }
    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void scaleSpider(EntityGallimimus par1EntityGallimimus, float par2)
    {
    	float f = par1EntityGallimimus.spiderScaleAmount();
        GL11.glScalef(f, f, f);
    }
    
    
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.scaleSpider((EntityGallimimus)par1EntityLivingBase, par2);
    }
}
