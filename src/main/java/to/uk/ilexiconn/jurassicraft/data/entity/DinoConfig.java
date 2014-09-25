package to.uk.ilexiconn.jurassicraft.data.entity;

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
}
