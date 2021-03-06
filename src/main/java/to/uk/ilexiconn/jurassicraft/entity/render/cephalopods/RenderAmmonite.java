package to.uk.ilexiconn.jurassicraft.entity.render.cephalopods;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.client.model.entity.ModelAmmonite;
import to.uk.ilexiconn.jurassicraft.entity.Entities;
import to.uk.ilexiconn.jurassicraft.entity.cephalopods.EntityAmmonite;
import to.uk.ilexiconn.jurassicraft.entity.render.RenderCephalopod;

@SideOnly(Side.CLIENT)
public class RenderAmmonite extends RenderCephalopod
{
    public RenderAmmonite(Entities cephalopod)
    {
        super(new ModelAmmonite(), cephalopod, 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityAmmonite cephalopod = (EntityAmmonite) entity;
        if (cephalopod.isMale())
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Ammonite.png");
        }
        else
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Ammonite.png");
        }
    }
}
