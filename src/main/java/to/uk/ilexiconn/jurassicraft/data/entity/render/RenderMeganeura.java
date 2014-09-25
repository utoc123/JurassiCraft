package to.uk.ilexiconn.jurassicraft.data.entity.render;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.data.entity.Dinosaur;
import to.uk.ilexiconn.jurassicraft.data.entity.RenderDinosaur;
import to.uk.ilexiconn.jurassicraft.data.entity.entity.EntityMeganeura;
import to.uk.ilexiconn.jurassicraft.data.entity.model.ModelMeganeura;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderMeganeura extends RenderDinosaur {
	public RenderMeganeura(Dinosaur dino) {
		super(new ModelMeganeura(), dino, 0.25F);
	}

	public ResourceLocation getEntityTexture(Entity var1) {
		EntityMeganeura dino = (EntityMeganeura) var1;
		switch (dino.getCreatureTexture()) {
			case 1:
			default:
				return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/meganeura1.png");
			case 0:
				return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/meganeura2.png");
		}
	}
}
