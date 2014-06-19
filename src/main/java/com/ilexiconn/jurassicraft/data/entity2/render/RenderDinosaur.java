package com.ilexiconn.jurassicraft.data.entity2.render;

import com.ilexiconn.jurassicraft.Util;
import com.ilexiconn.jurassicraft.data.entity2.EntityDinosaur;
import com.ilexiconn.jurassicraft.data.entity2.gender.Gender;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderDinosaur extends RenderLiving
{
    public ResourceLocation maleTexture;
    public ResourceLocation femaleTexture;

    public RenderDinosaur(ModelBase par1ModelBase, float par2, String mT, String fT)
    {
        super(par1ModelBase, par2);
        maleTexture = new ResourceLocation(Util.getModId() + "textures/entity/" + mT + ".png");
        femaleTexture = new ResourceLocation(Util.getModId() + "textures/entity/" + fT + ".png");
    }

    public ResourceLocation getEntityTexture(Entity entity)
    {
        return getEntityTexture((EntityDinosaur) entity);
    }

    public ResourceLocation getEntityTexture(EntityDinosaur entity)
    {
        return entity.getGender() == Gender.MALE ? maleTexture : femaleTexture;
    }
}
