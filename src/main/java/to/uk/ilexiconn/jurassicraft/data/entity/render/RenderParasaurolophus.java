package to.uk.ilexiconn.jurassicraft.data.entity.render;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.data.entity.Dinosaur;
import to.uk.ilexiconn.jurassicraft.data.entity.RenderDinosaur;
import to.uk.ilexiconn.jurassicraft.data.entity.entity.EntityParasaurolophus;
import to.uk.ilexiconn.jurassicraft.data.entity.model.ModelParasaurolophus;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderParasaurolophus extends RenderDinosaur {
	public RenderParasaurolophus(Dinosaur dino) {
		super(new ModelParasaurolophus(), dino, 1f);
	}

	public ResourceLocation getEntityTexture(Entity var1) {
		EntityParasaurolophus dino = (EntityParasaurolophus) var1;
		switch (dino.getCreatureTexture()) {
			case 1:
			default:
				return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/parasaurolophus1.png");
			case 0:
				return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/parasaurolophus2.png");
		}
	}
}
