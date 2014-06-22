package com.ilexiconn.jurassicraft.data.entity.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.ilexiconn.jurassicraft.JurassiCraft;
import com.ilexiconn.jurassicraft.data.entity.EntityVelociraptor;
import com.ilexiconn.jurassicraft.data.entity.model.ModelVelociraptor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderVelociraptor extends RenderLiving
{
    private static final ResourceLocation velociraptorTexture1 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/velociraptor1.png");
    private static final ResourceLocation velociraptorTexture2 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/velociraptor2.png");

    public RenderVelociraptor()
    {
        super(new ModelVelociraptor(), 1f);
    }

    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityVelociraptor entityvelociraptor = (EntityVelociraptor) entity;
        switch (entityvelociraptor.textureID)
        {
            case 2:
                return velociraptorTexture1;
            case 1:
                return velociraptorTexture2;
            case 3:
                return velociraptorTexture1;
            case 4:
                return velociraptorTexture2;
            default:
                return null;
        }
    }
    
    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void scaleSpider(EntityVelociraptor par1Entityvelociraptor, float par2)
    {
    	float f = par1Entityvelociraptor.spiderScaleAmount();
        GL11.glScalef(f, f, f);
    }
    
    
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.scaleSpider((EntityVelociraptor)par1EntityLivingBase, par2);
    }
    
}
