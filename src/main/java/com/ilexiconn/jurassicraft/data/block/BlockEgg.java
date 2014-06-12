package com.ilexiconn.jurassicraft.data.block;

import com.ilexiconn.jurassicraft.Util;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;

public abstract class BlockEgg extends BlockContainer
{
    public BlockEgg(String name)
    {
        super(Material.dragonEgg);
        setBlockName("egg" + name);
        setBlockTextureName(Util.getModId() + "egg" + name);
        setCreativeTab(Util.getCreativeTab(0));
    }
}
