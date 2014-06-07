package com.ilexiconn.jurassicraft.data.entity.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import com.ilexiconn.jurassicraft.data.entity.EntityLiopleurodon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


@SideOnly(Side.CLIENT)
public class RenderLiopleurodon extends RenderLiving
{
	private static final ResourceLocation Liopleurodontexture = new ResourceLocation("jurassicraft:Liopleurodon.png");
	 protected ResourceLocation func_110872_a(EntityLiopleurodon par1Entity)
	    {
	        return Liopleurodontexture;
	    }
	 @Override
	    protected ResourceLocation getEntityTexture(Entity par1Entity)
	    {
	        return this.func_110872_a((EntityLiopleurodon)par1Entity);
	    }

    public RenderLiopleurodon(ModelBase modelbase, float f)
    {
        super(modelbase, f); 
    }

    public void func_177_a(EntityLiopleurodon entityLiopleurodon, double d, double d1, double d2, 
            float f, float f1)
    {
        super.doRender(entityLiopleurodon, d, d1, d2, f, f1);
    }

    public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, 
            float f, float f1)
    {
    	func_177_a((EntityLiopleurodon)entityliving, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
    	func_177_a((EntityLiopleurodon)entity, d, d1, d2, f, f1);
    }

}
