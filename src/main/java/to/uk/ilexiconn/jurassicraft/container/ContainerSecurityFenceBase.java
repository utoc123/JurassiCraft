package to.uk.ilexiconn.jurassicraft.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemRedstone;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import to.uk.ilexiconn.jurassicraft.tile.TileSecurityFence;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerSecurityFenceBase extends Container
{

    private TileSecurityFence fence;
    private int lastIronIngots;
    private int lastRedstone;

    public ContainerSecurityFenceBase(InventoryPlayer playerInventory, TileEntity tileEntity)
    {
        this.fence = (TileSecurityFence) tileEntity;
        this.addSlotToContainer(new Slot(this.fence, 0, 120, 47));
        this.addSlotToContainer(new Slot(this.fence, 1, 120, 77));

        for (int i = 0; i < 3; i++)
        {
            for (int k = 0; k < 9; k++)
            {
                this.addSlotToContainer(new Slot(playerInventory, k + i * 9 + 9, 48 + k * 18, 174 + i * 18));
            }
        }

        for (int i = 0; i < 9; i++)
        {
            this.addSlotToContainer(new Slot(playerInventory, i, 48 + i * 18, 232));
        }
    }
    
    @Override
    public void addCraftingToCrafters(ICrafting iCrafting)
    {
        super.addCraftingToCrafters(iCrafting);
        iCrafting.sendProgressBarUpdate(this, 0, this.fence.getIronIngotsStored());
        iCrafting.sendProgressBarUpdate(this, 1, this.fence.getRedstoneStored());
    }

    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();
        for (int i = 0; i < this.crafters.size(); i++)
        {
            ICrafting iCrafting = (ICrafting) this.crafters.get(i);
            if (this.lastIronIngots != this.fence.getIronIngotsStored())
            {
                iCrafting.sendProgressBarUpdate(this, 0, this.fence.getIronIngotsStored());
            }
            if (this.lastRedstone != this.fence.getRedstoneStored())
            {
                iCrafting.sendProgressBarUpdate(this, 1, this.fence.getRedstoneStored());
            }
        }
        this.lastIronIngots = this.fence.getIronIngotsStored();
        this.lastRedstone = this.fence.getRedstoneStored();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int i, int unknown)
    {
        if (i == 0)
        {
        	this.fence.setIronIngotsStored((short) unknown);
        }
        else if (i == 1)
        {
        	this.fence.setRedstoneStored((short) unknown);
        }
    }
    
    @Override
    public void onContainerClosed(EntityPlayer player)
    {
        super.onContainerClosed(player);
        if (!player.worldObj.isRemote)
        {
        	this.fence.closeInventory();
        }
    }
    
    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return this.fence.isUseableByPlayer(player);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int i)
    {
        if (!entityPlayer.worldObj.isRemote)
        {
            Slot slot = (Slot) inventorySlots.get(i);
            ItemStack stackFinal = null;
            if (slot != null && slot.getHasStack())
            {
                ItemStack stackInSlot = slot.getStack();
                stackFinal = stackInSlot.copy();
                if (i < 2)
                {
                    if (!mergeItemStack(stackInSlot, 9, inventorySlots.size(), true))
                    {
                        return null;
                    }
                    slot.onSlotChange(stackInSlot, stackFinal);
                }
                else if (i >= 2)
                {
                	if (stackInSlot.getItem().getUnlocalizedName().equals("item.ingotIron"))
                    {
                        if (!mergeItemStack(stackInSlot, 0, 1, false))
                        {
                            return null;
                        }
                    }
                    else if (stackInSlot.getItem() instanceof ItemRedstone)
                    {
                        if (!mergeItemStack(stackInSlot, 1, 2, false))
                        {
                            return null;
                        }
                    }
                    else
                    {
                        return null;
                    }
                }
                else
                {
                    return null;
                }
                if (stackInSlot.stackSize == 0)
                {
                    slot.putStack((ItemStack) null);
                }
                else
                {
                    slot.onSlotChanged();
                }
                return stackFinal;
            }
            return null;
        }
        return null;
    }
}