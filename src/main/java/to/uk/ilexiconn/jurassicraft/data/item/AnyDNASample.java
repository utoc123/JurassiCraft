package to.uk.ilexiconn.jurassicraft.data.item;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface AnyDNASample {
	void setQuality(ItemStack dnaSample, int quality);
	int getQuality(ItemStack dnaSample);
}
