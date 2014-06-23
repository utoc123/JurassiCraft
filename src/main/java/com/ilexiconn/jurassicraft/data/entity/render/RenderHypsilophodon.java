package com.ilexiconn.jurassicraft.data.entity.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.ilexiconn.jurassicraft.JurassiCraft;
import com.ilexiconn.jurassicraft.data.entity.EntityHypsilophodon;
import com.ilexiconn.jurassicraft.data.entity.model.ModelHypsilophodon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderHypsilophodon extends RenderLiving
{
    public ResourceLocation HypsilophodonTexture1 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/hypsilophodon1.png");
    public ResourceLocation HypsilophodonTexture2 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/hypsilophodon2.png");

    public RenderHypsilophodon()
    {
        super(new ModelHypsilophodon(), 1f);
    }

    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityHypsilophodon entityHypsilophodon = (EntityHypsilophodon) entity;
        switch (entityHypsilophodon.textureID)
        {
            case 2:
                return HypsilophodonTexture1;
            case 1:
                return HypsilophodonTexture2;
            case 3:
                return HypsilophodonTexture1;
            case 4:
                return HypsilophodonTexture2;
            default:
                return null;
        }
    }
    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void scaleSpider(EntityHypsilophodon par1EntityHypsilophodon, float par2)
    {
    	float f = par1EntityHypsilophodon.spiderScaleAmount();
        GL11.glScalef(f, f, f);
    }
    
    
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.scaleSpider((EntityHypsilophodon)par1EntityLivingBase, par2);
    }
}
