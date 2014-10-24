package to.uk.ilexiconn.jurassicraft.entity.mammal;

import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import to.uk.ilexiconn.jurassicraft.item.ItemDinoPad;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class JurassiCraftInteractEvent 
{

	@SubscribeEvent
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
						if (cow != null && cow.getMammalName() != "None" && cow.getMammalName() != "" && cow.getMammalName() != null) {
							cow.showStatus();
						}
					} else if (event.target instanceof EntityPig) {
						EntityPregnantPig pig = EntityPregnantPig.get((EntityPig) event.target);
						if (pig != null && pig.getMammalName() != "None" && pig.getMammalName() != "" && pig.getMammalName() != null) {
							pig.showStatus();
						}
					} else if (event.target instanceof EntityHorse) {
						EntityPregnantHorse horse = EntityPregnantHorse.get((EntityHorse) event.target);
						if (horse != null && horse.getMammalName() != "None" && horse.getMammalName() != "" && horse.getMammalName() != null) {
							horse.showStatus();
						}
					} else if (event.target instanceof EntitySheep) {
						EntityPregnantSheep sheep = EntityPregnantSheep.get((EntitySheep) event.target);
						if (sheep != null && sheep.getMammalName() != "None" && sheep.getMammalName() != "" && sheep.getMammalName() != null) {
							sheep.showStatus();
						}
					}
				}
			}
		}
		
	}
	
	
	
}