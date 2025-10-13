package com.xiao_xing.BetterTooltipBox.Config;

import java.lang.reflect.Type;
import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.reader.ObjectReader;
import com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Textrue.TooltipsTexture;
import com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.TooltipValidationHandler.ITooltipValidationHandler;

public class TooltipsTextureObjectReader implements ObjectReader<TooltipsTexture> {

    @Override
    public TooltipsTexture readObject(JSONReader jsonReader, Type fieldType, Object fieldName, long features) {
        String textureName = "";
        String modId = "";
        ResourceLocation resourceLocation = new ResourceLocation("");
        int[][] backgroundColor = { { 255, 255, 255, 255 }, { 255, 255, 255, 255 } };
        int[][] lineColor = { { 0, 0, 0, 255, 0, 0, 0, 255, }, { 0, 0, 0, 255, 0, 0, 0, 255, },
            { 0, 0, 0, 255, 0, 0, 0, 255, }, { 0, 0, 0, 255, 0, 0, 0, 255, }, { 0, 0, 0, 255, 0, 0, 0, 255, }, };
        int width = 0;
        int height = 0;
        ArrayList<TooltipsTexture.TextureFragment> textureFragments = null;
        if (jsonReader.readIfNull()) {
            return null;
        }
        jsonReader.nextIfObjectStart();
        while (!jsonReader.nextIfObjectEnd()) {
            String key = jsonReader.readFieldName();
            switch (key) {
                case "TextureName" -> textureName = jsonReader.readString();
                case "ModId" -> modId = jsonReader.readString();
                case "ResourceLocation" -> resourceLocation = new ResourceLocation(jsonReader.readString());
                case "TextureSize" -> {
                    int[] size = jsonReader.readInt32ValueArray();
                    width = size[0];
                    height = size[1];
                }
                case "BackgroundColor" -> {
                    jsonReader.nextIfObjectStart();
                    int[] startColor = new int[0];
                    int[] endColor = new int[0];
                    while (!jsonReader.nextIfObjectEnd()) {
                        String color = jsonReader.readFieldName();
                        switch (color) {
                            case "StartColor" -> startColor = jsonReader.readInt32ValueArray();
                            case "EndColor" -> endColor = jsonReader.readInt32ValueArray();
                        }
                    }
                    backgroundColor = new int[][] { startColor, endColor };
                }
                case "LineColor" -> {
                    jsonReader.nextIfObjectStart();
                    int[] Top = new int[8];
                    int[] Bottom = new int[8];
                    int[] Left = new int[8];
                    int[] Right = new int[8];
                    int[] Center = new int[8];
                    while (!jsonReader.nextIfObjectEnd()) {
                        String key1 = jsonReader.readFieldName();
                        switch (key1) {
                            case "Top" -> {
                                jsonReader.nextIfObjectStart();
                                int[] startColor = new int[0];
                                int[] endColor = new int[0];
                                while (!jsonReader.nextIfObjectEnd()) {
                                    String color = jsonReader.readFieldName();
                                    switch (color) {
                                        case "StartColor" -> startColor = jsonReader.readInt32ValueArray();
                                        case "EndColor" -> endColor = jsonReader.readInt32ValueArray();
                                    }
                                }
                                Top = new int[] { startColor[0], startColor[1], startColor[2], startColor[3],
                                    endColor[0], endColor[1], endColor[2], endColor[3] };
                            }
                            case "Bottom" -> {
                                jsonReader.nextIfObjectStart();
                                int[] startColor = new int[0];
                                int[] endColor = new int[0];
                                while (!jsonReader.nextIfObjectEnd()) {
                                    String color = jsonReader.readFieldName();
                                    switch (color) {
                                        case "StartColor" -> startColor = jsonReader.readInt32ValueArray();
                                        case "EndColor" -> endColor = jsonReader.readInt32ValueArray();
                                    }
                                }
                                Bottom = new int[] { startColor[0], startColor[1], startColor[2], startColor[3],
                                    endColor[0], endColor[1], endColor[2], endColor[3] };
                            }
                            case "Left" -> {
                                jsonReader.nextIfObjectStart();
                                int[] startColor = new int[0];
                                int[] endColor = new int[0];
                                while (!jsonReader.nextIfObjectEnd()) {
                                    String color = jsonReader.readFieldName();
                                    switch (color) {
                                        case "StartColor" -> startColor = jsonReader.readInt32ValueArray();
                                        case "EndColor" -> endColor = jsonReader.readInt32ValueArray();
                                    }
                                }
                                Left = new int[] { startColor[0], startColor[1], startColor[2], startColor[3],
                                    endColor[0], endColor[1], endColor[2], endColor[3] };
                            }
                            case "Right" -> {
                                jsonReader.nextIfObjectStart();
                                int[] startColor = new int[0];
                                int[] endColor = new int[0];
                                while (!jsonReader.nextIfObjectEnd()) {
                                    String color = jsonReader.readFieldName();
                                    switch (color) {
                                        case "StartColor" -> startColor = jsonReader.readInt32ValueArray();
                                        case "EndColor" -> endColor = jsonReader.readInt32ValueArray();
                                    }
                                }
                                Right = new int[] { startColor[0], startColor[1], startColor[2], startColor[3],
                                    endColor[0], endColor[1], endColor[2], endColor[3] };
                            }
                            case "Center" -> {
                                jsonReader.nextIfObjectStart();
                                int[] startColor = new int[0];
                                int[] endColor = new int[0];
                                while (!jsonReader.nextIfObjectEnd()) {
                                    String color = jsonReader.readFieldName();
                                    switch (color) {
                                        case "StartColor" -> startColor = jsonReader.readInt32ValueArray();
                                        case "EndColor" -> endColor = jsonReader.readInt32ValueArray();
                                    }
                                }
                                Center = new int[] { startColor[0], startColor[1], startColor[2], startColor[3],
                                    endColor[0], endColor[1], endColor[2], endColor[3] };
                            }
                            default -> jsonReader.skipValue();
                        }
                    }
                    lineColor = new int[][] { { Top[0], Top[1], Top[2], Top[3], Top[4], Top[5], Top[6], Top[7] },
                        { Bottom[0], Bottom[1], Bottom[2], Bottom[3], Bottom[4], Bottom[5], Bottom[6], Bottom[7] },
                        { Left[0], Left[1], Left[2], Left[3], Left[4], Left[5], Left[6], Left[7] },
                        { Right[0], Right[1], Right[2], Right[3], Right[4], Right[5], Right[6], Right[7] },
                        { Center[0], Center[1], Center[2], Center[3], Center[4], Center[5], Center[6], Center[7] } };
                }
                case "FragmentList" -> {
                    textureFragments = new ArrayList<>();
                    jsonReader.nextIfObjectStart();
                    while (!jsonReader.nextIfObjectEnd()) {
                        TooltipsTexture.TextureFragmentType fragmentType = TooltipsTexture.TextureFragmentType
                            .valueOf(jsonReader.readFieldName());
                        int x = 0;
                        int y = 0;
                        int FragmentWidth = 0;
                        int FragmentHeight = 0;
                        int[] offset = new int[2];
                        jsonReader.nextIfObjectStart();
                        while (!jsonReader.nextIfObjectEnd()) {
                            String key2 = jsonReader.readFieldName();
                            switch (key2) {
                                case "X" -> x = jsonReader.readInt32();
                                case "Y" -> y = jsonReader.readInt32();
                                case "Width" -> FragmentWidth = jsonReader.readInt32();
                                case "Height" -> FragmentHeight = jsonReader.readInt32();
                                case "Offset" -> offset = jsonReader.readInt32ValueArray();
                                default -> jsonReader.skipValue();
                            }
                        }
                        textureFragments.add(
                            new TooltipsTexture.TextureFragment(
                                fragmentType,
                                width,
                                height,
                                x,
                                y,
                                FragmentWidth,
                                FragmentHeight,
                                offset[0],
                                offset[1]));
                    }
                }
                default -> jsonReader.skipValue();
            }
        }
        TooltipsTexture texture = new TooltipsTexture(
            textureName,
            resourceLocation,
            backgroundColor,
            lineColor,
            width,
            height);
        if (textureFragments != null) {
            texture.addTextureFragment(textureFragments.toArray(new TooltipsTexture.TextureFragment[0]));
        }
        ITooltipValidationHandler.register(modId, (String name, ItemStack itemStack) -> texture);
        return texture;
    }
}
