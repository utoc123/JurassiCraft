package to.uk.ilexiconn.jurassicraft.entity.render.dinosaurs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.client.model.entity.ModelOviraptor;
import to.uk.ilexiconn.jurassicraft.entity.Entities;
import to.uk.ilexiconn.jurassicraft.entity.dinosaurs.EntityOviraptor;
import to.uk.ilexiconn.jurassicraft.entity.render.RenderDinosaur;

@SideOnly(Side.CLIENT)
public class RenderOviraptor extends RenderDinosaur
{
    public RenderOviraptor(Entities dino)
    {
        super(new ModelOviraptor(), dino, 0.6F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
    	EntityOviraptor dino = (EntityOviraptor) entity;
        if (dino.isMale())
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Oviraptor_Male_1.png");
        } 
        else 
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Oviraptor_Female_1.png");
        }
    }
}
