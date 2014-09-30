package to.uk.ilexiconn.jurassicraft.entity.render;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.client.model.entity.ModelSarcosuchus;
import to.uk.ilexiconn.jurassicraft.entity.Dinosaur;
import to.uk.ilexiconn.jurassicraft.entity.dinosaur.EntitySarcosuchus;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSarcosuchus extends RenderDinosaur
{
    public RenderSarcosuchus(Dinosaur dino)
    {
        super(new ModelSarcosuchus(), dino, 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
    	EntitySarcosuchus dino = (EntitySarcosuchus) entity;
        if (dino.isMale())
        {
            switch (dino.getCreatureTexture()) {
            	case 0:
            		return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Sarcosuchus_Wetlands_Male_1.png");
            	case 1:
            		return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Sarcosuchus_Arid_Male_1.png");
            	default:
            		return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Sarcosuchus_Wetlands_Male_1.png");
            }
        } 
        else 
        {
        	switch (dino.getCreatureTexture()) {
            	case 0:
            		return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Sarcosuchus_Wetlands_Female_1.png");
            	case 1:
            		return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Sarcosuchus_Arid_Female_1.png");
            	default:
            		return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Sarcosuchus_Wetlands_Female_1.png");
            }
        }
    }
}
