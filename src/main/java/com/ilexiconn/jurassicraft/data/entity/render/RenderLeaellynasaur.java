package com.ilexiconn.jurassicraft.data.entity.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.ilexiconn.jurassicraft.JurassiCraft;
import com.ilexiconn.jurassicraft.data.entity.EntityLeaellynasaur;
import com.ilexiconn.jurassicraft.data.entity.model.ModelLeaellynasaur;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderLeaellynasaur extends RenderLiving
{
    public ResourceLocation LeaellynasaurTexture1 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/leaellynasaur1.png");
    public ResourceLocation LeaellynasaurTexture2 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/leaellynasaur2.png");

    public RenderLeaellynasaur()
    {
        super(new ModelLeaellynasaur(), 1f);
    }

    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityLeaellynasaur entityLeaellynasaur = (EntityLeaellynasaur) entity;
        switch (entityLeaellynasaur.textureID)
        {
            case 2:
                return LeaellynasaurTexture1;
            case 1:
                return LeaellynasaurTexture2;
            case 3:
                return LeaellynasaurTexture1;
            case 4:
                return LeaellynasaurTexture2;
            default:
                return null;
        }
    }
    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void scaleSpider(EntityLeaellynasaur par1EntityLeaellynasaur, float par2)
    {
    	float f = par1EntityLeaellynasaur.spiderScaleAmount();
        GL11.glScalef(f, f, f);
    }
    
    
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.scaleSpider((EntityLeaellynasaur)par1EntityLivingBase, par2);
    }
}
