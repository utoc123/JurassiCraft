package to.uk.ilexiconn.jurassicraft.data.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import to.uk.ilexiconn.jurassicraft.Util;

public class ItemDNA extends Item implements AnyDNASample {

	public ItemDNA(String name) {
		super();
		setUnlocalizedName(name + "_DNA");
		setTextureName(Util.getModId() + name + "_DNA");
		setCreativeTab(Util.getCreativeTab(0));
	}

	public Item getCorrespondingEgg() {
		int id = Util.getDNAArray().lastIndexOf(this);
		if (Util.getEggArray().size() > id)
			if (Util.getEggArray().get(id) != null)
				return Util.getEggArray().get(id);
		return null;
	}

	@Override
	public void setQuality(ItemStack dnaSample, int quality) {
		if (!dnaSample.hasTagCompound()) {
			NBTTagCompound compound = new NBTTagCompound();
			compound.setInteger("Quality", quality);
			dnaSample.setTagCompound(compound);
		} else {
			if (dnaSample.getTagCompound().hasKey("Quality")) {
				dnaSample.getTagCompound().removeTag("Quality");
				NBTTagCompound compound = new NBTTagCompound();
				compound.setInteger("Quality", quality);
				dnaSample.setTagCompound(compound);
			}
		}
	}

	@Override
	public int getQuality(ItemStack dnaSample) {
		if (dnaSample.hasTagCompound()) {
			if (dnaSample.getTagCompound().hasKey("Quality")) {
				return dnaSample.getTagCompound().getInteger("Quality");
			}
		}
		return 0;
	}

	@Override
	public void addInformation(ItemStack dnaSample, EntityPlayer player, List list, boolean flag) {
		if (dnaSample.hasTagCompound()) {
			if (dnaSample.getTagCompound().hasKey("Quality")) {
				list.add(EnumChatFormatting.GREEN + "Quality " + dnaSample.getTagCompound().getString("Quality") + "%");
			}
		}
	}
}
