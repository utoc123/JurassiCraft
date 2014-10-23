package to.uk.ilexiconn.jurassicraft.entity;

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
        for (Dinosaur creature : dinos)
        {
            switch (creature.creatureType) {
            	case 0:
                    addMeat(creature.creatureName);
                    addDNA(creature.creatureName);
                    addDinoEntity(creature);
            		break;
            	case 1:
            		addDNA(creature.creatureName);
                    addMammalEntity(creature);
            		break;
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void parseClientEntities()
    {
        loadConfig(DinoConfig.loadDinoConfig());
        for (Dinosaur creature : dinos)
        {
            switch (creature.creatureType) {
            	case 0:
            		addDinoEntityRenderer(creature);
            		break;
            	case 1:
            		addMammalEntityRenderer(creature);
            		break;
            }
        }
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
