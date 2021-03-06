package to.uk.ilexiconn.jurassicraft.entity.render.arthropods;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.client.model.entity.ModelMeganeura;
import to.uk.ilexiconn.jurassicraft.entity.Entities;
import to.uk.ilexiconn.jurassicraft.entity.arthropods.EntityMeganeura;
import to.uk.ilexiconn.jurassicraft.entity.render.RenderDinosaur;

@SideOnly(Side.CLIENT)
public class RenderMeganeura extends RenderDinosaur
{
    public RenderMeganeura(Entities dino)
    {
        super(new ModelMeganeura(), dino, 0.25F);
    }

    @Override
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
