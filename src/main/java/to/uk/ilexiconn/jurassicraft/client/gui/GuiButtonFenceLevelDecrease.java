package to.uk.ilexiconn.jurassicraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import to.uk.ilexiconn.jurassicraft.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiButtonFenceLevelDecrease extends GuiButton 
{
	
	public GuiButtonFenceLevelDecrease(int id, int xPos, int yPos, int width, int height) 
	{
		super(id, xPos, yPos, width, height, "");
	}

	@Override
	public void drawButton(Minecraft mc, int x, int y) 
    {
		if (this.visible)
        {
			if (this.enabled)
	        {
	            FontRenderer fontrenderer = mc.fontRenderer;
		        mc.renderEngine.bindTexture(new ResourceLocation(Util.getModId() + "textures/gui/guiSecurityFence.png"));
	            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	            GL11.glEnable(GL11.GL_BLEND);
	            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
	            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	            if (x >= this.xPosition && y >= this.yPosition && x < this.xPosition + this.width && y < this.yPosition + this.height) 
	            {
	            	this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 207, this.width, this.height);
	            }
	            this.mouseDragged(mc, x, y);
	        } else {
	        	FontRenderer fontrenderer = mc.fontRenderer;
		        mc.renderEngine.bindTexture(new ResourceLocation(Util.getModId() + "textures/gui/guiSecurityFence.png"));
	            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	            GL11.glEnable(GL11.GL_BLEND);
	            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				this.drawTexturedModalRect(this.xPosition, this.yPosition, 10, 207, this.width, this.height);
				this.mouseDragged(mc, x, y);
	        }
        }
    }
}