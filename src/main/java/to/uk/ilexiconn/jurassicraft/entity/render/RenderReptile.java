package to.uk.ilexiconn.jurassicraft.entity.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.EntityLivingBase;

import org.lwjgl.opengl.GL11;

import to.uk.ilexiconn.jurassicraft.entity.EntityJurassiCraftCreature;
import to.uk.ilexiconn.jurassicraft.entity.Reptile;

public abstract class RenderReptile extends RenderLiving
{

    private Reptile reptile;
    private float resizableShadow;

    public RenderReptile(ModelBase model, Reptile reptile, float shadow)
    {
        super(model, 1.0F);
        this.setReptile(reptile);
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

    public void setReptile(Reptile reptile)
    {
        this.reptile = reptile;
    }

    public Reptile getReptile()
    {
        return this.reptile;
    }

    @Override
    public void preRenderCallback(EntityLivingBase entity, float side)
    {
        float scale = (float) ((EntityJurassiCraftCreature) entity).getCreatureScale();
        this.shadowSize = scale * this.getShadow();
        GL11.glScalef(scale, scale, scale);
    }
}
