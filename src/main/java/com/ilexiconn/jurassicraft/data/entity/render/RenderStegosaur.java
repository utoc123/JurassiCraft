package com.ilexiconn.jurassicraft.data.entity.render;

import org.lwjgl.opengl.GL11;

import com.ilexiconn.jurassicraft.JurassiCraft;
import com.ilexiconn.jurassicraft.data.entity.EntityStegosaur;
import com.ilexiconn.jurassicraft.data.entity.EntityStegosaur;
import com.ilexiconn.jurassicraft.data.entity.model.ModelStegosaur;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderStegosaur extends RenderLiving
{
    public ResourceLocation stegosaurTexture1 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/stegosaur1.png");
    public ResourceLocation stegosaurTexture2 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/stegosaur2.png");

    public RenderStegosaur()
    {
        super(new ModelStegosaur(), 1f);
    }

    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityStegosaur entityStegosaur = (EntityStegosaur) entity;
        switch (entityStegosaur.textureID)
        {
            case 2:
                return stegosaurTexture1;
            case 1:
                return stegosaurTexture2;
            case 3:
                return stegosaurTexture1;
            case 4:
                return stegosaurTexture2;
            default:
                return null;
        }
    }
    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void scaleSpider(EntityStegosaur par1EntityStegosaur, float par2)
    {
    	float f = par1EntityStegosaur.spiderScaleAmount();
        GL11.glScalef(f, f, f);
    }
    
    
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.scaleSpider((EntityStegosaur)par1EntityLivingBase, par2);
    }
}
