package to.uk.ilexiconn.jurassicraft.data.gui.container;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import to.uk.ilexiconn.jurassicraft.data.item.ItemDNA;
import to.uk.ilexiconn.jurassicraft.data.tile.TileCultivate;

public class ContainerCultivate extends Container
{
    public TileCultivate   tileCultivate;
    public InventoryPlayer inventoryPlayer;
    
    public ContainerCultivate(InventoryPlayer inventory, TileCultivate tileEntity)
    {
        tileCultivate = tileEntity;
        inventoryPlayer = inventory;
        
        addSlotToContainer(new Slot(tileEntity, 0, 45, 38));
        addSlotToContainer(new SlotFurnace(inventoryPlayer.player, tileEntity, 1, 117, 38));
        
        bindPlayerInventory(inventoryPlayer);
    }
    
    protected void bindPlayerInventory(InventoryPlayer inventoryPlayer)
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        
        for (int i = 0; i < 9; i++)
        {
            addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
        }
    }
    
    public boolean canInteractWith(EntityPlayer player)
    {
        return true;
    }
    
    public boolean canCultivate(ItemStack stack)
    {
        Item stackItem = stack.getItem();
        
        if (stackItem == null || !(stackItem instanceof ItemDNA)) return false;
        
        Item eggItem = ((ItemDNA) stackItem).getCorrespondingEgg();
        
        if (eggItem == null) return false;
        
        return true;
    }
    
    public ItemStack transferStackInSlot(EntityPlayer player, int slot)
    {
        ItemStack stack = null;
        Slot slotObject = (Slot) inventorySlots.get(slot);

        //null checks and checks if the item can be stacked (maxStackSize > 1)
        if (slotObject != null && slotObject.getHasStack()) {
                ItemStack stackInSlot = slotObject.getStack();
                stack = stackInSlot.copy();

                //merges the item into player inventory since its in the tileEntity
                if (slot < 2) {
                        if (!this.mergeItemStack(stackInSlot, 2, 38, false)) {
                                return null;
                        }
                }
                //places it into the tileEntity is possible since its in the player inventory
                else if (canCultivate(stackInSlot)) {
                    if(!this.mergeItemStack(stackInSlot, 0, 1, false))
                        return null;
                }

                if (stackInSlot.stackSize == 0) {
                        slotObject.putStack(null);
                } else {
                        slotObject.onSlotChanged();
                }

                if (stackInSlot.stackSize == stack.stackSize) {
                        return null;
                }
                slotObject.onPickupFromSlot(player, stackInSlot);
        }
        return stack;
    }
}
