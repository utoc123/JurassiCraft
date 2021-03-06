package to.uk.ilexiconn.jurassicraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import to.uk.ilexiconn.jurassicraft.content.IContentHandler;

public class ModCreativeTabs implements IContentHandler
{
    public static CreativeTabs items;
    public static CreativeTabs blocks;

    public void init()
    {
        items = new CreativeTab("jurassicraft.items", Items.apple);
        blocks = new CreativeTab("jurassicraft.blocks", Items.arrow);
    }

    private static class CreativeTab extends CreativeTabs
    {
        public Item item;

        public CreativeTab(String n, Item i)
        {
            super(n);
            item = i;
        }

        public Item getTabIconItem()
        {
            return item;
        }
    }
}
