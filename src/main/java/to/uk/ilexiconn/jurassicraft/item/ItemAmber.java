package to.uk.ilexiconn.jurassicraft.item;

import net.minecraft.item.Item;
import to.uk.ilexiconn.jurassicraft.ModCreativeTabs;
import to.uk.ilexiconn.jurassicraft.Util;

public class ItemAmber extends Item implements IDNASource
{
    public ItemAmber()
    {
        super();
        setUnlocalizedName("amber");
        setTextureName(Util.getModId() + "amber");
        setCreativeTab(ModCreativeTabs.items);
    }
}
