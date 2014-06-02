package com.ilexiconn.jurassicraft.data.gui.container;

import com.ilexiconn.jurassicraft.data.tile.TileCultivate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

public class ContainerCultivate extends Container
{
    public TileCultivate tileCultivate;
    public InventoryPlayer inventoryPlayer;

    public ContainerCultivate(InventoryPlayer inventory, TileCultivate tileEntity)
    {
        tileCultivate = tileEntity;
        inventoryPlayer = inventory;

        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; ++i)
        {
            addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
        }
    }

    public boolean canInteractWith(EntityPlayer var1)
    {
        return true;
    }
}
