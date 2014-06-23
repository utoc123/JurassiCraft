package com.ilexiconn.jurassicraft.proxy;

import com.ilexiconn.jurassicraft.Util;
import com.ilexiconn.jurassicraft.data.block.BlockEgg;
import com.ilexiconn.jurassicraft.data.tile.render.CultivateRenderer3D;
import com.ilexiconn.jurassicraft.data.tile.render.EggRenderer3D;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends ServerProxy
{
    public void renderEntity(Class<? extends EntityLiving> entity, RenderLiving renderLiving)
    {
        RenderingRegistry.registerEntityRenderingHandler(entity, renderLiving);
    }

    public void renderTileEntity(Class<? extends TileEntity> tileEntity, TileEntitySpecialRenderer renderer)
    {
        ClientRegistry.bindTileEntitySpecialRenderer(tileEntity, renderer);
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
