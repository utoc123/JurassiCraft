package to.uk.ilexiconn.jurassicraft.entity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class DinoConfig
{
    public static File loadDinoConfig()
    {
        try
        {
            File tempFile = File.createTempFile("dinos", ".json");
            tempFile.deleteOnExit();
            InputStream in = DinoConfig.class.getResourceAsStream("/dinos.json");
            FileOutputStream out = new FileOutputStream(tempFile);
            org.apache.commons.io.IOUtils.copy(in, out);
            return tempFile;
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public static File loadMammalConfig()
    {
        try
        {
            File tempFile = File.createTempFile("mammals", ".json");
            tempFile.deleteOnExit();
            InputStream in = DinoConfig.class.getResourceAsStream("/mammals.json");
            FileOutputStream out = new FileOutputStream(tempFile);
            org.apache.commons.io.IOUtils.copy(in, out);
            return tempFile;
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public static File loadCephalopodConfig()
    {
        try
        {
            File tempFile = File.createTempFile("cephalopods", ".json");
            tempFile.deleteOnExit();
            InputStream in = DinoConfig.class.getResourceAsStream("/cephalopods.json");
            FileOutputStream out = new FileOutputStream(tempFile);
            org.apache.commons.io.IOUtils.copy(in, out);
            return tempFile;
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public static File loadFishConfig()
    {
        try
        {
            File tempFile = File.createTempFile("fish", ".json");
            tempFile.deleteOnExit();
            InputStream in = DinoConfig.class.getResourceAsStream("/fish.json");
            FileOutputStream out = new FileOutputStream(tempFile);
            org.apache.commons.io.IOUtils.copy(in, out);
            return tempFile;
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public static File loadReptileConfig()
    {
        try
        {
            File tempFile = File.createTempFile("reptiles", ".json");
            tempFile.deleteOnExit();
            InputStream in = DinoConfig.class.getResourceAsStream("/reptiles.json");
            FileOutputStream out = new FileOutputStream(tempFile);
            org.apache.commons.io.IOUtils.copy(in, out);
            return tempFile;
        }
        catch (Exception e)
        {
            return null;
        }
    }
}
