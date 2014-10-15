package to.uk.ilexiconn.jurassicraft.block.fence;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import to.uk.ilexiconn.jurassicraft.ModCreativeTabs;
import to.uk.ilexiconn.jurassicraft.tile.TileSecurityFenceHighPole;

public class BlockSecurityFenceHighPole extends BlockSecurityFence implements IFencePole
{
	public BlockSecurityFenceHighPole() 
	{
		this.setBlockName("block_High_Security_Fence_Pole");
		/** Temporary */
        this.setCreativeTab(ModCreativeTabs.BLOCKS.getTab());
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) 
	{
		return new TileSecurityFenceHighPole();
	}
}
