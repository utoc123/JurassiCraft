package to.uk.ilexiconn.jurassicraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.ModCreativeTabs;
import to.uk.ilexiconn.jurassicraft.Util;
import to.uk.ilexiconn.jurassicraft.tile.TileDNAExtractor;
import to.uk.ilexiconn.jurassicraft.tile.TileSecurityFenceBase;

public class BlockSecurityFenceBase extends BlockContainer {

	public BlockSecurityFenceBase() {
        super(Material.iron);
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setBlockName("security_Fence_Base");
        this.setBlockTextureName(Util.getModId() + "security_Fence_Base");
        this.setCreativeTab(ModCreativeTabs.fossilTab);
	}
	
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
        if (world.isRemote)
        {
            return true;
        }
        else if (!player.isSneaking())
        {
            player.openGui(JurassiCraft.instance, 0, world, x, y, z);
            return true;
        }
        return false;
    }
    
    @Override
    public void breakBlock(World world, int x, int y, int z, Block oldblock, int oldMetadata)
    {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity instanceof TileSecurityFenceBase)
        {
        	TileSecurityFenceBase tileFence = (TileSecurityFenceBase) tileEntity;
            if (tileFence.hasItems())
            {
                for (int i = 0; i < tileFence.getSizeInventory(); i++)
                {
                    ItemStack itemstack = tileFence.getStackInSlot(i);
                    if (itemstack != null)
                    {
                        float f = world.rand.nextFloat() * 0.8F + 0.1F;
                        float f1 = world.rand.nextFloat() * 0.8F + 0.1F;
                        float f2 = world.rand.nextFloat() * 0.8F + 0.1F;
                        while (itemstack.stackSize > 0)
                        {
                            int j = world.rand.nextInt(21) + 10;
                            if (j > itemstack.stackSize)
                            {
                                j = itemstack.stackSize;
                            }
                            itemstack.stackSize -= j;
                            EntityItem item = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float) z + f2), new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));
                            if (itemstack.hasTagCompound())
                            {
                                item.getEntityItem().setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
                            }
                            world.spawnEntityInWorld(item);
                        }
                    }
                }
                world.func_147453_f(x, y, z, oldblock);
            }
        }
        super.breakBlock(world, x, y, z, oldblock, oldMetadata);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata)
    {
        try
        {
            return new TileSecurityFenceBase();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
