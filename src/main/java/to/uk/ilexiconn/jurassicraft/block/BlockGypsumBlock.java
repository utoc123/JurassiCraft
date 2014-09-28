package to.uk.ilexiconn.jurassicraft.block;

import java.util.Random;

import to.uk.ilexiconn.jurassicraft.ModBlocks;
import to.uk.ilexiconn.jurassicraft.ModCreativeTabs;
import to.uk.ilexiconn.jurassicraft.ModItems;
import to.uk.ilexiconn.jurassicraft.Util;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

import com.rafamv.fossilhunting.FossilHunting;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGypsumBlock extends Block {

	public BlockGypsumBlock() {
		super(Material.rock);
		this.setHardness(1.5f);
		this.setResistance(3.0f);
        setBlockName("block_Gypsum_Block");
		this.setStepSound(soundTypeStone);
		this.setHarvestLevel("pickaxe", 1);
        setCreativeTab(ModCreativeTabs.fossilTab);
        setBlockTextureName(Util.getModId() + "block_Gypsum_Block");
	}

	@Override
	public Item getItemDropped(int id, Random random, int metadata) {
		return Item.getItemFromBlock(ModBlocks.gypsumCobblestone);
	}
}
