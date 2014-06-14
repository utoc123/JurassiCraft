package com.ilexiconn.jurassicraft.data.item;

import com.ilexiconn.jurassicraft.Util;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;

public class ItemMeat extends ItemFood
{
    public ItemMeat(String name)
    {
        super(4, 0.1f, true);
        setPotionEffect(Potion.hunger.id, 30, 0, 0.8f);
        setUnlocalizedName(name + "_Meat");
        setTextureName(Util.getModId() + name + "_Meat");
        setCreativeTab(Util.getCreativeTab(0));
    }
}
