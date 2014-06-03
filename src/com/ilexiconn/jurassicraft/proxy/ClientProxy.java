package com.ilexiconn.jurassicraft.proxy;

import com.ilexiconn.jurassicraft.Util;
import com.ilexiconn.jurassicraft.data.tile.render.CultivateRenderer3D;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.client.IItemRenderer;
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

    public void renderTestItem()
    {
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Util.getBlock(1)), (IItemRenderer) new CultivateRenderer3D());
    }
}
