package com.ilexiconn.jurassicraft;

import com.ilexiconn.jurassicraft.data.Data;
import com.ilexiconn.jurassicraft.data.Dinos;
import com.ilexiconn.jurassicraft.data.block.BlockEgg;
import com.ilexiconn.jurassicraft.data.item.ItemDNA;
import com.ilexiconn.jurassicraft.logger.Logger;
import com.ilexiconn.jurassicraft.proxy.ServerProxy;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;

import java.util.ArrayList;

public class Util
{
    /**
     * Stuff
     */
    private static final Logger logger = new Logger();
    private static final Data data = new Data();
    private static final Dinos dinos = new Dinos();
    @SidedProxy(clientSide = "com.ilexiconn.jurassicraft.proxy.ClientProxy", serverSide = "com.ilexiconn.jurassicraft.proxy.ServerProxy")
    public static ServerProxy proxy;
    private static CreativeTabs[] tabs = new CreativeTabs[512];
    private static Block[] blocks = new Block[512];
    private static Item[] items = new Item[512];
    private static ArrayList<ItemDNA> dnas = new ArrayList<ItemDNA>();
    private static ArrayList<BlockEgg> eggs = new ArrayList<BlockEgg>();

    /**
     * Getters
     */
    public static CreativeTabs getCreativeTab(int id)
    {
        return tabs[id];
    }

    public static Block getBlock(int id)
    {
        return blocks[id];
    }

    public static Item getItem(int id)
    {
        return items[id];
    }

    public static ArrayList<ItemDNA> getDNAArray()
    {
        return dnas;
    }

    public static ArrayList<BlockEgg> getEggArray()
    {
        return eggs;
    }

    public static String getModId()
    {
        return "jurassicraft:";
    }

    public static Logger getLogger()
    {
        return logger;
    }

    public static Data getData()
    {
        return data;
    }

    public static String[] getDinos()
    {
        return dinos.dinos;
    }

    /**
     * Adders
     */
    public void addCreativeTab(int id, CreativeTabs tab)
    {
        if (id != -1) tabs[id] = tab;
    }

    public void addBlock(int id, Block block)
    {
        if (id != -1) blocks[id] = block;
        GameRegistry.registerBlock(block, block.getUnlocalizedName());
    }

    public void addItem(int id, Item item)
    {
        if (id != -1) items[id] = item;
        GameRegistry.registerItem(item, item.getUnlocalizedName());
    }

    public void addDNA(ItemDNA item)
    {
        dnas.add(item);
        GameRegistry.registerItem(item, item.getUnlocalizedName());
    }

    public void addBlockWithTileEntity(int id, BlockContainer block, Class<? extends TileEntity> tileEntity, boolean doRegister)
    {
        addBlock(id, block);
        if (doRegister) GameRegistry.registerTileEntity(tileEntity, tileEntity.getSimpleName());
    }

    public void addTileEntity(Class<? extends TileEntity> tile)
    {
        GameRegistry.registerTileEntity(tile, tile.getSimpleName());
    }

    @SideOnly(Side.CLIENT)
    public void addTileEntityRenderer(Class<? extends TileEntity> tileEntity, TileEntitySpecialRenderer renderer)
    {
        proxy.renderTileEntity(tileEntity, renderer);
    }

    public void addEntity(Class<? extends EntityLiving> entity, String name, int color1, int color2)
    {
        int entityId = EntityRegistry.findGlobalUniqueEntityId();
        EntityRegistry.registerGlobalEntityID(entity, name, entityId, color1, color2);
        EntityRegistry.registerModEntity(entity, name, entityId, JurassiCraft.instance, 64, 1, true);

        addEntityRenderer(entity, name); //todo
    }

    @SideOnly(Side.CLIENT)
    private void addEntityRenderer(Class<? extends EntityLiving> entity, String name)
    {
        try
        {
            RenderLiving renderer = (RenderLiving) Class.forName("com.ilexiconn.jurassicraft.data.entity.render.Render" + name).newInstance();
            proxy.renderEntity(entity, renderer);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addGuiHandler(IGuiHandler handler)
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(JurassiCraft.instance, handler);
    }

    public void addWorldGenerator(IWorldGenerator generator, int weight)
    {
        GameRegistry.registerWorldGenerator(generator, weight);
    }

    public void addEgg(BlockEgg egg)
    {
        eggs.add(egg);
        addBlock(-1, egg);
    }
}
