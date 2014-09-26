package to.uk.ilexiconn.jurassicraft.data.entity.render;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.data.entity.Dinosaur;
import to.uk.ilexiconn.jurassicraft.data.entity.RenderDinosaur;
import to.uk.ilexiconn.jurassicraft.data.entity.entity.EntitySarchosuchus;
import to.uk.ilexiconn.jurassicraft.data.entity.model.ModelSarchosuchus;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSarchosuchus extends RenderDinosaur
{
    public RenderSarchosuchus(Dinosaur dino)
    {
        super(new ModelSarchosuchus(), dino, 0.5F);
    }

    public ResourceLocation getEntityTexture(Entity var1)
    {
    	EntitySarchosuchus dino = (EntitySarchosuchus) var1;
        switch (dino.getCreatureTexture())
        {
            case 1:
            default:
                return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/sarchosuchus1.png");
            case 0:
                return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/sarchosuchus2.png");
        }
    }
}
