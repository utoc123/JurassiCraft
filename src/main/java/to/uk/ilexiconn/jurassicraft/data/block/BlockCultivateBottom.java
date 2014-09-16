package to.uk.ilexiconn.jurassicraft.data.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.DinoEntry;
import to.uk.ilexiconn.jurassicraft.data.tile.TileCultivate;

import java.util.List;
import java.util.Random;

public class BlockCultivateBottom extends BlockContainer
{
    public static String[] colors = {"black", "red", "green", "brown", "blue", "purple", "cyan", "light_gray", "gray", "pink", "lime", "yellow", "light_blue", "magenta", "orange", "white"};
    @SideOnly(Side.CLIENT)
    public IIcon[] icons;
    public boolean isLit;

    public BlockCultivateBottom(boolean lit)
    {
        super(Material.cactus); //Yes..., Cactus xD
        setBlockName("cultivate_bottom_" + (lit ? "lit" : "idle"));
        setBlockTextureName(DinoEntry.getModId() + "cultivate");
        setCreativeTab(lit ? null : DinoEntry.getCreativeTab(0));
        setHardness(2f);
        setBlockBounds(0f, 0f, 0f, 1f, 2f, 1f);
        if (lit) setLightLevel(1.0f);
        isLit = lit;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        if (meta < 0 || meta >= colors.length) meta = 0;
        return icons[meta];
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
        for (int i = 0; i < colors.length; i++) list.add(new ItemStack(item, 1, i));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        icons = new IIcon[colors.length];

        for (int i = 0; i < colors.length; i++)
        {
            String name = getTextureName();

            if (colors[i] != null) name = name + "_" + colors[i];

            icons[i] = iconRegister.registerIcon(name);
        }
    }

    public int damageDropped(int meta)
    {
        return meta;
    }

    public int getRenderType()
    {
        return -1;
    }

    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 1;
    }

    public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int meta)
    {
        world.setBlockToAir(x, y + 1, z);
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float t, float h, float k)
    {
        player.openGui(JurassiCraft.instance, 0, world, x, y, z);
        return true;
    }

    public Item getItemDropped(int meta, Random random, int fortune)
    {
        return Item.getItemFromBlock(DinoEntry.getBlock(0));
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z)
    {
        return Item.getItemFromBlock(DinoEntry.getBlock(0));
    }

    public TileEntity createNewTileEntity(World world, int meta)
    {
        return new TileCultivate();
    }

    public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB box, List list, Entity entity)
    {
        AxisAlignedBB[] aabbs = BlockCultivate.boxes[1];
        for (AxisAlignedBB aabb : aabbs)
        {
            AxisAlignedBB aabbTmp = aabb.getOffsetBoundingBox(x, y, z);
            if (box.intersectsWith(aabbTmp)) list.add(aabbTmp);
        }
    }

    public MovingObjectPosition collisionRayTrace(World world, int x, int y, int z, Vec3 origin, Vec3 direction)
    {
        AxisAlignedBB[] aabbs = BlockCultivate.boxes[1];
        MovingObjectPosition closest = null;
        for (AxisAlignedBB aabb : aabbs)
        {
            MovingObjectPosition mop = aabb.getOffsetBoundingBox(x, y, z).calculateIntercept(origin, direction);
            if (mop != null)
            {
                if (closest != null && mop.hitVec.distanceTo(origin) < closest.hitVec.distanceTo(origin)) closest = mop;
                else closest = mop;
            }
        }
        if (closest != null)
        {
            closest.blockX = x;
            closest.blockY = y;
            closest.blockZ = z;
        }
        return closest;
    }
}
