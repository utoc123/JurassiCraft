package to.uk.ilexiconn.jurassicraft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;
import to.uk.ilexiconn.jurassicraft.data.Data;
import to.uk.ilexiconn.jurassicraft.data.entity.Dinosaur;
import to.uk.ilexiconn.jurassicraft.data.entity.JsonEntityParser;
import to.uk.ilexiconn.jurassicraft.data.item.ItemDNA;
import to.uk.ilexiconn.jurassicraft.data.item.ItemDinoEgg;
import to.uk.ilexiconn.jurassicraft.data.item.ItemMeat;
import to.uk.ilexiconn.jurassicraft.logger.LogHelper;
import to.uk.ilexiconn.jurassicraft.proxy.ServerProxy;
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
	@SidedProxy(clientSide = "to.uk.ilexiconn.jurassicraft.proxy.ClientProxy", serverSide = "to.uk.ilexiconn.jurassicraft.proxy.ServerProxy")
	public static ServerProxy proxy;
	private static CreativeTabs[] tabs = new CreativeTabs[512];
	private static Block[] blocks = new Block[512];
	private static Item[] items = new Item[512];
	private static ArrayList<ItemDNA> dnas = new ArrayList<ItemDNA>();
	private static ArrayList<ItemDinoEgg> eggs = new ArrayList<ItemDinoEgg>();
	private static Map<Dinosaur, Class<?>> dinos = new HashMap<Dinosaur, Class<?>>();
	private static ArrayList<ItemMeat> meat = new ArrayList<ItemMeat>();

	/** Getters */
	public static CreativeTabs getCreativeTab(int id)
	{
		return tabs[id];
	}

	public static Class<?> getDinoClass(String dinoName)
	{
		for (Map.Entry<Dinosaur, Class<?>> dino : dinos.entrySet()) 
		{
			if(dino.getKey().dinoName.equals(dinoName))
			{
				return dino.getValue();
			}
		}

		return null;
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

	public static ArrayList<ItemDinoEgg> getEggArray()
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

	public static Map<Dinosaur, Class<?>> getDinos()
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
			Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.data.entity.entity.Entity" + dino.dinoName);
			dinos.put(dino, entity);
			int entityId = EntityRegistry.findGlobalUniqueEntityId();
			EntityRegistry.registerGlobalEntityID(entity, dino.dinoName, entityId, 0, 0);
			EntityRegistry.registerModEntity(entity, dino.dinoName, entityId, JurassiCraft.instance, 64, 1, true);
			addEgg(dino.dinoName);
		}
		catch (Exception e)
		{
            LogHelper.warn("Failed to register dino!");
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

	public void addEgg(final String dinoName)
	{
		ItemDinoEgg egg = new ItemDinoEgg(dinoName);
		
		eggs.add(egg);
		
		addItem(-1, egg);
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
			RenderLiving renderer = (RenderLiving) Class.forName("to.uk.ilexiconn.jurassicraft.data.entity.render.Render" + dino.dinoName).getDeclaredConstructor(Dinosaur.class).newInstance(dino);
			Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.data.entity.entity.Entity" + dino.dinoName);
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

	public static Dinosaur getDinoByID(int id) 
	{
		for (Entry<Dinosaur, Class<?>> dino : dinos.entrySet()) 
		{
			if(dino.getKey().id == id)
			{
				return dino.getKey();
			}
		}
		
		return null;
	}
	
	public static int getDinoIDByName(String name) 
	{
		for (Entry<Dinosaur, Class<?>> dino : dinos.entrySet()) 
		{
			if(dino.getKey().dinoName.equals(name))
			{
				return dino.getKey().id;
			}
		}
		
		return -1;
	}
}
