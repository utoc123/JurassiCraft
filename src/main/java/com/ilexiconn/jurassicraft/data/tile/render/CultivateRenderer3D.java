package com.ilexiconn.jurassicraft.data.tile.render;

import com.ilexiconn.jurassicraft.data.block.model.ModelCultivate;
import com.ilexiconn.jurassicraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class CultivateRenderer3D implements IItemRenderer
{
    public ModelCultivate model = new ModelCultivate();

    public boolean handleRenderType(ItemStack item, ItemRenderType type)
    {
        return true;
    }

    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
    {
        switch(helper)
        {
            case ENTITY_ROTATION:
            case ENTITY_BOBBING: return true;
            default: return false;
        }
    }

    public void renderItem(ItemRenderType type, ItemStack item, Object... data)
    {
        boolean firstPerson = false;
        int renderType = 0;
        switch(type)
        {
            case ENTITY:
            {
                renderType = 2;
            }
            case INVENTORY:
            {
                if (renderType == 0)
                {
                    renderType = 1;
                }
            }
            case EQUIPPED_FIRST_PERSON:
            {
                if (renderType == 0)
                {
                    firstPerson = true;
                }
            }
            case EQUIPPED:
            {
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

                GL11.glPushMatrix();

                GL11.glEnable(GL11.GL_BLEND);
                GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

                GL11.glRotatef(180f, 0.0f, 0.0f, 1.0f);

                float scale = (renderType == 1 ? 6.2f : renderType == 2 ? 0.3f : 0.55f) * 0.5f;

                if (renderType == 0)
                {
                    GL11.glScalef(scale, scale, scale);

                    GL11.glRotatef(15f, 0.0f, 0.0f, 1.0f);

                    GL11.glTranslatef(-3.0f, 1.0f, 0.0f);

                    if (!firstPerson)
                    {
                        float scale1 = 3f;
                        GL11.glTranslatef(1.0f, -3.0f, 0.0f);
                        GL11.glRotatef(-135f, 1.0f, -1.0f, -0.3f);

                        GL11.glScalef(scale1, scale1, scale1);
                        GL11.glRotatef(-7.5f, 0.0f, 1.0f, 0.0f);
                        GL11.glRotatef(80f, 0.0f, 0.0f, 1.0f);
                        GL11.glRotatef(10f, 1.0f, 0.0f, 1.0f);
                    }
                    else
                    {
                        GL11.glScalef(4f, 4f, 4f);
                        GL11.glTranslatef(0f, -0.5f, 0f);
                    }
                }
                else if (renderType == 1)
                {
                    GL11.glScalef(-scale * 2, -scale * 2, -scale * 2);

                    GL11.glRotatef(35f, 1.0f, 0.0f, 0.0f);

                    GL11.glRotatef(-50f, 0.0f, 1.0f, 0.0f);

                    GL11.glTranslatef(3.08f, 3.1f, 0.9f);
                }
                else if (renderType == 2)
                {
                    GL11.glTranslatef(0.0f, -0.8f, 0.0f);
                    GL11.glScalef(scale * 4, scale * 4, scale * 4);
                }

                Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(Util.getModId() + "textures/blocks/cultivate_idle.png"));

                model.render();

                GL11.glDisable(GL11.GL_BLEND);

                GL11.glPopMatrix();
            }
        }
    }
}
