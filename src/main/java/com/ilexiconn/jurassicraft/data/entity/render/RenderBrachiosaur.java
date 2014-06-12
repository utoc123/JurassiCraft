package com.ilexiconn.jurassicraft.data.entity.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.ilexiconn.jurassicraft.JurassiCraft;
import com.ilexiconn.jurassicraft.data.entity.EntityBrachiosaur;
import com.ilexiconn.jurassicraft.data.entity.model.ModelBrachiosaur;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderBrachiosaur extends RenderLiving
{
    public ResourceLocation BrachiosaurTexture1 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Brachiosaur1.png");
    public ResourceLocation BrachiosaurTexture2 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Brachiosaur2.png");

    public RenderBrachiosaur()
    {
        super(new ModelBrachiosaur(), 1f);
    }

    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityBrachiosaur entityBrachiosaur = (EntityBrachiosaur) entity;
        switch (entityBrachiosaur.textureID)
        {
            case 2:
                return BrachiosaurTexture1;
            case 1:
                return BrachiosaurTexture2;
            case 3:
                return BrachiosaurTexture1;
            case 4:
                return BrachiosaurTexture2;
            default:
                return null;
        }
    }
    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void scaleSpider(EntityBrachiosaur par1EntityBrachiosaur, float par2)
    {
    	float f = par1EntityBrachiosaur.spiderScaleAmount();
        GL11.glScalef(f, f, f);
    }
    
    
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.scaleSpider((EntityBrachiosaur)par1EntityLivingBase, par2);
    }
}
