package to.uk.ilexiconn.jurassicraft.item;

import net.minecraft.item.Item;
import to.uk.ilexiconn.jurassicraft.ModCreativeTabs;
import to.uk.ilexiconn.jurassicraft.Util;

public class ItemOnAStick extends Item
{
    public ItemOnAStick(String foodOnAStick)
    {
        super();
        setUnlocalizedName(foodOnAStick + "OnAStick");
        setTextureName(Util.getModId() + foodOnAStick + "OnAStick");
        setCreativeTab(ModCreativeTabs.ITEMS.getTab());
    }
}
