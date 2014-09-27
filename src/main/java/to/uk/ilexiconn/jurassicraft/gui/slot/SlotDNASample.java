package to.uk.ilexiconn.jurassicraft.gui.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import to.uk.ilexiconn.jurassicraft.item.AnyDNASample;

public class SlotDNASample extends Slot
{

    public SlotDNASample(IInventory inventory, int number, int x, int y)
    {
        super(inventory, number, x, y);
    }

    @Override
    public int getSlotStackLimit()
    {
        return 64;
    }

    @Override
    public boolean isItemValid(ItemStack itemstack)
    {
        return (itemstack.getItem() instanceof AnyDNASample);
    }
}