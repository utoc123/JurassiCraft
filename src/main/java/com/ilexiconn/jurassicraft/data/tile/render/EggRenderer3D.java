package com.ilexiconn.jurassicraft.data.tile.render;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class EggRenderer3D implements IItemRenderer
{
    public EggRenderer3D(String dinoName)
    {

    }

    public boolean handleRenderType(ItemStack item, ItemRenderType type)
    {
        return false;
    }

    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
    {
        return false;
    }

    public void renderItem(ItemRenderType type, ItemStack item, Object... data)
    {

    }
}
