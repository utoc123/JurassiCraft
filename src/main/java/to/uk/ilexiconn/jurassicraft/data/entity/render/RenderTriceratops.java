package to.uk.ilexiconn.jurassicraft.data.entity.render;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.data.entity.Dinosaur;
import to.uk.ilexiconn.jurassicraft.data.entity.RenderDinosaur;
import to.uk.ilexiconn.jurassicraft.data.entity.entity.EntityTriceratops;
import to.uk.ilexiconn.jurassicraft.data.entity.model.ModelTriceratops;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderTriceratops extends RenderDinosaur {
	public RenderTriceratops(Dinosaur dino) {
		super(new ModelTriceratops(), dino, 1f);
	}

	public ResourceLocation getEntityTexture(Entity var1) {
		EntityTriceratops dino = (EntityTriceratops) var1;
		switch (dino.getCreatureTexture()) {
			case 1:
			default:
				return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/triceratops1.png");
			case 0:
				return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/triceratops2.png");
		}
	}
}
