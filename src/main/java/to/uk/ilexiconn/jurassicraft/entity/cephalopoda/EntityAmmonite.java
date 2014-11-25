package to.uk.ilexiconn.jurassicraft.entity.cephalopoda;

import net.minecraft.world.World;
import to.uk.ilexiconn.jurassicraft.entity.NewEntitySwimming;

public class EntityAmmonite extends NewEntitySwimming
{

    public EntityAmmonite(World world)
    {
        super(world, (byte) 27);
        this.swimRadius = 16.0F;
        this.swimRadiusHeight = 10.0F;
        this.swimSpeed = 0.6F;
        this.jumpOnLand = false;
        this.attackInterval = 1;
        this.isAgressive = true;
        this.setCreatureExperiencePoints(5000);
    }
}
