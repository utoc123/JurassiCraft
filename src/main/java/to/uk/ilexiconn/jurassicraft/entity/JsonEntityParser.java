package to.uk.ilexiconn.jurassicraft.entity;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Collection;

import org.apache.commons.io.IOUtils;
import to.uk.ilexiconn.jurassicraft.Util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class JsonEntityParser extends Util
{
    private Collection<Dinosaur> dinos;
    private Collection<Mammal> mammals;
    private Collection<Cephalopod> cephalopods;
    private Collection<Arthropod> arthropods;
    private Collection<Fish> Fish;
    private Collection<Reptile> reptiles;
    private Collection<Bird> birds;

    public void parseServerEntities()
    {
        loadConfig(DinoConfig.loadDinoConfig());
        for (Dinosaur creature : dinos)
        {
            addMeat(creature.creatureName);
            addDNA(creature.creatureName);
            addDinoEntity(creature);
        }

        loadConfig(DinoConfig.loadMammalConfig());
        for (Mammal creature : mammals)
        {
            addDNA(creature.creatureName);
            addMammalEntity(creature);
        }

        loadConfig(DinoConfig.loadCephalopodConfig());
        for (Cephalopod creature : cephalopods)
        {
            addCephalopodaEntity(creature);
        }

        loadConfig(DinoConfig.loadFishConfig());
        for (Fish creature : Fish)
        {
            addFishEntity(creature);
        }

        loadConfig(DinoConfig.loadReptileConfig());
        for (Reptile creature : reptiles)
        {
            addReptileEntity(creature);
        }

        loadConfig(DinoConfig.loadBirdConfig());
        for (Bird creature : birds)
        {
            addBirdEntity(creature);
        }
    }

    @SideOnly(Side.CLIENT)
    public void parseClientEntities()
    {
        loadConfig(DinoConfig.loadDinoConfig());
        for (Dinosaur creature : dinos)
        {
            addDinoEntityRenderer(creature);
        }

        loadConfig(DinoConfig.loadMammalConfig());
        for (Mammal creature : mammals)
        {
            addMammalEntityRenderer(creature);
        }

        loadConfig(DinoConfig.loadCephalopodConfig());
        for (Cephalopod creature : cephalopods)
        {
            addCephalopodaEntityRenderer(creature);
        }

        loadConfig(DinoConfig.loadFishConfig());
        for (Fish creature : Fish)
        {
            addFishEntityRenderer(creature);
        }

        loadConfig(DinoConfig.loadReptileConfig());
        for (Reptile creature : reptiles)
        {
            addReptileEntityRenderer(creature);
        }

        loadConfig(DinoConfig.loadBirdConfig());
        for (Bird creature : birds)
        {
            addBirdEntityRenderer(creature);
        }
    }

    private void loadConfig(File config)
    {
        try
        {
            if (config.toString().contains("dino"))
            {
                Type collectionType = new TypeToken<Collection<Dinosaur>>()
                {
                }.getType();

                dinos = new Gson().fromJson(new FileReader(config), collectionType);
            }
            if (config.toString().contains("mammal"))
            {
                Type collectionType = new TypeToken<Collection<Mammal>>()
                {
                }.getType();

                mammals = new Gson().fromJson(new FileReader(config), collectionType);
            }
            if (config.toString().contains("cephalopod"))
            {
                Type collectionType = new TypeToken<Collection<Cephalopod>>()
                {
                }.getType();

                cephalopods = new Gson().fromJson(new FileReader(config), collectionType);
            }
            if (config.toString().contains("arthropod"))
            {
                Type collectionType = new TypeToken<Collection<Arthropod>>()
                {
                }.getType();

                arthropods = new Gson().fromJson(new FileReader(config), collectionType);
            }
            if (config.toString().contains("fish"))
            {
                Type collectionType = new TypeToken<Collection<Fish>>()
                {
                }.getType();

                Fish = new Gson().fromJson(new FileReader(config), collectionType);
            }
            if (config.toString().contains("reptile"))
            {
                Type collectionType = new TypeToken<Collection<Reptile>>()
                {
                }.getType();

                reptiles = new Gson().fromJson(new FileReader(config), collectionType);
            }
            if (config.toString().contains("bird"))
            {
                Type collectionType = new TypeToken<Collection<Bird>>()
                {
                }.getType();

                birds = new Gson().fromJson(new FileReader(config), collectionType);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
