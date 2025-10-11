package com.xiao_xing.BetterTooltipBox.Mixins.mixin;

import static codechicken.lib.gui.GuiDraw.gui;

import com.gtnewhorizon.gtnhmixins.LateMixin;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import com.xiao_xing.BetterTooltipBox.Util.TooltipHelper;

import codechicken.lib.gui.GuiDraw;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = GuiDraw.class)
public class oldNEITooltipMixin {

    /**
     * @author xiao_xing521
     * @reason 修改Tooltip提示框
     */
    @Overwrite(remap = false)
    public static void drawTooltipBox(int x, int y, int width, int height) {
        TooltipHelper.z = (int) gui.getZLevel();
        TooltipHelper.DrawTooltip(x + 1, y - 1, width + 2, height + 2);
    }

    @Inject(method = "drawGradientRect", at = @At(value = "HEAD"),remap = false, cancellable = true)
    private static void drawGradientRect(int x, int y, int w, int h, int colour1, int colour2, CallbackInfo ci) {
        TooltipHelper.DrawTooltip(x - 3, y - 5, w + 5, h + 9);
        ci.cancel();
    }
}
