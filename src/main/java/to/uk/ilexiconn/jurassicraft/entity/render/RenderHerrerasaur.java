package to.uk.ilexiconn.jurassicraft.entity.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.entity.Dinosaur;
import to.uk.ilexiconn.jurassicraft.entity.RenderDinosaur;
import to.uk.ilexiconn.jurassicraft.entity.entity.EntityHerrerasaur;
import to.uk.ilexiconn.jurassicraft.entity.model.ModelHerrerasaur;

@SideOnly(Side.CLIENT)
public class RenderHerrerasaur extends RenderDinosaur
{

    public RenderHerrerasaur(Dinosaur dino)
    {
        super(new ModelHerrerasaur(), dino, 0.5F);
    }

    public ResourceLocation getEntityTexture(Entity var1)
    {
        EntityHerrerasaur dino = (EntityHerrerasaur) var1;
        switch (dino.getCreatureTexture())
        {
            case 0:
                return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/herrerasaur1.png");
            case 1:
                return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/herrerasaur2.png");
            default:
                return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/herrerasaur1.png");
        }
    }
}
