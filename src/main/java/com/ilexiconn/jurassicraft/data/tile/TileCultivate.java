package com.ilexiconn.jurassicraft.data.tile;

import com.ilexiconn.jurassicraft.Util;
import com.ilexiconn.jurassicraft.data.block.BlockCultivate;
import com.ilexiconn.jurassicraft.data.item.ItemDNA;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileCultivate extends TileEntity implements IInventory
{
	// 0 = Input
	// 1 = Output
    public ItemStack[] stacks = new ItemStack[2];
	public int cultivateTime = 0;
	public int timeToCultivate = 400;

	public void updateEntity()
    {
        if (getStackInSlot(0) != null)
        {
            if (!getActive()) BlockCultivate.updateCultivateBlockState(true, worldObj, xCoord, yCoord, zCoord);

			if (canCultivate())
				++cultivateTime;

			if (cultivateTime > timeToCultivate)
				finishItem();
        }
        else
        {
            if (getActive()) BlockCultivate.updateCultivateBlockState(false, worldObj, xCoord, yCoord, zCoord);
			cultivateTime = 0;
        }
    }

	public boolean canCultivate()
	{
		ItemStack result = new ItemStack(((ItemDNA) stacks[0].getItem()).getCorrespondingEgg());
		return stacks[1] == null || stacks[1].isItemEqual(result);
	}

    public boolean getActive()
    {
        return worldObj.getBlock(xCoord, yCoord, zCoord) == Util.getBlock(0);
    }

	public void finishItem()
	{
		if (stacks[1] != null)
			++stacks[1].stackSize;
		else
			stacks[1] = new ItemStack(((ItemDNA) stacks[0].getItem()).getCorrespondingEgg(), 1, 0);

		if (stacks[0].stackSize != 1)
			--stacks[0].stackSize;
		else
			stacks[0] = null;

		cultivateTime = 0;
	}

	public int getCookProgressScaled(int i)
	{
		return cultivateTime * i / timeToCultivate;
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

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);

		if (compound.getCompoundTag("DNA") != null)
			stacks[0] = ItemStack.loadItemStackFromNBT(compound.getCompoundTag("DNA"));
		if (compound.getCompoundTag("Egg") != null)
			stacks[1] = ItemStack.loadItemStackFromNBT(compound.getCompoundTag("Egg"));

		cultivateTime = compound.getInteger("CultivateTime");
	}

	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);

		if (stacks[0] != null)
			compound.setTag("DNA", stacks[0].writeToNBT(new NBTTagCompound()));
		if (stacks[1] != null)
			compound.setTag("Egg", stacks[1].writeToNBT(new NBTTagCompound()));

		compound.setInteger("CultivateTime", cultivateTime);
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
