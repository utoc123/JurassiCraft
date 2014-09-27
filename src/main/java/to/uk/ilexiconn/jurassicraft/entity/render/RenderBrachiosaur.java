package to.uk.ilexiconn.jurassicraft.entity.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.entity.Dinosaur;
import to.uk.ilexiconn.jurassicraft.entity.RenderDinosaur;
import to.uk.ilexiconn.jurassicraft.entity.entity.EntityBrachiosaur;
import to.uk.ilexiconn.jurassicraft.entity.model.ModelBrachiosaur;

@SideOnly(Side.CLIENT)
public class RenderBrachiosaur extends RenderDinosaur
{
    public RenderBrachiosaur(Dinosaur dino)
    {
        super(new ModelBrachiosaur(), dino, 1.6F);
    }

    public ResourceLocation getEntityTexture(Entity var1)
    {
        EntityBrachiosaur dino = (EntityBrachiosaur) var1;
        switch (dino.getCreatureTexture())
        {
            case 1:
                return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/brachiosaur1.png");
            case 2:
                return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/brachiosaur2.png");
            default:
                return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/brachiosaur1.png");
        }
    }
}
