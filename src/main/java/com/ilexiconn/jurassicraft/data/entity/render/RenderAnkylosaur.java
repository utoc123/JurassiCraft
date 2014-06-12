package com.ilexiconn.jurassicraft.data.entity.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.ilexiconn.jurassicraft.JurassiCraft;
import com.ilexiconn.jurassicraft.data.entity.EntityAnkylosaur;
import com.ilexiconn.jurassicraft.data.entity.model.ModelAnkylosaur;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderAnkylosaur extends RenderLiving
{
    public ResourceLocation AnkylosaurTexture1 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Ankylosaur1.png");
    public ResourceLocation AnkylosaurTexture2 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Ankylosaur2.png");

    public RenderAnkylosaur()
    {
        super(new ModelAnkylosaur(), 1f);
    }

    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityAnkylosaur entityAnkylosaur = (EntityAnkylosaur) entity;
        switch (entityAnkylosaur.textureID)
        {
            case 2:
                return AnkylosaurTexture1;
            case 1:
                return AnkylosaurTexture2;
            case 3:
                return AnkylosaurTexture1;
            case 4:
                return AnkylosaurTexture2;
            default:
                return null;
        }
    }
}
