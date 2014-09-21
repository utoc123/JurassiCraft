package to.uk.ilexiconn.jurassicraft.data.entity.render;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.data.entity.Dinosaur;
import to.uk.ilexiconn.jurassicraft.data.entity.RenderDinosaur;
import to.uk.ilexiconn.jurassicraft.data.entity.entity.EntityGallimimus;
import to.uk.ilexiconn.jurassicraft.data.entity.model.ModelGallimimus;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGallimimus extends RenderDinosaur {
	public RenderGallimimus(Dinosaur dino) {
		super(new ModelGallimimus(), dino, 1f);
	}

	private static final ResourceLocation texture1 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/gallimimus1.png");
	private static final ResourceLocation texture2 = new ResourceLocation(JurassiCraft.getModId() + "textures/entity/gallimimus2.png");

	protected ResourceLocation setTexture(EntityGallimimus dino) {
		switch (dino.getCreatureTexture()) {
			case 1:
			default:
				return texture1;
			case 0:
				return texture2;
		}
	}

	public ResourceLocation getEntityTexture(Entity var1) {
		return this.setTexture((EntityGallimimus) var1);
	}
}
