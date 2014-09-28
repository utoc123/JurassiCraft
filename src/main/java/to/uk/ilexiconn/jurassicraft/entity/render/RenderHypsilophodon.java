package to.uk.ilexiconn.jurassicraft.entity.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.entity.Dinosaur;
import to.uk.ilexiconn.jurassicraft.entity.dinosaur.EntityHypsilophodon;
import to.uk.ilexiconn.jurassicraft.entity.model.ModelHypsilophodon;

@SideOnly(Side.CLIENT)
public class RenderHypsilophodon extends RenderDinosaur
{

    public RenderHypsilophodon(Dinosaur dino)
    {
        super(new ModelHypsilophodon(), dino, 0.55F);
    }

    public ResourceLocation getEntityTexture(Entity var1)
    {
        EntityHypsilophodon dino = (EntityHypsilophodon) var1;
        switch (dino.getCreatureTexture())
        {
            case 0:
                return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/hypsilophodon1.png");
            case 1:
                return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/hypsilophodon2.png");
            default:
                return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/hypsilophodon1.png");
        }
    }
}
