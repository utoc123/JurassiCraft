package to.uk.ilexiconn.jurassicraft.item;

import net.minecraft.item.Item;
import to.uk.ilexiconn.jurassicraft.ModCreativeTabs;
import to.uk.ilexiconn.jurassicraft.Util;

public class ItemFossil extends Item implements AnyDNASource
{
    public ItemFossil()
    {
        super();
        setUnlocalizedName("fossil");
        setTextureName(Util.getModId() + "fossil");
        setCreativeTab(ModCreativeTabs.fossilTab);
    }
}
