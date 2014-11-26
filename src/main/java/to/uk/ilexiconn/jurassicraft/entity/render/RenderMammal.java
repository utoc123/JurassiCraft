package to.uk.ilexiconn.jurassicraft.entity.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.EntityLivingBase;

import org.lwjgl.opengl.GL11;

import to.uk.ilexiconn.jurassicraft.entity.EntityJurassiCraftCreature;
import to.uk.ilexiconn.jurassicraft.entity.Mammal;

public abstract class RenderMammal extends RenderLiving
{

    private Mammal mammal;
    private float resizableShadow;

    public RenderMammal(ModelBase model, Mammal mammal, float shadow)
    {
        super(model, 1.0F);
        this.setMammal(mammal);
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

    public void setMammal(Mammal mammal)
    {
        this.mammal = mammal;
    }

    public Mammal getMammal()
    {
        return this.mammal;
    }

    @Override
    public void preRenderCallback(EntityLivingBase entity, float side)
    {
        float scale = (float) ((EntityJurassiCraftCreature) entity).getCreatureScale();
        this.shadowSize = scale * this.getShadow();
        GL11.glScalef(scale, scale, scale);
    }
}
