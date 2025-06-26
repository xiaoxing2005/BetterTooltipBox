package com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Textrue;

import static com.xiao_xing.BetterTooltipBox.BetterTooltipBox.LOG;
import static com.xiao_xing.BetterTooltipBox.BetterTooltipBox.ResourceID;

import java.util.HashMap;

import com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.TooltipValidationHandler.ITooltipValidationHandler;
import net.minecraft.util.ResourceLocation;

public class TextureManager {

    private static final HashMap<String, ITexture> TEXTURE_MAP = new HashMap<>();

//    static {
//        TEXTURE_MAP.put("default", new ResourceLocation(ResourceID + "gui/tooltip_borders.png"));
//    }

    public static void register(String Name, ITexture iTexture) {
        if (TEXTURE_MAP.containsKey(Name)) {
            LOG.error("Texture {} already exists", Name);
            return;
        } else if (iTexture != null) {
            TEXTURE_MAP.put(Name, iTexture);
        }
        LOG.error("Texture {} register failed",Name);
    }

    public static ITexture getTexture(String TextureName) {
        if (TEXTURE_MAP.containsKey(TextureName)) {
            return TEXTURE_MAP.get(TextureName);
        }
        LOG.error("Texture {} not found", TextureName);
        return null;
    }

    public static ITexture getTexture(ITooltipValidationHandler handler){
        if(handler==null){
            return null;
        }
        return getTexture(handler.getTooltipName());
    }
}
