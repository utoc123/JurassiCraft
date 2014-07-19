package com.ilexiconn.jurassicraft;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

import com.ilexiconn.jurassicraft.data.entity.Dinosaur;
import com.ilexiconn.jurassicraft.data.entity.entity.EntityCoelacanth;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = "jurassicraft", name = "JurassiCraft", version = "1.1.2")
public class JurassiCraft extends Util
{
    @Mod.Instance("jurassicraft")
    public static JurassiCraft instance;
    public boolean isServerInitialized;

    @Mod.EventHandler
    public void init(FMLPreInitializationEvent event)
    {
        getData().init();

        getEntityParser().parseServerEntities();

        for (Dinosaur dino : getDinos()) System.out.println("Added dino " + dino.dinoName + " with ID " + dino.id);

        isServerInitialized = true;
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
        EntityRegistry.addSpawn(EntityCoelacanth.class, 2, 3, 5, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.deepOcean, BiomeGenBase.ocean});
    }
}
