package com.rafamv.bygoneage.client.renderer.tileentity;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class RenderItemHatchery implements IItemRenderer {
	
	TileEntitySpecialRenderer render;
	private TileEntity tileEntity;
	
	public RenderItemHatchery(TileEntitySpecialRenderer render, TileEntity entity) {
		this.tileEntity = entity;
		this.render = render;
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}
	
	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}
	
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		GL11.glScalef(0.85F, 0.85F, 0.85F);
		GL11.glTranslatef(-0.5F, -0.7F, -0.5F);
		if (type == IItemRenderer.ItemRenderType.ENTITY) {
			GL11.glScalef(1.5F, 1.5F, 1.5F);
		}
		this.render.renderTileEntityAt(this.tileEntity, 0.0D, 0.0D, 0.0D, 0.0F);
	}
	
}
