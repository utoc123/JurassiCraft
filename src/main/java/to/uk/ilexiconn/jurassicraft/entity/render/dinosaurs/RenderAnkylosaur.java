package to.uk.ilexiconn.jurassicraft.entity.render.dinosaurs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.client.model.entity.ModelAnkylosaur;
import to.uk.ilexiconn.jurassicraft.entity.Entities;
import to.uk.ilexiconn.jurassicraft.entity.dinosaurs.EntityAnkylosaur;
import to.uk.ilexiconn.jurassicraft.entity.render.RenderDinosaur;

@SideOnly(Side.CLIENT)
public class RenderAnkylosaur extends RenderDinosaur
{
    public RenderAnkylosaur(Entities dino)
    {
        super(new ModelAnkylosaur(), dino, 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
    	EntityAnkylosaur dino = (EntityAnkylosaur) entity;
        if (dino.isMale())
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Ankylosaurus_Male_1.png");
        } 
        else 
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Ankylosaurus_Female_1.png");
        }
    }
}
