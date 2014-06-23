package com.ilexiconn.jurassicraft.thehippomaster.AnimationAPI.client;

import com.ilexiconn.jurassicraft.thehippomaster.AnimationAPI.AnimationAPI;
import com.ilexiconn.jurassicraft.thehippomaster.AnimationAPI.CommonProxy;
import com.ilexiconn.jurassicraft.thehippomaster.AnimationExample.EntityTest;
import com.ilexiconn.jurassicraft.thehippomaster.AnimationExample.client.ModelTest;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.util.Timer;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.ReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
	
	public void initTimer() {
		mcTimer = ReflectionHelper.getPrivateValue(Minecraft.class, Minecraft.getMinecraft(), AnimationAPI.fTimer);
	}
	
	public float getPartialTick() {
		return mcTimer.renderPartialTicks;
	}
	
	private Timer mcTimer;
}
