package com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.TooltipValidationHandler;

import com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Texture.TooltipsTexture;
import net.minecraft.item.ItemStack;

import java.util.HashMap;

import static com.xiao_xing.BetterTooltipBox.BetterTooltipBox.LOG;

public interface ITooltipValidationHandler {

    HashMap<String, ITooltipValidationHandler> TooltipValidationHandlerMap = new HashMap<>();


    TooltipsTexture TooltipValidation(String name,ItemStack itemStack);

    static void register(String name, ITooltipValidationHandler handler){
        if (TooltipValidationHandlerMap.containsKey(name)) {
            return;
        }
        if (handler != null) {
            TooltipValidationHandlerMap.put(name, handler);
            return;
        }
        LOG.error("TooltipValidationHandler {} register failed", name);
    }


    static TooltipsTexture getTooltipValidation(String name, ItemStack itemStack){
        if (TooltipValidationHandlerMap.containsKey(name)) {
            ITooltipValidationHandler handler = TooltipValidationHandlerMap.get(name);
            if(handler!=null){
                return handler.TooltipValidation(name,itemStack);
            }
        }
        return null;
    }
}
