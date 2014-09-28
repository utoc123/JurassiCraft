package to.uk.ilexiconn.jurassicraft.client.animation;

import thehippomaster.AnimationAPI.AIAnimation;
import to.uk.ilexiconn.jurassicraft.entity.dinosaur.EntityTyrannosaurus;


public class AITyrannosaurusRoar extends AIAnimation
{
    private EntityTyrannosaurus entityTrex;

    public AITyrannosaurusRoar(EntityTyrannosaurus trex)
    {
        super(trex);
        entityTrex = trex;
    }

    public int getAnimID()
    {
        return 1;
    }

    public boolean isAutomatic()
    {
        return true;
    }

    public int getDuration()
    {
        return 80;
    }
}
