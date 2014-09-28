package to.uk.ilexiconn.jurassicraft.container.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import to.uk.ilexiconn.jurassicraft.item.AnyDNASample;
import to.uk.ilexiconn.jurassicraft.item.ItemDinoEgg;

public class SlotDNASampleAndEgg extends Slot
{

    public SlotDNASampleAndEgg(IInventory inventory, int number, int x, int y)
    {
        super(inventory, number, x, y);
    }

    @Override
    public int getSlotStackLimit()
    {
        return 1;
    }

    @Override
    public boolean isItemValid(ItemStack itemstack)
    {
        return (itemstack.getItem() instanceof AnyDNASample || itemstack.getItem() instanceof ItemDinoEgg);
    }
}