package to.uk.ilexiconn.jurassicraft.data.item;

import to.uk.ilexiconn.jurassicraft.DinoEntry;
import net.minecraft.item.Item;

public class ItemAmber extends Item
{
    public ItemAmber()
    {
        super();
        setUnlocalizedName("amber");
        setTextureName(DinoEntry.getModId() + "amber");
        setCreativeTab(DinoEntry.getCreativeTab(0));
    }
}
