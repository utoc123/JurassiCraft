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

public class EntityJsonParser extends Util
{
    public Collection<Dino> dinos;
    private static Dino currentDino;

    class Dino
    {
        String dinoName;
        int dinoSpeed;
        int dinoHealth;
        float sizeMultiplier;
        float hitboxSize;
        boolean isMale;
        String livingSiund;
        String hurtSound;
        String deathSound;
        boolean register;
    }

    public void parseServerEntities(FMLPreInitializationEvent event)
    {
        loadConfig(event.getSuggestedConfigurationFile());
        for (Dino dino : dinos)
        {
            setCurrentDino(dino);
            addEntity(dino.dinoName);
        }
    }

    @SideOnly(Side.CLIENT)
    public void parseClientEntities()
    {
        for (Dino dino : dinos)
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
            Type collectionType = new TypeToken<Collection<Dino>>(){}.getType();
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
            IOUtils.copy(EntityJsonParser.class.getResource("jurassicraft.cfg").openStream(), new FileOutputStream(configFile));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void setCurrentDino(Dino dino)
    {
        currentDino = dino;
    }

    public Dino getCurrentDino()
    {
        return currentDino;
    }
}
