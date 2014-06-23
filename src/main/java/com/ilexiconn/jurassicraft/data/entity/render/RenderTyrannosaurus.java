package com.ilexiconn.jurassicraft.data.entity.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.ilexiconn.jurassicraft.JurassiCraft;
import com.ilexiconn.jurassicraft.data.entity.entity.EntityTyrannosaurus;
import com.ilexiconn.jurassicraft.data.entity.model.ModelTyrannosaurus;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderTyrannosaurus extends RenderLiving
{
    private static final ResourceLocation tyrannosaurusTexture1 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/tyrannosaurus1.png");
    private static final ResourceLocation tyrannosaurusTexture2 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/tyrannosaurus2.png");

    public RenderTyrannosaurus()
    {
        super(new ModelTyrannosaurus(), 1f);
    }

    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityTyrannosaurus entityTyrannosaurus = (EntityTyrannosaurus) entity;
        switch (entityTyrannosaurus.textureID)
        {
            case 2:
                return tyrannosaurusTexture1;
            case 1:
                return tyrannosaurusTexture2;
            case 3:
                return tyrannosaurusTexture1;
            case 4:
                return tyrannosaurusTexture2;
            default:
                return null;
        }
    }
    
    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void scaleSpider(EntityTyrannosaurus par1EntityTyrannosaurus, float par2)
    {
    	float f = par1EntityTyrannosaurus.spiderScaleAmount();
        GL11.glScalef(f, f, f);
    }
    
    
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.scaleSpider((EntityTyrannosaurus)par1EntityLivingBase, par2);
    }
    
}
