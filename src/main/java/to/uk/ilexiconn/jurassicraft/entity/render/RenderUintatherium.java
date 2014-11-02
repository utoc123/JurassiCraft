package to.uk.ilexiconn.jurassicraft.entity.render;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.client.model.entity.ModelUintatherium;
import to.uk.ilexiconn.jurassicraft.entity.Dinosaur;
import to.uk.ilexiconn.jurassicraft.entity.mammal.EntityUintatherium;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderUintatherium extends RenderDinosaur
{
    public RenderUintatherium(Dinosaur dino)
    {
        super(new ModelUintatherium(), dino, 0.8F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
    	EntityUintatherium dino = (EntityUintatherium) entity;
        if (dino.isMale())
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Uintatherium_Male_1.png");
        } 
        else 
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Uintatherium_Female_1.png");
        }
    }
}
