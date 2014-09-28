package to.uk.ilexiconn.jurassicraft.entity.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.entity.Dinosaur;
import to.uk.ilexiconn.jurassicraft.entity.model.ModelCoelacanth;

@SideOnly(Side.CLIENT)
public class RenderCoelacanth extends RenderSwimming
{

    public RenderCoelacanth(Dinosaur dino)
    {
        super(new ModelCoelacanth(), dino, 0.5F);
    }

    public ResourceLocation getEntityTexture(Entity var1)
    {
        return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/coelacanth.png");
    }

}
