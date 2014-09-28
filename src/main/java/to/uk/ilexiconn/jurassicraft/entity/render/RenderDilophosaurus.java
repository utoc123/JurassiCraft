package to.uk.ilexiconn.jurassicraft.entity.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.entity.Dinosaur;
import to.uk.ilexiconn.jurassicraft.entity.dinosaur.EntityDilophosaurus;
import to.uk.ilexiconn.jurassicraft.entity.model.ModelDilophosaurus;

@SideOnly(Side.CLIENT)
public class RenderDilophosaurus extends RenderDinosaur
{
    public RenderDilophosaurus(Dinosaur dino)
    {
        super(new ModelDilophosaurus(), dino, 1.0F);
    }

    public ResourceLocation getEntityTexture(Entity var1)
    {
        EntityDilophosaurus dino = (EntityDilophosaurus) var1;
        switch (dino.getCreatureTexture())
        {
            case 0:
                return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/dilophosaurus1.png");
            case 1:
                return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/dilophosaurus2.png");
            default:
                return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/dilophosaurus1.png");
        }
    }
}