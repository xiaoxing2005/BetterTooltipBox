package com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.TooltipValidationHandler;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;

import java.util.HashMap;

public interface ITooltipValidationHandler {

    public final static HashMap<String, ITooltipValidationHandler> TooltipValidationHandlerMap = new HashMap<>();

    boolean TooltipValidation(ItemStack itemStack);

    String getTooltipName();

}
