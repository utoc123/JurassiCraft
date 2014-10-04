package to.uk.ilexiconn.jurassicraft;

import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import to.uk.ilexiconn.jurassicraft.client.render.item.ItemCultivateRenderer;
import to.uk.ilexiconn.jurassicraft.client.render.item.ItemDNACombinatorRenderer;
import to.uk.ilexiconn.jurassicraft.client.render.item.ItemDNAExtractorRenderer;
import to.uk.ilexiconn.jurassicraft.client.render.item.ItemDinoPadRenderer;
import to.uk.ilexiconn.jurassicraft.client.render.tile.TileCultivateRenderer;
import to.uk.ilexiconn.jurassicraft.client.render.tile.TileDNACombinatorRenderer;
import to.uk.ilexiconn.jurassicraft.client.render.tile.TileDNAExtractorRenderer;
import to.uk.ilexiconn.jurassicraft.client.render.tile.TileDinoPadRenderer;
import to.uk.ilexiconn.jurassicraft.entity.EntityDinoEgg;
import to.uk.ilexiconn.jurassicraft.entity.render.RenderDinoEgg;
import to.uk.ilexiconn.jurassicraft.tile.TileCultivate;
import to.uk.ilexiconn.jurassicraft.tile.TileDNACombinator;
import to.uk.ilexiconn.jurassicraft.tile.TileDNAExtractor;
import to.uk.ilexiconn.jurassicraft.tile.TileDinoPad;
import to.uk.ilexiconn.llib.content.ContentHandler;
import to.uk.ilexiconn.llib.content.ContentType;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
@ContentHandler(modid = "jurassicraft", type = ContentType.UNDEFINED, priority = EventPriority.LOW)
public class ModRenderers
{
    public void init()
    {
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.cultivateBottomOff), new ItemCultivateRenderer());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.dnaExtractor), new ItemDNAExtractorRenderer());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.dnaCombinator), new ItemDNACombinatorRenderer());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.dinoPad), new ItemDinoPadRenderer());
        MinecraftForgeClient.registerItemRenderer(ModItems.dinoPad, new ItemDinoPadRenderer());

        RenderingRegistry.registerEntityRenderingHandler(EntityDinoEgg.class, new RenderDinoEgg());
        
        ClientRegistry.bindTileEntitySpecialRenderer(TileDNACombinator.class, new TileDNACombinatorRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCultivate.class, new TileCultivateRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileDNAExtractor.class, new TileDNAExtractorRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileDinoPad.class, new TileDinoPadRenderer());
    }
}
