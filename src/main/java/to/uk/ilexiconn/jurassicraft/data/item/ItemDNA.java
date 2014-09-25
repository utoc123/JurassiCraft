package to.uk.ilexiconn.jurassicraft.data.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import to.uk.ilexiconn.jurassicraft.ModCreativeTabs;
import to.uk.ilexiconn.jurassicraft.Util;

import java.util.List;

public class ItemDNA extends Item implements AnyDNASample
{

    public ItemDNA(String name)
    {
        super();
        setUnlocalizedName(name + "_DNA");
        setTextureName(Util.getModId() + name + "_DNA");
        setCreativeTab(ModCreativeTabs.fossilTab);
    }

    public Item getCorrespondingEgg()
    {
        int id = Util.getDNAArray().lastIndexOf(this);
        if (Util.getEggArray().size() > id)
            if (Util.getEggArray().get(id) != null)
                return Util.getEggArray().get(id);
        return null;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack dnaSample, World world, EntityPlayer player)
    {
        if (player.capabilities.isCreativeMode && player.isSneaking())
        {
            NBTTagCompound compound = new NBTTagCompound();
            if (dnaSample.hasTagCompound())
            {
                int oldQuality = dnaSample.getTagCompound().getInteger("Quality");
                dnaSample.getTagCompound().removeTag("Quality");
                switch (oldQuality)
                {
                    case 25:
                        compound.setInteger("Quality", 50);
                        break;
                    case 50:
                        compound.setInteger("Quality", 75);
                        break;
                    case 75:
                        compound.setInteger("Quality", 100);
                        break;
                    case 100:
                        compound.setInteger("Quality", 25);
                        break;
                    default:
                        break;
                }
            }
            else
            {
                compound.setInteger("Quality", 25);
            }
            dnaSample.setTagCompound(compound);
            if (world.isRemote)
            {
                player.addChatMessage(new ChatComponentText("Cheater! New quality changed to " + dnaSample.getTagCompound().getInteger("Quality") + "%"));
            }
        }
        return dnaSample;
    }

    @Override
    public void setQuality(ItemStack dnaSample, int quality)
    {
        if (!dnaSample.hasTagCompound())
        {
            NBTTagCompound compound = new NBTTagCompound();
            compound.setInteger("Quality", quality);
            dnaSample.setTagCompound(compound);
        }
        else
        {
            if (dnaSample.getTagCompound().hasKey("Quality"))
            {
                dnaSample.getTagCompound().removeTag("Quality");
                NBTTagCompound compound = new NBTTagCompound();
                compound.setInteger("Quality", quality);
                dnaSample.setTagCompound(compound);
            }
        }
    }

    @Override
    public int getQuality(ItemStack dnaSample)
    {
        if (dnaSample.hasTagCompound())
        {
            if (dnaSample.getTagCompound().hasKey("Quality"))
            {
                return dnaSample.getTagCompound().getInteger("Quality");
            }
        }
        return 0;
    }

    @Override
    public void addInformation(ItemStack dnaSample, EntityPlayer player, List list, boolean flag)
    {
        if (dnaSample.hasTagCompound())
        {
            if (dnaSample.getTagCompound().hasKey("Quality"))
            {
                list.add(EnumChatFormatting.GREEN + "Quality " + dnaSample.getTagCompound().getString("Quality") + "%");
            }
        }
    }
}
