package com.ilexiconn.jurassicraft.data.tile.render;

import assets.jurassicraft.textures.models.blocks.ModelCultivate;
import com.ilexiconn.jurassicraft.Util;
import com.ilexiconn.jurassicraft.logger.LogType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
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
        boolean isFirstPerson = false;
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
                    isFirstPerson = true;
                }
            }
            case EQUIPPED:
            {
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

                GL11.glPushMatrix();

                GL11.glEnable(GL11.GL_BLEND);
                GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

                GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);

                float scale = (renderType == 1 ? 6.2F : renderType == 2 ? 0.3F : 0.55F) * 0.5F;

                if (renderType == 0)
                {
                    GL11.glScalef(scale, scale, scale);

                    GL11.glRotatef(15F, 0.0F, 0.0F, 1.0F);

                    GL11.glTranslatef(-3.0F, 1.0F, 0.0F);

                    if (!isFirstPerson)
                    {
                        float scale1 = 3f;
                        GL11.glTranslatef(1.0F, -3.0F, 0.0F);
                        GL11.glRotatef(-135F, 1.0F, -1.0F, -0.3F);

                        GL11.glScalef(scale1, scale1, scale1);
                        GL11.glRotatef(-7.5F, 0.0F, 1.0F, 0.0F);
                        GL11.glRotatef(80F, 0.0F, 0.0F, 1.0F);
                        GL11.glRotatef(10F, 1.0F, 0.0F, 1.0F);
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

                    GL11.glRotatef(35F, 1.0F, 0.0F, 0.0F);

                    GL11.glRotatef(-50F, 0.0F, 1.0F, 0.0F);

                    GL11.glTranslatef(3.08F, 3.1f, 0.9F);
                }
                else if (renderType == 2)
                {
                    GL11.glTranslatef(0.0F, -0.8F, 0.0F);
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
