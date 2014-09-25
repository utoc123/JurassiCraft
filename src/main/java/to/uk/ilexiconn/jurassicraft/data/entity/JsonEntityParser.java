package to.uk.ilexiconn.jurassicraft.data.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import to.uk.ilexiconn.jurassicraft.Util;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Collection;

public class JsonEntityParser extends Util
{
    private Collection<Dinosaur> dinos;

    public void parseServerEntities()
    {
        loadConfig(DinoConfig.loadDinoConfig());
        for (Dinosaur dino : dinos)
        {
            addMeat(dino.creatureName);
            addDNA(dino.creatureName);
            addEntity(dino);
        }
    }

    @SideOnly(Side.CLIENT)
    public void parseClientEntities()
    {
        loadConfig(DinoConfig.loadDinoConfig());
        for (Dinosaur dino : dinos) addEntityRenderer(dino);
    }

    private void loadConfig(File config)
    {
        try
        {
            Type collectionType = new TypeToken<Collection<Dinosaur>>()
            {
            }.getType();

            dinos = new Gson().fromJson(new FileReader(config), collectionType);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
