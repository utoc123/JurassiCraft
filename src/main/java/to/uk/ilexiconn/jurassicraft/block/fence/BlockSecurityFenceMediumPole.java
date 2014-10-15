package to.uk.ilexiconn.jurassicraft.block.fence;

import net.minecraft.block.Block;
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
	public void breakBlock(World world, int x, int y, int z, Block block, int metadata) 
	{
		if (metadata != 4) 
		{
			if (world.getBlock(x, y + 1, z) instanceof BlockSecurityFenceMediumPole) 
			{
				if (world.getTileEntity(x, y + 1, z) != (TileEntity) null)
					world.removeTileEntity(x, y + 1, z);
				world.setBlockToAir(x, y + 1, z);
			}
			if (world.getBlock(x, y, z + 1) instanceof BlockSecurityFenceMediumGrid) 
			{
				if (world.getTileEntity(x, y, z + 1) != (TileEntity) null)
					world.removeTileEntity(x, y, z + 1);
				world.setBlockToAir(x, y, z + 1);
			}
			if (world.getBlock(x - 1, y, z) instanceof BlockSecurityFenceMediumGrid) 
			{
				if (world.getTileEntity(x - 1, y, z) != (TileEntity) null)
					world.removeTileEntity(x - 1, y, z);
				world.setBlockToAir(x - 1, y, z);
			}
			if (world.getBlock(x, y, z - 1) instanceof BlockSecurityFenceMediumGrid) 
			{
				if (world.getTileEntity(x, y, z - 1) != (TileEntity) null)
					world.removeTileEntity(x, y, z - 1);
				world.setBlockToAir(x, y, z - 1);
			}
			if (world.getBlock(x + 1, y, z) instanceof BlockSecurityFenceMediumGrid) 
			{
				if (world.getTileEntity(x + 1, y, z) != (TileEntity) null)
					world.removeTileEntity(x + 1, y, z);
				world.setBlockToAir(x + 1, y, z);
			}
		}
		super.breakBlock(world, x, y, z, block, metadata);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) 
	{
		return new TileSecurityFenceMediumPole();
	}
}
