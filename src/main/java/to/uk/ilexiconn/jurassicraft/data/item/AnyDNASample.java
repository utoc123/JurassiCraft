package to.uk.ilexiconn.jurassicraft.data.item;

import net.minecraft.item.ItemStack;

public interface AnyDNASample
{
	void setDNASequence(ItemStack dnaSample);
	
	String getDNASequence(ItemStack dnaSample);
	
    void setQuality(ItemStack dnaSample, int quality);

    int getQuality(ItemStack dnaSample);
}
