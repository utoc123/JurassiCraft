package to.uk.ilexiconn.jurassicraft.entity.render;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.client.model.entity.ModelParaceratherium;
import to.uk.ilexiconn.jurassicraft.entity.Dinosaur;
import to.uk.ilexiconn.jurassicraft.entity.mammal.EntityParaceratherium;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderParaceratherium extends RenderDinosaur
{
    public RenderParaceratherium(Dinosaur dino)
    {
        super(new ModelParaceratherium(), dino, 1.6F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityParaceratherium dino = (EntityParaceratherium) entity;
        if (dino.isMale())
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Paraceratherium_Male_1.png");
        } 
        else 
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Paraceratherium_Female_1.png");
        }
    }
}
