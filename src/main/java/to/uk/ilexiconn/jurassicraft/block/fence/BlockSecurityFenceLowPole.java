package to.uk.ilexiconn.jurassicraft.block.fence;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import to.uk.ilexiconn.jurassicraft.tile.TileSecurityFenceLowPole;


public class BlockSecurityFenceLowPole extends BlockSecurityFence implements IFencePole
{
	public BlockSecurityFenceLowPole() 
	{
		this.setBlockName("block_Low_Security_Fence_Pole");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) 
	{
		return new TileSecurityFenceLowPole();
	}
}
