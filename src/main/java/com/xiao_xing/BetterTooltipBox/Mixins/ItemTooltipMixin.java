package com.xiao_xing.BetterTooltipBox.Mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import com.xiao_xing.BetterTooltipBox.Util.TooltipHelper;

import codechicken.lib.gui.GuiDraw;

@Mixin(value = GuiDraw.class, remap = false)
public class ItemTooltipMixin {

    /**
     * @author xiao_xing521
     * @reason 修改Tooltip提示框
     */

    @Overwrite
    public static void drawTooltipBox(int x, int y, int width, int height) {
        TooltipHelper.DrawTooltip(x, y, width, height);
    }
}
