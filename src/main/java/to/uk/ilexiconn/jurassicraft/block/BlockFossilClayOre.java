package to.uk.ilexiconn.jurassicraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import to.uk.ilexiconn.jurassicraft.ModCreativeTabs;
import to.uk.ilexiconn.jurassicraft.ModItems;
import to.uk.ilexiconn.jurassicraft.Util;

import java.util.List;
import java.util.Random;

public class BlockFossilClayOre extends Block
{
    public static final String[] colors = {"", "brown", "orange", "red", "silver", "white", "yellow"};

    @SideOnly(Side.CLIENT)
    public IIcon[] icon_0;
    @SideOnly(Side.CLIENT)
    public IIcon[] icon_1;
    @SideOnly(Side.CLIENT)
    public IIcon[] icon_2;
    @SideOnly(Side.CLIENT)
    public IIcon[] icon_3;
    @SideOnly(Side.CLIENT)
    public IIcon[] icon_4;
    @SideOnly(Side.CLIENT)
    public IIcon[] icon_5;

    public BlockFossilClayOre()
    {
        super(Material.clay);
        setBlockName("fossil_clay_ore");
        setHardness(3.0F);
        setResistance(5.0F);
        setCreativeTab(ModCreativeTabs.fossilTab);
        setStepSound(Block.soundTypeStone);
        setHarvestLevel("pickaxe", 0);
    }

    public Item getItemDropped(int value, Random random, int thing)
    {
        return ModItems.fossil;
    }

    public void harvestBlock(World world, EntityPlayer player, int x, int y, int z, int h)
    {
        if (!world.isRemote)
        {
            ItemStack equippedByPlayer = player.getCurrentEquippedItem();
            if (equippedByPlayer != null && equippedByPlayer.getItem() instanceof ItemPickaxe && Enum.valueOf(Item.ToolMaterial.class, ((ItemPickaxe) equippedByPlayer.getItem()).getToolMaterialName()).getHarvestLevel() >= 2)
                super.harvestBlock(world, player, x, y, z, h);
        }
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        switch (side)
        {
            case 0:
                return icon_0[meta];
            case 1:
                return icon_1[meta];
            case 2:
                return icon_2[meta];
            case 3:
                return icon_3[meta];
            case 4:
                return icon_4[meta];
            case 5:
                return icon_5[meta];
            default:
                return icon_0[meta];
        }
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
        list.add(new ItemStack(item, 1, 0));
        list.add(new ItemStack(item, 1, 1));
        list.add(new ItemStack(item, 1, 2));
        list.add(new ItemStack(item, 1, 3));
        list.add(new ItemStack(item, 1, 4));
        list.add(new ItemStack(item, 1, 5));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register)
    {
        this.icon_0 = new IIcon[colors.length];
        this.icon_1 = new IIcon[colors.length];
        this.icon_2 = new IIcon[colors.length];
        this.icon_3 = new IIcon[colors.length];
        this.icon_4 = new IIcon[colors.length];
        this.icon_5 = new IIcon[colors.length];

        for (int i = 0; i < this.icon_0.length; ++i)
        {
            if (!(colors[i].equals("")))
            {
                this.icon_0[i] = register.registerIcon(Util.getModId() + "fossil_side_0_hardened_clay_stained_" + colors[i]);
                this.icon_1[i] = register.registerIcon(Util.getModId() + "fossil_side_1_hardened_clay_stained_" + colors[i]);
                this.icon_2[i] = register.registerIcon(Util.getModId() + "fossil_side_2_hardened_clay_stained_" + colors[i]);
                this.icon_3[i] = register.registerIcon(Util.getModId() + "fossil_side_3_hardened_clay_stained_" + colors[i]);
                this.icon_4[i] = register.registerIcon(Util.getModId() + "fossil_side_4_hardened_clay_stained_" + colors[i]);
                this.icon_5[i] = register.registerIcon(Util.getModId() + "fossil_side_5_hardened_clay_stained_" + colors[i]);
            } else {
                this.icon_0[i] = register.registerIcon(Util.getModId() + "fossil_side_0_hardened_clay");
                this.icon_1[i] = register.registerIcon(Util.getModId() + "fossil_side_1_hardened_clay");
                this.icon_2[i] = register.registerIcon(Util.getModId() + "fossil_side_2_hardened_clay");
                this.icon_3[i] = register.registerIcon(Util.getModId() + "fossil_side_3_hardened_clay");
                this.icon_4[i] = register.registerIcon(Util.getModId() + "fossil_side_4_hardened_clay");
                this.icon_5[i] = register.registerIcon(Util.getModId() + "fossil_side_5_hardened_clay");
            }
        }
    }
}
