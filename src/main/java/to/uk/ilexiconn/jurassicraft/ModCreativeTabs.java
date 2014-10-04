package to.uk.ilexiconn.jurassicraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import to.uk.ilexiconn.llib.content.ContentHandler;
import to.uk.ilexiconn.llib.content.ContentType;
import cpw.mods.fml.common.eventhandler.EventPriority;

@ContentHandler(modid = "jurassicraft", type = ContentType.CREATIVETAB, priority = EventPriority.HIGHEST)
public class ModCreativeTabs 
{
    public static CreativeTabs fossilTab;

    public void init()
    {
        fossilTab = new CreativeTabs("fossilTab")
        {
            public Item getTabIconItem()
            {
                return ModItems.fossil;
            }
        };
    }
}
