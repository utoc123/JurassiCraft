package to.uk.ilexiconn.jurassicraft.entity.render.dinosaurs;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.client.model.entity.ModelStegosaur;
import to.uk.ilexiconn.jurassicraft.entity.Entities;
import to.uk.ilexiconn.jurassicraft.entity.dinosaurs.EntityStegosaur;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import to.uk.ilexiconn.jurassicraft.entity.render.RenderDinosaur;

@SideOnly(Side.CLIENT)
public class RenderStegosaur extends RenderDinosaur
{
    public RenderStegosaur(Entities dino)
    {
        super(new ModelStegosaur(), dino, 1.0F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityStegosaur dino = (EntityStegosaur) entity;
        if (dino.isMale())
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Stegosaurus_Male_1.png");
        } 
        else 
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Stegosaurus_Female_1.png");
        }
    }
}
