package to.uk.ilexiconn.jurassicraft.item;

import net.minecraft.item.Item;
import to.uk.ilexiconn.jurassicraft.ModCreativeTabs;
import to.uk.ilexiconn.jurassicraft.Util;

public class ItemGypsumPowder extends Item {
	
	public ItemGypsumPowder() {
        super();
        setUnlocalizedName("gypsumPowder");
        setTextureName(Util.getModId() + "gypsum_Powder");
        setCreativeTab(ModCreativeTabs.ITEMS.getTab());
	}
}
