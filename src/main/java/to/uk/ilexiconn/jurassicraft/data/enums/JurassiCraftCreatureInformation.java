package to.uk.ilexiconn.jurassicraft.data.enums;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;

public enum JurassiCraftCreatureInformation
{

    ANKYLOSAUR((byte) JurassiCraft.getDinoIDByName("Ankylosaur"), "Ankylosaur",
            10.0D, 20.0D, //Health min, max;
            1.0D, 6.0D, //Strength min, max;
            0.36D, 0.28D, //Speed min, max;
            3.0D, 1.0D, //Knockback min, max;
            1.0F, 3.0F, //Length min, max;
            0.7F, 2.0F, //Height min, max;
            1.0F, 2.0F,  //xzCollisonBox min, variation;
            1.0F, 2.0F, //yCollisonBox min, variation;
            16, (byte) 120, //Adult size in minutes and number of updates during life;
            new Item[]{Items.wheat}, //List of possible food. Already exists in the Util, just a convenience I guess;
            false, 0.0F, //Is ridable? Ridable speed.
            new Item[]{Items.carrot_on_a_stick}, //Riding items (Whip, carrot on a stick)
            1.5F, (byte) 10, //Cultivating time in minutes and number of updates during cultivating;
            500, 500, 500, 500), //Nutrients: proximate, minerals, vitamins, lipids. Machine can store a max value of 3000;

    BRACHIOSAUR((byte) JurassiCraft.getDinoIDByName("Brachiosaur"), "Brachiosaur",
            10.0D, 20.0D,
            1.0D, 6.0D,
            0.36D, 0.28D,
            3.0D, 1.0D,
            1.0F, 3.0F,
            0.7F, 2.0F,
            1.0F, 2.0F,
            1.0F, 2.0F,
            16, (byte) 120,
            new Item[]{Items.wheat},
            false, 0.0F,
            new Item[]{Items.carrot_on_a_stick},
            1.5F, (byte) 10,
            500, 500, 500, 500),

    COELACANTH((byte) JurassiCraft.getDinoIDByName("Coelacanth"), "Coelacanth",
            10.0D, 20.0D,
            1.0D, 6.0D,
            0.36D, 0.28D,
            3.0D, 1.0D,
            1.0F, 3.0F,
            0.7F, 2.0F,
            1.0F, 2.0F,
            1.0F, 2.0F,
            16, (byte) 120,
            new Item[]{Items.wheat},
            false, 0.0F,
            new Item[]{Items.carrot_on_a_stick},
            1.5F, (byte) 10,
            500, 500, 500, 500),

    DILOPHOSAURUS((byte) JurassiCraft.getDinoIDByName("Dilophosaurus"), "Dilophosaurus",
            10.0D, 20.0D,
            1.0D, 6.0D,
            0.36D, 0.28D,
            3.0D, 1.0D,
            1.0F, 3.0F,
            0.7F, 2.0F,
            1.0F, 2.0F,
            1.0F, 2.0F,
            16, (byte) 120,
            new Item[]{Items.wheat},
            false, 0.0F,
            new Item[]{Items.carrot_on_a_stick},
            1.5F, (byte) 10,
            500, 500, 500, 500),

    DIMETRODON((byte) JurassiCraft.getDinoIDByName("Dimetrodon"), "Dimetrodon",
            10.0D, 20.0D,
            1.0D, 6.0D,
            0.36D, 0.28D,
            3.0D, 1.0D,
            1.0F, 3.0F,
            0.7F, 2.0F,
            1.0F, 2.0F,
            1.0F, 2.0F,
            16, (byte) 120,
            new Item[]{Items.wheat},
            false, 0.0F,
            new Item[]{Items.carrot_on_a_stick},
            1.5F, (byte) 10,
            500, 500, 500, 500),

    GALLIMIMUS((byte) JurassiCraft.getDinoIDByName("Galliminus"), "Galliminus",
            10.0D, 20.0D,
            1.0D, 6.0D,
            0.36D, 0.28D,
            3.0D, 1.0D,
            1.0F, 3.0F,
            0.7F, 2.0F,
            1.0F, 2.0F,
            1.0F, 2.0F,
            16, (byte) 120,
            new Item[]{Items.wheat},
            false, 0.0F,
            new Item[]{Items.carrot_on_a_stick},
            1.5F, (byte) 10,
            500, 500, 500, 500),

    HERRERASAUR((byte) JurassiCraft.getDinoIDByName("Herrerasaur"), "Herrerasaur",
            10.0D, 20.0D,
            1.0D, 6.0D,
            0.36D, 0.28D,
            3.0D, 1.0D,
            1.0F, 3.0F,
            0.7F, 2.0F,
            1.0F, 2.0F,
            1.0F, 2.0F,
            16, (byte) 120,
            new Item[]{Items.wheat},
            false, 0.0F,
            new Item[]{Items.carrot_on_a_stick},
            1.5F, (byte) 10,
            500, 500, 500, 500),

    HYPSILOPHODON((byte) JurassiCraft.getDinoIDByName("Hypsilophodon"), "Hypsilophodon",
            10.0D, 20.0D,
            1.0D, 6.0D,
            0.36D, 0.28D,
            3.0D, 1.0D,
            1.0F, 3.0F,
            0.7F, 2.0F,
            1.0F, 2.0F,
            1.0F, 2.0F,
            16, (byte) 120,
            new Item[]{Items.wheat},
            false, 0.0F,
            new Item[]{Items.carrot_on_a_stick},
            1.5F, (byte) 10,
            500, 500, 500, 500),

    LEAELLYNASAUR((byte) JurassiCraft.getDinoIDByName("Leaellynasaur"), "Leaellynasaur",
            10.0D, 20.0D,
            1.0D, 6.0D,
            0.36D, 0.28D,
            3.0D, 1.0D,
            1.0F, 3.0F,
            0.7F, 2.0F,
            1.0F, 2.0F,
            1.0F, 2.0F,
            16, (byte) 120,
            new Item[]{Items.wheat},
            false, 0.0F,
            new Item[]{Items.carrot_on_a_stick},
            1.5F, (byte) 10,
            500, 500, 500, 500),

    LIOPLEURODON((byte) JurassiCraft.getDinoIDByName("Liopleurodon"), "Liopleurodon",
            10.0D, 20.0D,
            1.0D, 6.0D,
            0.36D, 0.28D,
            3.0D, 1.0D,
            1.0F, 3.0F,
            0.7F, 2.0F,
            1.0F, 2.0F,
            1.0F, 2.0F,
            16, (byte) 120,
            new Item[]{Items.wheat},
            false, 0.0F,
            new Item[]{Items.carrot_on_a_stick},
            1.5F, (byte) 10,
            500, 500, 500, 500),

    MEGANEURA((byte) JurassiCraft.getDinoIDByName("Meganeura"), "Meganeura",
            10.0D, 20.0D,
            1.0D, 6.0D,
            0.36D, 0.28D,
            3.0D, 1.0D,
            1.0F, 3.0F,
            0.7F, 2.0F,
            1.0F, 2.0F,
            1.0F, 2.0F,
            16, (byte) 120,
            new Item[]{Items.wheat},
            false, 0.0F,
            new Item[]{Items.carrot_on_a_stick},
            1.5F, (byte) 10,
            500, 500, 500, 500),

    OVIRAPTOR((byte) JurassiCraft.getDinoIDByName("Oviraptor"), "Oviraptor",
            10.0D, 20.0D,
            1.0D, 6.0D,
            0.36D, 0.28D,
            3.0D, 1.0D,
            1.0F, 3.0F,
            0.7F, 2.0F,
            1.0F, 2.0F,
            1.0F, 2.0F,
            16, (byte) 120,
            new Item[]{Items.wheat},
            false, 0.0F,
            new Item[]{Items.carrot_on_a_stick},
            1.5F, (byte) 10,
            500, 500, 500, 500),

    PARASAUROLOPHUS((byte) JurassiCraft.getDinoIDByName("Parasaurolophus"), "Parasaurolophus",
            10.0D, 20.0D,
            1.0D, 6.0D,
            0.36D, 0.28D,
            3.0D, 1.0D,
            1.0F, 3.0F,
            0.7F, 2.0F,
            1.0F, 2.0F,
            1.0F, 2.0F,
            16, (byte) 120,
            new Item[]{Items.wheat},
            false, 0.0F,
            new Item[]{Items.carrot_on_a_stick},
            1.5F, (byte) 10,
            500, 500, 500, 500),

    STEGOSAUR((byte) JurassiCraft.getDinoIDByName("Stegosaur"), "Stegosaur",
            10.0D, 20.0D,
            1.0D, 6.0D,
            0.36D, 0.28D,
            3.0D, 1.0D,
            1.0F, 3.0F,
            0.7F, 2.0F,
            1.0F, 2.0F,
            1.0F, 2.0F,
            16, (byte) 120,
            new Item[]{Items.wheat},
            false, 0.0F,
            new Item[]{Items.carrot_on_a_stick},
            1.5F, (byte) 10,
            500, 500, 500, 500),

    TRICERATOPS((byte) JurassiCraft.getDinoIDByName("Triceratops"), "Triceratops",
            10.0D, 20.0D,
            1.0D, 6.0D,
            0.36D, 0.28D,
            3.0D, 1.0D,
            1.0F, 3.0F,
            0.7F, 2.0F,
            1.0F, 2.0F,
            1.0F, 2.0F,
            16, (byte) 120,
            new Item[]{Items.wheat},
            false, 0.0F,
            new Item[]{Items.carrot_on_a_stick},
            1.5F, (byte) 10,
            500, 500, 500, 500),

    TYLOSAURUS((byte) JurassiCraft.getDinoIDByName("Tylosaurus"), "Tylosaurus",
            10.0D, 20.0D,
            1.0D, 6.0D,
            0.36D, 0.28D,
            3.0D, 1.0D,
            1.0F, 3.0F,
            0.7F, 2.0F,
            1.0F, 2.0F,
            1.0F, 2.0F,
            16, (byte) 120,
            new Item[]{Items.wheat},
            false, 0.0F,
            new Item[]{Items.carrot_on_a_stick},
            1.5F, (byte) 10,
            500, 500, 500, 500),

    TYRANNOSAURUS((byte) JurassiCraft.getDinoIDByName("Tyrannosaurus"), "Tyrannosaurus",
            10.0D, 20.0D,
            1.0D, 6.0D,
            0.36D, 0.28D,
            3.0D, 1.0D,
            1.0F, 3.0F,
            0.7F, 2.0F,
            1.0F, 2.0F,
            1.0F, 2.0F,
            16, (byte) 120,
            new Item[]{Items.wheat},
            false, 0.0F,
            new Item[]{Items.carrot_on_a_stick},
            1.5F, (byte) 10,
            500, 500, 500, 500
    ),

    VELOCIRAPTOR((byte) JurassiCraft.getDinoIDByName("Velociraptor"), "Velociraptor",
            10.0D, 20.0D,
            1.0D, 6.0D,
            0.36D, 0.28D,
            3.0D, 1.0D,
            1.0F, 3.0F,
            0.7F, 2.0F,
            1.0F, 2.0F,
            1.0F, 2.0F,
            16, (byte) 120,
            new Item[]{Items.wheat},
            false, 0.0F,
            new Item[]{Items.carrot_on_a_stick},
            1.5F, (byte) 10,
            500, 500, 500, 500);

    private JurassiCraftCreatureInformation(
            byte id, String name,
            double minCreatureHealth, double maxCreatureHealth,
            double minCreatureStrenght, double maxCreatureStrength,
            double minCreatureSpeed, double maxCreatureSpeed,
            double minCreatureKnockback, double maxCreatureKnockback,
            float minCreatureLength, float maxCreatureLength,
            float minCreatureHeight, float maxCreatureHeight,
            float xzCollisionBoxMin, float xzCollisionBoxVariation,
            float yCollisionBoxMin, float yCollisionBoxVariation,
            int fullGrowthInDays, byte creatureTimesOfGrowth,
            Item[] favoriteFood,
            boolean isCreatureRidable, float creatureRidingSpeed,
            Item[] ridingItems,
            float growthInMin, byte nStages,
            int proximate, int minerals, int vitamins, int lipids)
    {

        this.creatureID = id;
        this.creatureName = name;
        this.minHealth = minCreatureHealth;
        this.minStrength = minCreatureStrenght;
        this.minSpeed = minCreatureSpeed;
        this.minLength = minCreatureLength;
        this.minHeight = minCreatureHeight;
        this.minKnockback = minCreatureKnockback;
        this.maxHealth = maxCreatureHealth;
        this.maxStrength = maxCreatureStrength;
        this.maxSpeed = maxCreatureSpeed;
        this.maxLength = maxCreatureLength;
        this.maxHeight = maxCreatureHeight;
        this.maxKnockback = maxCreatureKnockback;
        this.xzBoxMin = xzCollisionBoxMin;
        this.yBoxMin = yCollisionBoxMin;
        this.xzBoxDelta = xzCollisionBoxVariation;
        this.yBoxDelta = yCollisionBoxVariation;
        this.fullGrowthTime = 24000 * fullGrowthInDays;
        this.timesOfGrowth = creatureTimesOfGrowth;
        this.favoriteFoodList = favoriteFood;
        this.isRidable = isCreatureRidable;
        this.ridingSpeed = creatureRidingSpeed;
        this.ridingItemList = ridingItems;
        this.hatchSpeed = (short) (1200 * growthInMin);
        this.numberOfStages = nStages;
        this.minProximate = proximate;
        this.minMinerals = minerals;
        this.minVitamins = vitamins;
        this.minLipids = lipids;
    }

    /**
     * Returns the creature name.
     */
    public String getCreatureName()
    {
        return creatureName;
    }

    /**
     * Returns the creature id.
     */
    public byte getCreatureID()
    {
        return creatureID;
    }

    /**
     * Returns the minimum creature health.
     */
    public double getMinHealth()
    {
        return minHealth;
    }

    /**
     * Returns the minimum creature strength.
     */
    public double getMinStrength()
    {
        return minStrength;
    }

    /**
     * Returns the minimum creature speed.
     */
    public double getMinSpeed()
    {
        return minSpeed;
    }

    /**
     * Returns the minimum knock back of the creature.
     */
    public double getMinKnockback()
    {
        return minKnockback;
    }

    /**
     * Returns the maximum creature health.
     */
    public double getMaxHealth()
    {
        return maxHealth;
    }

    /**
     * Returns the maximum creature strength.
     */
    public double getMaxStrength()
    {
        return maxStrength;
    }

    /**
     * Returns the maximum creature speed.
     */
    public double getMaxSpeed()
    {
        return maxSpeed;
    }

    /**
     * Returns the maximum knock back of the creature.
     */
    public double getMaxKnockback()
    {
        return maxKnockback;
    }

    /**
     * Returns the minimum height of the creature.
     */
    public float getMinHeight()
    {
        return minHeight;
    }

    /**
     * Returns the minimum length of the creature.
     */
    public float getMinLength()
    {
        return minLength;
    }

    /**
     * Returns the maximum height of the creature.
     */
    public float getMaxHeight()
    {
        return maxHeight;
    }

    /**
     * Returns the maximum length of the creature.
     */
    public float getMaxLength()
    {
        return maxLength;
    }

    /**
     * Returns the initial xz collision box of the creature.
     */
    public float getXZcollisionBoxMin()
    {
        return xzBoxMin;
    }

    /**
     * Returns the variation of xz collision box of the creature when full grown.
     */
    public float getXZcollisionBoxVariation()
    {
        return xzBoxDelta;
    }

    /**
     * Returns the initial y collision box of the creature.
     */
    public float getYcollisionBoxMin()
    {
        return yBoxMin;
    }

    /**
     * Returns the variation of y collision box of the creature when full grown.
     */
    public float getYcollisionBoxVariation()
    {
        return yBoxDelta;
    }

    /**
     * Returns how many ticks are required to reach the maximum size of the creature.
     */
    public int getCreatureTickToAdulthood()
    {
        return fullGrowthTime;
    }

    /**
     * Returns how many times this creature will update is status until adulthood.
     */
    public byte getCreatureTimesOfGrowth()
    {
        return timesOfGrowth;
    }

    /**
     * Returns the favorite food of the creature as a Item[].
     */
    public Item[] getFavoriteFoodList()
    {
        return favoriteFoodList;
    }

    /**
     * Returns true if the item is the favorite food of a certain creature.
     */
    public static boolean isFavoriteFood(byte id, Item item)
    {
        for (int n = 0; n < JurassiCraftCreatureInformation.values()[id].getFavoriteFoodList().length; n++)
        {
            if (item.equals(JurassiCraftCreatureInformation.values()[id].getFavoriteFoodList()[n]))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns how many ticks it will take to cultivate the creature.
     */
    public short getCultivateSpeed()
    {
        return hatchSpeed;
    }

    /**
     * Returns the number of stages that an embryo will grow/re-render.
     */
    public byte getCreatureEmbryoStages()
    {
        return numberOfStages;
    }

    /**
     * Returns the minimum amount of proximate for certain creature.
     */
    public int getMinimumProximate()
    {
        return minProximate;
    }

    /**
     * Returns the minimum amount of minerals for certain creature.
     */
    public int getMinimumMinerals()
    {
        return minMinerals;
    }

    /**
     * Returns the minimum amount of vitamins for certain creature.
     */
    public int getMinimumvitamins()
    {
        return minVitamins;
    }

    /**
     * Returns the minimum amount of lipids for certain creature.
     */
    public int getMinimumLipids()
    {
        return minLipids;
    }

    /**
     * Returns true if the creature is ridable.
     */
    public boolean isRidable()
    {
        return isRidable;
    }

    /**
     * Returns how fast the creature can move when a player is riding it.
     */
    public float getRidingSpeed()
    {
        return ridingSpeed;
    }

    /**
     * Returns the favorite food of the creature as a Item[].
     */
    public Item[] getRidingItemList()
    {
        return ridingItemList;
    }

    /**
     * Returns if the list of riding items contains certain item.
     */
    public static boolean isRidingItem(byte i, Item item)
    {
        for (int n = 0; n < JurassiCraftCreatureInformation.values()[i].getRidingItemList().length; n++)
        {
            if (item.equals(JurassiCraftCreatureInformation.values()[i].getRidingItemList()[n]))
            {
                return true;
            }
        }
        return false;
    }

    private byte creatureID;
    private final String creatureName;
    private final double minHealth;
    private final double minStrength;
    private final double minSpeed;
    private final float minHeight;
    private final float minLength;
    private final double minKnockback;
    private final double maxHealth;
    private final double maxStrength;
    private final double maxSpeed;
    private final float maxHeight;
    private final float maxLength;
    private final double maxKnockback;
    private final float xzBoxMin;
    private final float yBoxMin;
    private final float xzBoxDelta;
    private final float yBoxDelta;
    private final int fullGrowthTime;
    private final byte timesOfGrowth;
    private final Item[] favoriteFoodList;
    private boolean isRidable;
    private float ridingSpeed;
    private Item[] ridingItemList;
    private short hatchSpeed;
    private byte numberOfStages;
    private int minProximate;
    private int minMinerals;
    private int minVitamins;
    private int minLipids;
}