package to.uk.ilexiconn.jurassicraft.client.gui;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import to.uk.ilexiconn.jurassicraft.Util;
import to.uk.ilexiconn.jurassicraft.entity.Dinosaur;
import to.uk.ilexiconn.jurassicraft.entity.EntityJurassiCraftTameable;
import to.uk.ilexiconn.jurassicraft.entity.mammal.EntityPregnantCow;
import to.uk.ilexiconn.jurassicraft.entity.mammal.EntityPregnantHorse;
import to.uk.ilexiconn.jurassicraft.entity.mammal.EntityPregnantPig;
import to.uk.ilexiconn.jurassicraft.entity.mammal.EntityPregnantSheep;
import to.uk.ilexiconn.jurassicraft.tile.TileCultivate;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiPregnancyProgress extends GuiScreen
{

	public static Object creatureToAnalyze;
	private EntityAnimal creature;
	private float renderRotation;
    private int xSize;
    private int ySize;
    private int guiLeft;
    private int guiTop;

    public GuiPregnancyProgress()
    {
        super();
		this.renderRotation = 0.0F;
		this.xSize = 256;
		this.ySize = 176;
		if (this.creatureToAnalyze instanceof EntityAnimal && ((EntityAnimal) this.creatureToAnalyze).getGrowingAge() == 0) 
		{
			if (this.creatureToAnalyze instanceof EntityCow) {
				EntityPregnantCow cow = EntityPregnantCow.get(((EntityCow) this.creatureToAnalyze));
				if (cow != null && !cow.getMammalName().equals("None") || !cow.getMammalName().equals("")) {
					this.creature = (EntityCow) this.creatureToAnalyze;
				}
			} else if (this.creatureToAnalyze instanceof EntityPig) {
				EntityPregnantPig pig = EntityPregnantPig.get(((EntityPig) this.creatureToAnalyze));
				if (pig != null && !pig.getMammalName().equals("None") || !pig.getMammalName().equals("")) {
					this.creature = (EntityPig) this.creatureToAnalyze;
				}
			} else if (this.creatureToAnalyze instanceof EntityHorse) {
				EntityPregnantHorse horse = EntityPregnantHorse.get(((EntityHorse) this.creatureToAnalyze));
				if (horse != null && !horse.getMammalName().equals("None") || !horse.getMammalName().equals("")) {
					this.creature = (EntityHorse) this.creatureToAnalyze;
				}
			} else if (this.creatureToAnalyze instanceof EntitySheep) {
				EntityPregnantSheep sheep = EntityPregnantSheep.get(((EntitySheep) this.creatureToAnalyze));
				if (sheep != null && !sheep.getMammalName().equals("None") || !sheep.getMammalName().equals("")) {
					this.creature = (EntitySheep) this.creatureToAnalyze;
				}
			} else {
	            this.mc.thePlayer.closeScreen();
			}
		}
    }

	@Override
	public void updateScreen() 
	{
		this.renderRotation++;
		if (!this.creature.isEntityAlive()) 
		{
			this.mc.thePlayer.closeScreen();
		}
	}
	
    @Override
    public void onGuiClosed()
    {
        super.onGuiClosed();
    }

    @Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }

    @Override
    protected void keyTyped(char var1, int key)
    {
        if (key == 1 || key == this.mc.gameSettings.keyBindInventory.getKeyCode())
        {
            this.mc.thePlayer.closeScreen();
        }
    }

    @Override
    public void initGui()
    {
        super.initGui();
        this.guiLeft = (int) ((this.width - this.xSize) / 2);
        this.guiTop = (int) ((this.height - this.ySize) / 2);
    }

    @Override
    public void drawScreen(int x, int y, float f)
    {
		drawDefaultBackground();
		mc.renderEngine.bindTexture(new ResourceLocation(Util.getModId() + "textures/gui/guiPragnancyProgress.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);

		if (this.creature.isEntityAlive()) 
		{
			if (this.creature instanceof EntityCow) 
			{
				EntityPregnantCow cow = EntityPregnantCow.get(((EntityCow) this.creature));
				if (cow.getPregnancyProgress() >= cow.getPregnancySpeed()) 
				{
					this.mc.thePlayer.closeScreen();
				} 
				else 
				{
					this.drawTexturedModalRect(this.guiLeft + 140, this.guiTop + 80, 0, 202, 98, 8);
					this.drawTexturedModalRect(this.guiLeft + 141, this.guiTop + 81, 1, 182, cow.getPregnancyProgressScaled(95), 5);
					this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.pragnancy.cow"), this.guiLeft + 127 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.pragnancy.cow")) / 2, this.guiTop + 14, 14737632);
					this.fontRendererObj.drawString(cow.getMammalName() + ": " + cow.getPregnancyProgressScaled(100) + "%", this.guiLeft + 146, this.guiTop + 70, 14737632);
				}
			} 
			else if (this.creature instanceof EntityPig) 
			{
				EntityPregnantPig pig = EntityPregnantPig.get(((EntityPig) this.creature));
				if (pig.getPregnancyProgress() >= pig.getPregnancySpeed()) 
				{
					this.mc.thePlayer.closeScreen();
				} 
				else 
				{
					this.drawTexturedModalRect(this.guiLeft + 140, this.guiTop + 80, 0, 202, 98, 8);
					this.drawTexturedModalRect(this.guiLeft + 141, this.guiTop + 81, 1, 182, pig.getPregnancyProgressScaled(95), 5);
					this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.pragnancy.pig"), this.guiLeft + 127 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.pragnancy.pig")) / 2, this.guiTop + 14, 14737632);
					this.fontRendererObj.drawString(pig.getMammalName() + ": " + pig.getPregnancyProgressScaled(100) + "%", this.guiLeft + 146, this.guiTop + 70, 14737632);
				}
			} 
			else if (this.creature instanceof EntityHorse) 
			{
				EntityPregnantHorse horse = EntityPregnantHorse.get(((EntityHorse) this.creature));
				if (horse.getPregnancyProgress() >= horse.getPregnancySpeed()) 
				{
					this.mc.thePlayer.closeScreen();
				} 
				else 
				{
					this.drawTexturedModalRect(this.guiLeft + 140, this.guiTop + 80, 0, 202, 98, 8);
					this.drawTexturedModalRect(this.guiLeft + 141, this.guiTop + 81, 1, 182, horse.getPregnancyProgressScaled(95), 5);
					this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.pragnancy.horse"), this.guiLeft + 127 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.pragnancy.horse")) / 2, this.guiTop + 14, 14737632);
					this.fontRendererObj.drawString(horse.getMammalName() + ": " + horse.getPregnancyProgressScaled(100) + "%", this.guiLeft + 146, this.guiTop + 70, 14737632);
				}
			} 
			else if (this.creature instanceof EntitySheep) 
			{
				EntityPregnantSheep sheep = EntityPregnantSheep.get(((EntitySheep) this.creature));
				if (sheep.getPregnancyProgress() >= sheep.getPregnancySpeed()) 
				{
					this.mc.thePlayer.closeScreen();
				} 
				else 
				{
					this.drawTexturedModalRect(this.guiLeft + 140, this.guiTop + 80, 0, 202, 98, 8);
					this.drawTexturedModalRect(this.guiLeft + 141, this.guiTop + 81, 1, 182, sheep.getPregnancyProgressScaled(95), 5);
					this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.pragnancy.sheep"), this.guiLeft + 127 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.pragnancy.sheep")) / 2, this.guiTop + 14, 14737632);
					this.fontRendererObj.drawString(sheep.getMammalName() + ": " + sheep.getPregnancyProgressScaled(100) + "%", this.guiLeft + 146, this.guiTop + 70, 14737632);
				}
			}
			this.renderCreature((float) (this.guiLeft + 67), (float) (this.guiTop + 108), 30.0F);
		}
		super.drawScreen(x, y, f);
	}

	private void renderCreature(float posX, float posY, float scale) 
	{
		GL11.glEnable(GL11.GL_COLOR_MATERIAL);
		GL11.glPushMatrix();
		GL11.glTranslatef( posX, posY, 50.0F);
		GL11.glScalef(-scale, scale, scale);
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
		RenderHelper.enableStandardItemLighting();
		GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(1.5F * this.renderRotation, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(0.0F, creature.yOffset, 0.0F);
		RenderManager.instance.playerViewY = 180.0F;
		RenderManager.instance.renderEntityWithPosYaw(creature, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
		GL11.glPopMatrix();
		RenderHelper.disableStandardItemLighting();
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
	}
}
