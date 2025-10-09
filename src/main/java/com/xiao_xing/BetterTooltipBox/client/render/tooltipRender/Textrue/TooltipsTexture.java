package com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Textrue;

import net.minecraft.util.ResourceLocation;

import java.nio.FloatBuffer;
import java.util.ArrayList;

import static com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Textrue.TooltipsTexture.TextureFragmentType.Top_Center;

public class TooltipsTexture{

    private final ResourceLocation resourceLocation;
    private final int[][] backgroundColor;
    private final int[][] lineColor;
    private final int width;
    private final int height;
    public int CenterFragmentWidth = 0;
    public int CenterFragmentAmount = 0;


    private final ArrayList<TextureFragment> textureFragments = new ArrayList<>();

    public TooltipsTexture(ResourceLocation resourceLocation,int[][] backgroundColor,int[][] lineColor,
                          int textureWidth,int textureHeight){
        this.resourceLocation = resourceLocation;
        this.backgroundColor = backgroundColor;
        this.lineColor = lineColor;
        this.width = textureWidth;
        this.height = textureHeight;

    }

    public ResourceLocation getResourceLocation() {
        return this.resourceLocation;
    }

    public float getWidth() {
        return this.width;
    }

    public float getHeight() {
        return this.height;
    }


    public int[][] getBackgroundColor() {
        return backgroundColor;
    }

    public void addTextureFragment(TextureFragment... textureFragment){
        for (TextureFragment textureFragment1 : textureFragment) {
            switch (textureFragment1.getFragmentType()) {
                case Top_Center:
                case Bottom_Center:
                    if (CenterFragmentWidth == 0) {
                        CenterFragmentWidth = (int) textureFragment1.getWidth();
                    }
                    CenterFragmentAmount++;
                    break;
            }
            this.textureFragments.add(textureFragment1);
        }
    }

    public ArrayList<TextureFragment> getTextureFragments() {
        return textureFragments;
    }

    public int[][] getLineColor() {
        return lineColor;
    }

    public static class TextureFragment implements ITexture{
        private final float uMin;
        private final float vMin;
        private final float uMax;
        private final float vMax;
        private final float fragmentWidth;
        private final float fragmentHeight;
        private final float offsetX;
        private final float offsetY;
        private final TextureFragmentType fragmentType;

        public TextureFragment(TextureFragmentType fragmentType,float textureWidth,float textureHeight,float fragmentX, float fragmentY,float fragmentWidth, float fragmentHeight,
                                float offsetX, float offsetY){
            this.fragmentType = fragmentType;
            this.uMin = fragmentX / textureWidth;
            this.uMax = (fragmentX + fragmentWidth) / textureWidth;
            this.vMin = fragmentY / textureHeight;
            this.vMax = (fragmentY + fragmentHeight) / textureHeight;
            this.fragmentWidth = fragmentWidth;
            this.fragmentHeight = fragmentHeight;
            this.offsetX = offsetX;
            this.offsetY = offsetY;
        }

        public float[] generateVertex(float x, float y, float width, float height){
            return fragmentType.GenerateVertex(x + offsetX,y + offsetY,width,height,
                fragmentWidth,fragmentHeight,uMin,uMax,vMin,vMax);
        }

        public TextureFragmentType getFragmentType() {
            return fragmentType;
        }

        @Override
        public ResourceLocation getResourceLocation() {
            return null;
        }

        @Override
        public float getWidth() {
            return this.fragmentWidth;
        }

        @Override
        public float getHeight() {
            return this.fragmentHeight;
        }

        @Override
        public float getMaxU() {
            return this.uMax;
        }

        @Override
        public float getMaxV() {
            return this.vMax;
        }

        @Override
        public float getMinU() {
            return this.uMin;
        }

        @Override
        public float getMinV() {
            return this.vMin;
        }
    }

    public enum TextureFragmentType{
        Top_Left(
            (float x, float y, float width, float height,float fragmentWidth,float fragmentHeight,
             float uMin, float uMax, float vMin, float vMax) -> new float[]{
                 x, y, uMin, vMin,
                 x + fragmentWidth, y, uMax, vMin,
                 x + fragmentWidth, y + fragmentHeight, uMax, vMax,
                 x, y + fragmentHeight, uMin, vMax,
             }
        ),
        Bottom_Left(
            (float x, float y, float width, float height,float fragmentWidth,float fragmentHeight,
             float uMin, float uMax, float vMin, float vMax) -> new float[]{
                x, y + height - fragmentHeight, uMin, vMin,
                x + fragmentWidth, y + height - fragmentHeight, uMax, vMin,
                x + fragmentWidth, y + height, uMax, vMax,
                x, y + height, uMin, vMax,
            }
        ),
        Top_Right(
            (float x, float y, float width, float height,float fragmentWidth,float fragmentHeight,
             float uMin, float uMax, float vMin, float vMax) -> new float[]{
                x + width - fragmentWidth, y, uMin, vMin,
                x + width, y, uMax, vMin,
                x + width, y + fragmentHeight, uMax, vMax,
                x + width - fragmentWidth, y + fragmentHeight, uMin, vMax,
             }
        ),
        Bottom_Right(
            (float x, float y, float width, float height,float fragmentWidth,float fragmentHeight,
             float uMin, float uMax, float vMin, float vMax) -> new float[]{
                x + width - fragmentWidth, y + height - fragmentHeight, uMin, vMin,
                x + width, y + height - fragmentHeight, uMax, vMin,
                x + width, y + height, uMax, vMax,
                x+ width - fragmentWidth, y + height, uMin, vMax,
             }
        ),
        Top_Center(
            (float x, float y, float width, float height,float fragmentWidth,float fragmentHeight,
             float uMin, float uMax, float vMin, float vMax) -> new float[]{
                 (x + (width / 2)) - (fragmentWidth / 2), y, uMin, vMin,
                 (x + (width / 2)) + (fragmentWidth / 2), y, uMax, vMin,
                 (x + (width / 2)) + (fragmentWidth / 2), y + fragmentHeight, uMax, vMax,
                 (x + (width / 2)) - (fragmentWidth / 2), y + fragmentHeight, uMin, vMax,
             }
        ),
        Bottom_Center(
            (float x, float y, float width, float height,float fragmentWidth,float fragmentHeight,
             float uMin, float uMax, float vMin, float vMax) -> new float[]{
                (x + (width / 2)) - (fragmentWidth / 2), y + height - fragmentHeight, uMin, vMin,
                (x + (width / 2)) + (fragmentWidth / 2), y + height - fragmentHeight, uMax, vMin,
                (x + (width / 2)) + (fragmentWidth / 2), y + height, uMax, vMax,
                (x + (width / 2)) - (fragmentWidth / 2), y + height, uMin, vMax,
             }
        );

        private final ITextureFragmentTypeHandler handler;

        TextureFragmentType(ITextureFragmentTypeHandler handler){
            this.handler = handler;
        }

        public float[] GenerateVertex(float x, float y, float width, float height,float fragmentWidth,float fragmentHeight,
                                      float uMin, float uMax, float vMin, float vMaxV){
            return handler.GenerateVertex(x,y,width,height,fragmentWidth,fragmentHeight,uMin,uMax,vMin,vMaxV);
        }
    }

}
