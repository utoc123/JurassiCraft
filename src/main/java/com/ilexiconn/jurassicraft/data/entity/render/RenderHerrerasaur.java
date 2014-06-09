package com.ilexiconn.jurassicraft.data.entity.render;

import com.ilexiconn.jurassicraft.data.entity.EntityHerrerasaur;
import com.ilexiconn.jurassicraft.data.entity.model.ModelHerrerasaur;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.ilexiconn.jurassicraft.JurassiCraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderHerrerasaur extends RenderLiving
{
    private static final ResourceLocation Herrerasaurustexture1 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Herrerasaur1.png");
    private static final ResourceLocation Herrerasaurustexture2 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Herrerasaur2.png");

    public RenderHerrerasaur()
    {
        super(new ModelHerrerasaur(), 1f);
    }

    protected ResourceLocation func_110872_a(EntityHerrerasaur par1Entity)
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
        return this.func_110872_a((EntityHerrerasaur) par1Entity);
    }

    public void func_177_a(EntityHerrerasaur entityHerrerasaurus, double d, double d1, double d2, float f, float f1)
    {
        super.doRender(entityHerrerasaurus, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2, float f, float f1)
    {
        func_177_a((EntityHerrerasaur) entity, d, d1, d2, f, f1);
    }

    protected void scaleSpider(EntityHerrerasaur par1EntityHerrerasaurus, float par2)
    {
        GL11.glScalef(1f, 1f, 1f);
    }

    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.scaleSpider((EntityHerrerasaur) par1EntityLivingBase, par2);
    }
}
