package to.uk.ilexiconn.jurassicraft.data.entity;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import to.uk.ilexiconn.jurassicraft.data.block.model.ModelEgg;
import to.uk.ilexiconn.jurassicraft.data.entity.entity.EntityDinoEgg;

public class RenderDinoEgg extends Render
{
	public ModelEgg eggModel;
	
	public RenderDinoEgg()
	{
		this.eggModel = new ModelEgg();
	}
	
	@Override
	public void doRender(Entity entity, double x, double y, double z, float rotationYaw, float p_76986_9_)
	{
		renderEgg((EntityDinoEgg) entity, x, y, z, rotationYaw, p_76986_9_);
	}
	
	private void renderEgg(EntityDinoEgg entity, double x, double y, double z, float rotationYaw, float p_76986_9_)
	{
		if(!entity.isDead)
		{
			GL11.glPushMatrix();
			GL11.glTranslatef((float)x, (float)y + 1.5F, (float)z);
			GL11.glRotatef(180.0F - rotationYaw, 0.0F, 1.0F, 0.0F);
			float f4 = 0.75F;
			GL11.glScalef(f4, f4, f4);
			GL11.glScalef(1.0F / f4, 1.0F / f4, 1.0F / f4);
			this.bindEntityTexture(entity);
			GL11.glScalef(-1.0F, -1.0F, 1.0F);
			
			this.eggModel.render(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
		}
	}

	private ResourceLocation getDinoEggTexture(EntityDinoEgg egg)
	{
		return egg.getTexture();
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return getDinoEggTexture((EntityDinoEgg) entity);
	}
}
