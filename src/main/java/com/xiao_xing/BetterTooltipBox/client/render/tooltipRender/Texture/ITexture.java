package com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Texture;

import net.minecraft.util.ResourceLocation;

public interface ITexture {

    ResourceLocation getResourceLocation();

    float getWidth();

    float getHeight();

    float getMaxU();

    float getMaxV();

    float getMinU();

    float getMinV();

}
