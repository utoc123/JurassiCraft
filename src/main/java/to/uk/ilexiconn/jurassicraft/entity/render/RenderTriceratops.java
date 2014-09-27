package to.uk.ilexiconn.jurassicraft.entity.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.entity.Dinosaur;
import to.uk.ilexiconn.jurassicraft.entity.RenderDinosaur;
import to.uk.ilexiconn.jurassicraft.entity.entity.EntityTriceratops;
import to.uk.ilexiconn.jurassicraft.entity.model.ModelTriceratops;

@SideOnly(Side.CLIENT)
public class RenderTriceratops extends RenderDinosaur
{
    public RenderTriceratops(Dinosaur dino)
    {
        super(new ModelTriceratops(), dino, 1.0F);
    }

    public ResourceLocation getEntityTexture(Entity var1)
    {
        EntityTriceratops dino = (EntityTriceratops) var1;
        switch (dino.getCreatureTexture())
        {
            case 1:
                return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/triceratops1.png");
            case 2:
                return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/triceratops2.png");
            default:
                return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/triceratops1.png");
        }
    }
}
