package com.xiao_xing.BetterTooltipBox.Mixins.mixin;

import codechicken.lib.gui.GuiDraw;
import com.xiao_xing.BetterTooltipBox.Util.TooltipHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = GuiDraw.class, priority = 999)
public class NEIItemTooltipMixin {

    /**
     * @author xiao_xing521
     * @reason 修改Tooltip提示框
     */
    @Inject(method = "drawTooltipBox(IIIIIIII)V", at = @At(value = "HEAD"),remap = false, cancellable = true)
    private static void drawGradientRect(int x, int y, int w, int h, int bgStart, int bgEnd, int borderStart, int borderEnd, CallbackInfo ci) {
        TooltipHelper.NEIDrawTooltip(x, y, w, h);
        ci.cancel();
    }
}
