package com.rafamv.fossilhunting.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class AnyFossilBlock extends Block {
	
    public AnyFossilBlock() {
		super(Material.rock);
		this.setStepSound(soundTypeStone);
	}
    
	public int quantityDropped(Random a) {
        return 0;
    }
	
}
