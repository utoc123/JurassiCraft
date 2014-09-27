package to.uk.ilexiconn.jurassicraft.entity.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.entity.Dinosaur;
import to.uk.ilexiconn.jurassicraft.entity.RenderDinosaur;
import to.uk.ilexiconn.jurassicraft.entity.entity.EntityLeaellynasaur;
import to.uk.ilexiconn.jurassicraft.entity.model.ModelLeaellynasaur;

@SideOnly(Side.CLIENT)
public class RenderLeaellynasaur extends RenderDinosaur
{
    public RenderLeaellynasaur(Dinosaur dino)
    {
        super(new ModelLeaellynasaur(), dino, 0.45F);
    }

    public ResourceLocation getEntityTexture(Entity var1)
    {
        EntityLeaellynasaur dino = (EntityLeaellynasaur) var1;
        switch (dino.getCreatureTexture())
        {
            case 1:
                return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/leaellynasaur1.png");
            case 2:
                return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/leaellynasaur2.png");
            default:
                return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/leaellynasaur1.png");
        }
    }
}
