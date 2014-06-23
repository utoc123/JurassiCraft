package com.ilexiconn.jurassicraft.data.entity.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import com.ilexiconn.jurassicraft.JurassiCraft;
import com.ilexiconn.jurassicraft.data.entity.entity.EntityAnkylosaur;
import com.ilexiconn.jurassicraft.data.entity.model.ModelAnkylosaur;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderAnkylosaur extends RenderLiving
{
    public ResourceLocation AnkylosaurTexture1 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/ankylosaur1.png");
    public ResourceLocation AnkylosaurTexture2 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/ankylosaur2.png");

    public RenderAnkylosaur()
    {
        super(new ModelAnkylosaur(), 1f);
    }

    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityAnkylosaur entityAnkylosaur = (EntityAnkylosaur) entity;
        switch (entityAnkylosaur.textureID)
        {
            case 2:
                return AnkylosaurTexture1;
            case 1:
                return AnkylosaurTexture2;
            case 3:
                return AnkylosaurTexture1;
            case 4:
                return AnkylosaurTexture2;
            default:
                return null;
        }
    }
    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void scaleSpider(EntityAnkylosaur par1EntityAnkylosaur, float par2)
    {
    	float f = par1EntityAnkylosaur.spiderScaleAmount();
        GL11.glScalef(f, f, f);
    }
    
    
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.scaleSpider((EntityAnkylosaur)par1EntityLivingBase, par2);
    }
}
