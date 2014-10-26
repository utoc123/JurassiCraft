package to.uk.ilexiconn.jurassicraft.entity.render;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.client.model.entity.ModelArsinoitherium;
import to.uk.ilexiconn.jurassicraft.entity.Dinosaur;
import to.uk.ilexiconn.jurassicraft.entity.mammal.EntityArsinoitherium;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderArsinoitherium extends RenderDinosaur
{
    public RenderArsinoitherium(Dinosaur dino)
    {
        super(new ModelArsinoitherium(), dino, 1.6F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityArsinoitherium dino = (EntityArsinoitherium) entity;
        if (dino.isMale())
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Arsinoitherium_Male_1.png");
        } 
        else 
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Arsinoitherium_Female_1.png");
        }
    }
}
