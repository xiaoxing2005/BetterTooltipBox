package com.xiao_xing.BetterTooltipBox.Util;

import static com.xiao_xing.BetterTooltipBox.BetterTooltipBox.ResourceID;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class TooltipHelper {

    private static final Minecraft mc = Minecraft.getMinecraft();

    private static final ResourceLocation TEXTURE_TOOLTIP = new ResourceLocation(ResourceID + "gui/Tooltip.png");

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
        mc.getTextureManager()
            .bindTexture(TEXTURE_TOOLTIP_BACKGROUND);

        float texWidth = 64.0f; // 纹理的实际宽度
        float texHeight = 64.0f; // 纹理的实际高度

        renderQuad(tessellator, x, y, width, height, 0, 0, 64, 64, texWidth, texHeight);
    }

    private static void renderBorder(int x, int y, int width, int height) {
        mc.getTextureManager()
            .bindTexture(TEXTURE_TOOLTIP);

        float texWidth = 64.0f; // 纹理的实际宽度
        float texHeight = 64.0f; // 纹理的实际高度

        Tessellator tessellator = Tessellator.instance;
        // 左上角
        renderQuad(tessellator, x - 1, y - 1, 3, 3, 16, 16, 19, 19, texWidth, texHeight);
        // 右上角
        renderQuad(tessellator, x + width - 2, y - 1, 3, 3, 43, 16, 46, 19, texWidth, texHeight);
        // 左下角
        renderQuad(tessellator, x - 1, y + height - 2, 3, 3, 16, 43, 19, 46, texWidth, texHeight);
        // 右下角
        renderQuad(tessellator, x + width - 2, y + height - 2, 3, 3, 43, 43, 46, 46, texWidth, texHeight);

        // 左边
        renderQuad(tessellator, x - 1, y + 2, 1, height - 3d, 16, 19, 17, 43, texWidth, texHeight);
        // 右边
        renderQuad(tessellator, x + width, y + 2, 1, height - 3d, 45, 19, 46, 43, texWidth, texHeight);
        // 上边
        renderQuad(tessellator, x + 2, y - 1, ((double) width / 2) - 7.5d, 1, 19, 16, 26, 17, texWidth, texHeight);
        renderQuad(
            tessellator,
            x + ((double) width / 2) + 7.5d,
            y - 1,
            ((double) width / 2) - 8.5d,
            1,
            36,
            16,
            43,
            17,
            texWidth,
            texHeight);
        // 下边
        renderQuad(tessellator, x + 2, y + height, width - 3d, 1, 18, 45, 43, 46, texWidth, texHeight);
        // 顶部中央
        renderQuad(tessellator, x + ((double) width / 2) - 5.5d, y, 2, 1, 26, 17, 28, 18, texWidth, texHeight);
        renderQuad(tessellator, x + ((double) width / 2) + 5.5d, y, 2, 1, 34, 17, 36, 18, texWidth, texHeight);
        renderQuad(tessellator, x + +((double) width / 2) - 4.5, y - 5, 11, 7, 2, 2, 13, 9, texWidth, texHeight);

    }

    private static void renderQuad(Tessellator tessellator, double x, double y, double width, double height,
        double uStart, double vStart, double uEnd, double vEnd, double texWidth, double texHeight) {
        double uMin = uStart / texWidth;
        double vMin = vStart / texHeight;
        double uMax = uEnd / texWidth;
        double vMax = vEnd / texHeight;

        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(x, y, 0, uMin, vMin);
        tessellator.addVertexWithUV(x, y + height, 0, uMin, vMax);
        tessellator.addVertexWithUV(x + width, y + height, 0, uMax, vMax);
        tessellator.addVertexWithUV(x + width, y, 0, uMax, vMin);
        tessellator.draw();
    }
}
