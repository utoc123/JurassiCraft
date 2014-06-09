package com.ilexiconn.jurassicraft.data.entity.render;

import com.ilexiconn.jurassicraft.JurassiCraft;
import com.ilexiconn.jurassicraft.data.entity.EntityStegosaur;
import com.ilexiconn.jurassicraft.data.entity.model.ModelStegosaur;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderStegosaur extends RenderLiving
{
    public ResourceLocation stegosaurTexture1 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/stegosaur1.png");
    public ResourceLocation stegosaurTexture2 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/stegosaur2.png");

    public RenderStegosaur()
    {
        super(new ModelStegosaur(), 1f);
    }

    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityStegosaur entityStegosaur = (EntityStegosaur) entity;
        switch (entityStegosaur.textureID)
        {
            case 2:
                return stegosaurTexture1;
            case 1:
                return stegosaurTexture2;
            case 3:
                return stegosaurTexture1;
            case 4:
                return stegosaurTexture2;
            default:
                return null;
        }
    }
}
