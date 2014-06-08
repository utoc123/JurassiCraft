package com.ilexiconn.jurassicraft.data.entity.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.ilexiconn.jurassicraft.JurassiCraft;
import com.ilexiconn.jurassicraft.data.entity.EntityStegosaur;
import com.ilexiconn.jurassicraft.data.entity.model.ModelHerrerasaurus;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderHerrerasaurus extends RenderLiving
{
    private static final ResourceLocation Herrerasaurustexture1 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Herrerasaurus1.png");
    private static final ResourceLocation Herrerasaurustexture2 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Herrerasaurus2.png");

    public RenderHerrerasaurus()
    {
        super(new ModelHerrerasaurus(), 1f);
    }

    protected ResourceLocation func_110872_a(EntityStegosaur par1Entity)
    {
        int i = par1Entity.textureID;
        switch (i)
        {
            case 2:
                return Herrerasaurustexture1;
            case 1:
                return Herrerasaurustexture2;
            case 3:
                return Herrerasaurustexture1;
            case 4:
                return Herrerasaurustexture2;
            default:
                return null;
        }
    }

    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.func_110872_a((EntityStegosaur) par1Entity);
    }

    public void func_177_a(EntityStegosaur entityHerrerasaurus, double d, double d1, double d2, float f, float f1)
    {
        super.doRender(entityHerrerasaurus, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2, float f, float f1)
    {
        func_177_a((EntityStegosaur) entity, d, d1, d2, f, f1);
    }

    protected void scaleSpider(EntityStegosaur par1EntityHerrerasaurus, float par2)
    {
        float f = par1EntityHerrerasaurus.spiderScaleAmount();
        GL11.glScalef(f, f, f);
    }


    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.scaleSpider((EntityStegosaur) par1EntityLivingBase, par2);
    }
}
