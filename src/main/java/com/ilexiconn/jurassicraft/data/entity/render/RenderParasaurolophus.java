package com.ilexiconn.jurassicraft.data.entity.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.ilexiconn.jurassicraft.JurassiCraft;
import com.ilexiconn.jurassicraft.data.entity.entity.EntityParasaurolophus;
import com.ilexiconn.jurassicraft.data.entity.model.ModelParasaurolophus;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderParasaurolophus extends RenderLiving
{
    public ResourceLocation ParasaurolophusTexture1 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/parasaurolophus1.png");
    public ResourceLocation ParasaurolophusTexture2 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/parasaurolophus2.png");

    public RenderParasaurolophus()
    {
        super(new ModelParasaurolophus(), 1f);
    }

    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityParasaurolophus entityParasaurolophus = (EntityParasaurolophus) entity;
        switch (entityParasaurolophus.textureID)
        {
            case 2:
                return ParasaurolophusTexture1;
            case 1:
                return ParasaurolophusTexture2;
            case 3:
                return ParasaurolophusTexture1;
            case 4:
                return ParasaurolophusTexture2;
            default:
                return null;
        }
    }
    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void scaleSpider(EntityParasaurolophus par1EntityParasaurolophus, float par2)
    {
    	float f = par1EntityParasaurolophus.spiderScaleAmount();
        GL11.glScalef(f, f, f);
    }
    
    
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.scaleSpider((EntityParasaurolophus)par1EntityLivingBase, par2);
    }
}
