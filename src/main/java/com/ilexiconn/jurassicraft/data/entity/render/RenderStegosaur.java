package com.ilexiconn.jurassicraft.data.entity.render;

import com.ilexiconn.jurassicraft.JurassiCraft;
import com.ilexiconn.jurassicraft.data.entity.EntityStegosaur;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;


@SideOnly(Side.CLIENT)
public class RenderStegosaur extends RenderLiving
{
    private static final ResourceLocation Stegosaurustexture1 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Stegosaurus1.png");
    private static final ResourceLocation Stegosaurustexture2 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Stegosaurus2.png");

    public RenderStegosaur(ModelBase modelbase, float f)
    {
        super(modelbase, f);
    }

    protected ResourceLocation func_110872_a(EntityStegosaur par1Entity)
    {
        int i = par1Entity.textureID;
        switch (i)
        {
            case 2:
                return Stegosaurustexture1;
            case 1:
                return Stegosaurustexture2;
            case 3:
                return Stegosaurustexture1;
            case 4:
                return Stegosaurustexture2;
            default:
                return null;
        }
    }

    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.func_110872_a((EntityStegosaur) par1Entity);
    }

    public void func_177_a(EntityStegosaur entityStegosaurus, double d, double d1, double d2, float f, float f1)
    {
        super.doRender(entityStegosaurus, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2, float f, float f1)
    {
        func_177_a((EntityStegosaur) entity, d, d1, d2, f, f1);
    }

    protected void scaleSpider(EntityStegosaur par1EntityStegosaurus, float par2)
    {
        float f = par1EntityStegosaurus.spiderScaleAmount();
        GL11.glScalef(f, f, f);
    }


    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.scaleSpider((EntityStegosaur) par1EntityLivingBase, par2);
    }
}
