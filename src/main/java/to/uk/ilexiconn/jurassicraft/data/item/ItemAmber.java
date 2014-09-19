package to.uk.ilexiconn.jurassicraft.data.item;

import to.uk.ilexiconn.jurassicraft.Util;
import net.minecraft.item.Item;

public class ItemAmber extends Item
{
    public ItemAmber()
    {
        super();
        setUnlocalizedName("amber");
        setTextureName(Util.getModId() + "amber");
        setCreativeTab(Util.getCreativeTab(0));
    }
}
