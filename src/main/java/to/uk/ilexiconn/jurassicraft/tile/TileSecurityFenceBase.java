package to.uk.ilexiconn.jurassicraft.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemRedstone;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileSecurityFenceBase extends TileEntity implements ISidedInventory
{

    private ItemStack[] slots = new ItemStack[1];
    private static final int redstoneRequired = 8;
    private int redstoneStored = 0;
    private int securityLevel = 1;
    private int direction = 0;

    public TileSecurityFenceBase()
    {
    	
    }

    public void setSecurityLevel(int level)
    {
        this.securityLevel = level;
    }

    public int getSecurityLevel()
    {
        return this.securityLevel;
    }

    public void setDirection(int dir)
    {
        this.direction = dir;
    }

    public int getDirection()
    {
        return this.direction;
    }

    public void setRedstoneStored(int redstone)
    {
        this.redstoneStored = redstone;
    }

    public int getRedstoneStored()
    {
        return this.redstoneStored;
    }

    public int getRedstoneStoredProgressScaled(int i)
    {
    	if (this.getSecurityLevel() != 0) {
            return (int) ((this.getRedstoneStored() * i) / (this.getSecurityLevel() * this.redstoneRequired));
    	} else {
            return 0;
    	}
    }
    
    private boolean isIronBlock(World world, int x, int y, int z)
    {
    	return world.getBlock(x, y, z).getUnlocalizedName().equals("tile.blockIron");
    }
    
    private boolean isIronFence(World world, int x, int y, int z)
    {
    	return world.getBlock(x, y, z).getUnlocalizedName().equals("tile.fenceIron");
    }
    
    private boolean checkBlocksForFence(World world, int x, int y, int z, int sizeX, int sizeY, int sizeZ)
    {
    	for (int i = -sizeX; i <= sizeX; i++) 
    	{
        	for (int k = -sizeZ; k <= sizeZ; k++) 
            {
        		if (x + i != this.xCoord || y != this.yCoord || z + k != this.zCoord) {
                	if (!this.isIronBlock(world, x + i, y, z + k))
                		return false;
        		}
        	}
    	}
		for (int j = 1; j <= sizeY; j++) 
    	{
			for (int i = -sizeX; i <= sizeX; i++) 
			{
        		for (int k = -sizeZ; k <= sizeZ; k++) 
            	{
            		if (x + i != this.xCoord || y + j != this.yCoord || z + k != this.zCoord) {
                    	if (!this.isIronFence(world, x + i, y + j, z + k))
                			return false;
        			}
            	}
        	}
    	}
		return true;
    }
    
    private void removeBlocksForFence(World world, int x, int y, int z, int sizeX, int sizeY, int sizeZ)
    {
		for (int j = 0; j <= sizeY; j++) 
    	{
			for (int i = -sizeX; i <= sizeX; i++) 
			{
        		for (int k = -sizeZ; k <= sizeZ; k++) 
            	{
            		if (x + i != this.xCoord || y + j != this.yCoord || z + k != this.zCoord) {
                		world.setBlockToAir(x + i, y + j, z + k);
        			}
            	}
        	}
    	}
    }

    private boolean hasRedstone()
    {
    	return (this.slots[0] != (ItemStack) null && this.slots[0].getItem() instanceof ItemRedstone);
    }

    public boolean hasEnoughRedstone()
    {
    	return (this.slots[0] == (ItemStack) null || !(this.slots[0].getItem() instanceof ItemRedstone)) ? false : (this.slots[0].stackSize >= this.redstoneRequired * this.getSecurityLevel());
    }
    
    public boolean hasRequiredStructure()
    {
    	switch (this.getDirection()) 
    	{
    		case 0: //South - North
    			switch (this.getSecurityLevel()) 
    	    	{
    	    		case 1:
    	    			return this.checkBlocksForFence(this.worldObj, this.xCoord, this.yCoord, this.zCoord, 1, 3, 0);
    	    		case 2:
    	    			return this.checkBlocksForFence(this.worldObj, this.xCoord, this.yCoord, this.zCoord, 2, 3, 0);
    	    		case 3:
    	    			return this.checkBlocksForFence(this.worldObj, this.xCoord, this.yCoord, this.zCoord, 3, 3, 0);
    	   			default:
    	    			return false;
    	    	}
    		case 1: //East - West
    			switch (this.getSecurityLevel()) 
    	    	{
    	    		case 1:
    	    			return this.checkBlocksForFence(this.worldObj, this.xCoord, this.yCoord, this.zCoord, 0, 3, 1);
    	    		case 2:
    	    			return this.checkBlocksForFence(this.worldObj, this.xCoord, this.yCoord, this.zCoord, 0, 3, 2);
    	    		case 3:
    	    			return this.checkBlocksForFence(this.worldObj, this.xCoord, this.yCoord, this.zCoord, 0, 3, 3);
    	   			default:
    	    			return false;
    	    	}
    		default:
    			switch (this.getSecurityLevel()) 
    	    	{
    	    		case 1:
    	    			return this.checkBlocksForFence(this.worldObj, this.xCoord, this.yCoord, this.zCoord, 1, 3, 0);
    	    		case 2:
    	    			return this.checkBlocksForFence(this.worldObj, this.xCoord, this.yCoord, this.zCoord, 2, 3, 0);
    	    		case 3:
    	    			return this.checkBlocksForFence(this.worldObj, this.xCoord, this.yCoord, this.zCoord, 3, 3, 0);
    	   			default:
    	    			return false;
    	    	}
    	}
    }

    private void buildFence()
    {
    	switch (this.getDirection()) 
    	{
    		case 0: //South - North
    			switch (this.getSecurityLevel()) {
    	    		case 1:
    	    			this.removeBlocksForFence(this.worldObj, this.xCoord, this.yCoord, this.zCoord, 1, 3, 0);
    	    			//this.worldObj.setBlock(xCoord, yCoord, zCoord, ModBlocks.securityFenceLow);
    	    			break;
    	    		case 2:
    	    			this.removeBlocksForFence(this.worldObj, this.xCoord, this.yCoord, this.zCoord, 2, 3, 0);
    	    			//this.worldObj.setBlock(xCoord, yCoord, zCoord, ModBlocks.securityFenceMedium);
    	    			break;
    	    		case 3:
    	    			this.removeBlocksForFence(this.worldObj, this.xCoord, this.yCoord, this.zCoord, 3, 3, 0);
    	    			//this.worldObj.setBlock(xCoord, yCoord, zCoord, ModBlocks.securityFenceHigh);
    	    			break;
    	   			default:
    	    			return;
    	    	}
    			break;
    		case 1: //East - West
    			switch (this.getSecurityLevel()) {
    	    		case 1:
    	    			this.removeBlocksForFence(this.worldObj, this.xCoord, this.yCoord, this.zCoord, 0, 3, 1);
    	    			//this.worldObj.setBlock(xCoord, yCoord, zCoord, ModBlocks.securityFenceLow);
    	    			break;
    	    		case 2:
    	    			this.removeBlocksForFence(this.worldObj, this.xCoord, this.yCoord, this.zCoord, 0, 3, 2);
    	    			//this.worldObj.setBlock(xCoord, yCoord, zCoord, ModBlocks.securityFenceMedium);
    	    			break;
    	    		case 3:
    	    			this.removeBlocksForFence(this.worldObj, this.xCoord, this.yCoord, this.zCoord, 0, 3, 3);
    	    			//this.worldObj.setBlock(xCoord, yCoord, zCoord, ModBlocks.securityFenceHigh);
    	    			break;
    	   			default:
    	    			return;
    	    	}
    			break;
    		default: //Error
    			switch (this.getSecurityLevel()) {
    	    		case 1:
    	    			this.removeBlocksForFence(this.worldObj, this.xCoord, this.yCoord, this.zCoord, 1, 3, 0);
    	    			//this.worldObj.setBlock(xCoord, yCoord, zCoord, ModBlocks.securityFenceLow);
    	    			break;
    	    		case 2:
    	    			this.removeBlocksForFence(this.worldObj, this.xCoord, this.yCoord, this.zCoord, 2, 3, 0);
    	    			//this.worldObj.setBlock(xCoord, yCoord, zCoord, ModBlocks.securityFenceMedium);
    	    			break;
    	    		case 3:
    	    			this.removeBlocksForFence(this.worldObj, this.xCoord, this.yCoord, this.zCoord, 3, 3, 0);
    	    			//this.worldObj.setBlock(xCoord, yCoord, zCoord, ModBlocks.securityFenceHigh);
    	    			break;
    	   			default:
    	    			return;
    	    	}
    	}
    }
    
    public void tryToBuildFence()
    {
		if (this.hasEnoughRedstone()) 
		{
			if (this.hasRequiredStructure()) 
			{
				this.slots[0].stackSize -= this.redstoneRequired * this.getSecurityLevel();
				if (this.slots[0].stackSize <= 0) 
				{
					this.slots[0] = (ItemStack) null;
				}
				//this.buildFence(); CHANGE LATER
			}
		}
    }
    
    @Override
    public void updateEntity()
    {
        if (!this.worldObj.isRemote)
        {
            if (this.hasRedstone()) 
            {
            	this.setRedstoneStored(this.slots[0].stackSize);
            } 
            else 
            {
            	this.setRedstoneStored(0);
            }
        }
    }

    public boolean hasItems()
    {
        return this.slots[0] != null;
    }

    @Override
    public int getSizeInventory()
    {
        return slots.length;
    }

    @Override
    public ItemStack getStackInSlot(int i)
    {
        return slots[i];
    }

    @Override
    public ItemStack decrStackSize(int i, int stackSize)
    {
        if (this.slots[i] != null)
        {
            ItemStack splitedStack;
            if (this.slots[i].stackSize <= stackSize)
            {
                splitedStack = this.slots[i];
                this.slots[i] = null;
                return splitedStack;
            }
            else
            {
                splitedStack = this.slots[i].splitStack(stackSize);
                if (this.slots[i].stackSize == 0)
                {
                    this.slots[i] = null;
                }
                return splitedStack;
            }
        }
        else
        {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i)
    {
        if (this.slots[i] != null)
        {
            ItemStack itemStack = this.slots[i];
            this.slots[i] = null;
            return itemStack;
        }
        else
        {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemStack)
    {
        this.slots[i] = itemStack;
        if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit())
        {
            itemStack.stackSize = this.getInventoryStackLimit();
        }
    }

    @Override
    public String getInventoryName()
    {
        return "Security Fence Base";
    }

    @Override
    public boolean hasCustomInventoryName()
    {
        return true;
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player)
    {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;
    }

    @Override
    public void openInventory()
    {

    }

    @Override
    public void closeInventory()
    {

    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemStack)
    {
        return false;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int i)
    {
        return new int[] {0};
    }

    @Override
    public boolean canInsertItem(int i, ItemStack itemStack, int j)
    {
        return false;
    }

    @Override
    public boolean canExtractItem(int i, ItemStack itemStack, int j)
    {
        return false;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        NBTTagList list = nbt.getTagList("Items", 10);
        this.slots = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < list.tagCount(); i++)
        {
            NBTTagCompound compound = (NBTTagCompound) list.getCompoundTagAt(i);
            byte j = compound.getByte("Slot");

            if (j >= 0 && j < this.slots.length)
            {
                this.slots[j] = ItemStack.loadItemStackFromNBT(compound);
            }
        }
        this.setSecurityLevel(nbt.getInteger("SecurityLevel"));
        this.setDirection(nbt.getInteger("Direction"));
        this.setRedstoneStored(nbt.getInteger("RedstoneStored"));
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        NBTTagList list = new NBTTagList();
        for (int i = 0; i < this.slots.length; i++)
        {
            if (this.slots[i] != null)
            {
                NBTTagCompound compound = new NBTTagCompound();
                compound.setByte("Slot", (byte) i);
                this.slots[i].writeToNBT(compound);
                list.appendTag(compound);
            }
        }
        nbt.setTag("Items", list);
        nbt.setInteger("SecurityLevel", this.getSecurityLevel());
        nbt.setInteger("Direction", this.getDirection());
        nbt.setInteger("RedstoneStored", this.getRedstoneStored());
    }
}