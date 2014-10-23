package to.uk.ilexiconn.jurassicraft.entity.render;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.client.model.entity.ModelMammoth;
import to.uk.ilexiconn.jurassicraft.entity.Dinosaur;
import to.uk.ilexiconn.jurassicraft.entity.mammal.EntityMammoth;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderMammoth extends RenderDinosaur
{
    public RenderMammoth(Dinosaur dino)
    {
        super(new ModelMammoth(), dino, 1.6F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityMammoth dino = (EntityMammoth) entity;
        if (dino.isMale())
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Brachiosaurus_Male_1.png");
        } 
        else 
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Brachiosaurus_Female_1.png");
        }
    }
}
