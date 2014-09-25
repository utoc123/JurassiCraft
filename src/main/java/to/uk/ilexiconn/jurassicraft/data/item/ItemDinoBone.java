package to.uk.ilexiconn.jurassicraft.data.item;

import net.minecraft.item.Item;
import to.uk.ilexiconn.jurassicraft.Util;

public class ItemDinoBone extends Item
{
    public ItemDinoBone()
    {
        super();
        setUnlocalizedName("dinoBone");
        setTextureName(Util.getModId() + "dinoBone");
        setCreativeTab(ModCreativeTabs.fossilTab);
    }
}
