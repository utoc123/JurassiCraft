package to.uk.ilexiconn.jurassicraft.data.entity.render;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.data.entity.Dinosaur;
import to.uk.ilexiconn.jurassicraft.data.entity.RenderDinosaur;
import to.uk.ilexiconn.jurassicraft.data.entity.entity.EntityBrachiosaur;
import to.uk.ilexiconn.jurassicraft.data.entity.model.ModelBrachiosaur;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderBrachiosaur extends RenderDinosaur {
	public RenderBrachiosaur(Dinosaur dino) {
		super(new ModelBrachiosaur(), dino, 2f);
	}

	public ResourceLocation getEntityTexture(Entity var1) {
		EntityBrachiosaur dino = (EntityBrachiosaur) var1;
		switch (dino.getCreatureTexture()) {
			case 1:
			default:
				return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/brachiosaur1.png");
			case 0:
				return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/brachiosaur2.png");
		}
	}
}
