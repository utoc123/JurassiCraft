package to.uk.ilexiconn.jurassicraft.data.entity.render;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.data.entity.Dinosaur;
import to.uk.ilexiconn.jurassicraft.data.entity.RenderDinosaur;
import to.uk.ilexiconn.jurassicraft.data.entity.entity.EntityDilophosaurus;
import to.uk.ilexiconn.jurassicraft.data.entity.model.ModelDilophosaurus;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDilophosaurus extends RenderDinosaur {
	public RenderDilophosaurus(Dinosaur dino) {
		super(new ModelDilophosaurus(), dino, 1.0F);
	}

	public ResourceLocation getEntityTexture(Entity var1) {
		EntityDilophosaurus dino = (EntityDilophosaurus) var1;
		switch (dino.getCreatureTexture()) {
			case 1:
			default:
				return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/dilophosaurus1.png");
			case 0:
				return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/dilophosaurus2.png");
		}
	}
}