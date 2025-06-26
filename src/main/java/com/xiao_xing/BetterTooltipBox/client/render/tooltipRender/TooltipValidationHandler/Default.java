package com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.TooltipValidationHandler;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;

public class Default extends ModIdValidationBase {

    @Override
    public boolean modIdCheck(String modId, ItemStack itemStack) {
        return modId.equals("minecraft");
    }

    @Override
    public String getTooltipName() {
        return "Default";
    }
}
