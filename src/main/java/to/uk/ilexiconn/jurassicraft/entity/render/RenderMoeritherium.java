package to.uk.ilexiconn.jurassicraft.entity.render;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.client.model.entity.ModelMoeritherium;
import to.uk.ilexiconn.jurassicraft.entity.Dinosaur;
import to.uk.ilexiconn.jurassicraft.entity.mammal.EntityMoeritherium;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderMoeritherium extends RenderDinosaur
{
    public RenderMoeritherium(Dinosaur dino)
    {
        super(new ModelMoeritherium(), dino, 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityMoeritherium dino = (EntityMoeritherium) entity;
        if (dino.isMale())
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Moeritherium_Male_1.png");
        } 
        else 
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Moeritherium_Female_1.png");
        }
    }
}
