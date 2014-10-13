package to.uk.ilexiconn.jurassicraft.block.fence;

import to.uk.ilexiconn.jurassicraft.ModCreativeTabs;

public class BlockSecurityFenceHighPole extends BlockSecurityFence implements IFencePole
{
	public BlockSecurityFenceHighPole() 
	{
		this.setBlockName("block_High_Security_Fence_Pole");
		/** Temporary */
		this.setCreativeTab(ModCreativeTabs.BLOCKS.getTab());
	}
}
