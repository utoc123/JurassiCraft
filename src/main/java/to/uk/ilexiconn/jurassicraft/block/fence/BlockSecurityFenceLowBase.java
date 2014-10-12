package to.uk.ilexiconn.jurassicraft.block.fence;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import to.uk.ilexiconn.jurassicraft.ModCreativeTabs;
import to.uk.ilexiconn.jurassicraft.tile.TileBlockSecurityFence;

public class BlockSecurityFenceLowBase extends BlockSecurityFence implements IFenceBase
{
	public BlockSecurityFenceLowBase() 
	{
		this.setBlockName("block_Low_Security_Fence_Base");
	}
}
