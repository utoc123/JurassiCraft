package to.uk.ilexiconn.jurassicraft.entity.render.dinosaurs;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.client.model.entity.ModelParasaurolophus;
import to.uk.ilexiconn.jurassicraft.entity.Entities;
import to.uk.ilexiconn.jurassicraft.entity.dinosaurs.EntityParasaurolophus;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import to.uk.ilexiconn.jurassicraft.entity.render.RenderDinosaur;

@SideOnly(Side.CLIENT)
public class RenderParasaurolophus extends RenderDinosaur
{
    public RenderParasaurolophus(Entities dino)
    {
        super(new ModelParasaurolophus(), dino, 0.8F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityParasaurolophus dino = (EntityParasaurolophus) entity;
        if (dino.isMale())
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Parasaurolophus_Male_1.png");
        } 
        else 
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Parasaurolophus_Female_1.png");
        }
    }
}
