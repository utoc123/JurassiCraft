package com.ilexiconn.jurassicraft.data.tile;

import com.ilexiconn.jurassicraft.Util;
import com.ilexiconn.jurassicraft.data.block.BlockCultivate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileCultivate extends TileEntity implements IInventory
{
    public ItemStack[] stacks = new ItemStack[2];

    public void updateEntity()
    {
        if (getStackInSlot(0) != null)
        {
            if (!getActive()) BlockCultivate.updateCultivateBlockState(true, worldObj, xCoord, yCoord, zCoord);
        }
        else
        {
            if (getActive()) BlockCultivate.updateCultivateBlockState(false, worldObj, xCoord, yCoord, zCoord);
        }
    }

    public boolean getActive()
    {
        return worldObj.getBlock(xCoord, yCoord, zCoord) == Util.getBlock(0);
    }

    public int getSizeInventory()
    {
        return stacks.length;
    }

    public ItemStack getStackInSlot(int var1)
    {
        return stacks[var1];
    }

    public ItemStack decrStackSize(int slot, int amount)
    {
        if (stacks[slot] != null)
        {
            ItemStack var3;
            if (stacks[slot].stackSize <= amount)
            {
                var3 = stacks[slot];
                stacks[slot] = null;
                return var3;
            }
            else
            {
                var3 = stacks[slot].splitStack(amount);
                if (stacks[slot].stackSize == 0)
                    stacks[slot] = null;
                return var3;
            }
        }
        else
            return null;
    }

    public ItemStack getStackInSlotOnClosing(int var1)
    {
        if (stacks[var1] != null)
        {
            ItemStack itemstack = stacks[var1];
            stacks[var1] = null;
            return itemstack;
        }
        else
            return null;
    }

    public void setInventorySlotContents(int var1, ItemStack var2)
    {
        stacks[var1] = var2;

        if (var2 != null && var2.stackSize > getInventoryStackLimit())
            var2.stackSize = getInventoryStackLimit();
    }

    public String getInventoryName()
    {
        return "Cultivate";
    }

    public boolean hasCustomInventoryName()
    {
        return false;
    }

    public int getInventoryStackLimit()
    {
        return 64;
    }

    public boolean isUseableByPlayer(EntityPlayer var1)
    {
        return true;
    }

    public void openInventory()
    {

    }

    public void closeInventory()
    {

    }

    public boolean isItemValidForSlot(int var1, ItemStack var2)
    {
        return true;
    }
}
