package to.uk.ilexiconn.jurassicraft.block.fence;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import to.uk.ilexiconn.jurassicraft.ModCreativeTabs;
import to.uk.ilexiconn.jurassicraft.tile.TileBlockSecurityFence;

public class BlockSecurityFenceMediumPole extends BlockSecurityFence implements IFencePole
{
	public BlockSecurityFenceMediumPole() 
	{
		this.setBlockName("block_Medium_Security_Fence_Pole");
	}
}
