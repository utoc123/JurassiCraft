package to.uk.ilexiconn.jurassicraft.block.fence;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import to.uk.ilexiconn.jurassicraft.ModCreativeTabs;
import to.uk.ilexiconn.jurassicraft.tile.TileSecurityFenceHighBase;

public class BlockSecurityFenceHighBase extends BlockSecurityFence implements IFenceBase
{
	public BlockSecurityFenceHighBase() 
	{
		this.setBlockName("block_High_Security_Fence_Base");
		/** Temporary */
        this.setCreativeTab(ModCreativeTabs.BLOCKS.getTab());
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) 
	{
		return new TileSecurityFenceHighBase();
	}
}
