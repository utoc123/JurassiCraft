package to.uk.ilexiconn.jurassicraft.entity.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.EntityLivingBase;

import org.lwjgl.opengl.GL11;

import to.uk.ilexiconn.jurassicraft.entity.Arthropod;
import to.uk.ilexiconn.jurassicraft.entity.Bird;
import to.uk.ilexiconn.jurassicraft.entity.EntityJurassiCraftCreature;

public abstract class RenderBird extends RenderLiving
{

    private Bird bird;
    private float resizableShadow;

    public RenderBird(ModelBase model, Bird bird, float shadow)
    {
        super(model, 1.0F);
        this.setBird(bird);
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

    public void setBird(Bird bird)
    {
        this.bird = bird;
    }

    public Bird getBird()
    {
        return this.bird;
    }

    @Override
    public void preRenderCallback(EntityLivingBase entity, float side)
    {
        float scale = (float) ((EntityJurassiCraftCreature) entity).getCreatureScale();
        this.shadowSize = scale * this.getShadow();
        GL11.glScalef(scale, scale, scale);
    }
}
