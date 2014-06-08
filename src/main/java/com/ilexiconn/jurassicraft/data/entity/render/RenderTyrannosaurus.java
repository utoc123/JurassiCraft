package com.ilexiconn.jurassicraft.data.entity.render;

import com.ilexiconn.jurassicraft.JurassiCraft;
import com.ilexiconn.jurassicraft.data.entity.EntityTyrannosaurus;
import com.ilexiconn.jurassicraft.data.entity.model.ModelTyrannosaurus;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;


@SideOnly(Side.CLIENT)
public class RenderTyrannosaurus extends RenderLiving
{
    private static final ResourceLocation TRextexture1 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/TRex1.png");
    private static final ResourceLocation TRextexture2 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/TRex2.png");

    public RenderTyrannosaurus()
    {
        super(new ModelTyrannosaurus(), 1f);
    }

    protected ResourceLocation func_110872_a(EntityTyrannosaurus par1Entity)
    {
        int i = par1Entity.textureID;
        switch (i)
        {
            case 2:
                return TRextexture1;
            case 1:
                return TRextexture2;
            case 3:
                return TRextexture1;
            case 4:
                return TRextexture2;
            default:
                return null;
        }
    }

    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.func_110872_a((EntityTyrannosaurus) par1Entity);
    }

    public void func_177_a(EntityTyrannosaurus entityTRex, double d, double d1, double d2, float f, float f1)
    {
        super.doRender(entityTRex, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2, float f, float f1)
    {
        func_177_a((EntityTyrannosaurus) entity, d, d1, d2, f, f1);
    }

    protected void scaleSpider(EntityTyrannosaurus par1EntityTRex, float par2)
    {
       GL11.glScalef(4f, 4f, 4f);
    }

    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.scaleSpider((EntityTyrannosaurus) par1EntityLivingBase, par2);
    }
}
