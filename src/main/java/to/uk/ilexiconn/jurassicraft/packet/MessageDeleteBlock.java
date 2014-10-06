package to.uk.ilexiconn.jurassicraft.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import to.uk.ilexiconn.jurassicraft.tile.TileSecurityFenceBase;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageDeleteBlock implements IMessage 
{

	private int xCoord;
	private int yCoord;
	private int zCoord;
	private int securityLevel;
	private int direction;

	public MessageDeleteBlock() 
	{

	}

	public MessageDeleteBlock(int xCoord, int yCoord, int zCoord, int securityLevel, int direction) 
	{
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.zCoord = zCoord;
		this.securityLevel = securityLevel;
		this.direction = direction;
	}

	@Override
	public void fromBytes(ByteBuf buf) 
	{
		xCoord = ByteBufUtils.readVarInt(buf, 5);
		yCoord = ByteBufUtils.readVarInt(buf, 5);
		zCoord = ByteBufUtils.readVarInt(buf, 5);
		securityLevel = ByteBufUtils.readVarInt(buf, 5);
		direction = ByteBufUtils.readVarInt(buf, 5);
	}

	@Override
	public void toBytes(ByteBuf buf) 
	{
		ByteBufUtils.writeVarInt(buf, xCoord, 5);
		ByteBufUtils.writeVarInt(buf, yCoord, 5);
		ByteBufUtils.writeVarInt(buf, zCoord, 5);
		ByteBufUtils.writeVarInt(buf, securityLevel, 5);
		ByteBufUtils.writeVarInt(buf, direction, 5);
	}

	public static class Handler implements IMessageHandler<MessageDeleteBlock, IMessage> 
	{
		@Override
		public IMessage onMessage(MessageDeleteBlock message, MessageContext ctx) 
		{
			if (ctx.getServerHandler().playerEntity != (EntityPlayer) null) 
			{
				if (!ctx.getServerHandler().playerEntity.worldObj.isRemote) 
				{
					TileEntity tileEntity = ctx.getServerHandler().playerEntity.worldObj.getTileEntity(message.xCoord, message.yCoord, message.zCoord);
					if (tileEntity instanceof TileSecurityFenceBase) 
					{
						TileSecurityFenceBase fence = (TileSecurityFenceBase) tileEntity;
						if (message.securityLevel >= 1 && message.securityLevel <= 3) 
						{
							if (message.direction == 0 || message.direction == 1) 
							{
								fence.tryToBuildFence(message.securityLevel, message.direction);
							}
						}
					}
				}
			}
			return null;
		}
	}
}
