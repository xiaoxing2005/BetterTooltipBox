package com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Textrue;

import static com.xiao_xing.BetterTooltipBox.BetterTooltipBox.LOG;
import static com.xiao_xing.BetterTooltipBox.BetterTooltipBox.ResourceID;

import java.util.HashMap;

import com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.TooltipValidationHandler.ITooltipValidationHandler;
import net.minecraft.util.ResourceLocation;

public class TextureManager {

    private final HashMap<String, TooltipsTexture> TEXTURE_MAP = new HashMap<>();

    public static final TextureManager INSTANCE = new TextureManager();
//    static {
//        TEXTURE_MAP.put("default", new ResourceLocation(ResourceID + "gui/tooltip_borders.png"));
//    }

    public static TextureManager getInstance() {
        return INSTANCE;
    }

    public void register(String Name, TooltipsTexture Texture) {
        if (TEXTURE_MAP.containsKey(Name)) {
            LOG.error("Texture {} already exists", Name);
            return;
        } else if (Texture != null) {
            TEXTURE_MAP.put(Name, Texture);
        }
        LOG.error("Texture {} register failed",Name);
    }

    public TooltipsTexture getTexture(String TextureName) {
        if (TEXTURE_MAP.containsKey(TextureName)) {
            return TEXTURE_MAP.get(TextureName);
        }
        LOG.error("Texture {} not found", TextureName);
        return null;
    }

//    public static ITexture getTexture(ITooltipValidationHandler handler){
//        if(handler==null){
//            return null;
//        }
//        return getTexture(handler.getTooltipName());
//    }
}
