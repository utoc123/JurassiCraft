package to.uk.ilexiconn.jurassicraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import to.uk.ilexiconn.jurassicraft.ModCreativeTabs;
import to.uk.ilexiconn.jurassicraft.Util;

public class BlockGypsumCobblestone extends Block {

	public BlockGypsumCobblestone() {
		super(Material.rock);
		this.setHardness(1.2f);
		this.setResistance(2.5f);
        setBlockName("block_Gypsum_CobbleStone");
		this.setStepSound(soundTypeStone);
		this.setHarvestLevel("pickaxe", 0);
        setCreativeTab(ModCreativeTabs.BLOCKS.getTab());
        setBlockTextureName(Util.getModId() + "block_Gypsum_CobbleStone");
	}
}
