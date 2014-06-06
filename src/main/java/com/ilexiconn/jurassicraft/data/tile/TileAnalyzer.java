package com.ilexiconn.jurassicraft.data.tile;

import com.ilexiconn.jurassicraft.Util;
import com.ilexiconn.jurassicraft.data.block.BlockAnalyzer;
import com.ilexiconn.jurassicraft.data.item.ItemDNA;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import java.util.ArrayList;
import java.util.Random;

public class TileAnalyzer extends TileEntity implements ISidedInventory
{
    private static final int[] slots_top    = new int[]{}; // input
    private static final int[] slots_bottom = new int[]{10, 11, 12}; // output
    private static final int[] slots_sides  = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8}; // fuel
    public static ArrayList<ItemDNA> dnas = new ArrayList<ItemDNA>();
    public  int analyzerBurnTime    = 0;
    public  int currentItemBurnTime = 100;
    public  int analyzerCookTime    = 0;
    private ItemStack[] analyzerItemStacks;
    private int RawIndex            = -1;
    private int SpaceIndex          = -1;

    public TileAnalyzer()
    {
        analyzerItemStacks = new ItemStack[13];

        dnas = Util.getDNAArray();
    }

    private static int getItemBurnTime()
    {
        return 100;
    }

    public static boolean isItemFuel()
    {
        return getItemBurnTime() > 0;
    }

    public int[] getAccessibleSlotsFromSide(int par1)
    {
        return par1 == 0 ? slots_bottom : (par1 == 1 ? slots_top : slots_sides);
    }

    public boolean canInsertItem(int var1, ItemStack var2, int var3)
    {
        return isItemValidForSlot(var1, var2);
    }

    public boolean canExtractItem(int var1, ItemStack var2, int var3)
    {
        return var3 != 0 || var1 != 1 || var2.getItem() == Items.bucket;
    }

    public int getSizeInventory()
    {
        return analyzerItemStacks.length;
    }

    public ItemStack getStackInSlot(int var1)
    {
        return analyzerItemStacks[var1];
    }

    public ItemStack decrStackSize(int slot, int decrAmount)
    {
        if (analyzerItemStacks[slot] != null)
        {
            ItemStack var3;
            if (analyzerItemStacks[slot].stackSize <= decrAmount)
            {
                var3 = analyzerItemStacks[slot];
                analyzerItemStacks[slot] = null;
                return var3;
            }
            else
            {
                var3 = analyzerItemStacks[slot].splitStack(decrAmount);
                if (analyzerItemStacks[slot].stackSize == 0)
                    analyzerItemStacks[slot] = null;
                return var3;
            }
        }
        else
            return null;
    }

    public ItemStack getStackInSlotOnClosing(int var1)
    {
        if (analyzerItemStacks[var1] != null)
        {
            ItemStack itemstack = analyzerItemStacks[var1];
            analyzerItemStacks[var1] = null;
            return itemstack;
        }
        else
            return null;
    }

    public void setInventorySlotContents(int var1, ItemStack var2)
    {
        analyzerItemStacks[var1] = var2;

        if (var2 != null && var2.stackSize > getInventoryStackLimit())
            var2.stackSize = getInventoryStackLimit();
    }

    public String getInventoryName()
    {
        return "Analyzer";
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
        return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && var1.getDistanceSq((double) xCoord + 0.5D, (double) yCoord + 0.5D, (double) zCoord + 0.5D) <= 64.0D;
    }

    public void openInventory() { }

    public void closeInventory() { }

    public boolean isItemValidForSlot(int var1, ItemStack var2)
    {
        return var1 != 2 && (var1 != 1 || isItemFuel());
    }

    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        NBTTagList nbttaglist = compound.getTagList("Items", 10);
        analyzerItemStacks = new ItemStack[getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound var4 = nbttaglist.getCompoundTagAt(i);
            byte var5 = var4.getByte("Slot");

            if (var5 >= 0 && var5 < analyzerItemStacks.length)
                analyzerItemStacks[var5] = ItemStack.loadItemStackFromNBT(var4);
        }

        analyzerBurnTime = compound.getShort("BurnTime");
        analyzerCookTime = compound.getShort("CookTime");
        currentItemBurnTime = 100;
    }

    public void writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setShort("BurnTime", (short) analyzerBurnTime);
        compound.setShort("CookTime", (short) analyzerCookTime);
        NBTTagList tagList = new NBTTagList();

        for (int i = 0; i < analyzerItemStacks.length; i++)
        {
            if (analyzerItemStacks[i] != null)
            {
                NBTTagCompound slotCompound = new NBTTagCompound();
                slotCompound.setByte("Slot", (byte) i);
                analyzerItemStacks[i].writeToNBT(slotCompound);
                tagList.appendTag(slotCompound);
            }
        }

        compound.setTag("Items", tagList);
    }

    public int getCookPrograssScaled(int par1)
    {
        return analyzerCookTime * par1 / 200;
    }

    public boolean isBurning()
    {
        return analyzerBurnTime > 0;
    }

    public void updateEntity()
    {
        boolean var1 = analyzerBurnTime > 0;
        boolean var2 = false;

        if (analyzerBurnTime > 0)
            --analyzerBurnTime;

        if (!worldObj.isRemote)
        {
            if (analyzerBurnTime == 0 && canSmelt())
            {
                currentItemBurnTime = analyzerBurnTime = 100;

                if (analyzerBurnTime > 0)
                    var2 = true;
            }

            if (isBurning() && canSmelt())
            {
                ++analyzerCookTime;

                if (analyzerCookTime == 200)
                {
                    analyzerCookTime = 0;
                    smeltItem();
                    var2 = true;
                }
            }
            else
                analyzerCookTime = 0;

            if (var1 != analyzerBurnTime > 0)
            {
                var2 = true;
                BlockAnalyzer.updateAnalyzerBlockState(analyzerBurnTime > 0, worldObj, xCoord, yCoord, zCoord);
            }
        }

        if (var2)
            updateEntity();
    }

    private boolean canSmelt()
    {
        SpaceIndex = -1;
        RawIndex = -1;

        int var1;

        for (var1 = 0; var1 < 9; ++var1)
        {
            if (analyzerItemStacks[var1] != null)
            {
                Item var2 = analyzerItemStacks[var1].getItem();

                if (var2 == Util.getItem(2) || var2 == Util.getItem(1))
                {
                    RawIndex = var1;
                    break;
                }
            }
        }

        if (RawIndex == -1)
            return false;
        else
        {
            for (var1 = 12; var1 > 8; --var1)
            {
                if (analyzerItemStacks[var1] == null)
                {
                    SpaceIndex = var1;
                    break;
                }
            }

            return SpaceIndex != -1 && RawIndex != -1;
        }
    }

    public void smeltItem()
    {
        if (canSmelt())
        {
            ItemStack var1 = null;

            if (analyzerItemStacks[RawIndex].getItem() == Util.getItem(2))
            {
                int dnaResult = (new Random()).nextInt(99);

                if (dnaResult > 74)
                    var1 = new ItemStack(getRandomDNA(new Random()));
                else
                {
                    int output = (new Random()).nextInt(3);

                    if (output == 0)
                        var1 = new ItemStack(Blocks.sand, 3);
                    else if (output == 1)
                        var1 = new ItemStack(Blocks.stone, 1);
                    else if (output == 2)
                        var1 = new ItemStack(Items.bone, 2);
                }
            }

            if (analyzerItemStacks[RawIndex].getItem() == Util.getItem(1))
                var1 = new ItemStack(getRandomDNA(new Random()));

            if (var1 != null)
            {
                if (var1.stackSize != 0 && analyzerItemStacks[SpaceIndex] == null)
                    analyzerItemStacks[SpaceIndex] = var1.copy();

                --analyzerItemStacks[RawIndex].stackSize;

                if (analyzerItemStacks[RawIndex].stackSize == 0)
                    analyzerItemStacks[RawIndex] = null;
            }
        }
    }

    private Item getRandomDNA(Random rand)
    {
        int dna = rand.nextInt(dnas.size());

        return dnas.get(dna);
    }
}
