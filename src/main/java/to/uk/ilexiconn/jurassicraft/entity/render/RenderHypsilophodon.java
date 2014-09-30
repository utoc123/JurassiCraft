package to.uk.ilexiconn.jurassicraft.entity.render;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.client.model.entity.ModelHypsilophodon;
import to.uk.ilexiconn.jurassicraft.entity.Dinosaur;
import to.uk.ilexiconn.jurassicraft.entity.dinosaur.EntityHypsilophodon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderHypsilophodon extends RenderDinosaur
{

    public RenderHypsilophodon(Dinosaur dino)
    {
        super(new ModelHypsilophodon(), dino, 0.55F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityHypsilophodon dino = (EntityHypsilophodon) entity;
        if (dino.isMale())
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Hypsilophodon_Male_1.png");
        } 
        else 
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Hypsilophodon_Female_1.png");
        }
    }
}
