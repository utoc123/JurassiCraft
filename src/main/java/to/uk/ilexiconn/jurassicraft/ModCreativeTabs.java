package to.uk.ilexiconn.jurassicraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import to.uk.ilexiconn.llib.content.ContentHandler;
import to.uk.ilexiconn.llib.content.ContentType;

@ContentHandler(modid = "jurassicraft", type = ContentType.CREATIVETAB)
public class ModCreativeTabs
{
    public static CreativeTabs fossilTab;

    public void init()
    {
        fossilTab = new CreativeTabs("fossilTab")
        {
            public Item getTabIconItem()
            {
                return Items.potato;
            }
        };
    }
}
