package to.uk.ilexiconn.jurassicraft;

import net.minecraft.item.Item;
import to.uk.ilexiconn.jurassicraft.item.ItemAmber;
import to.uk.ilexiconn.jurassicraft.item.ItemDinoBone;
import to.uk.ilexiconn.jurassicraft.item.ItemFossil;
import to.uk.ilexiconn.llib.content.ContentHandler;
import to.uk.ilexiconn.llib.content.ContentType;

@ContentHandler(modid = "jurassicraft", type = ContentType.ITEM)
public class ModItems
{
    public static Item amber;
    public static Item fossil;
    public static Item dinoBone;

    public void init()
    {
        amber = new ItemAmber();
        fossil = new ItemFossil();
        dinoBone = new ItemDinoBone();
    }
}
