package to.uk.ilexiconn.jurassicraft;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import to.uk.ilexiconn.jurassicraft.client.gui.GuiHandler;
import to.uk.ilexiconn.jurassicraft.entity.EntityJurassiCraftCreature;
import to.uk.ilexiconn.jurassicraft.entity.dinosaur.EntityCoelacanth;
import to.uk.ilexiconn.llib.LLib;
import to.uk.ilexiconn.llib.config.ConfigSync;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = "jurassicraft", name = "JurassiCraft", version = "1.3.0 PRE-RELEASE", dependencies = "required-after:llib@[0.1.1,)")
public class JurassiCraft extends Util
{
    @Mod.Instance("jurassicraft")
    public static JurassiCraft instance;
    public boolean isServerInitialized;

    public static boolean versionCheck;
    public static boolean easterEggs;
	public static EntityJurassiCraftCreature creatureToAnalyze;

    @Mod.EventHandler
    public void init(FMLPreInitializationEvent event)
    {
        getEntityParser().parseServerEntities();

        isServerInitialized = true;
        
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    }

    @SideOnly(Side.CLIENT)
    @Mod.EventHandler
    public void initClient(FMLPreInitializationEvent event)
    {
        while (!isServerInitialized);

        getEntityParser().parseClientEntities();
    }

    @Mod.EventHandler
    public void load(FMLInitializationEvent event)
    {
        EntityRegistry.addSpawn(EntityCoelacanth.class, 2, 3, 5, EnumCreatureType.waterCreature, BiomeGenBase.deepOcean, BiomeGenBase.ocean);
    }

    @ConfigSync
    public void syncConfig()
    {
        versionCheck = LLib.config.getBoolean("Version Check", "jurassicraft", true, "Do an automatic version check on every start");
        easterEggs = LLib.config.getBoolean("Easter Eggs", "jurassicraft", false, "Enable all the easter eggs is the mod");
    }
}
