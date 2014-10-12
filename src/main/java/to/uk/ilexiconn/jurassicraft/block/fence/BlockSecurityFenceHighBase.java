package to.uk.ilexiconn.jurassicraft.block.fence;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import to.uk.ilexiconn.jurassicraft.ModCreativeTabs;
import to.uk.ilexiconn.jurassicraft.tile.TileBlockSecurityFence;

public class BlockSecurityFenceHighBase extends BlockSecurityFence implements IFenceBase
{
	public BlockSecurityFenceHighBase() 
	{
		this.setBlockName("block_High_Security_Fence_Base");
		/** Temporary */
		this.setCreativeTab(ModCreativeTabs.fossilTab);
	}
}
