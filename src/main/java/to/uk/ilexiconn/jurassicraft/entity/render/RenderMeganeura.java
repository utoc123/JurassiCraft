package to.uk.ilexiconn.jurassicraft.entity.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.entity.Dinosaur;
import to.uk.ilexiconn.jurassicraft.entity.RenderDinosaur;
import to.uk.ilexiconn.jurassicraft.entity.entity.EntityMeganeura;
import to.uk.ilexiconn.jurassicraft.entity.model.ModelMeganeura;

@SideOnly(Side.CLIENT)
public class RenderMeganeura extends RenderDinosaur
{
    public RenderMeganeura(Dinosaur dino)
    {
        super(new ModelMeganeura(), dino, 0.25F);
    }

    public ResourceLocation getEntityTexture(Entity var1)
    {
        EntityMeganeura dino = (EntityMeganeura) var1;
        switch (dino.getCreatureTexture())
        {
            case 0:
                return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/meganeura1.png");
            case 1:
                return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/meganeura2.png");
            default:
                return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/meganeura1.png");
        }
    }
}
