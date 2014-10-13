package to.uk.ilexiconn.jurassicraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import to.uk.ilexiconn.jurassicraft.ModBlocks;
import to.uk.ilexiconn.jurassicraft.ModCreativeTabs;
import to.uk.ilexiconn.jurassicraft.Util;

import java.util.Random;

public class BlockGypsumBlock extends Block {

	public BlockGypsumBlock() {
		super(Material.rock);
		this.setHardness(1.5f);
		this.setResistance(3.0f);
        setBlockName("block_Gypsum_Block");
		this.setStepSound(soundTypeStone);
		this.setHarvestLevel("pickaxe", 1);
        setCreativeTab(ModCreativeTabs.BLOCKS.getTab());
        setBlockTextureName(Util.getModId() + "block_Gypsum_Block");
	}

	@Override
	public Item getItemDropped(int id, Random random, int metadata) {
		return Item.getItemFromBlock(ModBlocks.gypsumCobblestone);
	}
}
