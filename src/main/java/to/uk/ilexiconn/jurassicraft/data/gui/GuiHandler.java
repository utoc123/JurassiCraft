package to.uk.ilexiconn.jurassicraft.data.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import to.uk.ilexiconn.jurassicraft.data.gui.container.*;
import to.uk.ilexiconn.jurassicraft.data.tile.*;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		if (tileEntity instanceof TileDNAExtractor)
			return new ContainerDNAExtractor(player.inventory, (TileDNAExtractor) tileEntity);
		if (tileEntity instanceof TileCultivate && ID == 0)
			return new ContainerCultivate(player.inventory, (TileCultivate) tileEntity);
		if (tileEntity instanceof TileDNACombinator)
			return new ContainerDNACombinator(player.inventory, (TileDNACombinator) tileEntity);
		return null;
	}

	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		if (tileEntity instanceof TileDNAExtractor)
			return new GuiDNAExtractor(player.inventory, (TileDNAExtractor) tileEntity);
		if (tileEntity instanceof TileCultivate && ID == 0)
			return new GuiCultivate(player.inventory, (TileCultivate) tileEntity);
		if (tileEntity instanceof TileCultivate && ID == 1)
			return new GuiCultivateProcess((TileCultivate) tileEntity);
		if (tileEntity instanceof TileDNACombinator)
			return new GuiDNACombinator(player.inventory, (TileDNACombinator) tileEntity);
		return null;
	}
}
