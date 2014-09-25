package to.uk.ilexiconn.jurassicraft.data.animation;

import thehippomaster.AnimationAPI.AIAnimation;
import to.uk.ilexiconn.jurassicraft.data.entity.entity.EntityVelociraptor;

public class AIVelociraptorRoar extends AIAnimation
{
    private EntityVelociraptor entityRaptor;

    public AIVelociraptorRoar(EntityVelociraptor raptor)
    {
        super(raptor);
        entityRaptor = raptor;
    }

    public int getAnimID()
    {
        return 2;
    }

    public boolean isAutomatic()
    {
        return true;
    }

    public int getDuration()
    {
        return 20;
    }
}

