package to.uk.ilexiconn.jurassicraft.block.fence;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import to.uk.ilexiconn.jurassicraft.tile.TileSecurityFenceMediumBase;


public class BlockSecurityFenceMediumBase extends BlockSecurityFence implements IFenceBase
{
	public BlockSecurityFenceMediumBase() 
	{
		this.setBlockName("block_Medium_Security_Fence_Base");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) 
	{
		return new TileSecurityFenceMediumBase();
	}
}
