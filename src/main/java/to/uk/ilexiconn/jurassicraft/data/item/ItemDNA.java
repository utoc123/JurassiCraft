package to.uk.ilexiconn.jurassicraft.data.item;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import to.uk.ilexiconn.jurassicraft.DinoEntry;

public class ItemDNA extends Item
{
    public ItemDNA(String name)
    {
        super();
        setUnlocalizedName(name + "_DNA");
        setTextureName(DinoEntry.getModId() + name + "_DNA");
        setCreativeTab(DinoEntry.getCreativeTab(0));
    }

	public Item getCorrespondingEgg()
	{
		int id = DinoEntry.getDNAArray().lastIndexOf(this);

		if (DinoEntry.getEggArray().size() > id)
			if (DinoEntry.getEggArray().get(id) != null)
				return DinoEntry.getEggArray().get(id);

		return null;
	}
}
