package com.ilexiconn.jurassicraft.data.block;

import com.ilexiconn.jurassicraft.Util;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

public abstract class BlockEgg extends BlockContainer
{
    private String dinoName;

    public BlockEgg(String name)
    {
        super(Material.dragonEgg);
        dinoName = name;
        setBlockName("egg" + name);
        setBlockTextureName(Util.getModId() + "egg" + name);
        setCreativeTab(Util.getCreativeTab(0));
        setBlockBounds(0.28f, 0f, 0.28f, 0.72f, 0.67f, 0.72f);
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public int getRenderType()
    {
        return -1;
    }

    public String getDinoName()
    {
        return dinoName;
    }
}
