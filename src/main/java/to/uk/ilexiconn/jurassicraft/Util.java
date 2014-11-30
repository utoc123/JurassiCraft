package to.uk.ilexiconn.jurassicraft;

import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.item.Item;
import to.uk.ilexiconn.jurassicraft.entity.*;
import to.uk.ilexiconn.jurassicraft.item.ItemDNA;
import to.uk.ilexiconn.jurassicraft.item.ItemDinoEgg;
import to.uk.ilexiconn.jurassicraft.item.ItemMammalSyringe;
import to.uk.ilexiconn.jurassicraft.item.ItemMeat;
import to.uk.ilexiconn.jurassicraft.proxy.ServerProxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @deprecated Start using LLib's Content Handler System instead
 */
@Deprecated
public class Util
{
    /**
     * Stuff
     */
    private static final JsonEntityParser entityParser = new JsonEntityParser();
    @SidedProxy(clientSide = "to.uk.ilexiconn.jurassicraft.proxy.ClientProxy", serverSide = "to.uk.ilexiconn.jurassicraft.proxy.ServerProxy")
    public static ServerProxy proxy;
    private static Item[] items = new Item[512];
    private static ArrayList<ItemDNA> dnas = new ArrayList<ItemDNA>();
    private static ArrayList<ItemDinoEgg> eggs = new ArrayList<ItemDinoEgg>();
    private static ArrayList<ItemMammalSyringe> syringes = new ArrayList<ItemMammalSyringe>();

    private static Map<Entities, Class<?>> dinos = new HashMap<Entities, Class<?>>();
    private static Map<Entities, Class<?>> mammals = new HashMap<Entities, Class<?>>();
    private static Map<Entities, Class<?>> cephalopods = new HashMap<Entities, Class<?>>();
    private static Map<Entities, Class<?>> arthropods = new HashMap<Entities, Class<?>>();
    private static Map<Entities, Class<?>> Fish = new HashMap<Entities, Class<?>>();
    private static Map<Entities, Class<?>> reptiles = new HashMap<Entities, Class<?>>();
    private static Map<Entities, Class<?>> birds = new HashMap<Entities, Class<?>>();

    private static Map<Entities, Class<?>> creatures = new HashMap<Entities, Class<?>>();

    private static ArrayList<ItemMeat> meat = new ArrayList<ItemMeat>();

    public static int entityId;

    public static byte creatureId = 0;

    /**
     * Getters
     */
    public static Class<?> getCreatureClass(String name)
    {
        for (Map.Entry<Entities, Class<?>> dino : dinos.entrySet())
        {
            if (dino.getKey().creatureName.equals(name))
            {
                return dino.getValue();
            }
        }

        for (Map.Entry<Entities, Class<?>> mammal : mammals.entrySet())
        {
            if (mammal.getKey().creatureName.equals(name))
            {
                return mammal.getValue();
            }
        }
        for (Map.Entry<Entities, Class<?>> cephalopod : cephalopods.entrySet())
        {
            if (cephalopod.getKey().creatureName.equals(name))
            {
                return cephalopod.getValue();
            }
        }
        for (Map.Entry<Entities, Class<?>> arthropod : arthropods.entrySet())
        {
            if (arthropod.getKey().creatureName.equals(name))
            {
                return arthropod.getValue();
            }
        }
        for (Map.Entry<Entities, Class<?>> fish : Fish.entrySet())
        {
            if (fish.getKey().creatureName.equals(name))
            {
                return fish.getValue();
            }
        }
        for (Map.Entry<Entities, Class<?>> reptile : reptiles.entrySet())
        {
            if (reptile.getKey().creatureName.equals(name))
            {
                return reptile.getValue();
            }
        }
        for (Map.Entry<Entities, Class<?>> bird : birds.entrySet())
        {
            if (bird.getKey().creatureName.equals(name))
            {
                return bird.getValue();
            }
        }

        return null;
    }

    private static Class<?> getDinoClass(String dinoName)
    {
        for (Map.Entry<Entities, Class<?>> dino : dinos.entrySet())
        {
            if (dino.getKey().creatureName.equals(dinoName))
            {
                return dino.getValue();
            }
        }

        return null;
    }

    public static Class<?> getMammalClass(String mammalName)
    {
        for (Map.Entry<Entities, Class<?>> mammal : mammals.entrySet())
        {
            if (mammal.getKey().creatureName.equals(mammalName))
            {
                return mammal.getValue();
            }
        }

        return null;
    }

    public static Class<?> getCephalopodClass(String cephalopodName)
    {
        for (Map.Entry<Entities, Class<?>> cephalopod : cephalopods.entrySet())
        {
            if (cephalopod.getKey().creatureName.equals(cephalopodName))
            {
                return cephalopod.getValue();
            }
        }

        return null;
    }

    public static Class<?> getArthropodClass(String arthropodName)
    {
        for (Map.Entry<Entities, Class<?>> arthropod : arthropods.entrySet())
        {
            if (arthropod.getKey().creatureName.equals(arthropodName))
            {
                return arthropod.getValue();
            }
        }

        return null;
    }

    public static Class<?> getFishClass(String fishName)
    {
        for (Map.Entry<Entities, Class<?>> fish : Fish.entrySet())
        {
            if (fish.getKey().creatureName.equals(fishName))
            {
                return fish.getValue();
            }
        }

        return null;
    }

    public static Class<?> getReptileClass(String reptileName)
    {
        for (Map.Entry<Entities, Class<?>> reptile : reptiles.entrySet())
        {
            if (reptile.getKey().creatureName.equals(reptileName))
            {
                return reptile.getValue();
            }
        }

        return null;
    }

    public static Class<?> getBirdClass(String birdName)
    {
        for (Map.Entry<Entities, Class<?>> bird : birds.entrySet())
        {
            if (bird.getKey().creatureName.equals(birdName))
            {
                return bird.getValue();
            }
        }

        return null;
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

    public static ArrayList<ItemMammalSyringe> getSyringeArray()
    {
        return syringes;
    }
    
    public static String getModId()
    {
        return "jurassicraft:";
    }

    public static JsonEntityParser getEntityParser()
    {
        return entityParser;
    }

    public static Map<Entities, Class<?>> getCreatures() {
        return creatures;
    }

    private static Map<Entities, Class<?>> getDinos()
    {
        return dinos;
    }

    private static Map<Entities, Class<?>> getMammals()
    {
        return mammals;
    }

    public static Map<Entities, Class<?>> getCephalopod() {
        return cephalopods;
    }

    public static Map<Entities, Class<?>> getArthropod() {
        return arthropods;
    }

    private static Map<Entities, Class<?>> getFish() {
        return Fish;
    }

    public static Map<Entities, Class<?>> getReptile() {
        return reptiles;
    }

    public static Map<Entities, Class<?>> getBird() {
        return birds;
    }

    public static ArrayList<ItemMeat> getDinoMeats()
    {
        return meat;
    }

    public static Item getMeat(int id)
    {
        return meat.get(id);
    }

    /**
     *  Adders
     */

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

    public void addDinoEntity(Entities dino)
    {
        try
        {
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.dinosaurs.Entity" + dino.creatureName);
            dinos.put(dino, entity);
            creatures.put(dino, entity);
            entityId = EntityRegistry.findGlobalUniqueEntityId();
            EntityRegistry.registerGlobalEntityID(entity, dino.creatureName, entityId, 0, 0);
            EntityRegistry.registerModEntity(entity, dino.creatureName, entityId, JurassiCraft.instance, 64, 1, true);
            addEgg(dino.creatureName);
            System.out.println(dino.creatureName + ";" + dino.creatureID);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addEgg(final String dinoName)
    {
        ItemDinoEgg egg = new ItemDinoEgg(dinoName);

        eggs.add(egg);

        addItem(-1, egg);
    }

    public void addMammalEntity(Entities mammal)
    {
        try
        {
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.mammals.Entity" + mammal.creatureName);
            mammals.put(mammal, entity);
            creatures.put(mammal, entity);
            entityId = EntityRegistry.findGlobalUniqueEntityId();
            EntityRegistry.registerGlobalEntityID(entity, mammal.creatureName, entityId, 0, 0);
            EntityRegistry.registerModEntity(entity, mammal.creatureName, entityId, JurassiCraft.instance, 64, 1, true);
            addSyringe(mammal.creatureName);
            System.out.println(mammal.creatureName + ";" + mammal.creatureID);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addCephalopodaEntity(Entities cephalopoda)
    {
        try
        {
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.cephalopods.Entity" + cephalopoda.creatureName);
            cephalopods.put(cephalopoda, entity);
            creatures.put(cephalopoda, entity);
            entityId = EntityRegistry.findGlobalUniqueEntityId();
            EntityRegistry.registerGlobalEntityID(entity, cephalopoda.creatureName, entityId, 0, 0);
            EntityRegistry.registerModEntity(entity, cephalopoda.creatureName, entityId, JurassiCraft.instance, 64, 1, true);
            System.out.println(cephalopoda.creatureName + ";" + cephalopoda.creatureID);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addArthropodEntity(Entities arthropod)
    {
        try
        {
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.arthropods.Entity" + arthropod.creatureName);
            arthropods.put(arthropod, entity);
            creatures.put(arthropod, entity);
            entityId = EntityRegistry.findGlobalUniqueEntityId();
            EntityRegistry.registerGlobalEntityID(entity, arthropod.creatureName, entityId, 0, 0);
            EntityRegistry.registerModEntity(entity, arthropod.creatureName, entityId, JurassiCraft.instance, 64, 1, true);
            System.out.println(arthropod.creatureName + ";" + arthropod.creatureID);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addFishEntity(Entities fish)
    {
        try
        {
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.fish.Entity" + fish.creatureName);
            Fish.put(fish, entity);
            creatures.put(fish, entity);
            entityId = EntityRegistry.findGlobalUniqueEntityId();
            EntityRegistry.registerGlobalEntityID(entity, fish.creatureName, entityId, 0, 0);
            EntityRegistry.registerModEntity(entity, fish.creatureName, entityId, JurassiCraft.instance, 64, 1, true);
            System.out.println(fish.creatureName + ";" + fish.creatureID);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addReptileEntity(Entities reptile)
    {
        try
        {
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.reptiles.Entity" + reptile.creatureName);
            reptiles.put(reptile, entity);
            creatures.put(reptile, entity);
            entityId = EntityRegistry.findGlobalUniqueEntityId();
            EntityRegistry.registerGlobalEntityID(entity, reptile.creatureName, entityId, 0, 0);
            EntityRegistry.registerModEntity(entity, reptile.creatureName, entityId, JurassiCraft.instance, 64, 1, true);
            System.out.println(reptile.creatureName + ";" + reptile.creatureID);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addBirdEntity(Entities bird)
    {
        try
        {
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.birds.Entity" + bird.creatureName);
            birds.put(bird, entity);
            creatures.put(bird, entity);
            entityId = EntityRegistry.findGlobalUniqueEntityId();
            EntityRegistry.registerGlobalEntityID(entity, bird.creatureName, entityId, 0, 0);
            EntityRegistry.registerModEntity(entity, bird.creatureName, entityId, JurassiCraft.instance, 64, 1, true);
            System.out.println(bird.creatureName + ";" + bird.creatureID);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addSyringe(final String mammalName)
    {
    	ItemMammalSyringe syringe = new ItemMammalSyringe(mammalName);

    	syringes.add(syringe);

        addItem(-1, syringe);
    }

    @SideOnly(Side.CLIENT)
    public void addDinoEntityRenderer(Entities dino)
    {
        try
        {
            RenderLiving renderer = (RenderLiving) Class.forName("to.uk.ilexiconn.jurassicraft.entity.render.dinosaurs.Render" + dino.creatureName).getDeclaredConstructor(Entities.class).newInstance(dino);
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.dinosaurs.Entity" + dino.creatureName);
            proxy.renderEntity(entity, renderer);
        }
        catch (Exception e)
        {

        }
    }

    @SideOnly(Side.CLIENT)
    public void addMammalEntityRenderer(Entities mammal)
    {
        try
        {
            RenderLiving renderer = (RenderLiving) Class.forName("to.uk.ilexiconn.jurassicraft.entity.render.mammals.Render" + mammal.creatureName).getDeclaredConstructor(Entities.class).newInstance(mammal);
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.mammals.Entity" + mammal.creatureName);
            proxy.renderEntity(entity, renderer);
        }
        catch (Exception e)
        {

        }
    }

    @SideOnly(Side.CLIENT)
    public void addCephalopodaEntityRenderer(Entities cephalopoda)
    {
        try
        {
            RenderLiving renderer = (RenderLiving) Class.forName("to.uk.ilexiconn.jurassicraft.entity.render.cephalopods.Render" + cephalopoda.creatureName).getDeclaredConstructor(Entities.class).newInstance(cephalopoda);
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.cephalopods.Entity" + cephalopoda.creatureName);
            proxy.renderEntity(entity, renderer);
        }
        catch (Exception e)
        {

        }
    }

    @SideOnly(Side.CLIENT)
    public void addArthropodEntityRenderer(Entities arthropod)
    {
        try
        {
            RenderLiving renderer = (RenderLiving) Class.forName("to.uk.ilexiconn.jurassicraft.entity.render.arthropods.Render" + arthropod.creatureName).getDeclaredConstructor(Entities.class).newInstance(arthropod);
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.arthropods.Entity" + arthropod.creatureName);
            proxy.renderEntity(entity, renderer);
        }
        catch (Exception e)
        {

        }
    }

    @SideOnly(Side.CLIENT)
    public void addFishEntityRenderer(Entities fish)
    {
        try
        {
            RenderLiving renderer = (RenderLiving) Class.forName("to.uk.ilexiconn.jurassicraft.entity.render.fish.Render" + fish.creatureName).getDeclaredConstructor(Entities.class).newInstance(fish);
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.fish.Entity" + fish.creatureName);
            proxy.renderEntity(entity, renderer);
        }
        catch (Exception e)
        {

        }
    }

    @SideOnly(Side.CLIENT)
    public void addReptileEntityRenderer(Entities reptile)
    {
        try
        {
            RenderLiving renderer = (RenderLiving) Class.forName("to.uk.ilexiconn.jurassicraft.entity.render.reptiles.Render" + reptile.creatureName).getDeclaredConstructor(Entities.class).newInstance(reptile);
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.reptiles.Entity" + reptile.creatureName);
            proxy.renderEntity(entity, renderer);
        }
        catch (Exception e)
        {

        }
    }

    @SideOnly(Side.CLIENT)
    public void addBirdEntityRenderer(Entities bird)
    {
        try
        {
            RenderLiving renderer = (RenderLiving) Class.forName("to.uk.ilexiconn.jurassicraft.entity.render.birds.Render" + bird.creatureName).getDeclaredConstructor(Entities.class).newInstance(birds);
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.birds.Entity" + bird.creatureName);
            proxy.renderEntity(entity, renderer);
        }
        catch (Exception e)
        {

        }
    }

    private static Entities getDinoByID(int id)
    {
        for (Entry<Entities, Class<?>> dino : dinos.entrySet())
        {
            if (dino.getKey().creatureID == id)
            {
                return dino.getKey();
            }
        }

        return null;
    }

    public static Entities getMammalByID(int id)
    {
        for (Entry<Entities, Class<?>> mammal : mammals.entrySet())
        {
            if (mammal.getKey().creatureID == id)
            {
                return mammal.getKey();
            }
        }

        return null;
    }

    public static Entities getCephalopodById(int id)
    {
        for (Entry<Entities, Class<?>> cephalopod : cephalopods.entrySet())
        {
            if (cephalopod.getKey().creatureID == id)
            {
                return cephalopod.getKey();
            }
        }

        return null;
    }

    public static Entities getArthropodById(int id)
    {
        for (Entry<Entities, Class<?>> arthorpod : arthropods.entrySet())
        {
            if (arthorpod.getKey().creatureID == id)
            {
                return arthorpod.getKey();
            }
        }

        return null;
    }

    public static Entities getFishById(int id)
    {
        for (Entry<Entities, Class<?>> fish : Fish.entrySet())
        {
            if (fish.getKey().creatureID == id)
            {
                return fish.getKey();
            }
        }

        return null;
    }

    public static Entities getReptileById(int id)
    {
        for (Entry<Entities, Class<?>> reptile : reptiles.entrySet())
        {
            if (reptile.getKey().creatureID == id)
            {
                return reptile.getKey();
            }
        }

        return null;
    }

    public static Entities getBirdById(int id)
    {
        for (Entry<Entities, Class<?>> bird : birds.entrySet())
        {
            if (bird.getKey().creatureID == id)
            {
                return bird.getKey();
            }
        }

        return null;
    }

    public static int getDinoIDByName(String name)
    {
        for (Entry<Entities, Class<?>> dino : dinos.entrySet())
        {
            if (dino.getKey().creatureName.equals(name))
            {
                return dino.getKey().creatureID;
            }
        }
        return -1;
    }

    public static int getMammalIDByName(String name)
    {
        for (Entry<Entities, Class<?>> mammal : mammals.entrySet())
        {
            if (mammal.getKey().creatureName.equals(name))
            {
                return mammal.getKey().creatureID;
            }
        }

        return -1;
    }

    public static int getCephalopodIdByName(String name)
    {
        for (Entry<Entities, Class<?>> cephalopod : cephalopods.entrySet())
        {
            if (cephalopod.getKey().creatureName.equals(name))
            {
                return cephalopod.getKey().creatureID;
            }
        }

        return -1;
    }

    public static int getArthropodIdByName(String name)
    {
        for (Entry<Entities, Class<?>> arthropod : arthropods.entrySet())
        {
            if (arthropod.getKey().creatureName.equals(name))
            {
                return arthropod.getKey().creatureID;
            }
        }

        return -1;
    }

    public static int getFishIdByName(String name)
    {
        for (Entry<Entities, Class<?>> fish : Fish.entrySet())
        {
            if (fish.getKey().creatureName.equals(name))
            {
                return fish.getKey().creatureID;
            }
        }

        return -1;
    }

    public static int getReptileIdByName(String name)
    {
        for (Entry<Entities, Class<?>> reptile : reptiles.entrySet())
        {
            if (reptile.getKey().creatureName.equals(name))
            {
                return reptile.getKey().creatureID;
            }
        }

        return -1;
    }

    public static int getBirdIdByName(String name)
    {
        for (Entry<Entities, Class<?>> bird : birds.entrySet())
        {
            if (bird.getKey().creatureName.equals(name))
            {
                return bird.getKey().creatureID;
            }
        }

        return -1;
    }

    public static boolean isFavoriteFood(int id, Item heldItem)
    {
    	ArrayList itemList = getCreatureFromId(id).favoriteFoodList;
        return !itemList.isEmpty() && itemList.contains(heldItem.getUnlocalizedName());
    }

    public static boolean isRidingItem(int id, Item heldItem)
    {
    	ArrayList itemList = getCreatureFromId(id).ridingItemList;
        return !itemList.isEmpty() && itemList.contains(heldItem.getUnlocalizedName());
    }

    public static Entities getCreatureFromId(int id)
    {
        if (id < dinos.size() && dinos.size() != 0)
            return getDinoByID(id);
        if (id < dinos.size() + reptiles.size() && reptiles.size() != 0)
            return getReptileById(id);
        if (id < dinos.size() + reptiles.size() + mammals.size() && mammals.size() != 0)
            return getMammalByID(id);
        if (id < dinos.size() + reptiles.size() + mammals.size() + birds.size() && birds.size() != 0)
            return getBirdById(id);
        if (id < dinos.size() + reptiles.size() + mammals.size() + birds.size() + Fish.size() && Fish.size() != 0)
            return getFishById(id);
        if (id < dinos.size() + reptiles.size() + mammals.size() + birds.size() + Fish.size() + cephalopods.size() && cephalopods.size() != 0)
            return getCephalopodById(id);
        if (id < dinos.size() + reptiles.size() + mammals.size() + birds.size() + Fish.size() + cephalopods.size() + arthropods.size() && arthropods.size() != 0)
            return getArthropodById(id);
        else return null;
    }

    public static int getCreatureFromName(String name)
    {
        for (Entry<Entities, Class<?>> dino : dinos.entrySet())
        {
            if (dino.getKey().creatureName.equals(name))
            {
                return dino.getKey().creatureID;
            }
        }
        for (Entry<Entities, Class<?>> mammal : mammals.entrySet())
        {
            if (mammal.getKey().creatureName.equals(name))
            {
                return mammal.getKey().creatureID;
            }
        }
        for (Entry<Entities, Class<?>> cephalopod : cephalopods.entrySet())
        {
            if (cephalopod.getKey().creatureName.equals(name))
            {
                return cephalopod.getKey().creatureID;
            }
        }
        for (Entry<Entities, Class<?>> arthropod : arthropods.entrySet())
        {
            if (arthropod.getKey().creatureName.equals(name))
            {
                return arthropod.getKey().creatureID;
            }
        }
        for (Entry<Entities, Class<?>> fish : Fish.entrySet())
        {
            if (fish.getKey().creatureName.equals(name))
            {
                return fish.getKey().creatureID;
            }
        }
        for (Entry<Entities, Class<?>> reptile : reptiles.entrySet())
        {
            if (reptile.getKey().creatureName.equals(name))
            {
                return reptile.getKey().creatureID;
            }
        }
        for (Entry<Entities, Class<?>> bird : birds.entrySet())
        {
            if (bird.getKey().creatureName.equals(name))
            {
                return bird.getKey().creatureID;
            }
        }

        return -1;
    }

    public static int classToId(Class class1)
    {
        for (Entry<Entities, Class<?>> dino : dinos.entrySet())
        {
            if (dino.getValue() == class1)
            {
                return dino.getKey().creatureID;
            }
        }
        for (Entry<Entities, Class<?>> mammal : mammals.entrySet())
        {
            if (mammal.getValue() == class1)
            {
                return mammal.getKey().creatureID;
            }
        }
        for (Entry<Entities, Class<?>> cephalopod : cephalopods.entrySet())
        {
            if (cephalopod.getValue() == class1)
            {
                return cephalopod.getKey().creatureID;
            }
        }
        for (Entry<Entities, Class<?>> arthropod : arthropods.entrySet())
        {
            if (arthropod.getValue() == class1)
            {
                return arthropod.getKey().creatureID;
            }
        }
        for (Entry<Entities, Class<?>> fish : Fish.entrySet())
        {
            if (fish.getValue() == class1)
            {
                return fish.getKey().creatureID;
            }
        }
        for (Entry<Entities, Class<?>> reptile : reptiles.entrySet())
        {
            if (reptile.getValue() == class1)
            {
                return reptile.getKey().creatureID;
            }
        }
        for (Entry<Entities, Class<?>> bird : birds.entrySet())
        {
            if (bird.getValue() == class1)
            {
                return bird.getKey().creatureID;
            }
        }

        return -1;
    }
}
