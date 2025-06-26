package com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Tooltip;

import java.util.HashMap;

import net.minecraft.util.ResourceLocation;

import org.joml.Vector2f;

public abstract class TooltipBase {

    private static final HashMap<String, TooltipBase> ALL_TOOLTIP_MAP = new HashMap<>();
    private final String Name;
    private final ResourceLocation Texture;
    private final Vector2f TextureSize;

    public TooltipBase(String Name, ResourceLocation texture, Vector2f textureSize) {
        this.Texture = texture;
        this.Name = Name;
        this.TextureSize = textureSize;
        ALL_TOOLTIP_MAP.put(Name, this);
    }

    public ResourceLocation getTexture() {
        return this.Texture;
    }

    public String getName() {
        return this.Name;
    }

    public static TooltipBase getTooltip(String Name) {
        if (ALL_TOOLTIP_MAP.containsKey(Name)) {
            return ALL_TOOLTIP_MAP.get(Name);
        }
        return null;
    }

    public abstract void drawTooltip(float x, float y, float width, float height);

    public Vector2f getTextureSize() {
        return TextureSize;
    }

    public String getTextureSizeStr() {
        return String.valueOf(TextureSize.x) + ',' + TextureSize.y;
    }
}
