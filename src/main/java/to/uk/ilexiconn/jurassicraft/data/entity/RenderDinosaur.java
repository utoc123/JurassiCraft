package to.uk.ilexiconn.jurassicraft.data.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.EntityLivingBase;
import org.lwjgl.opengl.GL11;

public abstract class RenderDinosaur extends RenderLiving
{
    private Dinosaur dino;

    public RenderDinosaur(ModelBase model, Dinosaur dino,  float shadow)
    {
        super(model, shadow);
        setDino(dino);
    }

    public void setDino(Dinosaur dino)
    {
        this.dino = dino;
    }

    public Dinosaur getDino()
    {
        return dino;
    }

    public void preRenderCallback(EntityLivingBase entity, float side)
    {
        GL11.glScalef(getDino().scale, getDino().scale, getDino().scale);
    }
}
