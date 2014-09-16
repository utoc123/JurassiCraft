package to.uk.ilexiconn.jurassicraft.data.block;

import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.DinoEntry;
import to.uk.ilexiconn.jurassicraft.data.tile.TileAnalyzer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockAnalyzer extends BlockContainer
{
    @SideOnly(Side.CLIENT)
    public IIcon topIcon;
    @SideOnly(Side.CLIENT)
    public IIcon frontIconIdle;
    @SideOnly(Side.CLIENT)
    public IIcon frontIconActive;
    @SideOnly(Side.CLIENT)
    public IIcon sideIcon;

    public boolean active;

    public BlockAnalyzer(boolean active)
    {
        super(Material.iron);
        this.active = active;
        setBlockName("analyzer_" + (active ? "active" : "idle"));
        setBlockTextureName(DinoEntry.getModId() + "analyzer");
        setCreativeTab(active ? null : DinoEntry.getCreativeTab(0));
        setHardness(3.0f);
    }

    public static void updateAnalyzerBlockState(boolean isActive, World worldObj, int xCoord, int yCoord, int zCoord)
    {
        int metadata = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
        TileEntity analyzerTileEntity = worldObj.getTileEntity(xCoord, yCoord, zCoord);

        if (analyzerTileEntity != null)
        {
            if (isActive)
                worldObj.setBlock(xCoord, yCoord, zCoord, DinoEntry.getBlock(2));
            else
                worldObj.setBlock(xCoord, yCoord, zCoord, DinoEntry.getBlock(3));

            worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, metadata, 2);
            analyzerTileEntity.validate();
            worldObj.setTileEntity(xCoord, yCoord, zCoord, analyzerTileEntity);
        }
    }

    public TileEntity createNewTileEntity(World var1, int var2)
    {
        return new TileAnalyzer();
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata)
    {
        if (metadata == 0 && side == 3) return frontIconIdle;
        else return side == 1 ? topIcon : (side == 0 ? topIcon : (side != metadata ? sideIcon : (active ? frontIconActive : frontIconIdle)));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        topIcon = iconRegister.registerIcon(DinoEntry.getModId() + "analyzer_top");
        sideIcon = iconRegister.registerIcon(DinoEntry.getModId() + "analyzer_side");
        frontIconIdle = iconRegister.registerIcon(DinoEntry.getModId() + "analyzer_front_idle");
        frontIconActive = iconRegister.registerIcon(DinoEntry.getModId() + "analyzer_front_active");
    }

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack)
    {
        int l = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }
        else if (l == 1)
        {
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }
        else if (l == 2)
        {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }
        else if (l == 3)
        {
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float i, float d, float k)
    {
        player.openGui(JurassiCraft.instance, 1, world, x, y, z);
        return true;
    }
}
