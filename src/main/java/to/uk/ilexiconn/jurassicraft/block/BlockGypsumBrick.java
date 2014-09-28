package to.uk.ilexiconn.jurassicraft.block;

import to.uk.ilexiconn.jurassicraft.ModCreativeTabs;
import to.uk.ilexiconn.jurassicraft.Util;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

import com.rafamv.fossilhunting.FossilHunting;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGypsumBrick extends Block {
	
	public BlockGypsumBrick() {
		super(Material.rock);
		this.setHardness(2.0f);
		this.setResistance(5.0f);
        setBlockName("block_Gypsum_Brick");
		this.setStepSound(soundTypeStone);
		this.setHarvestLevel("pickaxe", 1);
        setCreativeTab(ModCreativeTabs.fossilTab);
        setBlockTextureName(Util.getModId() + "block_Gypsum_Brick");
	}
}
