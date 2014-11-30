package to.uk.ilexiconn.jurassicraft.entity.render.dinosaurs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.client.model.entity.ModelDilophosaurus;
import to.uk.ilexiconn.jurassicraft.entity.Entities;
import to.uk.ilexiconn.jurassicraft.entity.dinosaurs.EntityDilophosaurus;
import to.uk.ilexiconn.jurassicraft.entity.render.RenderDinosaur;

@SideOnly(Side.CLIENT)
public class RenderDilophosaurus extends RenderDinosaur
{
    public RenderDilophosaurus(Entities dino)
    {
        super(new ModelDilophosaurus(), dino, 1.0F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityDilophosaurus dino = (EntityDilophosaurus) entity;
        if (dino.isMale())
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Dilophosaurus_Male_1.png");
        } 
        else 
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Dilophosaurus_Female_1.png");
        }
    }
}