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
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.llamalad7.mixinextras.sugar.Local;
import com.xiao_xing.BetterTooltipBox.Util.TooltipHelper;

import cpw.mods.fml.common.Loader;
import squeek.applecore.client.TooltipOverlayHandler;

@Mixin(value = GuiScreen.class)
public class TooltipMixin extends Gui {

    @Shadow
    protected static RenderItem itemRender;

    @Inject(
        method = "drawHoveringText",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/gui/GuiScreen;drawGradientRect(IIIIII)V",
            shift = At.Shift.BEFORE),
        cancellable = true)
    private void onDrawHoveringText(List<String> textLines, int x, int y, FontRenderer font, CallbackInfo ci,
        @Local(ordinal = 2) int k, @Local(ordinal = 3) int j2, @Local(ordinal = 4) int k2, @Local(ordinal = 5) int i1) {
        TooltipHelper.z = 300;
        TooltipHelper.DrawTooltip(j2 - 2, k2 - 2, k + 4, i1 + 4);
        for (int i2 = 0; i2 < textLines.size(); ++i2) {
            if (Loader.isModLoaded("AppleCore")) {
                TooltipOverlayHandler.toolTipX = j2;
                TooltipOverlayHandler.toolTipY = k2;
                TooltipOverlayHandler.toolTipW = k;
                TooltipOverlayHandler.toolTipH = i1;
            }
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
        ci.cancel();
    }

}
