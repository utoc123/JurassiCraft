package to.uk.ilexiconn.jurassicraft.entity.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.entity.Dinosaur;
import to.uk.ilexiconn.jurassicraft.entity.RenderDinosaur;
import to.uk.ilexiconn.jurassicraft.entity.entity.EntitySarcosuchus;
import to.uk.ilexiconn.jurassicraft.entity.model.ModelSarcosuchus;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSarcosuchus extends RenderDinosaur
{
    public RenderSarcosuchus(Dinosaur dino)
    {
        super(new ModelSarcosuchus(), dino, 0.5F);
    }

    public ResourceLocation getEntityTexture(Entity var1)
    {
    	EntitySarcosuchus dino = (EntitySarcosuchus) var1;
        switch (dino.getCreatureTexture())
        {
            case 1:
                return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/sarcosuchus1.png");
            case 2:
                return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/sarcosuchus2.png");
            default:
                return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/sarcosuchus1.png");
        }
    }
}
