package to.uk.ilexiconn.jurassicraft.entity.mammal;

import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import to.uk.ilexiconn.jurassicraft.item.ItemDinoPad;

public class JurassiCraftInteractEvent 
{
	public void onEntityInteract(EntityInteractEvent event) 
	{
		if (event.entity instanceof EntityPlayer) 
		{
			if (event.target != null) 
			{
				EntityPlayer player = (EntityPlayer) event.entity;
				ItemStack heldItem = player.getHeldItem();
				if (heldItem != (ItemStack) null && heldItem.getItem() instanceof ItemDinoPad) 
				{
					if (event.target instanceof EntityCow) {
						EntityPregnantCow cow = EntityPregnantCow.get((EntityCow) event.target);
						cow.showStatus();
					}
					
					/** Add more later! */
				}
			}
		}
		
	}
	
	
	
}