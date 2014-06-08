package com.ilexiconn.jurassicraft.data.entity.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.ilexiconn.jurassicraft.JurassiCraft;
import com.ilexiconn.jurassicraft.data.entity.EntityTRex;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


@SideOnly(Side.CLIENT)
public class RenderTRex extends RenderLiving
{
	private static final ResourceLocation TRextexture1 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/TRex1.png");
	private static final ResourceLocation TRextexture2 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/TRex2.png");
	 protected ResourceLocation func_110872_a(EntityTRex par1Entity)
	    {
		 int i = par1Entity.textureID;
		 switch(i)
		 {
		 case 2:
		        return TRextexture1;
		 case 1:
		        return TRextexture2;	
		 case 3:
		        return TRextexture1;
		 case 4:
		        return TRextexture2;	
		 default: return null;
		 }
	    }
	 @Override
	    protected ResourceLocation getEntityTexture(Entity par1Entity)
	    {
	        return this.func_110872_a((EntityTRex)par1Entity);
	    }

    public RenderTRex(ModelBase modelbase, float f)
    {
        super(modelbase, f); 
    }

    public void func_177_a(EntityTRex entityTRex, double d, double d1, double d2, 
            float f, float f1)
    {
        super.doRender(entityTRex, d, d1, d2, f, f1);
    }

    public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, 
            float f, float f1)
    {
    	func_177_a((EntityTRex)entityliving, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
    	func_177_a((EntityTRex)entity, d, d1, d2, f, f1);
    }
    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void scaleSpider(EntityTRex par1EntityTRex, float par2)
    {
    	float f = par1EntityTRex.spiderScaleAmount();
        GL11.glScalef(f, f, f);
    }
    
    
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.scaleSpider((EntityTRex)par1EntityLivingBase, par2);
    }

}
