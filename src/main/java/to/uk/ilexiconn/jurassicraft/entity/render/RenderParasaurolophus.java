package to.uk.ilexiconn.jurassicraft.entity.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.entity.Dinosaur;
import to.uk.ilexiconn.jurassicraft.entity.dinosaur.EntityParasaurolophus;
import to.uk.ilexiconn.jurassicraft.entity.model.ModelParasaurolophus;

@SideOnly(Side.CLIENT)
public class RenderParasaurolophus extends RenderDinosaur
{
    public RenderParasaurolophus(Dinosaur dino)
    {
        super(new ModelParasaurolophus(), dino, 0.8F);
    }

    public ResourceLocation getEntityTexture(Entity var1)
    {
        EntityParasaurolophus dino = (EntityParasaurolophus) var1;
        switch (dino.getCreatureTexture())
        {
            case 0:
                return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/parasaurolophus1.png");
            case 1:
                return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/parasaurolophus2.png");
            default:
                return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/parasaurolophus1.png");
        }
    }
}
