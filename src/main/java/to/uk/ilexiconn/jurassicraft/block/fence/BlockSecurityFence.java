package to.uk.ilexiconn.jurassicraft.block.fence;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import to.uk.ilexiconn.jurassicraft.Util;
import to.uk.ilexiconn.jurassicraft.tile.TileBlockSecurityFence;

public class BlockSecurityFence extends Block implements ITileEntityProvider
{
	public BlockSecurityFence() 
	{
		super(Material.iron);
		this.setHardness(2.5f);
		this.setResistance(6.0f);
		this.setHarvestLevel("pickaxe", 2);
		this.setStepSound(soundTypeMetal);
		this.setBlockTextureName(Util.getModId() + "block_Security_Fence_Breaking_Particles");
	}

	public int quantityDropped(Random rand) 
	{
		return 0;
	}

	@Override
	public int getRenderType() 
	{
		return -1;
	}

	@Override
	public boolean isOpaqueCube() 
	{
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() 
	{
		return false;
	}

	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) 
	{
		System.out.println(world.getBlock(x, y, z).getUnlocalizedName());
		return null;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) 
	{
		try 
		{
			return new TileBlockSecurityFence();
		} 
		catch (Exception e) 
		{
			throw new RuntimeException(e);
		}
	}
}
