package to.uk.ilexiconn.jurassicraft.data.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;

import to.uk.ilexiconn.jurassicraft.Util;

public abstract class BlockEgg extends BlockContainer
{
    public BlockEgg(String name)
    {
        super(Material.dragonEgg);
        setBlockName("egg" + name);
        setBlockTextureName(Util.getModId() + "egg" + name);
        setCreativeTab(Util.getCreativeTab(0));
        setBlockBounds(0.28f, 0f, 0.28f, 0.72f, 0.5f, 0.72f);
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
}
