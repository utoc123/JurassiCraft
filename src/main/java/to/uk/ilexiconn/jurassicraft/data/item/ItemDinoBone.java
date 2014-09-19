package to.uk.ilexiconn.jurassicraft.data.item;

import to.uk.ilexiconn.jurassicraft.Util;
import net.minecraft.item.Item;

public class ItemDinoBone extends Item
{
    public ItemDinoBone()
    {
        super();
        setUnlocalizedName("dinoBone");
        setTextureName(Util.getModId() + "dinoBone");
        setCreativeTab(Util.getCreativeTab(0));
    }
}
