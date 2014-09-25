package to.uk.ilexiconn.jurassicraft;

import cpw.mods.fml.common.registry.EntityRegistry;
import to.uk.ilexiconn.jurassicraft.data.entity.entity.EntityDinoEgg;
import to.uk.ilexiconn.llib.content.ContentHandler;
import to.uk.ilexiconn.llib.content.ContentType;

@ContentHandler(modid = "jurassicraft", type = ContentType.ENTITY)
public class ModEntities
{
    public void init()
    {
        EntityRegistry.registerModEntity(EntityDinoEgg.class, "dino_egg", Util.entityId, JurassiCraft.instance, 64, 1, true);
    }
}
