package com.ilexiconn.jurassicraft.data.egg;

import com.ilexiconn.jurassicraft.data.block.BlockEgg;
import com.ilexiconn.jurassicraft.data.entity.EntityHerrerasaur;
import com.ilexiconn.jurassicraft.data.tile.TileEgg;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockHerrerasaurEgg extends BlockEgg
{
    public BlockHerrerasaurEgg()
    {
        super("herrerasaur");
    }

    public TileEntity createNewTileEntity(World var1, int var2)
    {
        return new TileEgg(EntityHerrerasaur.class);
    }
}
