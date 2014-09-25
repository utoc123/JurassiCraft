package to.uk.ilexiconn.jurassicraft.data;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.Util;
import to.uk.ilexiconn.jurassicraft.data.block.BlockStuffFluid;
import to.uk.ilexiconn.jurassicraft.data.entity.entity.EntityDinoEgg;
import to.uk.ilexiconn.jurassicraft.data.gui.GuiHandler;
import to.uk.ilexiconn.jurassicraft.data.item.ItemAmber;
import to.uk.ilexiconn.jurassicraft.data.item.ItemDinoBone;
import to.uk.ilexiconn.jurassicraft.data.item.ItemFossil;
import to.uk.ilexiconn.jurassicraft.data.world.gen.WorldGenAmberOre;
import to.uk.ilexiconn.jurassicraft.data.world.gen.WorldGenFossilOre;

public final class Data extends Util
{
    public static Fluid fluid;
    public static Block stuffFluid;

    public void init()
    {
    	/** Items */
        { 
            addItem(1, new ItemAmber());
            addItem(2, new ItemFossil());
            addItem(3, new ItemDinoBone());
        }
        
    	/** Tile entities */
        { 
        }
        
    	/** World Generators */
        { 
            addWorldGenerator(new WorldGenFossilOre(), 1);
            addWorldGenerator(new WorldGenAmberOre(), 2);
        }
        
    	/** Other stuff */
        {
            addGuiHandler(new GuiHandler());
        }
        
        /** Entities */
        {
			EntityRegistry.registerModEntity(EntityDinoEgg.class, "dino_egg", Util.entityId, JurassiCraft.instance, 64, 1, true);
        }

        { /** Other test stuff */

            fluid = new Fluid("stuff").setLuminosity(5).setViscosity(1);
            FluidRegistry.registerFluid(fluid);

            stuffFluid = new BlockStuffFluid(fluid, Material.water).setBlockName("stuffBlock").setCreativeTab(null);
            GameRegistry.registerBlock(stuffFluid, "stuffFluid");

            fluid.setUnlocalizedName(stuffFluid.getUnlocalizedName());
        }
    }
}
