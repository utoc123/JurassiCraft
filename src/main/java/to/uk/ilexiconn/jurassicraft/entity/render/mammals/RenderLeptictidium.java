package to.uk.ilexiconn.jurassicraft.entity.render.mammals;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.client.model.entity.ModelLeptictidium;
import to.uk.ilexiconn.jurassicraft.entity.Entities;
import to.uk.ilexiconn.jurassicraft.entity.mammals.EntityLeptictidium;
import to.uk.ilexiconn.jurassicraft.entity.render.RenderMammal;

@SideOnly(Side.CLIENT)
public class RenderLeptictidium extends RenderMammal
{
    public RenderLeptictidium(Entities mammal)
    {
        super(new ModelLeptictidium(), mammal, 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityLeptictidium mammal = (EntityLeptictidium) entity;
        if (mammal.isMale())
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Leptictidium_Male_1.png");
        } 
        else 
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Leptictidium_Female_1.png");
        }
    }
}
