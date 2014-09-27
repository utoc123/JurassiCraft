package to.uk.ilexiconn.jurassicraft.block;

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
import to.uk.ilexiconn.jurassicraft.ModCreativeTabs;
import to.uk.ilexiconn.jurassicraft.Util;

import java.util.Random;

public class BlockFossilClayOre extends Block
{
    protected IIcon[] icons = new IIcon[6];
    protected String textureSuffix;

    public BlockFossilClayOre(String color)
    {
        super(Material.ground);
        setBlockName("fossil_clay_ore" + color);
        setBlockTextureName(Util.getModId() + "fossil_clay_ore" + color);
        setHardness(3.0F);
        setResistance(5.0F);
        setCreativeTab(ModCreativeTabs.fossilTab);
        setStepSound(Block.soundTypeStone);
        setHarvestLevel("pickaxe", 0);
        textureSuffix = color;
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
        world.setBlockMetadataWithNotify(x, y, z, new Random().nextInt(6), 2);
    }

    @Override
    public void registerBlockIcons(IIconRegister register)
    {
        for (int i = 0; i < 6; ++i)
            icons[i] = register.registerIcon(Util.getModId() + "fossil_side_" + i + "_hardened_clay" + textureSuffix);
    }

    @Override
    public IIcon getIcon(int side, int metadata)
    {
        if (metadata > 5)
            return icons[0];

        return icons[metadata];
    }
}
