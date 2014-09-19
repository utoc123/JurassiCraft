package to.uk.ilexiconn.jurassicraft.data.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import to.uk.ilexiconn.jurassicraft.Util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
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
            addMeat(dino.name);
            addDNA(dino.name);
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
            File tempFile = File.createTempFile("dinos", ".json");
            tempFile.deleteOnExit();
            InputStream in = JsonEntityParser.class.getResourceAsStream("dinos.json");
            FileOutputStream out = new FileOutputStream(tempFile);
            org.apache.commons.io.IOUtils.copy(in, out);
            return  tempFile;
        }
        catch (Exception e)
        {
            return null;
        }
    }
}
