package com.xiao_xing.BetterTooltipBox.Mixins.mixin;

import static codechicken.lib.gui.GuiDraw.gui;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import com.xiao_xing.BetterTooltipBox.Util.TooltipHelper;

import codechicken.lib.gui.GuiDraw;
import cpw.mods.fml.common.Loader;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import squeek.applecore.client.TooltipOverlayHandler;

@Mixin(value = GuiDraw.class, priority = 999)
public class NEIItemTooltipMixin {

    /**
     * @author xiao_xing521
     * @reason 修改Tooltip提示框
     */

    @Overwrite(remap = false)
    public static void drawTooltipBox(int x, int y, int w, int h, int bgStart, int bgEnd, int borderStart,
        int borderEnd) {
        if (Loader.isModLoaded("AppleCore")) {
            TooltipOverlayHandler.toolTipX = x;
            TooltipOverlayHandler.toolTipY = y;
            TooltipOverlayHandler.toolTipW = w;
            TooltipOverlayHandler.toolTipH = h;
        }
        TooltipHelper.z = (int) gui.getZLevel();
        TooltipHelper.DrawTooltip(x, y, w, h);
    }

    @Inject(method = "drawGradientRect", at = @At(value = "HEAD"),remap = false, cancellable = true)
    private static void drawGradientRect(int x, int y, int w, int h, int colour1, int colour2, CallbackInfo ci) {
        TooltipHelper.DrawTooltip(x - 3, y - 5, w + 5, h + 9);
        ci.cancel();
    }
}
