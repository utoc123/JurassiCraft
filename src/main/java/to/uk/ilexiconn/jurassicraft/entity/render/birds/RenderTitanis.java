package to.uk.ilexiconn.jurassicraft.entity.render.birds;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.client.model.entity.ModelTitanis;
import to.uk.ilexiconn.jurassicraft.entity.Entities;
import to.uk.ilexiconn.jurassicraft.entity.birds.EntityTitanis;
import to.uk.ilexiconn.jurassicraft.entity.render.RenderDinosaur;

@SideOnly(Side.CLIENT)
public class RenderTitanis extends RenderDinosaur
{
    public RenderTitanis(Entities dino)
    {
        super(new ModelTitanis(), dino, 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
    	EntityTitanis dino = (EntityTitanis) entity;
        if (dino.isMale())
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Titanis_Male_1.png");
        } 
        else 
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Titanis_Female_1.png");
        }
    }
}
