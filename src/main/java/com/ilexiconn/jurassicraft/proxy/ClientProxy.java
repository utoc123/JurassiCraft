package com.ilexiconn.jurassicraft.proxy;

import com.ilexiconn.jurassicraft.Util;
import com.ilexiconn.jurassicraft.data.block.BlockEgg;
import com.ilexiconn.jurassicraft.data.tile.render.CultivateRenderer3D;
import com.ilexiconn.jurassicraft.data.tile.render.EggRenderer3D;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends ServerProxy
{
    public void renderEntity()
    {
        RenderingRegistry.registerEntityRenderingHandler(Util.getEntityToRender(), Util.getEntityRenderer());
    }

    public void renderTileEntity()
    {
        ClientRegistry.bindTileEntitySpecialRenderer(Util.getTileEntityToRender(), Util.getTileEntityRenderer());
    }

    public void renderItems()
    {
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Util.getBlock(1)), new CultivateRenderer3D());
        for (BlockEgg egg : Util.getEggArray())
        {
            MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(egg), new EggRenderer3D(egg.getDinoName()));
        }
    }
}
