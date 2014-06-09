package com.ilexiconn.jurassicraft.data;

import com.ilexiconn.jurassicraft.Util;
import com.ilexiconn.jurassicraft.data.block.*;
import com.ilexiconn.jurassicraft.data.gui.GuiHandler;
import com.ilexiconn.jurassicraft.data.item.ItemAmber;
import com.ilexiconn.jurassicraft.data.item.ItemDNA;
import com.ilexiconn.jurassicraft.data.item.ItemFossil;
import com.ilexiconn.jurassicraft.data.item.ItemMeat;
import com.ilexiconn.jurassicraft.data.tile.TileAnalyzer;
import com.ilexiconn.jurassicraft.data.tile.TileCultivate;
import com.ilexiconn.jurassicraft.data.tile.render.CultivateRenderer;
import com.ilexiconn.jurassicraft.data.world.gen.WorldGenAmberOre;
import com.ilexiconn.jurassicraft.data.world.gen.WorldGenFossilOre;
import com.ilexiconn.jurassicraft.logger.LogType;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public final class Data extends Util
{
    public void init(FMLPreInitializationEvent event)
    {
        { /** Creativetabs */
            addCreativeTab(0, new CreativeTabs("fossilTab")
            {
                public Item getTabIconItem()
                {
                    return Items.arrow;
                }
            });
        }
        { /** Blocks */
            addBlockWithTileEntity(0, new BlockCultivate(true), TileCultivate.class, true);
            addBlockWithTileEntity(1, new BlockCultivate(false), TileCultivate.class, false);
            addBlockWithTileEntity(2, new BlockAnalyzer(true), TileAnalyzer.class, true);
            addBlockWithTileEntity(3, new BlockAnalyzer(false), TileAnalyzer.class, false);
            addBlock(4, new BlockAmberOre());
            addBlock(5, new BlockFossilOre());
            addBlock(6, new GhostBlock("cultivate_top", getBlock(1), 1f, new int[]{-1}, -1, 2, 0f, -1f, 0f, 1f, 1f, 1f));
        }
        { /** Items */
            addItem(1, new ItemAmber());
            addItem(2, new ItemFossil());
        }
        { /** Entities */
            for (String name : getDinos())
            {
                try
                {
                    Class<? extends EntityLiving> entity = (Class<? extends EntityLiving>) Class.forName("com.ilexiconn.jurassicraft.data.entity.Entity" + name);
                    RenderLiving renderer = (RenderLiving) Class.forName("com.ilexiconn.jurassicraft.data.entity.render.Render" + name).newInstance();

                    addEntity(entity, name, renderer, 0xffffff, 0xffffff);

                    addDNA(new ItemDNA(name));
                    addItem(-1, new ItemMeat(name));

                    getLogger().print(LogType.INFO, "Added the " + name + "!");
                } catch (Exception e)
                {
                    getLogger().print(LogType.ERROR, "Can't add the " + name + ", " + e);
                }
            }
        }
        { /** World Gens */
            addWorldGenerator(new WorldGenFossilOre(), 1);
            addWorldGenerator(new WorldGenAmberOre(), 2);
        }
        { /** Renderers */
            addTileEntityRenderer(TileCultivate.class, new CultivateRenderer());
            proxy.renderItems();
        }
        { /** Other stuff */
            addGuiHandler(new GuiHandler());
        }
    }
}
