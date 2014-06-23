package com.ilexiconn.jurassicraft.thehippomaster.AnimationAPI;

import net.minecraft.entity.Entity;
import com.ilexiconn.jurassicraft.thehippomaster.AnimationAPI.packet.PacketAnim;
import com.ilexiconn.jurassicraft.thehippomaster.AnimationAPI.packet.PacketPipeline;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "AnimationAPI", name = "AnimationAPI", version = "1.2.1")
public class AnimationAPI {
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		packetPipeline.initialize();
		packetPipeline.registerPacket(PacketAnim.class);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		proxy.initTimer();
		packetPipeline.postInitialize();
	}
	
	public static boolean isClient() {
		return FMLCommonHandler.instance().getSide().isClient();
	}
	
	public static boolean isEffectiveClient() {
		return FMLCommonHandler.instance().getEffectiveSide().isClient();
	}
	
	public static void sendAnimPacket(IAnimatedEntity entity, int animID) {
		if(isEffectiveClient()) return;
		entity.setAnimID(animID);
		Entity e = (Entity)entity;
		packetPipeline.sendToAll(new PacketAnim((byte)animID, e.getEntityId()));
	}
	
	@Instance("AnimationAPI")
	public static AnimationAPI instance;
	@SidedProxy(clientSide="thehippomaster.AnimationAPI.client.ClientProxy", serverSide="thehippomaster.AnimationAPI.CommonProxy")
	public static CommonProxy proxy;
	public static final PacketPipeline packetPipeline = new PacketPipeline();
	
	public static final String[] fTimer;
	
	static {
		fTimer = new String[] {"field_71428_T", "S", "timer"};
	}
}
