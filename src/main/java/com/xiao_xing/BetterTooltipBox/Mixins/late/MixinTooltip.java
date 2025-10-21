package com.xiao_xing.BetterTooltipBox.Mixins.late;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import com.xiao_xing.BetterTooltipBox.Mixins.Interface.IMixinTooltip;

import mcp.mobius.waila.overlay.Tooltip;

@Mixin(value = Tooltip.class, remap = false)
public class MixinTooltip implements IMixinTooltip {

    @Shadow
    int w, h, x, y, ty;

    @Override
    public void betterTooltipBox$setTooltipY(int y) {
        this.y = y;
    }
}
