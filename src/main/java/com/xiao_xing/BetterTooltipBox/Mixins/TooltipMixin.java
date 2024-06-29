package com.xiao_xing.BetterTooltipBox.Mixins;

import java.util.Iterator;
import java.util.List;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderHelper;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import com.xiao_xing.BetterTooltipBox.Util.TooltipHelper;

@Mixin(value = GuiScreen.class)
public class TooltipMixin extends Gui {

    @Inject(
        method = "drawHoveringText",
        at = @At(value = "INVOKE", target = "Ljava/util/List;size()I", shift = At.Shift.BEFORE),
        slice = @Slice(
            from = @At(
                value = "INVOKE",
                target = "Lnet/minecraft/client/gui/GuiScreen;drawGradientRect(IIIIII)V",
                ordinal = 0)),
        locals = LocalCapture.CAPTURE_FAILHARD,
        cancellable = true)
    private void onDrawHoveringText(List<String> textLines, int x, int y, FontRenderer font, CallbackInfo ci, int k,
        Iterator<String> iterator, int j2, int k2, int i1, int j1, int k1, int l1) {
        TooltipHelper.DrawTooltip(j2, k2, k, i1);
        for (int i2 = 0; i2 < textLines.size(); ++i2) {
            String s1 = (String) textLines.get(i2);
            font.drawStringWithShadow(s1, j2, k2, -1);

            if (i2 == 0) {
                k2 += 2;
            }

            k2 += 10;
        }

        this.zLevel = 0.0F;
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        RenderHelper.enableStandardItemLighting();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        ci.cancel();
    }

}
