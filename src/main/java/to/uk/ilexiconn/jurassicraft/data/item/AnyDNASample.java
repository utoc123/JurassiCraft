package to.uk.ilexiconn.jurassicraft.data.item;

import net.minecraft.item.ItemStack;

public interface AnyDNASample
{
    void setQuality(ItemStack dnaSample, int quality);

    int getQuality(ItemStack dnaSample);
}
