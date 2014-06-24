package com.ilexiconn.jurassicraft.data.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ilexiconn.jurassicraft.Util;
import com.ilexiconn.jurassicraft.data.item.ItemMeat;
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
    public Collection<Dinosaur> dinos;
    private Dinosaur currentDino;
    private ItemMeat currentMeat;

    public void parseServerEntities(FMLPreInitializationEvent event)
    {
        loadConfig(event.getSuggestedConfigurationFile());
        for (Dinosaur dino : dinos)
        {
            setCurrentDino(dino);
            setCurrentMeat(addMeat(dino.dinoName));
            addDNA(dino.dinoName);
            addEntity(dino.dinoName);
        }
    }

    @SideOnly(Side.CLIENT)
    public void parseClientEntities()
    {
        for (Dinosaur dino : dinos)
        {
            setCurrentDino(dino);
            addEntityRenderer(dino.dinoName);
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

    public void setCurrentDino(Dinosaur dino)
    {
        currentDino = dino;
    }

    public Dinosaur getCurrentDino()
    {
        return currentDino;
    }

    public void setCurrentMeat(ItemMeat item)
    {
        currentMeat = item;
    }

    public ItemMeat getCurrentMeat()
    {
        return currentMeat;
    }
}
