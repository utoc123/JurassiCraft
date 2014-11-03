package to.uk.ilexiconn.jurassicraft.item;

import net.minecraft.item.Item;
import to.uk.ilexiconn.jurassicraft.ModCreativeTabs;
import to.uk.ilexiconn.jurassicraft.Util;

public class ItemGrowthSerum extends Item
{
    public ItemGrowthSerum()
    {
        super();
        setUnlocalizedName("growthSerum");
        setTextureName(Util.getModId() + "growth_Serum");
        setCreativeTab(ModCreativeTabs.items);
    }
}
