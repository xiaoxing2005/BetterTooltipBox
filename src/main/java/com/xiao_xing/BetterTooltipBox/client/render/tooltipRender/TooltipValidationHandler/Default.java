package com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.TooltipValidationHandler;

import com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Texture.TooltipsTexture;
import net.minecraft.item.ItemStack;

public class Default implements ITooltipValidationHandler {

    @Override
    public TooltipsTexture TooltipValidation(String modId, ItemStack itemStack) {
        return null;
    }
}
