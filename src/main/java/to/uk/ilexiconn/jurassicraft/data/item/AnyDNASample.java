package to.uk.ilexiconn.jurassicraft.data.item;

import net.minecraft.item.ItemStack;

public interface AnyDNASample
{
	String getDNASequence(ItemStack dnaSample);

    int getQuality(ItemStack dnaSample);
}
