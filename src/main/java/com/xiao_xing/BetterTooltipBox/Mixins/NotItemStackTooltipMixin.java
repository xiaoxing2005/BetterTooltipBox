package com.xiao_xing.BetterTooltipBox.Mixins;

import java.util.List;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

import com.xiao_xing.BetterTooltipBox.Util.TooltipHelper;

import cpw.mods.fml.common.Loader;
import squeek.applecore.client.TooltipOverlayHandler;

@Mixin(value = GuiScreen.class)
public class NotItemStackTooltipMixin extends Gui {

    @Shadow
    protected FontRenderer fontRendererObj;

    @Shadow
    protected static RenderItem itemRender;

    @Shadow
    public int width;

    @Shadow
    public int height;

    /**
     * @author xiao_xing521
     * @reason 修改Tooltip提示框
     */
    @Overwrite(remap = false)
    public void func_146283_a(List<String> textLines, int x, int y) {
        betterTooltipBox$drawHoveringText(textLines, x, y, fontRendererObj);
    }

    @Unique
    protected void betterTooltipBox$drawHoveringText(List<String> textLines, int x, int y, FontRenderer font) {
        if (!textLines.isEmpty()) {
            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
            RenderHelper.disableStandardItemLighting();
            GL11.glDisable(GL11.GL_LIGHTING);
            GL11.glDisable(GL11.GL_DEPTH_TEST);
            int k = 0;

            for (String s : textLines) {
                int l = font.getStringWidth(s);

                if (l > k) {
                    k = l;
                }
            }

            int j2 = x + 12;
            int k2 = y - 12;
            int i1 = 8;

            if (textLines.size() > 1) {
                i1 += 2 + (textLines.size() - 1) * 10;
            }

            if (j2 + k > this.width) {
                j2 -= 28 + k;
            }

            if (k2 + i1 + 6 > this.height) {
                k2 = this.height - i1 - 6;
            }

            this.zLevel = 300.0F;
            itemRender.zLevel = 300.0F;

            if (Loader.isModLoaded("AppleCore")) {
                TooltipOverlayHandler.toolTipX = j2 + 2;
                TooltipOverlayHandler.toolTipY = k2 + 2;
                TooltipOverlayHandler.toolTipW = k;
                TooltipOverlayHandler.toolTipH = i1;
            }
            TooltipHelper.z = 300;
            TooltipHelper.DrawTooltip(j2 - 2, k2 - 2, k + 4, i1 + 4);

            for (int i2 = 0; i2 < textLines.size(); ++i2) {
                String s1 = (String) textLines.get(i2);
                font.drawStringWithShadow(s1, j2, k2, -1);

                if (i2 == 0) {
                    k2 += 2;
                }

                k2 += 10;
            }

            this.zLevel = 0.0F;
            itemRender.zLevel = 0.0F;
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glEnable(GL11.GL_DEPTH_TEST);
            RenderHelper.enableStandardItemLighting();
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        }
    }
}
