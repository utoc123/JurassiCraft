package com.ilexiconn.jurassicraft.data.block;

import com.ilexiconn.jurassicraft.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

public class BlockFossilOre extends Block
{
    @SideOnly(Side.CLIENT)
    public IIcon[] icons = new IIcon[6];

    public BlockFossilOre()
    {
        super(Material.ground);
        setBlockName("fossil_ore");
        setBlockTextureName(Util.getModId() + "fossil_ore");
        setHardness(3.0F);
        setResistance(5.0F);
        setCreativeTab(Util.getCreativeTab(0));
        setStepSound(Block.soundTypeStone);
        setHarvestLevel("pickaxe", 0);
    }

    public Item getItemDropped(int value, Random random, int thing)
    {
        return Util.getItem(2);
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

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack)
    {
        world.setBlockMetadataWithNotify(x, y, z, new Random().nextInt(icons.length), 2);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        for (int i = 0; i < icons.length; i++)
        {
            icons[i] = iconRegister.registerIcon(Util.getModId() + "fossil_side_" + i);
        }
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata)
    {
        return icons[metadata];
    }
}
