package to.uk.ilexiconn.jurassicraft.data.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class DinoConfig
{
    public static File loadServerFile()
    {
        try
        {
            File tempFile = File.createTempFile("dinos", ".json");
            tempFile.deleteOnExit();
            InputStream in = DinoConfig.class.getResourceAsStream("/dinos.json");
            FileOutputStream out = new FileOutputStream(tempFile);
            org.apache.commons.io.IOUtils.copy(in, out);
            return  tempFile;
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @SideOnly(Side.CLIENT)
    public static File loadClientFile()
    {
        try
        {
            File tempFile = File.createTempFile("dinos", ".json");
            tempFile.deleteOnExit();
            InputStream in = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("jurassicraft", "dinos.json")).getInputStream();
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
