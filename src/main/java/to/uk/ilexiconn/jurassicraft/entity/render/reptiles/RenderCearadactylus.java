package to.uk.ilexiconn.jurassicraft.entity.render.reptiles;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.client.model.entity.ModelCearadactylus;
import to.uk.ilexiconn.jurassicraft.entity.Entities;
import to.uk.ilexiconn.jurassicraft.entity.Reptile;
import to.uk.ilexiconn.jurassicraft.entity.render.RenderDinosaur;
import to.uk.ilexiconn.jurassicraft.entity.render.RenderReptile;
import to.uk.ilexiconn.jurassicraft.entity.reptiles.EntityCearadactylus;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderCearadactylus extends RenderReptile
{
    public RenderCearadactylus(Entities reptile)
    {
        super(new ModelCearadactylus(), reptile, 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityCearadactylus reptile = (EntityCearadactylus) entity;
        if (reptile.isMale())
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Cearadactylus_Male_1.png");
        } 
        else 
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Cearadactylus_Female_1.png");
        }
    }
}
