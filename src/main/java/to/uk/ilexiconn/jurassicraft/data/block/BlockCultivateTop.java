package to.uk.ilexiconn.jurassicraft.data.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ilexiconn.llib.block.ICustomHighlightedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.Util;

import java.util.List;
import java.util.Random;

public class BlockCultivateTop extends Block implements ICustomHighlightedBlock
{
    public static String[] colors = {"black", "red", "green", "brown", "blue", "purple", "cyan", "light_gray", "gray", "pink", "lime", "yellow", "light_blue", "magenta", "orange", "white"};
    @SideOnly(Side.CLIENT)
    public IIcon[] icons;
    public boolean isLit;

    public BlockCultivateTop(boolean lit)
    {
        super(Material.cactus);
        setBlockName("cultivate_top_" + (lit ? "lit" : "idle"));
        setBlockTextureName(Util.getModId() + "cultivate");
        setCreativeTab(null);
        setHardness(2f);
        setBlockBounds(0f, -1, 0f, 1f, 1f, 1f);
        if (lit) setLightLevel(1.0f);
        isLit = lit;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return icons[meta];
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

    public boolean renderAsNormalBlock()
    {
        return false;
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

    public Item getItemDropped(int meta, Random random, int fortune)
    {
        return Item.getItemFromBlock(Util.getBlock(0));
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z)
    {
        return Item.getItemFromBlock(Util.getBlock(0));
    }

    public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int meta)
    {
        world.setBlockToAir(x, y - 1, z);
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public int damageDropped(int i)
    {
        return i;
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float t, float h, float k)
    {
        player.openGui(JurassiCraft.instance, 0, world, x, y - 1, z);
        return true;
    }

    public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB box, List list, Entity entity)
    {
        AxisAlignedBB[] aabbs = BlockCultivate.boxes[0];
        for (AxisAlignedBB aabb : aabbs)
        {
            AxisAlignedBB aabbTmp = aabb.getOffsetBoundingBox(x, y, z);
            if (box.intersectsWith(aabbTmp)) list.add(aabbTmp);
        }
    }

    public MovingObjectPosition collisionRayTrace(World world, int x, int y, int z, Vec3 origin, Vec3 direction)
    {
        AxisAlignedBB[] aabbs = BlockCultivate.boxes[0];
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

    public AxisAlignedBB[] getHighlightedBoxes(World world, int i, int i2, int i3, EntityPlayer entityPlayer)
    {
        return BlockCultivate.boxes[0];
    }
}
