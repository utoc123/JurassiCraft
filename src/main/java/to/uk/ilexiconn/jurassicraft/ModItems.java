package to.uk.ilexiconn.jurassicraft;

import net.minecraft.item.Item;
import to.uk.ilexiconn.jurassicraft.item.ItemAmber;
import to.uk.ilexiconn.jurassicraft.item.ItemDinoBone;
import to.uk.ilexiconn.jurassicraft.item.ItemDinoPad;
import to.uk.ilexiconn.jurassicraft.item.ItemDinoSteak;
import to.uk.ilexiconn.jurassicraft.item.ItemFossil;
import to.uk.ilexiconn.jurassicraft.item.ItemGrowthSerum;
import to.uk.ilexiconn.jurassicraft.item.ItemGypsumPowder;
import to.uk.ilexiconn.jurassicraft.item.ItemOnAStick;
import to.uk.ilexiconn.llib.content.ContentHandler;
import to.uk.ilexiconn.llib.content.ContentType;
import cpw.mods.fml.common.eventhandler.EventPriority;

@ContentHandler(modid = "jurassicraft", type = ContentType.ITEM, priority = EventPriority.HIGH)
public class ModItems
{
    public static Item amber;
    public static Item fossil;
    public static Item dinoPad;
    public static Item dinoBone;
    public static Item growthSerum;
    public static Item gypsumPowder;
    public static Item dinoSteak;
    public static Item appleOnAStick;
    public static Item beefOnAStick;
    public static Item carrotOnAStick;
    public static Item fishOnAStick;
    public static Item porkOnAStick;
    public static Item wheatOnAStick;

    public void init()
    {
        amber = new ItemAmber();
        fossil = new ItemFossil();
        dinoBone = new ItemDinoBone();
        growthSerum = new ItemGrowthSerum();
        gypsumPowder = new ItemGypsumPowder();
        dinoPad = new ItemDinoPad();
        dinoSteak = new ItemDinoSteak();
        appleOnAStick = new ItemOnAStick("Apple");
        beefOnAStick = new ItemOnAStick("Beef");
        carrotOnAStick = new ItemOnAStick("Carrot");
        fishOnAStick = new ItemOnAStick("Fish");
        porkOnAStick = new ItemOnAStick("Pork");
        wheatOnAStick = new ItemOnAStick("Wheat");
    }
}
