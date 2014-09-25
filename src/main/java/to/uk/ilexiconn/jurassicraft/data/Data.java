package to.uk.ilexiconn.jurassicraft.data;

import to.uk.ilexiconn.jurassicraft.Util;
import to.uk.ilexiconn.jurassicraft.data.gui.GuiHandler;
import to.uk.ilexiconn.jurassicraft.data.world.gen.WorldGenAmberOre;
import to.uk.ilexiconn.jurassicraft.data.world.gen.WorldGenFossilOre;

public final class Data extends Util
{
    public void init()
    {
        /** World Generators */
        {
            addWorldGenerator(new WorldGenFossilOre(), 1);
            addWorldGenerator(new WorldGenAmberOre(), 2);
        }

        /** Other stuff */
        {
            addGuiHandler(new GuiHandler());
        }
    }
}
