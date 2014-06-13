package com.ilexiconn.jurassicraft.data.item;

import com.ilexiconn.jurassicraft.Util;
import net.minecraft.item.Item;

public class ItemDinoBone extends Item
{
    public ItemDinoBone()
    {
        super();
        setUnlocalizedName("dinobone");
        setTextureName(Util.getModId() + "dinobone");
        setCreativeTab(Util.getCreativeTab(0));
    }
}
