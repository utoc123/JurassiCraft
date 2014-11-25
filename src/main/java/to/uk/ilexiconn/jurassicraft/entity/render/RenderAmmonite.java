package to.uk.ilexiconn.jurassicraft.entity.render;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.client.model.entity.ModelAmmonite;
import to.uk.ilexiconn.jurassicraft.entity.Dinosaur;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import to.uk.ilexiconn.jurassicraft.entity.cephalopoda.EntityAmmonite;

@SideOnly(Side.CLIENT)
public class RenderAmmonite extends RenderDinosaur
{
    public RenderAmmonite(Dinosaur dino)
    {
        super(new ModelAmmonite(), dino, 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityAmmonite dino = (EntityAmmonite) entity;
        if (dino.isMale())
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Ammonite.png");
        }
        else
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Ammonite.png");
        }
    }
}
