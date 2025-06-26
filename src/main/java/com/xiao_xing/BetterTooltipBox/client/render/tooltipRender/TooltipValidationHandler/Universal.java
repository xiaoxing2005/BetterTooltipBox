package com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.TooltipValidationHandler;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;

public class Universal extends ModIdValidationBase {

    private final String ModId;

    public Universal(String modId) {
        ModId = modId;
    }

    @Override
    public boolean modIdCheck(String modId, ItemStack itemStack) {
        return modId.equals(ModId);
    }

    @Override
    public String getTooltipName() {
        return ModId;
    }
}
