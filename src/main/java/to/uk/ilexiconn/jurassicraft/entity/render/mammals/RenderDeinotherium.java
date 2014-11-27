package to.uk.ilexiconn.jurassicraft.entity.render.mammals;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.client.model.entity.ModelDeinotherium;
import to.uk.ilexiconn.jurassicraft.entity.Dinosaur;
import to.uk.ilexiconn.jurassicraft.entity.Mammal;
import to.uk.ilexiconn.jurassicraft.entity.mammals.EntityDeinotherium;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import to.uk.ilexiconn.jurassicraft.entity.render.RenderMammal;

@SideOnly(Side.CLIENT)
public class RenderDeinotherium extends RenderMammal
{
    public RenderDeinotherium(Mammal mammal)
    {
        super(new ModelDeinotherium(), mammal, 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
    	EntityDeinotherium mammal = (EntityDeinotherium) entity;
        if (mammal.isMale())
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Deinotherium_Male_1.png");
        } 
        else 
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Deinotherium_Female_1.png");
        }
    }
}