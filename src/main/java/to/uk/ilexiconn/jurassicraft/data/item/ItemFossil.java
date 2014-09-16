package to.uk.ilexiconn.jurassicraft.data.item;

import to.uk.ilexiconn.jurassicraft.DinoEntry;
import net.minecraft.item.Item;

public class ItemFossil extends Item
{
    public ItemFossil()
    {
        super();
        setUnlocalizedName("fossil");
        setTextureName(DinoEntry.getModId() + "fossil");
        setCreativeTab(DinoEntry.getCreativeTab(0));
    }
}
