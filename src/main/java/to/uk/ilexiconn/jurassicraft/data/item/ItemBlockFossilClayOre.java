package to.uk.ilexiconn.jurassicraft.data.item;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBlockFossilClayOre extends ItemBlock
{
    public static final String[] colors = {"", "brown", "orange", "red", "silver", "white", "yellow"};

    public ItemBlockFossilClayOre(Block block)
    {
        super(block);
        setHasSubtypes(true);
    }

    public String getItemStackDisplayName(ItemStack itemStack)
    {
        String name = "";
        if (!(colors[itemStack.getItemDamage()]).equals(""))
        {
            for (String item : colors[itemStack.getItemDamage()].replaceAll("_", " ").split(" "))
                name = name + String.valueOf(item.charAt(0)).toUpperCase() + item.substring(1) + " ";
            return name + "Stained Clay Fossil Ore";
        } else {
            return "Clay Fossil Ore";
        }
    }

    public int getMetadata(int meta)
    {
        return meta;
    }

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack)
    {
        world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z), 2);
    }
}
