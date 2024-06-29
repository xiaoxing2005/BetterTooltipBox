package com.xiao_xing.BetterTooltipBox.Util;

import static com.xiao_xing.BetterTooltipBox.BetterTooltipBox.ResourceID;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class TooltipHelper {

    private static Minecraft mc = Minecraft.getMinecraft();

    private static final ResourceLocation TEXTURE_TOOLTIP = new ResourceLocation(
        ResourceID + "gui/tooltip_borders.png");

    private static final ResourceLocation TEXTURE_TOOLTIP_BACKGROUND = new ResourceLocation(
        ResourceID + "gui/Tooltip_Background.png");

    public static void DrawTooltip(int x, int y, int width, int height) {
        GL11.glPushMatrix();
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        Tessellator tessellator = Tessellator.instance;

        // 绘制背景
        renderBackground(tessellator, x, y, width, height);

        // 绘制四个角
        renderBorder(x, y, width, height);

        GL11.glDisable(GL11.GL_BLEND);
        GL11.glPopMatrix();
    }

    private static void renderBackground(Tessellator tessellator, int x, int y, int width, int height) {
        Minecraft.getMinecraft()
            .getTextureManager()
            .bindTexture(TEXTURE_TOOLTIP_BACKGROUND);

        float texWidth = 256.0f; // 纹理的实际宽度
        float texHeight = 256.0f; // 纹理的实际高度

        renderQuad(tessellator, x, y, width, height, 3, 3, 253, 253, 256, 256);
    }

    private static void renderBorder(int x, int y, int width, int height) {
        Minecraft.getMinecraft()
            .getTextureManager()
            .bindTexture(TEXTURE_TOOLTIP);

        float texWidth = 128.0f; // 纹理的实际宽度
        float texHeight = 128.0f; // 纹理的实际高度

        Tessellator tessellator = Tessellator.instance;
        // 左上角
        renderQuad(tessellator, x - 4f, y - 4f, 8, 8, 1, 1, 7, 7, texWidth, texHeight);
        // 右上角
        renderQuad(tessellator, x + width - 5.3f, y - 4, 8, 8, 56, 1, 62, 7, texWidth, texHeight);
        // 左下角
        renderQuad(tessellator, x - 3.5f, y + height - 5.7f, 8, 8, 1, 7, 8, 14, texWidth, texHeight);
        // 右下角
        renderQuad(tessellator, x + width - 5.7f, y + height - 5.7f, 8, 8, 55, 7, 62, 14, texWidth, texHeight);

        // 中心
        renderQuad(
            tessellator,
            ((float) x + ((float) width / 2)) - 15.5f,
            y - 6,
            30,
            6,
            12,
            0,
            50,
            7,
            texWidth,
            texHeight);
    }

    private static void renderQuad(Tessellator tessellator, float x, float y, float width, float height, float uStart,
        float vStart, float uEnd, float vEnd, float texWidth, float texHeight) {
        float uMin = uStart / texWidth;
        float vMin = vStart / texHeight;
        float uMax = uEnd / texWidth;
        float vMax = vEnd / texHeight;

        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(x, y, 0, uMin, vMin);
        tessellator.addVertexWithUV(x, y + height, 0, uMin, vMax);
        tessellator.addVertexWithUV(x + width, y + height, 0, uMax, vMax);
        tessellator.addVertexWithUV(x + width, y, 0, uMax, vMin);
        tessellator.draw();
    }
}
