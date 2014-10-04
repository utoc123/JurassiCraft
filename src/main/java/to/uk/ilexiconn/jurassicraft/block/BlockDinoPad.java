package to.uk.ilexiconn.jurassicraft.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.ModItems;
import to.uk.ilexiconn.jurassicraft.tile.TileDinoPad;

public class BlockDinoPad extends Block implements ITileEntityProvider
{

    public BlockDinoPad()
    {
        super(Material.iron);
        this.setTickRandomly(true);
        this.setBlockName("dinoPad");
        this.setHardness(0.0F);
        this.setResistance(0.0F);
        this.setStepSound(Block.soundTypeStone);
        this.setBlockBounds(0.2F, 0.0F, 0.2F, 0.8F, 0.2F, 0.8F);
        this.setBlockTextureName(JurassiCraft.getModId() + "dnaExtractorBreakingParticles");
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
    public Item getItemDropped(int value, Random random, int var)
    {
        return ModItems.dinoPad;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int hitX, float hitY, float hitZ, float f) 
	{
		if (player.getHeldItem() != null) 
		{
			return false;
		} 
		else 
		{
			world.removeTileEntity(x, y, z);
			world.setBlockToAir(x, y, z);
			player.inventory.addItemStackToInventory(new ItemStack(ModItems.dinoPad, 1));
			return true;
		}
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) 
	{
		this.canBlockStay(world, x, y, z);
	}

    @Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
        return !super.canPlaceBlockAt(world, x, y, z) ? false : this.canBlockStay(world, x, y, z);
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
        if (!this.canBlockStay(world, x, y, z))
        {
			world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(ModItems.dinoPad, 1)));
			world.removeTileEntity(x, y, z);
			world.setBlockToAir(x, y, z);
        }
    }

    @Override
	public boolean canBlockStay(World world, int x, int y, int z) 
	{
		return world.getBlock(x, y - 1, z).getMaterial().isSolid();
	}
    
    @Override
    public TileEntity createNewTileEntity(World world, int metadata)
    {
        try
        {
            return new TileDinoPad();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
