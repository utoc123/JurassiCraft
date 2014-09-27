package to.uk.ilexiconn.jurassicraft.data.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import to.uk.ilexiconn.jurassicraft.ModCreativeTabs;
import to.uk.ilexiconn.jurassicraft.ModItems;
import to.uk.ilexiconn.jurassicraft.Util;

import java.util.Random;

public class BlockAmberOre extends Block
{
    public BlockAmberOre()
    {
        super(Material.ground);
        setBlockName("amber_ore");
        setBlockTextureName(Util.getModId() + "amber_ore");
        setHardness(3.0F);
        setResistance(5.0F);
        setStepSound(Block.soundTypeStone);
        setHarvestLevel("pickaxe", 1);
        setCreativeTab(ModCreativeTabs.fossilTab);
    }

    public Item getItemDropped(int value, Random random, int thing)
    {
        return ModItems.amber;
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
}
