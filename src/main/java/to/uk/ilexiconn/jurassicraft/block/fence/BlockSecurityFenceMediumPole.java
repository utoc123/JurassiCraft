package to.uk.ilexiconn.jurassicraft.block.fence;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import to.uk.ilexiconn.jurassicraft.tile.TileSecurityFenceMediumPole;


public class BlockSecurityFenceMediumPole extends BlockSecurityFence implements IFencePole
{
	public BlockSecurityFenceMediumPole() 
	{
		this.setBlockName("block_Medium_Security_Fence_Pole");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) 
	{
		return new TileSecurityFenceMediumPole();
	}
}
