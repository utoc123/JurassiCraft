package to.uk.ilexiconn.jurassicraft.data.item;

import to.uk.ilexiconn.jurassicraft.DinoEntry;
import net.minecraft.item.Item;

public class ItemDinoBone extends Item
{
    public ItemDinoBone()
    {
        super();
        setUnlocalizedName("dinoBone");
        setTextureName(DinoEntry.getModId() + "dinoBone");
        setCreativeTab(DinoEntry.getCreativeTab(0));
    }
}
