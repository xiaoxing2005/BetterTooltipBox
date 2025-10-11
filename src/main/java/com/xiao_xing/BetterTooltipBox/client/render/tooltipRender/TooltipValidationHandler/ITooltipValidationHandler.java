package com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.TooltipValidationHandler;

import com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Textrue.TooltipsTexture;
import net.minecraft.item.ItemStack;

import java.util.HashMap;

import static com.xiao_xing.BetterTooltipBox.BetterTooltipBox.LOG;

public interface ITooltipValidationHandler {

    HashMap<String, ITooltipValidationHandler> TooltipValidationHandlerMap = new HashMap<>();

    TooltipsTexture TooltipValidation(String modId,ItemStack itemStack);

    static void register(String modId, ITooltipValidationHandler handler){
        if (TooltipValidationHandlerMap.containsKey(modId)) {
            return;
        }
        if (handler != null) {
            TooltipValidationHandlerMap.put(modId, handler);
            return;
        }
        LOG.error("TooltipValidationHandler {} register failed", modId);
    }

    static TooltipsTexture getTooltipValidation(String modId, ItemStack itemStack){
        if (TooltipValidationHandlerMap.containsKey(modId)) {
            ITooltipValidationHandler handler = TooltipValidationHandlerMap.get(modId);
            if(handler!=null){
                return handler.TooltipValidation(modId,itemStack);
            }
        }
        return null;
    }
}
