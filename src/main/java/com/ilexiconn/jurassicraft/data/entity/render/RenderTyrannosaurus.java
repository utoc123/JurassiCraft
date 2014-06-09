package com.ilexiconn.jurassicraft.data.entity.render;

import com.ilexiconn.jurassicraft.JurassiCraft;
import com.ilexiconn.jurassicraft.data.entity.EntityTyrannosaurus;
import com.ilexiconn.jurassicraft.data.entity.model.ModelTyrannosaurus;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

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
}
