package to.uk.ilexiconn.jurassicraft.data.item;

import to.uk.ilexiconn.jurassicraft.DinoEntry;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;

public class ItemMeat extends ItemFood
{
    public ItemMeat(String name)
    {
        super(4, 0.1f, true);
        setPotionEffect(Potion.hunger.id, 30, 0, 0.8f);
        setUnlocalizedName(name + "_Meat");
        setTextureName(DinoEntry.getModId() + name + "_Meat");
        setCreativeTab(DinoEntry.getCreativeTab(0));
    }
}
