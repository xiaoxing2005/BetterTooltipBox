package com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Texture;

import net.minecraft.util.ResourceLocation;
import static com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Texture.TooltipsTexture.TextureFragment;
import static com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Texture.TooltipsTexture.TextureFragmentType.*;

public class TextureLoader {

    private final TextureManager textureManager;
    public static TooltipsTexture defaultTexture;
    public static TooltipsTexture ULV;
    public static TooltipsTexture LV;
    public static TooltipsTexture MV;
    public static TooltipsTexture HV;
    public static TooltipsTexture EV;
    public static TooltipsTexture IV;
    public static TooltipsTexture LuV;
    public static TooltipsTexture ZPM;
    public static TooltipsTexture UV;
    public static TooltipsTexture UHV;
    public static TooltipsTexture UEV;
    public static TooltipsTexture UIV;
    public static TooltipsTexture UMV;
    public static TooltipsTexture UXV;
    public static TooltipsTexture MAX;

    public TextureLoader() {
        textureManager = TextureManager.getInstance();
    }

    public void loader(){

        defaultTexture = new TooltipsTexture(
            new ResourceLocation("bettertooltipbox","gui/LOGO.png"),
            new int[][]{{56,86,181,221},{56,86,181,221}},
            new int[][]{
                {
                    0,224,255,255,
                    0,224,255,255,
                },
                {
                    0,224,255,255,
                    0,224,255,255,
                },
                {
                    0,224,255,255,
                    0,224,255,255,
                },
                {
                    0,224,255,255,
                    0,224,255,255,
                }},
            15,
            13
        );
        defaultTexture.addTextureFragment(
            new TextureFragment(Top_Center, 15,13,0,0,15,13,0, -12)
        );
        textureManager.register("default",defaultTexture);
        ULV = new TooltipsTexture(
                new ResourceLocation("bettertooltipbox","gui/GregTech.png"),
                new int[][]{{17,7,7, 248},{ 160,108,95, 248,}},
                new int[][]{
                    {
                        184,103,89,255,
                        184,103,89,255,
                    },
                    {
                        216,136,123,255,
                        216,136,123,255,
                    },
                    {
                        184,103,89,255,
                        216,136,123,255,
                    },
                    {
                        184,103,89,255,
                        216,136,123,255,
                    }},
                64,
                240
        );
        ULV.addTextureFragment(
                new TextureFragment(Top_Left, 64,240,0,0,7,7,-4, -4),
                new TextureFragment(Top_Center,64,240,24,0,15,8, 0,-6),
                new TextureFragment(Top_Right,64,240,57,0,7,7,3,-3),

                new TextureFragment(Bottom_Left,64,240,0,9,7,7,-4,4),
                new TextureFragment(Bottom_Center,64,240,27,11,9,3, 0,3),
                new TextureFragment(Bottom_Right,64,240,57,9,7,7, 4,4)
        );
        textureManager.register("ULV",ULV);
        LV = new TooltipsTexture(
            new ResourceLocation("bettertooltipbox","gui/GregTech.png"),
            new int[][]{{6,9,10, 248},{ 40,39,37, 248,}},
            new int[][]{
                {
                    61,57,52,255,
                    61,57,52,255,
                },
                {
                    74,70,65,255,
                    74,70,65,255,
                },
                {
                    61,57,52,255,
                    74,70,65,255,
                },
                {
                    61,57,52,255,
                    74,70,65,255,
                }},
            64,
            240
        );
        int level = 1;
        LV.addTextureFragment(
            new TextureFragment(Top_Left, 64,240,0,16 * level,7,7,-4, -4),
            new TextureFragment(Top_Center,64,240,25 + 64 * level,16 * level,13,8, 0,-6),
            new TextureFragment(Top_Right,64,240,57 + 64 * level,16 * level,7,7,3,-3),

            new TextureFragment(Bottom_Left,64,240,0,9 + 16 * level,7,7,-4,4),
            new TextureFragment(Bottom_Center,64,240,27 + 64 * level,11 + 16 * level,9,3, 0,3),
            new TextureFragment(Bottom_Right,64,240,57 + 64 * level,9 + 16 * level,7,7, 4,4)
        );
        textureManager.register("LV",LV);
        level++;
        MV = new TooltipsTexture(
            new ResourceLocation("bettertooltipbox","gui/GregTech.png"),
            new int[][]{{6,7,8, 248},{ 86,109,121, 248,}},
            new int[][]{
                {
                    51,74,76,255,
                    51,74,76,255,
                },
                {
                    122,157,174,255,
                    122,157,174,255,
                },
                {
                    51,74,76,255,
                    122,157,174,255,
                },
                {
                    51,74,76,255,
                    122,157,174,255,
                }},
            64,
            240
        );
        MV.addTextureFragment(
            new TextureFragment(Top_Left, 64,240,0,16 * level,7,7,-4, -4),
            new TextureFragment(Top_Center,64,240,25 + 64 * level,16 * level,13,8, 0,-6),
            new TextureFragment(Top_Right,64,240,57 + 64 * level,16 * level,7,7,3,-3),

            new TextureFragment(Bottom_Left,64,240,0,9 + 16 * level,7,7,-4,4),
            new TextureFragment(Bottom_Center,64,240,27 + 64 * level,11 + 16 * level,9,3, 0,3),
            new TextureFragment(Bottom_Right,64,240,57 + 64 * level,9 + 16 * level,7,7, 4,4)
        );
        textureManager.register("MV",MV);
        level++;
        HV = new TooltipsTexture(
            new ResourceLocation("bettertooltipbox","gui/GregTech.png"),
            new int[][]{{30,30,35, 248},{ 155,155,164, 248,}},
            new int[][]{
                {
                    93,93,106, 255,
                    93,93,106, 255,
                },
                {
                    206,206,220,255,
                    206,206,220,255,
                },
                {
                    93,93,106, 255,
                    206,206,220,255,
                },
                {
                    93,93,106, 255,
                    206,206,220,255,
                }},
            64,
            240
        );
        HV.addTextureFragment(
            new TextureFragment(Top_Left, 64,240,0,16 * level,7,7,-4, -4),
            new TextureFragment(Top_Center,64,240,25 + 64 * level,16 * level,13,8, 0,-6),
            new TextureFragment(Top_Right,64,240,57 + 64 * level,16 * level,7,7,3,-3),

            new TextureFragment(Bottom_Left,64,240,0,9 + 16 * level,7,7,-4,4),
            new TextureFragment(Bottom_Center,64,240,27 + 64 * level,11 + 16 * level,9,3, 0,3),
            new TextureFragment(Bottom_Right,64,240,57 + 64 * level,9 + 16 * level,7,7, 4,4)
        );
        textureManager.register("HV",HV);
        level++;
        EV = new TooltipsTexture(
            new ResourceLocation("bettertooltipbox","gui/GregTech.png"),
            new int[][]{{15,13,16, 248},{ 105,85,110, 248,}},
            new int[][]{
                {
                    83,74,87,255,
                    83,74,87,255,
                },
                {
                    151,123,160,255,
                    151,123,160,255,
                },
                {
                    83,74,87,255,
                    151,123,160,255,
                },
                {
                    83,74,87,255,
                    151,123,160,255,
                }},
            64,
            240
        );
        EV.addTextureFragment(
            new TextureFragment(Top_Left, 64,240,0,16 * level,7,7,-4, -4),
            new TextureFragment(Top_Center,64,240,25 + 64 * level,16 * level,13,8, 0,-6),
            new TextureFragment(Top_Right,64,240,57 + 64 * level,16 * level,7,7,3,-3),

            new TextureFragment(Bottom_Left,64,240,0,9 + 16 * level,7,7,-4,4),
            new TextureFragment(Bottom_Center,64,240,27 + 64 * level,11 + 16 * level,9,3, 0,3),
            new TextureFragment(Bottom_Right,64,240,57 + 64 * level,9 + 16 * level,7,7, 4,4)
        );
        textureManager.register("EV",EV);
        level++;
        IV = new TooltipsTexture(
            new ResourceLocation("bettertooltipbox","gui/GregTech.png"),
            new int[][]{{2,2,4, 248},{ 23,32,54, 248,}},
            new int[][]{
                {
                    53,67,110,255,
                    53,67,110,255,
                },
                {
                    53,67,110,255,
                    53,67,110,255,
                },
                {
                    53,67,110,255,
                    53,67,110,255,
                },
                {
                    53,67,110,255,
                    53,67,110,255,
                }},
            64,
            240
        );
        IV.addTextureFragment(
            new TextureFragment(Top_Left, 64,240,0,16 * level,7,7,-4, -4),
            new TextureFragment(Top_Center,64,240,25 + 64 * level,16 * level,13,8, 0,-6),
            new TextureFragment(Top_Right,64,240,57 + 64 * level,16 * level,7,7,3,-3),

            new TextureFragment(Bottom_Left,64,240,0,9 + 16 * level,7,7,-4,4),
            new TextureFragment(Bottom_Center,64,240,27 + 64 * level,11 + 16 * level,9,3, 0,3),
            new TextureFragment(Bottom_Right,64,240,57 + 64 * level,9 + 16 * level,7,7, 4,4)
        );
        textureManager.register("IV",IV);
        level++;
        LuV = new TooltipsTexture(
            new ResourceLocation("bettertooltipbox","gui/GregTech.png"),
            new int[][]{{3,2,3, 248},{ 38,28,41, 248}},
            new int[][]{
                {
                    91,64,95,255,
                    91,64,95,255,
                },
                {
                    88,62,91,255,
                    88,62,91,255,
                },
                {
                    91,64,95,255,
                    88,62,91,255,
                },
                {
                    91,64,95,255,
                    88,62,91,255,
                }},
            64,
            240
        );
        LuV.addTextureFragment(
            new TextureFragment(Top_Left, 64,240,0,16 * level,7,7,-4, -4),
            new TextureFragment(Top_Center,64,240,24 + 64 * level,16 * level,15,8, 0,-6),
            new TextureFragment(Top_Right,64,240,57 + 64 * level,16 * level,7,7,3,-3),

            new TextureFragment(Bottom_Left,64,240,0,9 + 16 * level,7,7,-4,4),
            new TextureFragment(Bottom_Center,64,240,27 + 64 * level,11 + 16 * level,9,3, 0,3),
            new TextureFragment(Bottom_Right,64,240,57 + 64 * level,9 + 16 * level,7,7, 4,4)
        );
        textureManager.register("LuV",LuV);
        level++;
        ZPM = new TooltipsTexture(
            new ResourceLocation("bettertooltipbox","gui/GregTech.png"),
            new int[][]{{1,1,1, 248},{ 1,1,1, 248,}},
            new int[][]{
                {
                    47,35,67,255,
                    47,35,67,255,
                },
                {
                    121,110,138,255,
                    121,110,138,255,
                },
                {
                    47,35,67,255,
                    121,110,138,255,
                },
                {
                    47,35,67,255,
                    121,110,138,255,
                }},
            64,
            240
        );
        ZPM.addTextureFragment(
            new TextureFragment(Top_Left, 64,240,0,16 * level,7,7,-4, -4),
            new TextureFragment(Top_Center,64,240,23 + 64 * level,16 * level,17,8, 0,-6),
            new TextureFragment(Top_Right,64,240,57 + 64 * level,16 * level,7,7,3,-3),

            new TextureFragment(Bottom_Left,64,240,0,9 + 16 * level,7,7,-4,4),
            new TextureFragment(Bottom_Center,64,240,27 + 64 * level,11 + 16 * level,9,3, 0,3),
            new TextureFragment(Bottom_Right,64,240,57 + 64 * level,9 + 16 * level,7,7, 4,4)
        );
        textureManager.register("ZPM",ZPM);
        level++;
        UV = new TooltipsTexture(
            new ResourceLocation("bettertooltipbox","gui/GregTech.png"),
            new int[][]{{17,18,27, 248},{ 53,57,87, 248,}},
            new int[][]{
                {
                    74,221,244,255,
                    74,221,244,255,
                },
                {
                    61,72,193,255,
                    61,72,193,255,
                },
                {
                    74,221,244,255,
                    61,72,193,255,
                },
                {
                    74,221,244,255,
                    61,72,193,255,
                }},
            64,
            240
        );
        UV.addTextureFragment(
            new TextureFragment(Top_Left, 64,240,0,16 * level,7,7,-4, -4),
            new TextureFragment(Top_Center,64,240,25 + 64 * level,16 * level,13,8, 0,-6),
            new TextureFragment(Top_Right,64,240,57 + 64 * level,16 * level,7,7,3,-3),

            new TextureFragment(Bottom_Left,64,240,0,9 + 16 * level,7,7,-4,4),
            new TextureFragment(Bottom_Center,64,240,27 + 64 * level,11 + 16 * level,9,3, 0,3),
            new TextureFragment(Bottom_Right,64,240,57 + 64 * level,9 + 16 * level,7,7, 4,4)
        );
        textureManager.register("UV",UV);
        level++;
        UHV = new TooltipsTexture(
            new ResourceLocation("bettertooltipbox","gui/GregTech.png"),
            new int[][]{{23,22,26, 248},{ 71,69,81, 248,}},
            new int[][]{
                {
                    242,146,235,255,
                    242,146,235,255,
                },
                {
                    167,42,104,255,
                    167,42,104,255,
                },
                {
                    242,146,235,255,
                    167,42,104,255,
                },
                {
                    242,146,235,255,
                    167,42,104,255,
                }},
            64,
            240
        );
        UHV.addTextureFragment(
            new TextureFragment(Top_Left, 64,240,0,16 * level,7,7,-4, -4),
            new TextureFragment(Top_Center,64,240,24 + 64 * level,16 * level,15,8, 0,-6),
            new TextureFragment(Top_Right,64,240,57 + 64 * level,16 * level,7,7,3,-3),

            new TextureFragment(Bottom_Left,64,240,0,9 + 16 * level,7,7,-4,4),
            new TextureFragment(Bottom_Center,64,240,27 + 64 * level,11 + 16 * level,9,3, 0,3),
            new TextureFragment(Bottom_Right,64,240,57 + 64 * level,9 + 16 * level,7,7, 4,4)
        );
        textureManager.register("UHV",UHV);
        level++;
        UEV = new TooltipsTexture(
            new ResourceLocation("bettertooltipbox","gui/GregTech.png"),
            new int[][]{{19,16,16, 248},{ 56,47,45, 248,}},
            new int[][]{
                {
                    73,99,0,255,
                    73,99,0,255,
                },
                {
                    153,208,0,255,
                    153,208,0,255,
                },
                {
                    73,99,0,255,
                    153,208,0,255,
                },
                {
                    73,99,0,255,
                    153,208,0,255,
                }},
            64,
            240
        );
        UEV.addTextureFragment(
            new TextureFragment(Top_Left, 64,240,0,16 * level,7,7,-4, -4),
            new TextureFragment(Top_Center,64,240,24 + 64 * level,16 * level,15,8, 0,-6),
            new TextureFragment(Top_Right,64,240,57 + 64 * level,16 * level,7,7,3,-3),

            new TextureFragment(Bottom_Left,64,240,0,9 + 16 * level,7,7,-4,4),
            new TextureFragment(Bottom_Center,64,240,27 + 64 * level,11 + 16 * level,9,3, 0,3),
            new TextureFragment(Bottom_Right,64,240,57 + 64 * level,9 + 16 * level,7,7, 4,4)
        );
        textureManager.register("UEV",UEV);
        level++;
        UIV = new TooltipsTexture(
            new ResourceLocation("bettertooltipbox","gui/GregTech.png"),
            new int[][]{{14,14,17, 248},{ 45,45,57, 248,}},
            new int[][]{
                {
                    239,240,245,255,
                    239,240,245,255,
                },
                {
                    206,209,225,255,
                    206,209,225,255,
                },
                {
                    239,240,245,255,
                    206,209,225,255,
                },
                {
                    239,240,245,255,
                    206,209,225,255,
                }},
            64,
            240
        );
        UIV.addTextureFragment(
            new TextureFragment(Top_Left, 64,240,0,16 * level,7,7,-4, -4),
            new TextureFragment(Top_Center,64,240,24 + 64 * level,16 * level,15,8, 0,-6),
            new TextureFragment(Top_Right,64,240,57 + 64 * level,16 * level,7,7,3,-3),

            new TextureFragment(Bottom_Left,64,240,0,9 + 16 * level,7,7,-4,4),
            new TextureFragment(Bottom_Center,64,240,27 + 64 * level,11 + 16 * level,9,3, 0,3),
            new TextureFragment(Bottom_Right,64,240,57 + 64 * level,9 + 16 * level,7,7, 4,4)
        );
        textureManager.register("UIV",UIV);
        level++;
        UMV = new TooltipsTexture(
            new ResourceLocation("bettertooltipbox","gui/GregTech.png"),
            new int[][]{{35,7,37, 248},{ 63,34,55, 248,}},
            new int[][]{
                {
                    129,32,167,255,
                    129,32,167,255,
                },
                {
                    169,47,224,255,
                    169,47,224,255,
                },
                {
                    129,32,167,255,
                    169,47,224,255,
                },
                {
                    129,32,167,255,
                    169,47,224,255,
                }},
            64,
            240
        );
        UMV.addTextureFragment(
            new TextureFragment(Top_Left, 64,240,0,16 * level,7,7,-4, -4),
            new TextureFragment(Top_Center,64,240,23 + 64 * level,16 * level,17,8, 0,-6),
            new TextureFragment(Top_Right,64,240,57 + 64 * level,16 * level,7,7,3,-3),

            new TextureFragment(Bottom_Left,64,240,0,9 + 16 * level,7,7,-4,4),
            new TextureFragment(Bottom_Center,64,240,27 + 64 * level,11 + 16 * level,9,3, 0,3),
            new TextureFragment(Bottom_Right,64,240,57 + 64 * level,9 + 16 * level,7,7, 4,4)
        );
        textureManager.register("UMV",UMV);
        level++;
        UXV = new TooltipsTexture(
            new ResourceLocation("bettertooltipbox","gui/GregTech.png"),
            new int[][]{{41,23,8, 248},{ 108,94,74, 248,}},
            new int[][]{
                {
                    208,195,98,255,
                    208,195,98,255,
                },
                {
                    232,107,41,255,
                    232,107,41,255,
                },
                {
                    208,195,98,255,
                    232,107,41,255,
                },
                {
                    208,195,98,255,
                    232,107,41,255,
                }},
            64,
            240
        );
        UXV.addTextureFragment(
            new TextureFragment(Top_Left, 64,240,0,16 * level,7,7,-4, -4),
            new TextureFragment(Top_Center,64,240,24 + 64 * level,16 * level,15,8, 0,-6),
            new TextureFragment(Top_Right,64,240,57 + 64 * level,16 * level,7,7,3,-3),

            new TextureFragment(Bottom_Left,64,240,0,9 + 16 * level,7,7,-4,4),
            new TextureFragment(Bottom_Center,64,240,27 + 64 * level,11 + 16 * level,9,3, 0,3),
            new TextureFragment(Bottom_Right,64,240,57 + 64 * level,9 + 16 * level,7,7, 4,4)
        );
        textureManager.register("UXV",UXV);
        level++;
        MAX = new TooltipsTexture(
            new ResourceLocation("bettertooltipbox","gui/GregTech.png"),
            new int[][]{{22,20,27, 248},{ 38,34,46, 248,}},
            new int[][]{
                {
                    174,106,187,255,
                    174,106,187,255,
                },
                {
                    83,71,108,255,
                    83,71,108,255,
                },
                {
                    174,106,187,255,
                    83,71,108,255,
                },
                {
                    174,106,187,255,
                    83,71,108,255,
                }},
            64,
            240
        );
        MAX.addTextureFragment(
            new TextureFragment(Top_Left, 64,240,0,16 * level,7,7,-4, -4),
            new TextureFragment(Top_Center,64,240,23 + 64 * level,16 * level,17,8, 0,-6),
            new TextureFragment(Top_Right,64,240,57 + 64 * level,16 * level,7,7,3,-3),

            new TextureFragment(Bottom_Left,64,240,0,9 + 16 * level,7,7,-4,4),
            new TextureFragment(Bottom_Center,64,240,27 + 64 * level,11 + 16 * level,9,3, 0,3),
            new TextureFragment(Bottom_Right,64,240,57 + 64 * level,9 + 16 * level,7,7, 4,4)
        );
        textureManager.register("MAX",MAX);
    }

}
