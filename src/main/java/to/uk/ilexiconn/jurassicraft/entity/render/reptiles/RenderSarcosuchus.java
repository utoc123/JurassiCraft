package to.uk.ilexiconn.jurassicraft.entity.render.reptiles;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.client.model.entity.ModelSarcosuchus;
import to.uk.ilexiconn.jurassicraft.entity.Dinosaur;
import to.uk.ilexiconn.jurassicraft.entity.Mammal;
import to.uk.ilexiconn.jurassicraft.entity.Reptile;
import to.uk.ilexiconn.jurassicraft.entity.render.RenderDinosaur;
import to.uk.ilexiconn.jurassicraft.entity.render.RenderMammal;
import to.uk.ilexiconn.jurassicraft.entity.render.RenderReptile;
import to.uk.ilexiconn.jurassicraft.entity.reptiles.EntitySarcosuchus;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSarcosuchus extends RenderReptile
{
    public RenderSarcosuchus(Reptile reptile)
    {
        super(new ModelSarcosuchus(), reptile, 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
    	EntitySarcosuchus reptile = (EntitySarcosuchus) entity;
        if (reptile.isMale())
        {
            switch (reptile.getCreatureTexture()) {
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
        	switch (reptile.getCreatureTexture()) {
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
