package to.uk.ilexiconn.jurassicraft.block.fence;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import to.uk.ilexiconn.jurassicraft.ModCreativeTabs;
import to.uk.ilexiconn.jurassicraft.tile.TileSecurityFence;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSecurityFenceMediumGrid extends BlockSecurityFence implements IFenceGrid {
	public BlockSecurityFenceMediumGrid() 
	{
		this.setBlockName("block_Medium_Security_Fence_Grid");
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack) 
	{
		int direction = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		/** South */
		if (direction == 0) 
		{
			world.setBlockMetadataWithNotify(x, y, z, 0, 2);
		}
		/** West */
		else if (direction == 1) 
		{
			world.setBlockMetadataWithNotify(x, y, z, 1, 2);
		}
		/** North */
		else if (direction == 2) 
		{
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}
		/** East */
		else if (direction == 3) 
		{
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) 
	{
		int widthInPixels = 6;
		int direction = world.getBlockMetadata(x, y, z);
		if (direction == 0 || direction == 2) 
		{
			return AxisAlignedBB.getBoundingBox((double) x, (double) y, (double) (z + 0.5D - widthInPixels * 0.03125D), (double) (x + 1.0D), (double) (y + 1.0D), (double) (z + 0.5D + widthInPixels * 0.03125D));
		} 
		else if (direction == 1 || direction == 3) 
		{
			return AxisAlignedBB.getBoundingBox((double) (x + 0.5D - widthInPixels * 0.03125D), (double) y, (double) z, (double) (x + 0.5D + widthInPixels * 0.03125D), (double) (y + 1.0D), (double) (z + 1.0D));
		}
		else 
		{
			return AxisAlignedBB.getBoundingBox((double) x, (double) y, (double) z, (double) (x + 1.0D), (double) (y + 1.0D), (double) (z + 1.0D));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) 
	{
		int widthInPixels = 6;
		int direction = world.getBlockMetadata(x, y, z);
		if (direction == 0 || direction == 2) 
		{
			return AxisAlignedBB.getBoundingBox((double) x, (double) y, (double) (z + 0.5D - widthInPixels * 0.03125D), (double) (x + 1.0D), (double) (y + 1.0D), (double) (z + 0.5D + widthInPixels * 0.03125D));
		} 
		else if (direction == 1 || direction == 3) 
		{
			return AxisAlignedBB.getBoundingBox((double) (x + 0.5D - widthInPixels * 0.03125D), (double) y, (double) z, (double) (x + 0.5D + widthInPixels * 0.03125D), (double) (y + 1.0D), (double) (z + 1.0D));
		} 
		else 
		{
			return AxisAlignedBB.getBoundingBox((double) x, (double) y, (double) z, (double) (x + 1.0D), (double) (y + 1.0D), (double) (z + 1.0D));
		}
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int direction) 
	{
		switch (direction) {
		/** Facing South, should search West */
			case 0:
				for (int i = 1; i < 12; i++) 
				{
					if (world.getBlock(x + i, y, z) instanceof IFencePole) 
					{
						for (int j = 1; j < 7; j++) 
						{
							if (world.getBlock(x + i, y - j, z) instanceof BlockSecurityFenceMain) 
							{
								TileEntity fence = world.getTileEntity(x + i, y - j, z);
								if (fence instanceof TileSecurityFence) 
								{
									((TileSecurityFence) fence).breakFenceLineAt((byte) 3, j);
									break;
								}
							}
						}
						break;
					}
				}
				break;
			/** Facing West, should search North */
			case 1:
				for (int i = 1; i < 12; i++) 
				{
					if (world.getBlock(x, y, z - i) instanceof IFencePole) 
					{
						for (int j = 1; j < 7; j++) 
						{
							if (world.getBlock(x, y - j, z - i) instanceof BlockSecurityFenceMain) 
							{
								TileEntity fence = world.getTileEntity(x, y - j, z - i);
								if (fence instanceof TileSecurityFence) 
								{
									((TileSecurityFence) fence).breakFenceLineAt((byte) 0, j);
									break;
								}
							}
						}
						break;
					}
				}
				break;
			/** Facing North, should search East */
			case 2:
				for (int i = 1; i < 12; i++) 
				{
					if (world.getBlock(x - i, y, z) instanceof IFencePole) 
					{
						for (int j = 1; j < 7; j++) 
						{
							if (world.getBlock(x - i, y - j, z) instanceof BlockSecurityFenceMain) 
							{
								TileEntity fence = world.getTileEntity(x - i, y - j, z);
								if (fence instanceof TileSecurityFence) 
								{
									((TileSecurityFence) fence).breakFenceLineAt((byte) 1, j);
									break;
								}
							}
						}
						break;
					}
				}
				break;
			/** Facing East, should search South */
			case 3:
				for (int i = 1; i < 12; i++) 
				{
					if (world.getBlock(x, y, z + i) instanceof IFencePole) 
					{
						for (int j = 1; j < 7; j++) 
						{
							if (world.getBlock(x, y - j, z + i) instanceof BlockSecurityFenceMain) 
							{
								TileEntity fence = world.getTileEntity(x, y - j, z + i);
								if (fence instanceof TileSecurityFence) 
								{
									((TileSecurityFence) fence).breakFenceLineAt((byte) 2, j);
									break;
								}
							}
						}
						break;
					}
				}
				break;
		}
		super.breakBlock(world, x, y, z, block, direction);
	}

	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) 
	{
		entity.attackEntityFrom(DamageSource.generic, 8.0F);
	}
}
