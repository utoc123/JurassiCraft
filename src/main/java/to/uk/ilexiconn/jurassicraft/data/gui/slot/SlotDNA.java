package to.uk.ilexiconn.jurassicraft.data.gui.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import to.uk.ilexiconn.jurassicraft.data.item.ItemDNA;

public class SlotDNA extends Slot
{
    public SlotDNA(IInventory inventory, int x, int y, int z)
    {
        super(inventory, x, y, z);
    }

    public boolean isItemValid(ItemStack itemStack)
    {
        return itemStack.getItem() instanceof ItemDNA;
    }
}
