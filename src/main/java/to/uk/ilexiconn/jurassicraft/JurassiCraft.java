package to.uk.ilexiconn.jurassicraft;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ilexiconn.llib.LLib;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import to.uk.ilexiconn.jurassicraft.data.entity.Dinosaur;
import to.uk.ilexiconn.jurassicraft.data.entity.entity.EntityCoelacanth;
import to.uk.ilexiconn.jurassicraft.logger.LogHelper;

import java.util.Map.Entry;

@Mod(modid = "jurassicraft", name = "JurassiCraft", version = "1.1.2", dependencies = "after:llib")
public class JurassiCraft extends Util
{
    @Mod.Instance("jurassicraft")
    public static JurassiCraft instance;
    public boolean isServerInitialized;

    @Deprecated
    public static boolean versionCheck;

    @Mod.EventHandler
    public void init(FMLPreInitializationEvent event)
    {
        try
        {
            LLib.addConfigSyncMethod("syncConfig", this);
        }
        catch (NoSuchMethodException e)
        {
            e.printStackTrace();
        }

        getData().init();

        getEntityParser().parseServerEntities();

        for (Entry<Dinosaur, Class<?>> dino : getDinos().entrySet())
            LogHelper.info("Added dino " + dino.getKey().dinoName + " with ID " + dino.getKey().id);

        isServerInitialized = true;
        LogHelper.info("PreInitialization complete");
    }

    @SideOnly(Side.CLIENT)
    @Mod.EventHandler
    public void initClient(FMLPreInitializationEvent event)
    {
        while (!isServerInitialized);

        getData().initClient();

        getEntityParser().parseClientEntities();
    }
    
    @Mod.EventHandler
    public void load(FMLInitializationEvent event)
    {
        EntityRegistry.addSpawn(EntityCoelacanth.class, 2, 3, 5, EnumCreatureType.waterCreature, BiomeGenBase.deepOcean, BiomeGenBase.ocean);
    }

    public void syncConfig()
    {
        versionCheck = LLib.config.getBoolean("Version Check", "jurassicraft", true, "Do an automatic version check on every start");
    }
}
