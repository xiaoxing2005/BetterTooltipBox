package com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.TooltipValidationHandler;

import net.minecraft.item.ItemStack;

import com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Textrue.TooltipsTexture;

public class Universal implements ITooltipValidationHandler {

    private final String ModId;

    public Universal(String modId) {
        ModId = modId;
    }

    @Override
    public TooltipsTexture TooltipValidation(String name, ItemStack itemStack) {
        return null;
    }
}
