package com.ilexiconn.jurassicraft.data.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ilexiconn.jurassicraft.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Collection;

public class JsonEntityParser extends Util
{
    private Collection<Dinosaur> dinos;
    private boolean configLoaded;

    public void parseServerEntities()
    {
        loadConfig(getConfigFile());
        configLoaded = true;
        for (Dinosaur dino : dinos)
        {
            addMeat(dino.dinoName);
            addDNA(dino.dinoName);
            addEntity(dino);
        }
    }

    @SideOnly(Side.CLIENT)
    public void parseClientEntities()
    {
        while (!configLoaded);
        for (Dinosaur dino : dinos) addEntityRenderer(dino);
    }

    private void loadConfig(File config)
    {
        try
        {
            Type collectionType = new TypeToken<Collection<Dinosaur>>(){}.getType();

            dinos = new Gson().fromJson(new FileReader(config), collectionType);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private File getConfigFile()
    {
        try
        {
            return new File(getClass().getResource("dinos.json").toURI());
        }
        catch (Exception e)
        {
            return null;
        }
    }
}
