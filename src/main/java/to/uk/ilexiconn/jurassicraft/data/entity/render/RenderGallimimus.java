package to.uk.ilexiconn.jurassicraft.data.entity.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.data.entity.Dinosaur;
import to.uk.ilexiconn.jurassicraft.data.entity.RenderDinosaur;
import to.uk.ilexiconn.jurassicraft.data.entity.entity.EntityGallimimus;
import to.uk.ilexiconn.jurassicraft.data.entity.model.ModelGallimimus;

@SideOnly(Side.CLIENT)
public class RenderGallimimus extends RenderDinosaur
{
    private static final ResourceLocation texture1 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/gallimimus1.png");
    private static final ResourceLocation texture2 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/gallimimus2.png");

    public RenderGallimimus(Dinosaur dino)
    {
        super(new ModelGallimimus(), dino, 0.65F);
    }

    protected ResourceLocation setTexture(EntityGallimimus dino)
    {
        switch (dino.getCreatureTexture())
        {
            case 1:
                return texture1;
            case 2:
                return texture2;
            default:
                return texture1;
        }
    }

    public ResourceLocation getEntityTexture(Entity var1)
    {
        return this.setTexture((EntityGallimimus) var1);
    }
}
