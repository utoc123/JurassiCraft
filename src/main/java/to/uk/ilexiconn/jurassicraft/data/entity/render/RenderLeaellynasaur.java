package to.uk.ilexiconn.jurassicraft.data.entity.render;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.data.entity.Dinosaur;
import to.uk.ilexiconn.jurassicraft.data.entity.RenderDinosaur;
import to.uk.ilexiconn.jurassicraft.data.entity.entity.EntityLeaellynasaur;
import to.uk.ilexiconn.jurassicraft.data.entity.model.ModelLeaellynasaur;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderLeaellynasaur extends RenderDinosaur
{
    public RenderLeaellynasaur(Dinosaur dino)
    {
        super(new ModelLeaellynasaur(), dino, 1f);
    }

    public ResourceLocation getEntityTexture(Entity var1)
    {
    	EntityLeaellynasaur ank = (EntityLeaellynasaur)var1;
    	switch(ank.texid)
    	{
    	case 1:
    		default:
        return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/leaellynasaur1.png");
    	case 0:
        return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/leaellynasaur2.png");
    	}
    }
}
