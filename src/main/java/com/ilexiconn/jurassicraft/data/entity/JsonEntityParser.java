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
import java.util.ArrayList;
import java.util.Collection;

public class JsonEntityParser extends Util
{
    private Collection<Dinosaur> dinos;
    private ArrayList<Dinosaur> dArray = new ArrayList<Dinosaur>();

    public void parseServerEntities(FMLPreInitializationEvent event)
    {
        loadConfig(event.getSuggestedConfigurationFile());
        for (Dinosaur dino : dinos) if (!dArray.contains(dino)) dArray.add(dino);
        for (Dinosaur dino : dArray) addEntity(dino);
    }

    @SideOnly(Side.CLIENT)
    public void parseClientEntities()
    {
        for (Dinosaur dino : dinos)
        {
            addEntityRenderer(dino);
        }
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
            IOUtils.copy(JsonEntityParser.class.getResource("jurassicraft.cfg").openStream(), new FileOutputStream(configFile));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
