package com.ilexiconn.jurassicraft;

import com.ilexiconn.jurassicraft.logger.LogType;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = "jurassicraft", name = "JurassiCraft", version = "1.1.2")
public class JurassiCraft extends Util
{
    @Mod.Instance("jurassicraft")
    public static JurassiCraft instance;

    @Mod.EventHandler
    public void init(FMLPreInitializationEvent event)
    {
        getLogger().print(LogType.INFO, "Initializing mod...");
        getData().init(event);
    }

    @SideOnly(Side.CLIENT)
    @Mod.EventHandler
    public void initClient(FMLPreInitializationEvent event)
    {
        getData().initClient(event);
    }
}
