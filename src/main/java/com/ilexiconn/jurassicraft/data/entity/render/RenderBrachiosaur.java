package com.ilexiconn.jurassicraft.data.entity.render;

import com.ilexiconn.jurassicraft.JurassiCraft;
import com.ilexiconn.jurassicraft.data.entity.RenderDinosaurCreature;
import com.ilexiconn.jurassicraft.data.entity.model.ModelBrachiosaur;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderBrachiosaur extends RenderDinosaurCreature
{
    public RenderBrachiosaur()
    {
        super(new ModelBrachiosaur(), 2f);
    }

    public ResourceLocation getEntityTexture(Entity entity)
    {
        return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/brachiosaur1.png");
    }
}
