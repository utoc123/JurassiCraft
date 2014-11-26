package to.uk.ilexiconn.jurassicraft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.item.Item;
import to.uk.ilexiconn.jurassicraft.entity.*;
import to.uk.ilexiconn.jurassicraft.item.ItemDNA;
import to.uk.ilexiconn.jurassicraft.item.ItemDinoEgg;
import to.uk.ilexiconn.jurassicraft.item.ItemMammalSyringe;
import to.uk.ilexiconn.jurassicraft.item.ItemMeat;
import to.uk.ilexiconn.jurassicraft.proxy.ServerProxy;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

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
    private static Map<Dinosaur, Class<?>> dinos = new HashMap<Dinosaur, Class<?>>();
    private static Map<Mammal, Class<?>> mammals = new HashMap<Mammal, Class<?>>();
    private static Map<Cephalopod, Class<?>> cephalopods = new HashMap<Cephalopod, Class<?>>();
    private static Map<Arthropod, Class<?>> arthropods = new HashMap<Arthropod, Class<?>>();
    private static Map<Fish, Class<?>> Fish = new HashMap<Fish, Class<?>>();
    private static Map<Reptile, Class<?>> reptiles = new HashMap<Reptile, Class<?>>();
    private static Map<Bird, Class<?>> birds = new HashMap<Bird, Class<?>>();
    private static ArrayList<ItemMeat> meat = new ArrayList<ItemMeat>();

    public static int entityId;

    /**
     * Getters
     */

    public static Class<?> getDinoClass(String dinoName)
    {
        for (Map.Entry<Dinosaur, Class<?>> dino : dinos.entrySet())
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
        for (Map.Entry<Mammal, Class<?>> mammal : mammals.entrySet())
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
        for (Map.Entry<Cephalopod, Class<?>> cephalopod : cephalopods.entrySet())
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
        for (Map.Entry<Arthropod, Class<?>> arthropod : arthropods.entrySet())
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
        for (Map.Entry<Fish, Class<?>> fish : Fish.entrySet())
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
        for (Map.Entry<Reptile, Class<?>> reptile : reptiles.entrySet())
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
        for (Map.Entry<Bird, Class<?>> bird : birds.entrySet())
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

    public static Map<Dinosaur, Class<?>> getDinos()
    {
        return dinos;
    }

    public static Map<Mammal, Class<?>> getMammals()
    {
        return mammals;
    }

    public static Map<Cephalopod, Class<?>> getCephalopod() {
        return cephalopods;
    }

    public static Map<Arthropod, Class<?>> getArthropod() {
        return arthropods;
    }

    public static Map<Fish, Class<?>> getFish() {
        return Fish;
    }

    public static Map<Reptile, Class<?>> getReptile() {
        return reptiles;
    }

    public static Map<Bird, Class<?>> getBird() {
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
     * Adders
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

    public void addDinoEntity(Dinosaur dino)
    {
        try
        {
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.dinosaurs.Entity" + dino.creatureName);
            dinos.put(dino, entity);
            entityId = EntityRegistry.findGlobalUniqueEntityId();
            EntityRegistry.registerGlobalEntityID(entity, dino.creatureName, entityId, 0, 0);
            EntityRegistry.registerModEntity(entity, dino.creatureName, entityId, JurassiCraft.instance, 64, 1, true);
            addEgg(dino.creatureName);
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

    public void addMammalEntity(Mammal mammal)
    {
        try
        {
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.mammals.Entity" + mammal.creatureName);
            mammals.put(mammal, entity);
            entityId = EntityRegistry.findGlobalUniqueEntityId();
            EntityRegistry.registerGlobalEntityID(entity, mammal.creatureName, entityId, 0, 0);
            EntityRegistry.registerModEntity(entity, mammal.creatureName, entityId, JurassiCraft.instance, 64, 1, true);
            addSyringe(mammal.creatureName);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addCephalopodaEntity(Cephalopod cephalopoda)
    {
        try
        {
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.cephalopods.Entity" + cephalopoda.creatureName);
            cephalopods.put(cephalopoda, entity);
            entityId = EntityRegistry.findGlobalUniqueEntityId();
            EntityRegistry.registerGlobalEntityID(entity, cephalopoda.creatureName, entityId, 0, 0);
            EntityRegistry.registerModEntity(entity, cephalopoda.creatureName, entityId, JurassiCraft.instance, 64, 1, true);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addArthropodEntity(Arthropod arthropod)
    {
        try
        {
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.arthropods.Entity" + arthropod.creatureName);
            arthropods.put(arthropod, entity);
            entityId = EntityRegistry.findGlobalUniqueEntityId();
            EntityRegistry.registerGlobalEntityID(entity, arthropod.creatureName, entityId, 0, 0);
            EntityRegistry.registerModEntity(entity, arthropod.creatureName, entityId, JurassiCraft.instance, 64, 1, true);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addFishEntity(Fish fish)
    {
        try
        {
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.fish.Entity" + fish.creatureName);
            Fish.put(fish, entity);
            entityId = EntityRegistry.findGlobalUniqueEntityId();
            EntityRegistry.registerGlobalEntityID(entity, fish.creatureName, entityId, 0, 0);
            EntityRegistry.registerModEntity(entity, fish.creatureName, entityId, JurassiCraft.instance, 64, 1, true);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addReptileEntity(Reptile reptile)
    {
        try
        {
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.reptiles.Entity" + reptile.creatureName);
            reptiles.put(reptile, entity);
            entityId = EntityRegistry.findGlobalUniqueEntityId();
            EntityRegistry.registerGlobalEntityID(entity, reptile.creatureName, entityId, 0, 0);
            EntityRegistry.registerModEntity(entity, reptile.creatureName, entityId, JurassiCraft.instance, 64, 1, true);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addBirdEntity(Bird bird)
    {
        try
        {
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.birds.Entity" + bird.creatureName);
            birds.put(bird, entity);
            entityId = EntityRegistry.findGlobalUniqueEntityId();
            EntityRegistry.registerGlobalEntityID(entity, bird.creatureName, entityId, 0, 0);
            EntityRegistry.registerModEntity(entity, bird.creatureName, entityId, JurassiCraft.instance, 64, 1, true);
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
    public void addDinoEntityRenderer(Dinosaur dino)
    {
        try
        {
            RenderLiving renderer = (RenderLiving) Class.forName("to.uk.ilexiconn.jurassicraft.entity.render.dinosaurs.Render" + dino.creatureName).getDeclaredConstructor(Dinosaur.class).newInstance(dino);
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.dinosaurs.Entity" + dino.creatureName);
            proxy.renderEntity(entity, renderer);
        }
        catch (Exception e)
        {

        }
    }

    @SideOnly(Side.CLIENT)
    public void addMammalEntityRenderer(Mammal mammal)
    {
        try
        {
            RenderLiving renderer = (RenderLiving) Class.forName("to.uk.ilexiconn.jurassicraft.entity.render.mammals.Render" + mammal.creatureName).getDeclaredConstructor(Mammal.class).newInstance(mammal);
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.mammals.Entity" + mammal.creatureName);
            proxy.renderEntity(entity, renderer);
        }
        catch (Exception e)
        {

        }
    }

    @SideOnly(Side.CLIENT)
    public void addCephalopodaEntityRenderer(Cephalopod cephalopoda)
    {
        try
        {
            RenderLiving renderer = (RenderLiving) Class.forName("to.uk.ilexiconn.jurassicraft.entity.render.cephalopods.Render" + cephalopoda.creatureName).getDeclaredConstructor(Cephalopod.class).newInstance(cephalopoda);
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.cephalopods.Entity" + cephalopoda.creatureName);
            proxy.renderEntity(entity, renderer);
        }
        catch (Exception e)
        {

        }
    }

    @SideOnly(Side.CLIENT)
    public void addArthropodEntityRenderer(Arthropod arthropod)
    {
        try
        {
            RenderLiving renderer = (RenderLiving) Class.forName("to.uk.ilexiconn.jurassicraft.entity.render.arthropods.Render" + arthropod.creatureName).getDeclaredConstructor(Arthropod.class).newInstance(arthropod);
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.arthropods.Entity" + arthropod.creatureName);
            proxy.renderEntity(entity, renderer);
        }
        catch (Exception e)
        {

        }
    }

    @SideOnly(Side.CLIENT)
    public void addFishEntityRenderer(Fish fish)
    {
        try
        {
            RenderLiving renderer = (RenderLiving) Class.forName("to.uk.ilexiconn.jurassicraft.entity.render.fish.Render" + fish.creatureName).getDeclaredConstructor(Fish.class).newInstance(fish);
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.fish.Entity" + fish.creatureName);
            proxy.renderEntity(entity, renderer);
        }
        catch (Exception e)
        {

        }
    }

    @SideOnly(Side.CLIENT)
    public void addReptileEntityRenderer(Reptile reptile)
    {
        try
        {
            RenderLiving renderer = (RenderLiving) Class.forName("to.uk.ilexiconn.jurassicraft.entity.render.reptiles.Render" + reptile.creatureName).getDeclaredConstructor(Reptile.class).newInstance(reptile);
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.reptiles.Entity" + reptile.creatureName);
            proxy.renderEntity(entity, renderer);
        }
        catch (Exception e)
        {

        }
    }

    @SideOnly(Side.CLIENT)
    public void addBirdEntityRenderer(Bird bird)
    {
        try
        {
            RenderLiving renderer = (RenderLiving) Class.forName("to.uk.ilexiconn.jurassicraft.entity.render.birds.Render" + bird.creatureName).getDeclaredConstructor(Bird.class).newInstance(birds);
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.birds.Entity" + bird.creatureName);
            proxy.renderEntity(entity, renderer);
        }
        catch (Exception e)
        {

        }
    }

    public static Dinosaur getDinoByID(int id)
    {
        for (Entry<Dinosaur, Class<?>> dino : dinos.entrySet())
        {
            if (dino.getKey().creatureID == id)
            {
                return dino.getKey();
            }
        }

        return null;
    }

    public static Mammal getMammalByID(int id)
    {
        for (Entry<Mammal, Class<?>> mammal : mammals.entrySet())
        {
            if (mammal.getKey().creatureID == id)
            {
                return mammal.getKey();
            }
        }

        return null;
    }

    public static Cephalopod getCephalopodById(int id)
    {
        for (Entry<Cephalopod, Class<?>> cephalopod : cephalopods.entrySet())
        {
            if (cephalopod.getKey().creatureID == id)
            {
                return cephalopod.getKey();
            }
        }

        return null;
    }

    public static Arthropod getArthropodById(int id)
    {
        for (Entry<Arthropod, Class<?>> arthorpod : arthropods.entrySet())
        {
            if (arthorpod.getKey().creatureID == id)
            {
                return arthorpod.getKey();
            }
        }

        return null;
    }

    public static Fish getFishById(int id)
    {
        for (Entry<Fish, Class<?>> fish : Fish.entrySet())
        {
            if (fish.getKey().creatureID == id)
            {
                return fish.getKey();
            }
        }

        return null;
    }

    public static Reptile getReptileById(int id)
    {
        for (Entry<Reptile, Class<?>> reptile : reptiles.entrySet())
        {
            if (reptile.getKey().creatureID == id)
            {
                return reptile.getKey();
            }
        }

        return null;
    }

    public static Bird getBirdById(int id)
    {
        for (Entry<Bird, Class<?>> bird : birds.entrySet())
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
        for (Entry<Dinosaur, Class<?>> dino : dinos.entrySet())
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
        for (Entry<Mammal, Class<?>> mammal : mammals.entrySet())
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
        for (Entry<Cephalopod, Class<?>> cephalopod : cephalopods.entrySet())
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
        for (Entry<Arthropod, Class<?>> arthropod : arthropods.entrySet())
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
        for (Entry<Fish, Class<?>> fish : Fish.entrySet())
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
        for (Entry<Reptile, Class<?>> reptile : reptiles.entrySet())
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
        for (Entry<Bird, Class<?>> bird : birds.entrySet())
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
    	ArrayList itemList = getDinoByID(id).favoriteFoodList;
        return !itemList.isEmpty() && itemList.contains(heldItem.getUnlocalizedName());
    }

    public static boolean isRidingItem(int id, Item heldItem)
    {
    	ArrayList itemList = getDinoByID(id).ridingItemList;
        return !itemList.isEmpty() && itemList.contains(heldItem.getUnlocalizedName());
    }
}
