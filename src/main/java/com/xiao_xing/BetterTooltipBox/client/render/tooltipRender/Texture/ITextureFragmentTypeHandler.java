package com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Texture;

@FunctionalInterface
public interface ITextureFragmentTypeHandler {
        float[] GenerateVertex(float x, float y, float width, float height,float fragmentWidth,float fragmentHeight,
                               float uMin, float uMax, float vMin, float vMax);
}
