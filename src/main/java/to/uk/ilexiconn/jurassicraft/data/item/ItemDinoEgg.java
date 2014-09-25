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
import to.uk.ilexiconn.jurassicraft.data.entity.entity.EntityDinoEgg;

import java.util.List;

public class ItemDinoEgg extends Item
{
    public String dinoName;

    public ItemDinoEgg(String dinoName)
    {
        super();
        this.setUnlocalizedName("egg_" + dinoName);
        this.setTextureName(Util.getModId() + "egg_" + dinoName);
        this.setCreativeTab(ModCreativeTabs.fossilTab);
        this.dinoName = dinoName;
    }

    public void setEggQuality(ItemStack egg, int quality)
    {
        if (!egg.hasTagCompound())
        {
            NBTTagCompound compound = new NBTTagCompound();
            compound.setInteger("EggQuality", quality);
            egg.setTagCompound(compound);
        }
        else
        {
            if (egg.getTagCompound().hasKey("EggQuality"))
            {
                egg.getTagCompound().removeTag("EggQuality");
                NBTTagCompound compound = new NBTTagCompound();
                compound.setInteger("EggQuality", quality);
                egg.setTagCompound(compound);
            }
        }
    }

    public int getEggQuality(ItemStack egg)
    {
        if (egg.hasTagCompound())
        {
            if (egg.getTagCompound().hasKey("EggQuality"))
            {
                return egg.getTagCompound().getInteger("EggQuality");
            }
        }
        System.out.println("Egg does not have quality");
        return 75;
    }

    @Override
    public void addInformation(ItemStack egg, EntityPlayer player, List list, boolean flag)
    {
        if (egg.hasTagCompound())
        {
            if (egg.getTagCompound().hasKey("EggQuality"))
            {
                list.add(EnumChatFormatting.GREEN + "Quality " + egg.getTagCompound().getString("EggQuality") + "%");
            }
        }
    }

    @Override
    public ItemStack onItemRightClick(ItemStack egg, World world, EntityPlayer player)
    {
        if (player.capabilities.isCreativeMode && player.isSneaking())
        {
            NBTTagCompound compound = new NBTTagCompound();
            if (egg.hasTagCompound())
            {
                int oldQuality = egg.getTagCompound().getInteger("EggQuality");
                egg.getTagCompound().removeTag("EggQuality");
                switch (oldQuality)
                {
                    case 25:
                        compound.setInteger("EggQuality", 50);
                        break;
                    case 50:
                        compound.setInteger("EggQuality", 75);
                        break;
                    case 75:
                        compound.setInteger("EggQuality", 100);
                        break;
                    case 100:
                        compound.setInteger("EggQuality", 25);
                        break;
                    default:
                        break;
                }
            }
            else
            {
                compound.setInteger("EggQuality", 25);
            }
            egg.setTagCompound(compound);
            if (world.isRemote)
            {
                player.addChatMessage(new ChatComponentText("Cheater! New quality changed to " + egg.getTagCompound().getInteger("EggQuality") + "%"));
            }
        }
        return egg;
    }

    /**
     * Callback for item usage. If the item does something special on right
     * clicking, he will have one of those. Return True if something happen and
     * false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float clickX, float clickY, float clickZ)
    {
        if (!world.isRemote && !player.capabilities.isCreativeMode)
        {
            world.spawnEntityInWorld(new EntityDinoEgg(world, dinoName, this.getEggQuality(stack), 2048, x, y + 1, z));
        }
        else if (!world.isRemote && !player.isSneaking())
        {
            world.spawnEntityInWorld(new EntityDinoEgg(world, dinoName, this.getEggQuality(stack), 2048, x, y + 1, z));
        }
        else
        {
            this.onItemRightClick(stack, world, player);
        }
        return true;
    }
}
