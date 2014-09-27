package to.uk.ilexiconn.jurassicraft.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.EntityLivingBase;
import org.lwjgl.opengl.GL11;

public abstract class RenderDinosaur extends RenderLiving
{

    private Dinosaur dino;
    private float resizableShadow;

    public RenderDinosaur(ModelBase model, Dinosaur dino, float shadow)
    {
        super(model, 1.0F);
        this.setDino(dino);
        this.setShadow(shadow);
    }

    private void setShadow(float shadow)
    {
        this.resizableShadow = shadow;
    }

    public float getShadow()
    {
        return this.resizableShadow;
    }

    public void setDino(Dinosaur dino)
    {
        this.dino = dino;
    }

    public Dinosaur getDino()
    {
        return this.dino;
    }

    public void preRenderCallback(EntityLivingBase entity, float side)
    {
        float scale = (float) ((EntityJurassiCraftCreature) entity).getCreatureScale();
        this.shadowSize = scale * this.getShadow();
        GL11.glScalef(scale, scale, scale);
    }
}
