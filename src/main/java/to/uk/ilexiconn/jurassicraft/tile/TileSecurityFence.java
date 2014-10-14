package to.uk.ilexiconn.jurassicraft.tile;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
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
import to.uk.ilexiconn.jurassicraft.ModBlocks;
import to.uk.ilexiconn.jurassicraft.block.fence.BlockSecurityFenceMain;
import to.uk.ilexiconn.jurassicraft.block.fence.IFenceBase;
import to.uk.ilexiconn.jurassicraft.block.fence.IFenceGrid;
import to.uk.ilexiconn.jurassicraft.block.fence.IFencePole;

public class TileSecurityFence extends TileEntity implements ISidedInventory {

	private ItemStack[] slots = new ItemStack[2];
	private byte[] securityLevel = new byte[4];
	private short fenceGridsStored = 0;
	private short fenceBasesStored = 0;
	private short fencePolesStored = 0;
	private byte distancePlanned = 0;
	private byte heightPlanned = 0;
	private byte direction = 0;

	public TileSecurityFence() {

	}

	public int getFenceGridsStored() {
		return fenceGridsStored;
	}

	public void setFenceGridsStored(short fenceGrids) {
		this.fenceGridsStored = fenceGrids;
	}

	public int getFenceBasesStored() {
		return fenceBasesStored;
	}

	public void setFenceBasesStored(short fenceBases) {
		this.fenceBasesStored = fenceBases;
	}

	public int getFencePolesStored() {
		return fencePolesStored;
	}

	public void setFencePolesStored(short fencePoles) {
		this.fencePolesStored = fencePoles;
	}

	public byte getSecurityLevel(int direction) {
		return securityLevel[direction];
	}

	public void setSecurityLevel(byte securityLV, int direction) {
		if (securityLV > 0 && securityLV <= 3) {
			this.securityLevel[direction] = securityLV;
		}
	}

	public byte getDirection() {
		return direction;
	}

	public void setDirection(byte dir) {
		this.direction = dir;
	}

	public boolean isFenceBuilt(int direction) {
		return this.securityLevel[direction] > 0;
	}

	public byte getHeightPlanned(int level) {
		switch (level) {
			case 0:
				return 2;
			case 1:
				return 3;
			case 2:
				return 5;
			case 3:
				return 5;
		}
		return 0;
	}

	public boolean hasIronIngots() {
		return (this.slots[0] != (ItemStack) null && this.slots[0].getItem().getUnlocalizedName().equals("item.ingotIron"));
	}

	public boolean hasRedstone() {
		return (this.slots[1] != (ItemStack) null && this.slots[1].getItem() instanceof ItemRedstone);
	}

	public boolean hasFenceBases() {
		return this.fenceBasesStored > 0;
	}

	public boolean hasFenceGrids() {
		return this.fenceGridsStored > 0;
	}

	public boolean hasFencePoles() {
		return this.fencePolesStored > 0;
	}

	public boolean isSecurityLevelValid(int level) {
		return (level > -1 && level < 4);
	}

	public boolean isFenceValid(int direction, int level) {
		if (level == 0) {
			return !(this.securityLevel[direction] > 0);
		} else if (level == 1 || level == 2 || level == 3) {
			return (this.securityLevel[direction] > 0);
		}
		return false;
	}

	public boolean isDistanceValid(int distance) {
		return (distance > 0 && distance < 12);
	}

	public boolean isHeightValid(int height) {
		return (height > 0 && height < 7);
	}

	public int getRequiredFenceGrids(int securityLV, int direction) {
		return this.getHeightPlanned(securityLV) * (this.calculateDistanceToNextPole(direction) - 1);
	}

	public boolean hasEnoughFenceGrids(int securityLV, int direction) {
		TileEntity tileEntity = (TileEntity) null;
		switch (direction) {
			case 0:
				tileEntity = this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord + this.calculateDistanceToNextPole(direction));
				break;
			case 1:
				tileEntity = this.worldObj.getTileEntity(this.xCoord - this.calculateDistanceToNextPole(direction), this.yCoord, this.zCoord);
				break;
			case 2:
				tileEntity = this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord - this.calculateDistanceToNextPole(direction));
				break;
			case 3:
				tileEntity = this.worldObj.getTileEntity(this.xCoord + this.calculateDistanceToNextPole(direction), this.yCoord, this.zCoord);
				break;
		}
		if (tileEntity instanceof TileSecurityFence) {
			TileSecurityFence nextFence = (TileSecurityFence) tileEntity;
			if ((nextFence.hasFenceGrids() && nextFence.isSecurityLevelValid(securityLV)) || (this.hasFenceGrids() && this.isSecurityLevelValid(securityLV))) {
				return (this.getFenceGridsStored() + nextFence.getFenceGridsStored() >= this.getRequiredFenceGrids(securityLV, direction));
			}
		}
		return false;
	}

	public int getRequiredFenceBases(int direction) {
		return this.calculateDistanceToNextPole(direction) - 1;
	}

	public boolean hasEnoughFenceBases(int securityLV, int direction) {
		TileEntity tileEntity = (TileEntity) null;
		switch (direction) {
			case 0:
				tileEntity = this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord + this.calculateDistanceToNextPole(direction));
				break;
			case 1:
				tileEntity = this.worldObj.getTileEntity(this.xCoord - this.calculateDistanceToNextPole(direction), this.yCoord, this.zCoord);
				break;
			case 2:
				tileEntity = this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord - this.calculateDistanceToNextPole(direction));
				break;
			case 3:
				tileEntity = this.worldObj.getTileEntity(this.xCoord + this.calculateDistanceToNextPole(direction), this.yCoord, this.zCoord);
				break;
		}
		if (tileEntity instanceof TileSecurityFence) {
			TileSecurityFence nextFence = (TileSecurityFence) tileEntity;
			if ((nextFence.hasFenceBases() && nextFence.isSecurityLevelValid(securityLV)) || (this.hasFenceBases() && this.isSecurityLevelValid(securityLV))) {
				return (this.getFenceBasesStored() + nextFence.getFenceBasesStored() >= this.getRequiredFenceBases(direction));
			}
		}
		return false;
	}

	public int getRequiredFencePoles(int securityLV) {
		if (securityLV == 0 || securityLV == 2) {
			return 4;
		} else {
			return 2;
		}
	}

	public boolean hasEnoughFencePoles(int securityLV) {
		TileEntity tileEntity = (TileEntity) null;
		switch (direction) {
			case 0:
				tileEntity = this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord + this.calculateDistanceToNextPole(direction));
				break;
			case 1:
				tileEntity = this.worldObj.getTileEntity(this.xCoord - this.calculateDistanceToNextPole(direction), this.yCoord, this.zCoord);
				break;
			case 2:
				tileEntity = this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord - this.calculateDistanceToNextPole(direction));
				break;
			case 3:
				tileEntity = this.worldObj.getTileEntity(this.xCoord + this.calculateDistanceToNextPole(direction), this.yCoord, this.zCoord);
				break;
		}
		if (tileEntity instanceof TileSecurityFence) {
			TileSecurityFence nextFence = (TileSecurityFence) tileEntity;
			if ((nextFence.hasFencePoles() && nextFence.isSecurityLevelValid(securityLV)) || (this.hasFencePoles() && this.isSecurityLevelValid(securityLV))) {
				return (this.getFencePolesStored() + nextFence.getFencePolesStored() >= this.getRequiredFencePoles(securityLV));
			}
		}
		return false;
	}

	private boolean hasSecurityFenceMainBlockAt(World world, int x, int y, int z) {
		return world.getBlock(x, y, z) instanceof BlockSecurityFenceMain;
	}

	public boolean canCraftBase() {
		return (this.slots[0] != (ItemStack) null && this.slots[0].stackSize - 8 > -1 && this.getFenceBasesStored() + 1 <= 256);
	}

	public boolean canCraftGrid() {
		return (this.slots[0] != (ItemStack) null && this.slots[1] != (ItemStack) null && this.slots[0].stackSize - 1 > -1 && this.slots[1].stackSize - 3 > -1 && this.getFenceGridsStored() + 1 <= 256);
	}

	public boolean canCraftPole() {
		return (this.slots[0] != (ItemStack) null && this.slots[1] != (ItemStack) null && this.slots[0].stackSize - 6 > -1 && this.slots[1].stackSize - 4 > -1 && this.getFencePolesStored() + 1 <= 256);
	}

	public void tryToIncreaseFenceBases() {
		if (this.canCraftBase()) {
			this.setFenceBasesStored((short) (this.getFenceBasesStored() + 1));
			this.slots[0].stackSize = this.slots[0].stackSize - 8;
			if (this.slots[0].stackSize < 1) {
				this.slots[0] = (ItemStack) null;
			}
		}
	}

	public void tryToIncreaseFenceGrids() {
		if (this.canCraftGrid()) {
			this.setFenceGridsStored((short) (this.getFenceGridsStored() + 1));
			this.slots[0].stackSize = this.slots[0].stackSize - 1;
			if (this.slots[0].stackSize < 1) {
				this.slots[0] = (ItemStack) null;
			}
			this.slots[1].stackSize = this.slots[1].stackSize - 3;
			if (this.slots[1].stackSize < 1) {
				this.slots[1] = (ItemStack) null;
			}
		}
	}

	public void tryToIncreaseFencePoles() {
		if (this.canCraftPole()) {
			this.setFencePolesStored((short) (this.getFencePolesStored() + 1));
			this.slots[0].stackSize = this.slots[0].stackSize - 6;
			if (this.slots[0].stackSize < 1) {
				this.slots[0] = (ItemStack) null;
			}
			this.slots[1].stackSize = this.slots[1].stackSize - 4;
			if (this.slots[1].stackSize < 1) {
				this.slots[1] = (ItemStack) null;
			}
		}
	}

	private boolean hasSecurityFencePoleAt(World world, int x, int y, int z) {
		return world.getBlock(x, y, z) instanceof IFencePole;
	}

	private boolean hasSecurityFenceGridAt(World world, int x, int y, int z) {
		return world.getBlock(x, y, z) instanceof IFenceGrid;
	}

	private boolean hasSecurityFenceBaseAt(World world, int x, int y, int z) {
		return world.getBlock(x, y, z) instanceof IFenceBase;
	}

	public int calculateDistanceToNextPole(int direction) {
		switch (direction) {
		/** South */
			case 0:
				for (int i = 1; i < 12; i++) {
					if (this.hasSecurityFenceMainBlockAt(this.worldObj, this.xCoord, this.yCoord, this.zCoord + i))
						return (int) i;
				}
				break;
			/** West */
			case 1:
				for (int i = 1; i < 12; i++) {
					if (this.hasSecurityFenceMainBlockAt(this.worldObj, this.xCoord - i, this.yCoord, this.zCoord))
						return (int) i;
				}
				break;
			/** North */
			case 2:
				for (int i = 1; i < 12; i++) {
					if (this.hasSecurityFenceMainBlockAt(this.worldObj, this.xCoord, this.yCoord, this.zCoord - i))
						return (int) i;
				}
				break;
			/** East */
			case 3:
				for (int i = 1; i < 12; i++) {
					if (this.hasSecurityFenceMainBlockAt(this.worldObj, this.xCoord + i, this.yCoord, this.zCoord))
						return (int) i;
				}
				break;
		}
		return 0;
	}

	/** Returns the height of the pole connected to this block. */
	public int calculateHeighOfThePole() {
		int numberOfBlocks = 0;
		while (this.hasSecurityFencePoleAt(this.worldObj, this.xCoord, this.yCoord + numberOfBlocks + 1, this.zCoord)) {
			numberOfBlocks++;
		}
		return numberOfBlocks;
	}

	/**
	 * Remove all blocks at a certain direction and between two fence poles at a
	 * specific height relative to the fence main block.
	 */
	public void breakFenceLineAt(byte direction, int height) {
		int lineSize = this.calculateDistanceToNextPole(direction);
		switch (direction) {
		/** South */
			case 0:
				for (int i = 1; i < lineSize; i++) {
					if (this.worldObj.getTileEntity(this.xCoord, this.yCoord + height, this.zCoord + i) != (TileEntity) null) {
						this.worldObj.removeTileEntity(this.xCoord, this.yCoord + height, this.zCoord + i);
					}
					this.worldObj.setBlockToAir(this.xCoord, this.yCoord + height, this.zCoord + i);
				}
				break;
			/** West */
			case 1:
				for (int i = 1; i < lineSize; i++) {
					if (this.worldObj.getTileEntity(this.xCoord - i, this.yCoord + height, this.zCoord) != (TileEntity) null) {
						this.worldObj.removeTileEntity(this.xCoord - i, this.yCoord + height, this.zCoord);
					}
					this.worldObj.setBlockToAir(this.xCoord - i, this.yCoord + height, this.zCoord);
				}
				break;
			/** North */
			case 2:
				for (int i = 1; i < lineSize; i++) {
					if (this.worldObj.getTileEntity(this.xCoord, this.yCoord + height, this.zCoord - i) != (TileEntity) null) {
						this.worldObj.removeTileEntity(this.xCoord, this.yCoord + height, this.zCoord - i);
					}
					this.worldObj.setBlockToAir(this.xCoord, this.yCoord + height, this.zCoord - i);
				}
				break;
			/** East */
			case 3:
				for (int i = 1; i < lineSize; i++) {
					if (this.worldObj.getTileEntity(this.xCoord + i, this.yCoord + height, this.zCoord) != (TileEntity) null) {
						this.worldObj.removeTileEntity(this.xCoord + i, this.yCoord + height, this.zCoord);
					}
					this.worldObj.setBlockToAir(this.xCoord + i, this.yCoord + height, this.zCoord);
				}
				break;
		}
	}

	@Override
	public void updateEntity() {

	}

	public HashMap<Integer, int[]> getAllMainBlocks() {
		HashMap<Integer, int[]> map = new HashMap<Integer, int[]>();
		int numberOfBlocks = 0;
		for (int i = -11; i < 12; i++) {
			for (int k = -11; k < 12; k++) {
				if (this.hasSecurityFenceMainBlockAt(this.worldObj, this.xCoord + i, this.yCoord, this.zCoord + k)) {
					map.put(numberOfBlocks, new int[] { i, k });
					numberOfBlocks++;
				}
			}
		}
		return map;
	}

	public TileSecurityFence getNextFence(World world, int x, int y, int z, int direction, int distance) {
		TileEntity tileEntity = (TileEntity) null;
		switch (direction) {
			case 0:
				tileEntity = world.getTileEntity(x, y, z + distance);
				break;
			case 1:
				tileEntity = world.getTileEntity(x - distance, y, z);
				break;
			case 2:
				tileEntity = world.getTileEntity(x, y, z - distance);
				break;
			case 3:
				tileEntity = world.getTileEntity(x + distance, y, z);
				break;
		}
		return (TileSecurityFence) tileEntity;
	}

	public int[] getBlocksToRepair(int securityLevel, int direction, int distance) {
		int[] brokenBlocks = new int[3];
		int height = 0;
		switch (securityLevel) {
			case 1:
				height = 2;
				break;
			case 2:
				height = 3;
				break;
			case 3:
				height = 5;
				break;
		}
		switch (direction) {
			case 0:
				for (int i = 1; i < distance; i++) {
					if (!this.hasSecurityFenceBaseAt(this.worldObj, this.xCoord, this.yCoord, this.zCoord + i))
						brokenBlocks[0]++;
				}
				for (int i = 1; i < distance; i++) {
					for (int j = 1; j <= height; j++) {
						if (!this.hasSecurityFenceGridAt(this.worldObj, this.xCoord, this.yCoord + j, this.zCoord + i))
							brokenBlocks[1]++;
					}
				}
				for (int j = 1; j <= height; j++) {
					if (!this.hasSecurityFencePoleAt(this.worldObj, this.xCoord, this.yCoord + j, this.zCoord))
						brokenBlocks[2]++;
					if (!this.hasSecurityFencePoleAt(this.worldObj, this.xCoord, this.yCoord + j, this.zCoord + distance))
						brokenBlocks[2]++;
				}
				break;
			case 1:
				for (int i = 1; i < distance; i++) {
					if (!this.hasSecurityFenceBaseAt(this.worldObj, this.xCoord - 1, this.yCoord, this.zCoord))
						brokenBlocks[0]++;
				}
				for (int i = 1; i < distance; i++) {
					for (int j = 1; j <= height; j++) {
						if (!this.hasSecurityFenceGridAt(this.worldObj, this.xCoord - 1, this.yCoord + j, this.zCoord))
							brokenBlocks[1]++;
					}
				}
				for (int j = 1; j <= height; j++) {
					if (!this.hasSecurityFencePoleAt(this.worldObj, this.xCoord, this.yCoord + j, this.zCoord))
						brokenBlocks[2]++;
					if (!this.hasSecurityFencePoleAt(this.worldObj, this.xCoord - distance, this.yCoord + j, this.zCoord))
						brokenBlocks[2]++;
				}
				break;
			case 2:
				for (int i = 1; i < distance; i++) {
					if (!this.hasSecurityFenceBaseAt(this.worldObj, this.xCoord, this.yCoord, this.zCoord - i))
						brokenBlocks[0]++;
				}
				for (int i = 1; i < distance; i++) {
					for (int j = 1; j <= height; j++) {
						if (!this.hasSecurityFenceGridAt(this.worldObj, this.xCoord, this.yCoord + j, this.zCoord - i))
							brokenBlocks[1]++;
					}
				}
				for (int j = 1; j <= height; j++) {
					if (!this.hasSecurityFencePoleAt(this.worldObj, this.xCoord, this.yCoord + j, this.zCoord))
						brokenBlocks[2]++;
					if (!this.hasSecurityFencePoleAt(this.worldObj, this.xCoord, this.yCoord + j, this.zCoord - distance))
						brokenBlocks[2]++;
				}
				break;
			case 3:
				for (int i = 1; i < distance; i++) {
					if (!this.hasSecurityFenceBaseAt(this.worldObj, this.xCoord + 1, this.yCoord, this.zCoord))
						brokenBlocks[0]++;
				}
				for (int i = 1; i < distance; i++) {
					for (int j = 1; j <= height; j++) {
						if (!this.hasSecurityFenceGridAt(this.worldObj, this.xCoord + 1, this.yCoord + j, this.zCoord))
							brokenBlocks[1]++;
					}
				}
				for (int j = 1; j <= height; j++) {
					if (!this.hasSecurityFencePoleAt(this.worldObj, this.xCoord, this.yCoord + j, this.zCoord))
						brokenBlocks[2]++;
					if (!this.hasSecurityFencePoleAt(this.worldObj, this.xCoord + distance, this.yCoord + j, this.zCoord))
						brokenBlocks[2]++;
				}
				break;
		}
		return brokenBlocks;
	}

	/**
	 * Returns true if there is the required structure to build or upgrade the
	 * security fence.
	 */
	public boolean hasRequiredStructure(int securityLevel, int direction, int distance) {
		switch (direction) {
		/** South */
			case 0:
				switch (securityLevel) {
					case 0:
						if (!this.hasSecurityFenceMainBlockAt(this.worldObj, this.xCoord, this.yCoord, this.zCoord))
							return false;
						if (!this.hasSecurityFenceMainBlockAt(this.worldObj, this.xCoord, this.yCoord, this.zCoord + distance))
							return false;
						for (int j = 1; j <= 2; j++) {
							if (!this.worldObj.isAirBlock(this.xCoord, this.yCoord + j, this.zCoord) && !this.hasSecurityFencePoleAt(this.worldObj, this.xCoord, this.yCoord + j, this.zCoord))
								return false;
							if (!this.worldObj.isAirBlock(this.xCoord, this.yCoord + j, this.zCoord + distance) && !this.hasSecurityFencePoleAt(this.worldObj, this.xCoord, this.yCoord + j, this.zCoord + distance))
								return false;
						}
						for (int j = 0; j <= 2; j++) {
							for (int k = 1; k < distance - 1; k++) {
								if (!this.worldObj.isAirBlock(this.xCoord, this.yCoord + j, this.zCoord + k))
									return false;
							}
						}
						return true;
					case 1:
						if (!this.hasSecurityFenceMainBlockAt(this.worldObj, this.xCoord, this.yCoord, this.zCoord))
							return false;
						if (!this.hasSecurityFenceMainBlockAt(this.worldObj, this.xCoord, this.yCoord, this.zCoord + distance))
							return false;
						if (!this.worldObj.isAirBlock(this.xCoord, this.yCoord + 3, this.zCoord) && !this.hasSecurityFencePoleAt(this.worldObj, this.xCoord, this.yCoord + 3, this.zCoord))
							return false;
						if (!this.worldObj.isAirBlock(this.xCoord, this.yCoord + 3, this.zCoord + distance) && !this.hasSecurityFencePoleAt(this.worldObj, this.xCoord, this.yCoord + 3, this.zCoord + distance))
							return false;
						for (int k = 1; k < distance - 1; k++) {
							if (!this.hasSecurityFenceBaseAt(this.worldObj, this.xCoord, this.yCoord, this.zCoord + k))
								return false;
						}
						for (int j = 1; j <= 2; j++) {
							for (int k = 1; k < distance - 1; k++) {
								if (!this.hasSecurityFenceGridAt(this.worldObj, this.xCoord, this.yCoord + j, this.zCoord + k))
									return false;
							}
						}
						for (int k = 1; k < distance - 1; k++) {
							if (!this.worldObj.isAirBlock(this.xCoord, this.yCoord + 3, this.zCoord + k))
								return false;
						}
						return true;
					case 2:
						if (!this.hasSecurityFenceMainBlockAt(this.worldObj, this.xCoord, this.yCoord, this.zCoord))
							return false;
						if (!this.hasSecurityFenceMainBlockAt(this.worldObj, this.xCoord, this.yCoord, this.zCoord + distance))
							return false;
						if (!this.worldObj.isAirBlock(this.xCoord, this.yCoord + 4, this.zCoord) && !this.hasSecurityFencePoleAt(this.worldObj, this.xCoord, this.yCoord + 4, this.zCoord))
							return false;
						if (!this.worldObj.isAirBlock(this.xCoord, this.yCoord + 5, this.zCoord) && !this.hasSecurityFencePoleAt(this.worldObj, this.xCoord, this.yCoord + 5, this.zCoord))
							return false;
						if (!this.worldObj.isAirBlock(this.xCoord, this.yCoord + 4, this.zCoord + distance) && !this.hasSecurityFencePoleAt(this.worldObj, this.xCoord, this.yCoord + 4, this.zCoord + distance))
							return false;
						if (!this.worldObj.isAirBlock(this.xCoord, this.yCoord + 5, this.zCoord + distance) && !this.hasSecurityFencePoleAt(this.worldObj, this.xCoord, this.yCoord + 5, this.zCoord + distance))
							return false;
						for (int k = 1; k < distance - 1; k++) {
							if (!this.hasSecurityFenceBaseAt(this.worldObj, this.xCoord, this.yCoord, this.zCoord + k))
								return false;
						}
						for (int j = 1; j <= 3; j++) {
							for (int k = 1; k < distance - 1; k++) {
								if (!this.hasSecurityFenceGridAt(this.worldObj, this.xCoord, this.yCoord + j, this.zCoord + k))
									return false;
							}
						}
						for (int j = 4; j <= 5; j++) {
							for (int k = 1; k < distance - 1; k++) {
								if (!this.worldObj.isAirBlock(this.xCoord, this.yCoord + j, this.zCoord + k))
									return false;
							}
						}
						return true;
					default:
						return false;
				}
				/** West */
			case 1:
				switch (securityLevel) {
					case 0:
						if (!this.hasSecurityFenceMainBlockAt(this.worldObj, this.xCoord, this.yCoord, this.zCoord))
							return false;
						if (!this.hasSecurityFenceMainBlockAt(this.worldObj, this.xCoord - distance, this.yCoord, this.zCoord))
							return false;
						for (int j = 1; j <= 2; j++) {
							if (!this.worldObj.isAirBlock(this.xCoord, this.yCoord + j, this.zCoord) && !this.hasSecurityFencePoleAt(this.worldObj, this.xCoord, this.yCoord + j, this.zCoord))
								return false;
							if (!this.worldObj.isAirBlock(this.xCoord - distance, this.yCoord + j, this.zCoord) && !this.hasSecurityFencePoleAt(this.worldObj, this.xCoord - distance, this.yCoord + j, this.zCoord))
								return false;
						}
						for (int i = 1; i < distance - 1; i++) {
							for (int j = 0; j <= 2; j++) {
								if (!this.worldObj.isAirBlock(this.xCoord - i, this.yCoord + j, this.zCoord))
									return false;
							}
						}
						return true;
					case 1:
						if (!this.hasSecurityFenceMainBlockAt(this.worldObj, this.xCoord, this.yCoord, this.zCoord))
							return false;
						if (!this.hasSecurityFenceMainBlockAt(this.worldObj, this.xCoord - distance, this.yCoord, this.zCoord))
							return false;
						if (!this.worldObj.isAirBlock(this.xCoord, this.yCoord + 3, this.zCoord) && !this.hasSecurityFencePoleAt(this.worldObj, this.xCoord, this.yCoord + 3, this.zCoord))
							return false;
						if (!this.worldObj.isAirBlock(this.xCoord - distance, this.yCoord + 3, this.zCoord) && !this.hasSecurityFencePoleAt(this.worldObj, this.xCoord - distance, this.yCoord + 3, this.zCoord))
							return false;
						for (int i = 1; i < distance - 1; i++) {
							if (!this.hasSecurityFenceBaseAt(this.worldObj, this.xCoord - i, this.yCoord, this.zCoord))
								return false;
						}
						for (int i = 1; i < distance - 1; i++) {
							for (int j = 1; j <= 2; j++) {
								if (!this.hasSecurityFenceGridAt(this.worldObj, this.xCoord - i, this.yCoord + j, this.zCoord))
									return false;
							}
						}
						for (int i = 1; i < distance - 1; i++) {
							if (!this.worldObj.isAirBlock(this.xCoord - i, this.yCoord + 3, this.zCoord))
								return false;
						}
						return true;
					case 2:
						if (!this.hasSecurityFenceMainBlockAt(this.worldObj, this.xCoord, this.yCoord, this.zCoord))
							return false;
						if (!this.hasSecurityFenceMainBlockAt(this.worldObj, this.xCoord - distance, this.yCoord, this.zCoord))
							return false;
						if (!this.worldObj.isAirBlock(this.xCoord, this.yCoord + 4, this.zCoord) && !this.hasSecurityFencePoleAt(this.worldObj, this.xCoord, this.yCoord + 4, this.zCoord))
							return false;
						if (!this.worldObj.isAirBlock(this.xCoord, this.yCoord + 5, this.zCoord) && !this.hasSecurityFencePoleAt(this.worldObj, this.xCoord, this.yCoord + 5, this.zCoord))
							return false;
						if (!this.worldObj.isAirBlock(this.xCoord - distance, this.yCoord + 4, this.zCoord) && !this.hasSecurityFencePoleAt(this.worldObj, this.xCoord - distance, this.yCoord + 4, this.zCoord))
							return false;
						if (!this.worldObj.isAirBlock(this.xCoord - distance, this.yCoord + 5, this.zCoord) && !this.hasSecurityFencePoleAt(this.worldObj, this.xCoord - distance, this.yCoord + 5, this.zCoord))
							return false;
						for (int i = 1; i < distance - 1; i++) {
							if (!this.hasSecurityFenceBaseAt(this.worldObj, this.xCoord - i, this.yCoord, this.zCoord))
								return false;
						}
						for (int j = 1; j <= 3; j++) {
							for (int i = 1; i < distance - 1; i++) {
								if (!this.hasSecurityFenceGridAt(this.worldObj, this.xCoord - i, this.yCoord + j, this.zCoord))
									return false;
							}
						}
						for (int j = 4; j <= 5; j++) {
							for (int i = 1; i < distance - 1; i++) {
								if (!this.worldObj.isAirBlock(this.xCoord - i, this.yCoord + j, this.zCoord))
									return false;
							}
						}
						return true;
					default:
						return false;
				}
				/** North */
			case 2:
				switch (securityLevel) {
					case 0:
						if (!this.hasSecurityFenceMainBlockAt(this.worldObj, this.xCoord, this.yCoord, this.zCoord))
							return false;
						if (!this.hasSecurityFenceMainBlockAt(this.worldObj, this.xCoord, this.yCoord, this.zCoord - distance))
							return false;
						for (int j = 1; j <= 2; j++) {
							if (!this.worldObj.isAirBlock(this.xCoord, this.yCoord + j, this.zCoord) && !this.hasSecurityFencePoleAt(this.worldObj, this.xCoord, this.yCoord + j, this.zCoord))
								return false;
							if (!this.worldObj.isAirBlock(this.xCoord, this.yCoord + j, this.zCoord - distance) && !this.hasSecurityFencePoleAt(this.worldObj, this.xCoord, this.yCoord + j, this.zCoord - distance))
								return false;
						}
						for (int j = 0; j <= 2; j++) {
							for (int k = 1; k < distance - 1; k++) {
								if (!this.worldObj.isAirBlock(this.xCoord, this.yCoord + j, this.zCoord - k))
									return false;
							}
						}
						return true;
					case 1:
						if (!this.hasSecurityFenceMainBlockAt(this.worldObj, this.xCoord, this.yCoord, this.zCoord))
							return false;
						if (!this.hasSecurityFenceMainBlockAt(this.worldObj, this.xCoord, this.yCoord, this.zCoord - distance))
							return false;
						if (!this.worldObj.isAirBlock(this.xCoord, this.yCoord + 3, this.zCoord) && !this.hasSecurityFencePoleAt(this.worldObj, this.xCoord, this.yCoord + 3, this.zCoord))
							return false;
						if (!this.worldObj.isAirBlock(this.xCoord, this.yCoord + 3, this.zCoord - distance) && !this.hasSecurityFencePoleAt(this.worldObj, this.xCoord, this.yCoord + 3, this.zCoord - distance))
							return false;
						for (int k = 1; k < distance - 1; k++) {
							if (!this.hasSecurityFenceBaseAt(this.worldObj, this.xCoord, this.yCoord, this.zCoord - k))
								return false;
						}
						for (int j = 1; j <= 2; j++) {
							for (int k = 1; k < distance - 1; k++) {
								if (!this.hasSecurityFenceGridAt(this.worldObj, this.xCoord, this.yCoord + j, this.zCoord - k))
									return false;
							}
						}
						for (int k = 1; k < distance - 1; k++) {
							if (!this.worldObj.isAirBlock(this.xCoord, this.yCoord + 3, this.zCoord - k))
								return false;
						}
						return true;
					case 2:
						if (!this.hasSecurityFenceMainBlockAt(this.worldObj, this.xCoord, this.yCoord, this.zCoord))
							return false;
						if (!this.hasSecurityFenceMainBlockAt(this.worldObj, this.xCoord, this.yCoord, this.zCoord - distance))
							return false;
						if (!this.worldObj.isAirBlock(this.xCoord, this.yCoord + 4, this.zCoord) && !this.hasSecurityFencePoleAt(this.worldObj, this.xCoord, this.yCoord + 4, this.zCoord))
							return false;
						if (!this.worldObj.isAirBlock(this.xCoord, this.yCoord + 5, this.zCoord) && !this.hasSecurityFencePoleAt(this.worldObj, this.xCoord, this.yCoord + 5, this.zCoord))
							return false;
						if (!this.worldObj.isAirBlock(this.xCoord, this.yCoord + 4, this.zCoord - distance) && !this.hasSecurityFencePoleAt(this.worldObj, this.xCoord, this.yCoord + 4, this.zCoord - distance))
							return false;
						if (!this.worldObj.isAirBlock(this.xCoord, this.yCoord + 5, this.zCoord - distance) && !this.hasSecurityFencePoleAt(this.worldObj, this.xCoord, this.yCoord + 5, this.zCoord - distance))
							return false;
						for (int k = 1; k < distance - 1; k++) {
							if (!this.hasSecurityFenceBaseAt(this.worldObj, this.xCoord, this.yCoord, this.zCoord - k))
								return false;
						}
						for (int j = 1; j <= 3; j++) {
							for (int k = 1; k < distance - 1; k++) {
								if (!this.hasSecurityFenceGridAt(this.worldObj, this.xCoord, this.yCoord + j, this.zCoord - k))
									return false;
							}
						}
						for (int j = 4; j <= 5; j++) {
							for (int k = 1; k < distance - 1; k++) {
								if (!this.worldObj.isAirBlock(this.xCoord, this.yCoord + j, this.zCoord - k))
									return false;
							}
						}
						return true;
					default:
						return false;
				}
				/** East */
			case 3:
				switch (securityLevel) {
					case 0:
						if (!this.hasSecurityFenceMainBlockAt(this.worldObj, this.xCoord, this.yCoord, this.zCoord))
							return false;
						if (!this.hasSecurityFenceMainBlockAt(this.worldObj, this.xCoord + distance, this.yCoord, this.zCoord))
							return false;
						for (int j = 1; j <= 2; j++) {
							if (!this.worldObj.isAirBlock(this.xCoord, this.yCoord + j, this.zCoord) && !this.hasSecurityFencePoleAt(this.worldObj, this.xCoord, this.yCoord + j, this.zCoord))
								return false;
							if (!this.worldObj.isAirBlock(this.xCoord + distance, this.yCoord + j, this.zCoord) && !this.hasSecurityFencePoleAt(this.worldObj, this.xCoord + distance, this.yCoord + j, this.zCoord))
								return false;
						}
						for (int i = 1; i < distance - 1; i++) {
							for (int j = 0; j <= 2; j++) {
								if (!this.worldObj.isAirBlock(this.xCoord + i, this.yCoord + j, this.zCoord))
									return false;
							}
						}
						return true;
					case 1:
						if (!this.hasSecurityFenceMainBlockAt(this.worldObj, this.xCoord, this.yCoord, this.zCoord))
							return false;
						if (!this.hasSecurityFenceMainBlockAt(this.worldObj, this.xCoord + distance, this.yCoord, this.zCoord))
							return false;
						if (!this.worldObj.isAirBlock(this.xCoord, this.yCoord + 3, this.zCoord) && !this.hasSecurityFencePoleAt(this.worldObj, this.xCoord, this.yCoord + 3, this.zCoord))
							return false;
						if (!this.worldObj.isAirBlock(this.xCoord + distance, this.yCoord + 3, this.zCoord) && !this.hasSecurityFencePoleAt(this.worldObj, this.xCoord + distance, this.yCoord + 3, this.zCoord))
							return false;
						for (int i = 1; i < distance - 1; i++) {
							if (!this.hasSecurityFenceBaseAt(this.worldObj, this.xCoord + i, this.yCoord, this.zCoord))
								return false;
						}
						for (int i = 1; i < distance - 1; i++) {
							for (int j = 1; j <= 2; j++) {
								if (!this.hasSecurityFenceGridAt(this.worldObj, this.xCoord + i, this.yCoord + j, this.zCoord))
									return false;
							}
						}
						for (int i = 1; i < distance - 1; i++) {
							if (!this.worldObj.isAirBlock(this.xCoord + i, this.yCoord + 3, this.zCoord))
								return false;
						}
						return true;
					case 2:
						if (!this.hasSecurityFenceMainBlockAt(this.worldObj, this.xCoord, this.yCoord, this.zCoord))
							return false;
						if (!this.hasSecurityFenceMainBlockAt(this.worldObj, this.xCoord + distance, this.yCoord, this.zCoord))
							return false;
						if (!this.worldObj.isAirBlock(this.xCoord, this.yCoord + 4, this.zCoord) && !this.hasSecurityFencePoleAt(this.worldObj, this.xCoord, this.yCoord + 4, this.zCoord))
							return false;
						if (!this.worldObj.isAirBlock(this.xCoord, this.yCoord + 5, this.zCoord) && !this.hasSecurityFencePoleAt(this.worldObj, this.xCoord, this.yCoord + 5, this.zCoord))
							return false;
						if (!this.worldObj.isAirBlock(this.xCoord + distance, this.yCoord + 4, this.zCoord) && !this.hasSecurityFencePoleAt(this.worldObj, this.xCoord + distance, this.yCoord + 4, this.zCoord))
							return false;
						if (!this.worldObj.isAirBlock(this.xCoord + distance, this.yCoord + 5, this.zCoord) && !this.hasSecurityFencePoleAt(this.worldObj, this.xCoord + distance, this.yCoord + 5, this.zCoord))
							return false;
						for (int i = 1; i < distance - 1; i++) {
							if (!this.hasSecurityFenceBaseAt(this.worldObj, this.xCoord + i, this.yCoord, this.zCoord))
								return false;
						}
						for (int j = 1; j <= 3; j++) {
							for (int i = 1; i < distance - 1; i++) {
								if (!this.hasSecurityFenceGridAt(this.worldObj, this.xCoord + i, this.yCoord + j, this.zCoord))
									return false;
							}
						}
						for (int j = 4; j <= 5; j++) {
							for (int i = 1; i < distance - 1; i++) {
								if (!this.worldObj.isAirBlock(this.xCoord + i, this.yCoord + j, this.zCoord))
									return false;
							}
						}
						return true;
					default:
						return false;
				}
				/** Error! */
			default:
				return false;
		}
	}

	private void placeFenceBlocks(World world, int security, int direction, int distance, int height, int x, int y, int z) {
		Block fenceBase = Blocks.air;
		Block fenceGrid = Blocks.air;
		Block fencePole = Blocks.air;
		int blockMetadata = 0;
		switch (security) {
			case 0:
				fenceBase = ModBlocks.securityFenceLowBase;
				fenceGrid = ModBlocks.securityFenceLowFence;
				fencePole = ModBlocks.securityFenceLowPole;
				break;
			case 1:
				fenceBase = ModBlocks.securityFenceMediumBase;
				fenceGrid = ModBlocks.securityFenceMediumFence;
				fencePole = ModBlocks.securityFenceMediumPole;
				break;
			case 2:
				fenceBase = ModBlocks.securityFenceHighBase;
				fenceGrid = ModBlocks.securityFenceHighFence;
				fencePole = ModBlocks.securityFenceHighPole;
				break;
		}
		switch (direction) {
		/** South */
			case 0:
				blockMetadata = 3;
				for (int j = 1; j < height + 1; j++) {
					world.setBlockToAir(x, y + j, z);
					world.removeTileEntity(x, y + j, z);
					world.setBlock(x, y + j, z, fencePole, blockMetadata, 2);
					world.setBlockToAir(x, y + j, z + distance);
					world.removeTileEntity(x, y + j, z + distance);
					world.setBlock(x, y + j, z + distance, fencePole, blockMetadata, 2);
				}
				for (int k = 1; k < distance; k++) {
					world.setBlockToAir(x, y, z + k);
					world.removeTileEntity(x, y, z + k);
					world.setBlock(x, y, z + k, fenceBase, blockMetadata, 2);
				}
				for (int j = 1; j < height + 1; j++) {
					for (int k = 1; k < distance; k++) {
						world.setBlockToAir(x, y + j, z + k);
						world.removeTileEntity(x, y + j, z + k);
						world.setBlock(x, y + j, z + k, fenceGrid, blockMetadata, 2);
					}
				}
				return;
				/** West */
			case 1:
				blockMetadata = 0;
				for (int j = 1; j < height + 1; j++) {
					world.setBlockToAir(x, y + j, z);
					world.removeTileEntity(x, y + j, z);
					world.setBlock(x, y + j, z, fencePole, blockMetadata, 2);
					world.setBlockToAir(x - distance, y + j, z);
					world.removeTileEntity(x - distance, y + j, z);
					world.setBlock(x - distance, y + j, z, fencePole, blockMetadata, 2);
				}
				for (int i = 1; i < distance; i++) {
					world.setBlockToAir(x - i, y, z);
					world.removeTileEntity(x - i, y, z);
					world.setBlock(x - i, y, z, fenceBase, blockMetadata, 2);
				}
				for (int j = 1; j < height + 1; j++) {
					for (int i = 1; i < distance; i++) {
						world.setBlockToAir(x - i, y + j, z);
						world.removeTileEntity(x - i, y + j, z);
						world.setBlock(x - i, y + j, z, fenceGrid, blockMetadata, 2);
					}
				}
				return;
				/** North */
			case 2:
				blockMetadata = 1;
				for (int j = 1; j < height + 1; j++) {
					world.setBlockToAir(x, y + j, z);
					world.removeTileEntity(x, y + j, z);
					world.setBlock(x, y + j, z, fencePole, blockMetadata, 2);
					world.setBlockToAir(x, y + j, z - distance);
					world.removeTileEntity(x, y + j, z - distance);
					world.setBlock(x, y + j, z - distance, fencePole, blockMetadata, 2);
				}
				for (int k = 1; k < distance; k++) {
					world.setBlockToAir(x, y, z - k);
					world.removeTileEntity(x, y, z - k);
					world.setBlock(x, y, z - k, fenceBase, blockMetadata, 2);
				}
				for (int j = 1; j < height + 1; j++) {
					for (int k = 1; k < distance; k++) {
						world.setBlockToAir(x, y + j, z - k);
						world.removeTileEntity(x, y + j, z - k);
						world.setBlock(x, y + j, z - k, fenceGrid, blockMetadata, 2);
					}
				}
				return;
				/** East */
			case 3:
				blockMetadata = 2;
				for (int j = 1; j < height + 1; j++) {
					world.setBlockToAir(x, y + j, z);
					world.removeTileEntity(x, y + j, z);
					world.setBlock(x, y + j, z, fencePole, blockMetadata, 2);
					world.setBlockToAir(x + distance, y + j, z);
					world.removeTileEntity(x + distance, y + j, z);
					world.setBlock(x + distance, y + j, z, fencePole, blockMetadata, 2);
				}
				for (int i = 1; i < distance; i++) {
					world.setBlockToAir(x + i, y, z);
					world.removeTileEntity(x + i, y, z);
					world.setBlock(x + i, y, z, fenceBase, blockMetadata, 2);
				}
				for (int j = 1; j < height + 1; j++) {
					for (int i = 1; i < distance; i++) {
						world.setBlockToAir(x + i, y + j, z);
						world.removeTileEntity(x + i, y + j, z);
						world.setBlock(x + i, y + j, z, fenceGrid, blockMetadata, 2);
					}
				}
				return;
		}
		return;
	}

	private void consumeMaterialsAndSetFenceAsBuilt(TileSecurityFence nextFence, int security, int dir) {
		int prevMaterial = this.getFenceBasesStored();
		int requiredMaterial = this.getRequiredFenceBases(dir);
		this.setFenceBasesStored((short) (this.getFenceBasesStored() - requiredMaterial));
		if (this.getFenceBasesStored() <= 0) {
			this.setFenceBasesStored((short) 0);
			requiredMaterial = requiredMaterial - prevMaterial;
			nextFence.setFenceBasesStored((short) (nextFence.getFenceBasesStored() - requiredMaterial));
		}
		prevMaterial = this.getFenceGridsStored();
		requiredMaterial = this.getRequiredFenceGrids(security, dir);
		this.setFenceGridsStored((short) (this.getFenceGridsStored() - requiredMaterial));
		if (this.getFenceGridsStored() <= 0) {
			this.setFenceGridsStored((short) 0);
			requiredMaterial = requiredMaterial - prevMaterial;
			nextFence.setFenceGridsStored((short) (nextFence.getFenceGridsStored() - requiredMaterial));
		}
		prevMaterial = this.getFencePolesStored();
		requiredMaterial = this.getRequiredFencePoles(security);
		this.setFencePolesStored((short) (this.getFencePolesStored() - requiredMaterial));
		if (this.getFencePolesStored() <= 0) {
			this.setFencePolesStored((short) 0);
			requiredMaterial = requiredMaterial - prevMaterial;
			nextFence.setFencePolesStored((short) (nextFence.getFencePolesStored() - requiredMaterial));
		}
		switch (dir) {
			case 0:
				this.setSecurityLevel((byte) (security + 1), 0);
				nextFence.setSecurityLevel((byte) (security + 1), 2);
				break;
			case 1:
				this.setSecurityLevel((byte) (security + 1), 1);
				nextFence.setSecurityLevel((byte) (security + 1), 3);
				break;
			case 2:
				this.setSecurityLevel((byte) (security + 1), 2);
				nextFence.setSecurityLevel((byte) (security + 1), 0);
				break;
			case 3:
				this.setSecurityLevel((byte) (security + 1), 3);
				nextFence.setSecurityLevel((byte) (security + 1), 1);
				break;
		}
		this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
		nextFence.worldObj.markBlockForUpdate(nextFence.xCoord, nextFence.yCoord, nextFence.zCoord);
	}

	private void consumeMaterials(int bases, int grids, int poles) {
		this.setFenceBasesStored((short) (this.getFenceBasesStored() - bases));
		if (this.getFenceBasesStored() < 0) {
			this.setFenceBasesStored((short) 0);
		}
		this.setFenceGridsStored((short) (this.getFenceGridsStored() - grids));
		if (this.getFenceGridsStored() < 0) {
			this.setFenceGridsStored((short) 0);
		}
		this.setFencePolesStored((short) (this.getFencePolesStored() - poles));
		if (this.getFencePolesStored() < 0) {
			this.setFencePolesStored((short) 0);
		}
		this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
	}

	public boolean canBuildFence(int securityLV, int direction, int length, int height) {
		return (this.isSecurityLevelValid(securityLV) && this.isHeightValid(height) && this.isDistanceValid(length) && this.isFenceValid(direction, securityLV) && this.hasEnoughFenceBases(securityLV, direction) && this.hasEnoughFenceGrids(securityLV, direction)
				&& this.hasEnoughFencePoles(securityLV) && this.hasRequiredStructure(securityLV, direction, length));
	}

	public void tryToBuildFence(int security, int direction, int distance, int height) {
		if (!this.worldObj.isRemote) {
			if (this.canBuildFence(security, direction, distance, height)) {
				TileSecurityFence nextFence = this.getNextFence(this.worldObj, this.xCoord, this.yCoord, this.zCoord, direction, distance);
				this.placeFenceBlocks(this.worldObj, security, direction, distance, height, this.xCoord, this.yCoord, this.zCoord);
				this.consumeMaterialsAndSetFenceAsBuilt(nextFence, security, direction);
			}
		}
	}

	public void tryToFixFence(int security, int direction, int distance, int height, int bases, int grids, int poles) {
		if (!this.worldObj.isRemote) {
			this.placeFenceBlocks(this.worldObj, security, direction, distance, height, this.xCoord, this.yCoord, this.zCoord);
			this.consumeMaterials(bases, grids, poles);
		}
	}

	public boolean hasItems() {
		return this.slots[0] != null || this.slots[1] != null;
	}

	@Override
	public int getSizeInventory() {
		return slots.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return slots[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int stackSize) {
		if (this.slots[i] != null) {
			ItemStack splitedStack;
			if (this.slots[i].stackSize <= stackSize) {
				splitedStack = this.slots[i];
				this.slots[i] = null;
				return splitedStack;
			} else {
				splitedStack = this.slots[i].splitStack(stackSize);
				if (this.slots[i].stackSize == 0) {
					this.slots[i] = null;
				}
				return splitedStack;
			}
		} else {
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		if (this.slots[i] != null) {
			ItemStack itemStack = this.slots[i];
			this.slots[i] = null;
			return itemStack;
		} else {
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemStack) {
		this.slots[i] = itemStack;
		if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()) {
			itemStack.stackSize = this.getInventoryStackLimit();
		}
	}

	@Override
	public String getInventoryName() {
		return "Security Fence Base";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return true;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openInventory() {

	}

	@Override
	public void closeInventory() {

	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemStack) {
		return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int i) {
		return new int[] { 0 };
	}

	@Override
	public boolean canInsertItem(int i, ItemStack itemStack, int j) {
		return false;
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemStack, int j) {
		return false;
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		NBTTagList list = new NBTTagList();
		for (int i = 0; i < this.slots.length; i++) {
			if (this.slots[i] != null) {
				NBTTagCompound tagCompound = new NBTTagCompound();
				tagCompound.setByte("Slot", (byte) i);
				this.slots[i].writeToNBT(tagCompound);
				list.appendTag(tagCompound);
			}
		}
		compound.setTag("Items", list);
		compound.setByte("Direction", this.getDirection());
		compound.setByte("SecurityLevelSouth", this.getSecurityLevel(0));
		compound.setByte("SecurityLevelWest", this.getSecurityLevel(1));
		compound.setByte("SecurityLevelNorth", this.getSecurityLevel(2));
		compound.setByte("SecurityLevelEast", this.getSecurityLevel(3));
		compound.setShort("GridsStored", (short) this.getFenceGridsStored());
		compound.setShort("BasesStored", (short) this.getFenceBasesStored());
		compound.setShort("PolesStored", (short) this.getFencePolesStored());
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		NBTTagList list = compound.getTagList("Items", 10);
		this.slots = new ItemStack[this.getSizeInventory()];
		for (int i = 0; i < list.tagCount(); i++) {
			NBTTagCompound tagCompound = (NBTTagCompound) list.getCompoundTagAt(i);
			byte j = tagCompound.getByte("Slot");

			if (j >= 0 && j < this.slots.length) {
				this.slots[j] = ItemStack.loadItemStackFromNBT(tagCompound);
			}
		}
		this.setDirection(compound.getByte("Direction"));
		this.setSecurityLevel(compound.getByte("SecurityLevelSouth"), 0);
		this.setSecurityLevel(compound.getByte("SecurityLevelWest"), 1);
		this.setSecurityLevel(compound.getByte("SecurityLevelNorth"), 2);
		this.setSecurityLevel(compound.getByte("SecurityLevelEast"), 3);
		this.setFenceGridsStored(compound.getShort("GridsStored"));
		this.setFenceBasesStored(compound.getShort("BasesStored"));
		this.setFencePolesStored(compound.getShort("PolesStored"));
	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound compound = new NBTTagCompound();
		this.writeToNBT(compound);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, this.blockMetadata, compound);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
		NBTTagCompound compound = packet.func_148857_g();
		this.readFromNBT(compound);
	}
}