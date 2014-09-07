package to.uk.ilexiconn.jurassicraft.data.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.Util;
import to.uk.ilexiconn.jurassicraft.data.entity.entity.EntityDinoEgg;

public class ItemDinoEgg extends Item
{
	public String dinoName;
	
	public ItemDinoEgg(String dinoName)
	{
		super();
		this.setUnlocalizedName("egg_" + dinoName);
		this.setTextureName(Util.getModId() + "egg_" + dinoName);
		this.setCreativeTab(JurassiCraft.getCreativeTab(0));
		this.dinoName = dinoName;
	}
	
    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float clickX, float clickY, float clickZ)
    {
    	if(!world.isRemote)
    	{
        	world.spawnEntityInWorld(new EntityDinoEgg(world, dinoName, 2048, x, y+1, z));
    	}
    	
        return true;
    }
}
