package to.uk.ilexiconn.jurassicraft.item;

import net.minecraft.item.Item;
import to.uk.ilexiconn.jurassicraft.ModCreativeTabs;
import to.uk.ilexiconn.jurassicraft.Util;

public class ItemDinoPad extends Item
{
    public ItemDinoPad()
    {
        super();
        setUnlocalizedName("dinopad");
        setTextureName(Util.getModId() + "dinopad");
        setCreativeTab(ModCreativeTabs.fossilTab);
    }
}
