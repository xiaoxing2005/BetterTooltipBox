package com.xiao_xing.BetterTooltipBox.Mixins;

import static codechicken.lib.gui.GuiDraw.gui;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import com.xiao_xing.BetterTooltipBox.Util.TooltipHelper;

import codechicken.lib.gui.GuiDraw;

@Mixin(value = GuiDraw.class, priority = 999)
public class ItemTooltipMixin {

    /**
     * @author xiao_xing521
     * @reason 修改Tooltip提示框
     */

    @Overwrite(remap = false)
    public static void drawTooltipBox(int x, int y, int w, int h, int bgStart, int bgEnd, int borderStart,
        int borderEnd) {
        TooltipHelper.z = (int) gui.getZLevel();
        TooltipHelper.DrawTooltip(x, y, w, h);
    }
}
