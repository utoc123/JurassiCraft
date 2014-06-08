package com.ilexiconn.jurassicraft.proxy;

import com.ilexiconn.jurassicraft.Util;
import com.ilexiconn.jurassicraft.data.entity.EntityLiopleurodon;
import com.ilexiconn.jurassicraft.data.entity.EntityStegosaur;
import com.ilexiconn.jurassicraft.data.entity.EntityTyrannosaurus;
import com.ilexiconn.jurassicraft.data.entity.model.ModelLiopleurodon;
import com.ilexiconn.jurassicraft.data.entity.model.ModelStegosaurus;
import com.ilexiconn.jurassicraft.data.entity.model.ModelTRex;
import com.ilexiconn.jurassicraft.data.entity.render.RenderLiopleurodon;
import com.ilexiconn.jurassicraft.data.entity.render.RenderStegosaur;
import com.ilexiconn.jurassicraft.data.entity.render.RenderTyrannosaurus;
import com.ilexiconn.jurassicraft.data.tile.render.CultivateRenderer3D;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends ServerProxy
{
    public void renderEntity()
    {
        RenderingRegistry.registerEntityRenderingHandler(Util.getEntityToRender(), Util.getEntityRenderer());
    }

    public void renderTileEntity()
    {
        ClientRegistry.bindTileEntitySpecialRenderer(Util.getTileEntityToRender(), Util.getTileEntityRenderer());
    }

    public void renderItems()
    {
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Util.getBlock(1)), new CultivateRenderer3D());
    }

    public void registerRenderInformation()
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityStegosaur.class, new RenderStegosaur(new ModelStegosaurus(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityLiopleurodon.class, new RenderLiopleurodon(new ModelLiopleurodon(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityTyrannosaurus.class, new RenderTyrannosaurus(new ModelTRex(), 0.5F));

    }
}
