package com.ilexiconn.jurassicraft.data.entity.render;

import org.lwjgl.opengl.GL11;

import com.ilexiconn.jurassicraft.Util;
import com.ilexiconn.jurassicraft.data.entity.entity.EntityMeganeura;
import com.ilexiconn.jurassicraft.data.entity.model.ModelMeganeura;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderMeganeura extends RenderLiving
{
    public ResourceLocation MeganeuraTexture = new ResourceLocation(Util.getModId() + "textures/entity/meganeura1.png");
    public ResourceLocation MeganeuraNymphTexture = new ResourceLocation(Util.getModId() + "textures/entity/meganeura2.png");
    
    public RenderMeganeura()
    {
        super(new ModelMeganeura(), 1f);
    }

    public ResourceLocation getEntityTexture(Entity entity)
    {        
    	EntityMeganeura entityMeganeura = (EntityMeganeura) entity;
    	if(entityMeganeura.isChild()) {
    		return MeganeuraNymphTexture;
    	}
    	else {
    		return MeganeuraTexture;
    	}
    }
    
    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void scaleSpider(EntityMeganeura par1EntityMeganeura, float par2)
    {
    	float f = par1EntityMeganeura.spiderScaleAmount();
        GL11.glScalef(f, f, f);
    }
    
    
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.scaleSpider((EntityMeganeura)par1EntityLivingBase, par2);
    }
}
