package to.uk.ilexiconn.jurassicraft.entity.render.dinosaurs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.client.model.entity.ModelLeaellynasaur;
import to.uk.ilexiconn.jurassicraft.entity.Entities;
import to.uk.ilexiconn.jurassicraft.entity.dinosaurs.EntityLeaellynasaur;
import to.uk.ilexiconn.jurassicraft.entity.render.RenderDinosaur;

@SideOnly(Side.CLIENT)
public class RenderLeaellynasaur extends RenderDinosaur
{
    public RenderLeaellynasaur(Entities dino)
    {
        super(new ModelLeaellynasaur(), dino, 0.45F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityLeaellynasaur dino = (EntityLeaellynasaur) entity;
        if (dino.isMale())
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Leaellynasaura_Male_1.png");
        } 
        else 
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Leaellynasaura_Female_1.png");
        }
    }
}
