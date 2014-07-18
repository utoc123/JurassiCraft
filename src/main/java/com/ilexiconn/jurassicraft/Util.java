package com.ilexiconn.jurassicraft;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.client.IItemRenderer;

import com.ilexiconn.jurassicraft.data.Data;
import com.ilexiconn.jurassicraft.data.block.BlockEgg;
import com.ilexiconn.jurassicraft.data.entity.Dinosaur;
import com.ilexiconn.jurassicraft.data.entity.JsonEntityParser;
import com.ilexiconn.jurassicraft.data.item.ItemDNA;
import com.ilexiconn.jurassicraft.data.item.ItemMeat;
import com.ilexiconn.jurassicraft.data.tile.TileEgg;
import com.ilexiconn.jurassicraft.proxy.ServerProxy;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Util
{
    /** Stuff */
    private static final Data data = new Data();
    private static final JsonEntityParser entityParser = new JsonEntityParser();
    @SidedProxy(clientSide = "com.ilexiconn.jurassicraft.proxy.ClientProxy", serverSide = "com.ilexiconn.jurassicraft.proxy.ServerProxy")
    public static ServerProxy proxy;
    private static CreativeTabs[] tabs = new CreativeTabs[512];
    private static Block[] blocks = new Block[512];
    private static Item[] items = new Item[512];
    private static ArrayList<ItemDNA> dnas = new ArrayList<ItemDNA>();
    private static ArrayList<BlockEgg> eggs = new ArrayList<BlockEgg>();
    private static ArrayList<Dinosaur> dinos = new ArrayList<Dinosaur>();
    private static ArrayList<ItemMeat> meat = new ArrayList<ItemMeat>();

    /** Getters */
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

    public static Data getData()
    {
        return data;
    }

    public static JsonEntityParser getEntityParser()
    {
        return entityParser;
    }

    public static ArrayList<Dinosaur> getDinos()
    {
        return dinos;
    }

    public static ItemMeat getMeat(int id)
    {
        return meat.get(id);
    }

    /** Adders */
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

    public void addDNA(String dinoName)
    {
        ItemDNA item = new ItemDNA(dinoName);
        dnas.add(item);
        GameRegistry.registerItem(item, item.getUnlocalizedName());
    }

    public void addMeat(String dinoName)
    {
        ItemMeat item = new ItemMeat(dinoName);
        meat.add(item);
        addItem(-1, item);
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

    public void addEntity(Dinosaur dino)
    {
        try
        {
            dinos.add(dino);
            Class entity = Class.forName("com.ilexiconn.jurassicraft.data.entity.entity.Entity" + dino.dinoName);
            int entityId = EntityRegistry.findGlobalUniqueEntityId();
            EntityRegistry.registerGlobalEntityID(entity, dino.dinoName, entityId, 0, 0);
            EntityRegistry.registerModEntity(entity, dino.dinoName, entityId, JurassiCraft.instance, 64, 1, true);
        }
        catch (Exception e)
        {

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

    public void addEgg(final String dinoName)
    {
        BlockEgg egg = new BlockEgg(dinoName)
        {
            public TileEntity createNewTileEntity(World world, int meta)
            {
                return new TileEgg(dinoName);
            }
        };
        eggs.add(egg);
        addBlock(-1, egg);
    }

    public void addShapedRecipe(ItemStack output, Object... obj)
    {
        GameRegistry.addRecipe(output, obj);
    }

    public void addShapelessRecipe(ItemStack output, Object... obj)
    {
        GameRegistry.addShapelessRecipe(output, obj);
    }

    @SideOnly(Side.CLIENT)
    public void addBlockRenderer(Class<? extends TileEntity> tileEntity, TileEntitySpecialRenderer renderer)
    {
        proxy.renderTileEntity(tileEntity, renderer);
    }

    @SideOnly(Side.CLIENT)
    public void addEntityRenderer(Dinosaur dino)
    {
        try
        {
            RenderLiving renderer = (RenderLiving) Class.forName("com.ilexiconn.jurassicraft.data.entity.render.Render" + dino.dinoName).getDeclaredConstructor(Dinosaur.class).newInstance(dino);
            Class entity = Class.forName("com.ilexiconn.jurassicraft.data.entity.entity.Entity" + dino.dinoName);
            proxy.renderEntity(entity, renderer);
        }
        catch (Exception e)
        {

        }
    }

    @SideOnly(Side.CLIENT)
    public void addItemRenderer(Item item, IItemRenderer render)
    {
        proxy.renderItem(item, render);
    }
}
