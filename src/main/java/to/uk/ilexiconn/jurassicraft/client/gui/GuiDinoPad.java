package to.uk.ilexiconn.jurassicraft.client.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.Util;
import to.uk.ilexiconn.jurassicraft.entity.EntityJurassiCraftTameable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiDinoPad extends GuiScreen {

	private EntityJurassiCraftTameable creature;
	private int xSize;
	private int ySize;
	private int guiLeft;
	private int guiTop;

	public GuiDinoPad() 
	{
		super();
		if (JurassiCraft.creatureToAnalyze instanceof EntityJurassiCraftTameable) 
		{
			this.creature = (EntityJurassiCraftTameable) JurassiCraft.creatureToAnalyze;
			this.xSize = 256;
			this.ySize = 176;
		}
	}

	@Override
	public void initGui() 
	{
		this.buttonList.clear();
		this.guiLeft = (int) ((this.width - this.xSize) / 2);
		this.guiTop = (int) ((this.height - this.ySize) / 2);
	}

	@Override
	public boolean doesGuiPauseGame() 
	{
		return false;
	}

	@Override
	public void onGuiClosed() 
	{
		super.onGuiClosed();
	}

	@Override
	protected void keyTyped(char keyChar, int key) 
	{
		if (key == 1 || key == this.mc.gameSettings.keyBindInventory.getKeyCode()) 
		{
			this.mc.thePlayer.closeScreen();
		}
	}

	@Override
	public void updateScreen() 
	{
		if (this.creature.isDead) 
		{
			this.mc.thePlayer.closeScreen();
		}
	}

	@Override
	public void drawScreen(int x, int y, float f) 
	{
		drawDefaultBackground();
		mc.renderEngine.bindTexture(new ResourceLocation(Util.getModId() + "textures/gui/guiDinoPad.png"));
		drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		this.renderEmptyBars();
		this.renderStatusBars();
		this.renderCreature(this.guiLeft + 60, this.guiTop + 100, (int) (20 - 5 * this.creature.getCreatureScale()), (float) (this.guiLeft + 70) - x, (float) (this.guiTop + 100 - 50) - y, this.creature);
		this.renderNameGenderStrings();
		this.renderStatusStrings();
		this.renderTamedStrings();
		
		super.drawScreen(x, y, f);
	}

	private void renderEmptyBars() 
	{
		this.drawTexturedModalRect(this.guiLeft + 140, this.guiTop + 55, 0, 202, 98, 8);
		this.drawTexturedModalRect(this.guiLeft + 140, this.guiTop + 80, 0, 202, 98, 8);
		this.drawTexturedModalRect(this.guiLeft + 140, this.guiTop + 105, 0, 202, 98, 8);
	}

	private void renderStatusBars() 
	{
		this.drawTexturedModalRect(this.guiLeft + 141, this.guiTop + 56, 1, 177, this.creature.getCreatureHealthScaled(95), 5);
		this.drawTexturedModalRect(this.guiLeft + 141, this.guiTop + 81, 1, 182, this.creature.getCreatureAttackScaled(95), 5);
		this.drawTexturedModalRect(this.guiLeft + 141, this.guiTop + 106, 1, 187, this.creature.getCreatureSpeedScaled(95), 5);
	}

	private void renderNameGenderStrings() 
	{
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Creature: " + this.creature.getCreatureName()), this.guiLeft + 127 - this.fontRendererObj.getStringWidth("Creature: " + this.creature.getCreatureName()) / 2, this.guiTop + 11, 14737632);
		this.fontRendererObj.drawString(StatCollector.translateToLocal(this.creature.getCreatureAgeString() + ", " + this.creature.getCreatureGenderString()), this.guiLeft + 127 - this.fontRendererObj.getStringWidth(this.creature.getCreatureAgeString() + ", " + this.creature.getCreatureGenderString()) / 2, this.guiTop + 19, 14737632);
	}

	private void renderStatusStrings() 
	{
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Health: " + String.valueOf(this.creature.getCreatureCurrentHealth() + "/" + this.creature.getCreatureHealth())), this.guiLeft + 192 - this.fontRendererObj.getStringWidth("Health: " + String.valueOf(this.creature.getCreatureCurrentHealth() + "/" + this.creature.getCreatureHealth())) / 2, this.guiTop + 45, 14737632);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Attack: " + String.valueOf(this.creature.getCreatureAttack())), this.guiLeft + 192 - this.fontRendererObj.getStringWidth("Attack: " + String.valueOf(this.creature.getCreatureAttack())) / 2, this.guiTop + 70, 14737632);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Speed: " + String.valueOf(this.creature.getCreatureSpeed())), this.guiLeft + 192 - this.fontRendererObj.getStringWidth("Speed: " + String.valueOf(this.creature.getCreatureSpeed())) / 2, this.guiTop + 95, 14737632);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Height: " + String.valueOf(this.creature.getCreatureHeight())), this.guiLeft + 192 - this.fontRendererObj.getStringWidth("Height: " + String.valueOf(this.creature.getCreatureHeight())) / 2, this.guiTop + 116, 14737632);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Length: " + String.valueOf(this.creature.getCreatureLength())), this.guiLeft + 192 - this.fontRendererObj.getStringWidth("Length: " + String.valueOf(this.creature.getCreatureLength())) / 2, this.guiTop + 126, 14737632);
	}

	private void renderTamedStrings() 
	{
		if (creature.isTamed()) 
		{
			if (Util.getDinoByID(creature.getCreatureID()).isRidable && this.creature.isCreatureAdult()) 
			{
				this.fontRendererObj.drawString(StatCollector.translateToLocal("Owner: " + ((EntityJurassiCraftTameable) creature).getOwnerName()), this.guiLeft + 67 - this.fontRendererObj.getStringWidth("Owner: " + ((EntityJurassiCraftTameable) creature).getOwnerName()) / 2, this.guiTop + 112, 14737632);
				this.fontRendererObj.drawString(StatCollector.translateToLocal("Ridable"), this.guiLeft + 67 - this.fontRendererObj.getStringWidth("Ridable") / 2, this.guiTop + 122, 14737632);
			} 
			else 
			{
				this.fontRendererObj.drawString(StatCollector.translateToLocal("Owner: " + ((EntityJurassiCraftTameable) creature).getOwnerName()), this.guiLeft + 67 - this.fontRendererObj.getStringWidth("Owner: " + ((EntityJurassiCraftTameable) creature).getOwnerName()) / 2, this.guiTop + 122, 14737632);
			}
		}
		else 
		{
			this.fontRendererObj.drawString(StatCollector.translateToLocal("Owner: none"), this.guiLeft + 67 - this.fontRendererObj.getStringWidth("Owner: none") / 2, this.guiTop + 122, 14737632);
		}
	}

	private static void renderCreature(int posX, int posY, int scale, float rotation1, float rotation2, EntityLivingBase creature) 
	{
		GL11.glEnable(GL11.GL_COLOR_MATERIAL);
		GL11.glPushMatrix();
		GL11.glTranslatef((float) posX, (float) posY, 50.0F);
		GL11.glScalef((float) (-scale), (float) scale, (float) scale);
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
		RenderHelper.enableStandardItemLighting();
		GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(-((float) Math.atan((double) (rotation2 / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
		creature.renderYawOffset = (float) Math.atan((double) (rotation1 / 40.0F)) * 20.0F;
		creature.rotationYaw = (float) Math.atan((double) (rotation1 / 40.0F)) * 40.0F;
		creature.rotationPitch = -((float) Math.atan((double) (rotation2 / 40.0F))) * 20.0F;
		creature.rotationYawHead = creature.rotationYaw;
		creature.prevRotationYawHead = creature.rotationYaw;
		GL11.glTranslatef(0.0F, creature.yOffset, 0.0F);
		RenderManager.instance.playerViewY = 180.0F;
		RenderManager.instance.renderEntityWithPosYaw(creature, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
		GL11.glPopMatrix();
		RenderHelper.disableStandardItemLighting();
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
	}
}
