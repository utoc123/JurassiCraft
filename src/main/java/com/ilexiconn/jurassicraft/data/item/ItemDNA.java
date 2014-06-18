package com.ilexiconn.jurassicraft.data.item;

import com.ilexiconn.jurassicraft.Util;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class ItemDNA extends Item
{
    public ItemDNA(String name)
    {
        super();
        setUnlocalizedName(name + "_DNA");
        setTextureName(Util.getModId() + name + "_DNA");
        setCreativeTab(Util.getCreativeTab(0));
    }

	public Block getCorrespondingEgg()
	{
		int id = Util.getDNAArray().lastIndexOf(this);

		if (Util.getEggArray().size() > id)
			if (Util.getEggArray().get(id) != null)
				return Util.getEggArray().get(id);

		return null;
	}
}
