package to.uk.ilexiconn.jurassicraft.entity.render.mammals;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.client.model.entity.ModelParaceratherium;
import to.uk.ilexiconn.jurassicraft.entity.Entities;
import to.uk.ilexiconn.jurassicraft.entity.mammals.EntityParaceratherium;
import to.uk.ilexiconn.jurassicraft.entity.render.RenderMammal;

@SideOnly(Side.CLIENT)
public class RenderParaceratherium extends RenderMammal
{
    public RenderParaceratherium(Entities mammal)
    {
        super(new ModelParaceratherium(), mammal, 1.6F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityParaceratherium mammal = (EntityParaceratherium) entity;
        if (mammal.isMale())
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Paraceratherium_Male_1.png");
        } 
        else 
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Paraceratherium_Female_1.png");
        }
    }
}
