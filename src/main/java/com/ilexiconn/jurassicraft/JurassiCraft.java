package com.ilexiconn.jurassicraft;

import com.ilexiconn.jurassicraft.data.entity.EntityLiopleurodon;
import com.ilexiconn.jurassicraft.data.entity.EntityStegosaurus;
import com.ilexiconn.jurassicraft.data.entity.EntityTRex;
import com.ilexiconn.jurassicraft.logger.LogType;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;

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
    
    @EventHandler
    public void load(FMLInitializationEvent event)
    {
		EntityRegistry.registerGlobalEntityID(EntityStegosaurus.class, "Stegosaurus", EntityRegistry.findGlobalUniqueEntityId(), 0x7D3B0C, 0xB37346);
		EntityRegistry.registerGlobalEntityID(EntityLiopleurodon.class, "Liopleurodon", EntityRegistry.findGlobalUniqueEntityId(), 0x7D3B0C, 0xB37346);
		EntityRegistry.registerGlobalEntityID(EntityTRex.class, "Rex", EntityRegistry.findGlobalUniqueEntityId(), 0x7D3B0C, 0xB37346);
		proxy.registerRenderInformation();

    }
}
