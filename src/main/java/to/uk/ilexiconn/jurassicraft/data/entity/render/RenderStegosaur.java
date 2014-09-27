package to.uk.ilexiconn.jurassicraft.data.entity.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.data.entity.Dinosaur;
import to.uk.ilexiconn.jurassicraft.data.entity.RenderDinosaur;
import to.uk.ilexiconn.jurassicraft.data.entity.entity.EntityStegosaur;
import to.uk.ilexiconn.jurassicraft.data.entity.model.ModelStegosaur;

@SideOnly(Side.CLIENT)
public class RenderStegosaur extends RenderDinosaur
{
    public RenderStegosaur(Dinosaur dino)
    {
        super(new ModelStegosaur(), dino, 1.0F);
    }

    public ResourceLocation getEntityTexture(Entity var1)
    {
        EntityStegosaur dino = (EntityStegosaur) var1;
        switch (dino.getCreatureTexture())
        {
            case 1:
                return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/stegosaur1.png");
            case 2:
                return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/stegosaur2.png");
            default:
                return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/stegosaur1.png");
        }
    }
}
