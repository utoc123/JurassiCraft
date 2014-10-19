package to.uk.ilexiconn.jurassicraft.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import to.uk.ilexiconn.jurassicraft.ModCreativeTabs;
import to.uk.ilexiconn.jurassicraft.Util;

public class ItemFossilModel extends Item {

	public ItemFossilModel(String fossilName) {
		super();
		this.setMaxStackSize(8);
		this.setUnlocalizedName(fossilName + "_Fossil");
		this.setTextureName(Util.getModId() + fossilName + "_Fossil");
		this.setCreativeTab(ModCreativeTabs.BLOCKS.getTab());
	}

	public int getFossil(ItemStack fossil) {
		if (fossil.hasTagCompound()) {
			if (fossil.getTagCompound().hasKey("FossilID")) {
				return fossil.getTagCompound().getInteger("FossilID");
			}
		}
		return 0;
	}

	@Override
	public void addInformation(ItemStack fossil, EntityPlayer player, List list, boolean flag) {
		if (fossil.hasTagCompound()) {
			if (fossil.getTagCompound().hasKey("FossilID")) {
				list.add(EnumChatFormatting.GREEN + String.valueOf(fossil.getTagCompound().getInteger("FossilID")));
			}
		}
	}

	@Override
	public ItemStack onItemRightClick(ItemStack fossil, World world, EntityPlayer player) {
		if (player.capabilities.isCreativeMode && player.isSneaking()) {
			if (fossil.hasTagCompound()) {
				if (fossil.getTagCompound().hasKey("FossilID")) {
					// PLACE
				}
			}
		}
		return fossil;
	}
}
