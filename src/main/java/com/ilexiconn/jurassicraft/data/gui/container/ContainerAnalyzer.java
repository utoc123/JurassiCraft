package com.ilexiconn.jurassicraft.data.gui.container;

import com.ilexiconn.jurassicraft.data.tile.TileAnalyzer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;

public class ContainerAnalyzer extends Container
{
    public TileAnalyzer tileAnalyzer;
    public InventoryPlayer inventoryPlayer;
    public int cookTime, burnTime, itemBurnTime;

    public ContainerAnalyzer(InventoryPlayer inventory, TileAnalyzer tileEntity)
    {
        tileAnalyzer = tileEntity;
        inventoryPlayer = inventory;

        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 3; ++j)
            {
                addSlotToContainer(new Slot(tileAnalyzer, j + i * 3, 20 + j * 18, 17 + i * 18));
            }
        }

        addSlotToContainer(new SlotFurnace(inventoryPlayer.player, tileAnalyzer, 9, 116, 21));

        for (int i = 0; i < 3; ++i)
        {
            addSlotToContainer(new SlotFurnace(inventoryPlayer.player, tileAnalyzer, 10 + i, 111 + 18 * i, 53));
        }

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

    public void addCraftingToCrafters(ICrafting crafting)
    {
        super.addCraftingToCrafters(crafting);
        crafting.sendProgressBarUpdate(this, 0, tileAnalyzer.analyzerCookTime);
        crafting.sendProgressBarUpdate(this, 1, tileAnalyzer.analyzerBurnTime);
        crafting.sendProgressBarUpdate(this, 2, tileAnalyzer.currentItemBurnTime);
    }

    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (Object crafter : crafters)
        {
            ICrafting var2 = (ICrafting) crafter;

            if (cookTime != tileAnalyzer.analyzerCookTime)
                var2.sendProgressBarUpdate(this, 0, tileAnalyzer.analyzerCookTime);

            if (burnTime != tileAnalyzer.analyzerBurnTime)
                var2.sendProgressBarUpdate(this, 1, tileAnalyzer.analyzerBurnTime);

            if (itemBurnTime != tileAnalyzer.currentItemBurnTime)
                var2.sendProgressBarUpdate(this, 20, tileAnalyzer.currentItemBurnTime);
        }

        cookTime = tileAnalyzer.analyzerCookTime;
        burnTime = tileAnalyzer.analyzerBurnTime;
        itemBurnTime = tileAnalyzer.currentItemBurnTime;
    }

    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0) tileAnalyzer.analyzerCookTime = par2;

        if (par1 == 1) tileAnalyzer.analyzerBurnTime = par2;

        if (par1 == 2) tileAnalyzer.currentItemBurnTime = par2;
    }

    public boolean canInteractWith(EntityPlayer var1)
    {
        return tileAnalyzer.isUseableByPlayer(var1);
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
                if (slot < 13) {
                        if (!this.mergeItemStack(stackInSlot, 13, 49, false)) {
                                return null;
                        }
                }
                //places it into the tileEntity is possible since its in the player inventory
                else if (!this.mergeItemStack(stackInSlot, 0, 9, false)) {
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
