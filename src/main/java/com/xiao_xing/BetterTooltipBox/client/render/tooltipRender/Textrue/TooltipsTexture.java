package com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Textrue;

import net.minecraft.util.ResourceLocation;

public class TooltipsTexture implements ITexture{

    private final ResourceLocation resourceLocation;
    private final int width;
    private final int height;
    private float maxU;
    private float maxV;
    private float minU;
    private float minV;

    public TooltipsTexture(ResourceLocation resourceLocation,int resourceWidth,int resourceHeight,
                          int textureWidth,int textureHeight,
                          int textureX,int textureY){
        this.resourceLocation = resourceLocation;
        this.width = textureWidth;
        this.height = textureHeight;
        calculateUV(resourceWidth,resourceHeight,textureX,textureY);
    }

    private void calculateUV(int resourceWidth,int resourceHeight,int textureX,int textureY){
        this.minU = (float) textureX / resourceWidth;
        this.minV = (float) textureY / resourceHeight;
        this.maxU = (float) (textureX + this.width) / resourceWidth;
        this.maxV = (float) (textureY + this.height) / resourceHeight;
    }

    @Override
    public ResourceLocation getResourceLocation() {
        return this.resourceLocation;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public float getMaxU() {
        return this.maxU;
    }

    @Override
    public float getMaxV() {
        return this.maxV;
    }

    @Override
    public float getMinU() {
        return this.minU;
    }

    @Override
    public float getMinV() {
        return this.minV;
    }
}
