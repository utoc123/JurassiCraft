package com.ilexiconn.jurassicraft.data.entity.render;

import com.ilexiconn.jurassicraft.JurassiCraft;
import com.ilexiconn.jurassicraft.data.entity.Dinosaur;
import com.ilexiconn.jurassicraft.data.entity.RenderDinosaur;
import com.ilexiconn.jurassicraft.data.entity.entity.EntityDilophosaurus;
import com.ilexiconn.jurassicraft.data.entity.model.ModelDilophosaurus;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderDilophosaurus extends RenderDinosaur
{
    public RenderDilophosaurus(Dinosaur dino)
    {
        super(new ModelDilophosaurus(), dino, 2f);
    }

    public ResourceLocation getEntityTexture(Entity var1)
    {
    	EntityDilophosaurus ank = (EntityDilophosaurus)var1;
    	switch(ank.texid)
    	{
    	case 1:
    		default:
        return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/dilophosaurus1.png");
    	case 0:
        return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/dilophosaurus2.png");
    	}
    }
}