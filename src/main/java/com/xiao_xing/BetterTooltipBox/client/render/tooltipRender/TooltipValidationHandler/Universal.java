package com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.TooltipValidationHandler;

import com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Textrue.TooltipsTexture;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;

public class Universal implements ITooltipValidationHandler {

    private final String ModId;

    public Universal(String modId) {
        ModId = modId;
    }

    @Override
    public TooltipsTexture TooltipValidation(String modId, ItemStack itemStack) {
        return null;
    }
}
