package com.ilexiconn.jurassicraft.data.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ilexiconn.jurassicraft.Util;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

public class JsonEntityParser extends Util
{
    private Collection<Dinosaur> dinos;

    public void parseServerEntities(FMLPreInitializationEvent event)
    {
        loadConfig(event.getSuggestedConfigurationFile());
        for (Dinosaur dino : dinos)
        {
            addMeat(dino.dinoName);
            addDNA(dino.dinoName);
            addEntity(dino);
        }
    }

    @SideOnly(Side.CLIENT)
    public void parseClientEntities(FMLPreInitializationEvent event)
    {
        for (Dinosaur dino : dinos) addEntityRenderer(dino);
    }

    public void loadConfig(File configFile)
    {
        try
        {
            makeConfig(configFile);
            Type collectionType = new TypeToken<Collection<Dinosaur>>(){}.getType();
            dinos =  new Gson().fromJson(new FileReader(configFile), collectionType);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void makeConfig(File configFile)
    {
        try
        {
            if (configFile.exists()) configFile.delete();
            System.out.println(JsonEntityParser.class.getResourceAsStream("jurassicraft.cfg"));
            System.out.println(configFile);
            IOUtils.copy(JsonEntityParser.class.getResourceAsStream("jurassicraft.cfg"), new FileOutputStream(configFile));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
