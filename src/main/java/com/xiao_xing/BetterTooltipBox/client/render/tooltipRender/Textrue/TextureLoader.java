package com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Textrue;

import net.minecraft.util.ResourceLocation;
import static com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Textrue.TooltipsTexture.TextureFragment;
import static com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Textrue.TooltipsTexture.TextureFragmentType.*;

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
                new int[][]{{184,103,89, 240},{ 184,103,89, 240,}},
                new int[][]{
                    {
                        216,136,123,255,
                        216,136,123,255,
                    },
                    {
                        216,136,123,255,
                        216,136,123,255,
                    },
                    {
                        216,136,123,255,
                        216,136,123,255,
                    },
                    {
                        216,136,123,255,
                        216,136,123,255,
                    }},
                64,
                240
        );
        ULV.addTextureFragment(
                new TextureFragment(Top_Left, 64,240,0,0,7,7,-4, -4),
                new TextureFragment(Top_Center,64,240,24,0,16,8, 0,-8),
                new TextureFragment(Top_Right,64,240,57,0,7,7,3,-3),

                new TextureFragment(Bottom_Left,64,240,0,9,7,7,-4,4),
                new TextureFragment(Bottom_Center,64,240,27,11,9,3, 0,3),
                new TextureFragment(Bottom_Right,64,240,57,9,7,7, 4,4)
        );
        textureManager.register("ULV",ULV);
        LV = new TooltipsTexture(
            new ResourceLocation("bettertooltipbox","gui/GregTech.png"),
            new int[][]{{173,173,173, 240},{ 173,173,173, 240,}},
            new int[][]{
                {
                    28,28,33,255,
                    28,28,33,255,
                },
                {
                    28,28,33,255,
                    28,28,33,255,
                },
                {
                    28,28,33,255,
                    28,28,33,255,
                },
                {
                    28,28,33,255,
                    28,28,33,255,
                }},
            64,
            240
        );
        int level = 1;
        LV.addTextureFragment(
            new TextureFragment(Top_Left, 64,240,0,16 * level,7,7,-4, -4),
            new TextureFragment(Top_Center,64,240,24 + 64 * level,16 * level,16,8, 0,-8),
            new TextureFragment(Top_Right,64,240,57 + 64 * level,16 * level,7,7,3,-3),

            new TextureFragment(Bottom_Left,64,240,0,9 + 16 * level,7,7,-4,4),
            new TextureFragment(Bottom_Center,64,240,27 + 64 * level,11 + 16 * level,9,3, 0,3),
            new TextureFragment(Bottom_Right,64,240,57 + 64 * level,9 + 16 * level,7,7, 4,4)
        );
        textureManager.register("LV",LV);
        level++;
        MV = new TooltipsTexture(
            new ResourceLocation("bettertooltipbox","gui/GregTech.png"),
            new int[][]{{137,179,198, 240},{ 137,179,198, 240,}},
            new int[][]{
                {
                    0,235,236,255,
                    0,235,236,255,
                },
                {
                    0,235,236,255,
                    0,235,236,255,
                },
                {
                    0,235,236,255,
                    0,235,236,255,
                },
                {
                    0,235,236,255,
                    0,235,236,255,
                }},
            64,
            240
        );
        MV.addTextureFragment(
            new TextureFragment(Top_Left, 64,240,0,16 * level,7,7,-4, -4),
            new TextureFragment(Top_Center,64,240,24 + 64 * level,16 * level,16,8, 0,-8),
            new TextureFragment(Top_Right,64,240,57 + 64 * level,16 * level,7,7,3,-3),

            new TextureFragment(Bottom_Left,64,240,0,9 + 16 * level,7,7,-4,4),
            new TextureFragment(Bottom_Center,64,240,27 + 64 * level,11 + 16 * level,9,3, 0,3),
            new TextureFragment(Bottom_Right,64,240,57 + 64 * level,9 + 16 * level,7,7, 4,4)
        );
        textureManager.register("MV",MV);
        level++;
        HV = new TooltipsTexture(
            new ResourceLocation("bettertooltipbox","gui/GregTech.png"),
            new int[][]{{147,147,163, 240},{ 147,147,163, 240,}},
            new int[][]{
                {
                    250,242,94,255,
                    250,242,94,255,
                },
                {
                    250,242,94,255,
                    250,242,94,255,
                },
                {
                    250,242,94,255,
                    250,242,94,255,
                },
                {
                    250,242,94,255,
                    250,242,94,255,
                }},
            64,
            240
        );
        HV.addTextureFragment(
            new TextureFragment(Top_Left, 64,240,0,16 * level,7,7,-4, -4),
            new TextureFragment(Top_Center,64,240,24 + 64 * level,16 * level,16,8, 0,-8),
            new TextureFragment(Top_Right,64,240,57 + 64 * level,16 * level,7,7,3,-3),

            new TextureFragment(Bottom_Left,64,240,0,9 + 16 * level,7,7,-4,4),
            new TextureFragment(Bottom_Center,64,240,27 + 64 * level,11 + 16 * level,9,3, 0,3),
            new TextureFragment(Bottom_Right,64,240,57 + 64 * level,9 + 16 * level,7,7, 4,4)
        );
        textureManager.register("HV",HV);
        level++;
        EV = new TooltipsTexture(
            new ResourceLocation("bettertooltipbox","gui/GregTech.png"),
            new int[][]{{216,148,211, 240},{ 216,148,211, 240,}},
            new int[][]{
                {
                    138,22,173,255,
                    138,22,173,255,
                },
                {
                    138,22,173,255,
                    138,22,173,255,
                },
                {
                    138,22,173,255,
                    138,22,173,255,
                },
                {
                    138,22,173,255,
                    138,22,173,255,
                }},
            64,
            240
        );
        EV.addTextureFragment(
            new TextureFragment(Top_Left, 64,240,0,16 * level,7,7,-4, -4),
            new TextureFragment(Top_Center,64,240,24 + 64 * level,16 * level,16,8, 0,-8),
            new TextureFragment(Top_Right,64,240,57 + 64 * level,16 * level,7,7,3,-3),

            new TextureFragment(Bottom_Left,64,240,0,9 + 16 * level,7,7,-4,4),
            new TextureFragment(Bottom_Center,64,240,27 + 64 * level,11 + 16 * level,9,3, 0,3),
            new TextureFragment(Bottom_Right,64,240,57 + 64 * level,9 + 16 * level,7,7, 4,4)
        );
        textureManager.register("EV",EV);
        level++;
        IV = new TooltipsTexture(
            new ResourceLocation("bettertooltipbox","gui/GregTech.png"),
            new int[][]{{121,137,191, 240},{ 121,137,191, 240,}},
            new int[][]{
                {
                    45,63,150,255,
                    45,63,150,255,
                },
                {
                    45,63,150,255,
                    45,63,150,255,
                },
                {
                    45,63,150,255,
                    45,63,150,255,
                },
                {
                    45,63,150,255,
                    45,63,150,255,
                }},
            64,
            240
        );
        IV.addTextureFragment(
            new TextureFragment(Top_Left, 64,240,0,16 * level,7,7,-4, -4),
            new TextureFragment(Top_Center,64,240,24 + 64 * level,16 * level,16,8, 0,-8),
            new TextureFragment(Top_Right,64,240,57 + 64 * level,16 * level,7,7,3,-3),

            new TextureFragment(Bottom_Left,64,240,0,9 + 16 * level,7,7,-4,4),
            new TextureFragment(Bottom_Center,64,240,27 + 64 * level,11 + 16 * level,9,3, 0,3),
            new TextureFragment(Bottom_Right,64,240,57 + 64 * level,9 + 16 * level,7,7, 4,4)
        );
        textureManager.register("IV",IV);
        level++;
        LuV = new TooltipsTexture(
            new ResourceLocation("bettertooltipbox","gui/GregTech.png"),
            new int[][]{{161,153,153, 240},{ 161,153,153, 240,}},
            new int[][]{
                {
                    215,79,194,255,
                    215,79,194,255,
                },
                {
                    215,79,194,255,
                    215,79,194,255,
                },
                {
                    215,79,194,255,
                    215,79,194,255,
                },
                {
                    215,79,194,255,
                    215,79,194,255,
                }},
            64,
            240
        );
        LuV.addTextureFragment(
            new TextureFragment(Top_Left, 64,240,0,16 * level,7,7,-4, -4),
            new TextureFragment(Top_Center,64,240,24 + 64 * level,16 * level,16,8, 0,-8),
            new TextureFragment(Top_Right,64,240,57 + 64 * level,16 * level,7,7,3,-3),

            new TextureFragment(Bottom_Left,64,240,0,9 + 16 * level,7,7,-4,4),
            new TextureFragment(Bottom_Center,64,240,27 + 64 * level,11 + 16 * level,9,3, 0,3),
            new TextureFragment(Bottom_Right,64,240,57 + 64 * level,9 + 16 * level,7,7, 4,4)
        );
        textureManager.register("LuV",LuV);
        level++;
        ZPM = new TooltipsTexture(
            new ResourceLocation("bettertooltipbox","gui/GregTech.png"),
            new int[][]{{221,221,221, 240},{ 221,221,221, 240,}},
            new int[][]{
                {
                    0,255,33,255,
                    0,255,33,255,
                },
                {
                    0,255,33,255,
                    0,255,33,255,
                },
                {
                    0,255,33,255,
                    0,255,33,255,
                },
                {
                    0,255,33,255,
                    0,255,33,255,
                }},
            64,
            240
        );
        ZPM.addTextureFragment(
            new TextureFragment(Top_Left, 64,240,0,16 * level,7,7,-4, -4),
            new TextureFragment(Top_Center,64,240,24 + 64 * level,16 * level,16,8, 0,-8),
            new TextureFragment(Top_Right,64,240,57 + 64 * level,16 * level,7,7,3,-3),

            new TextureFragment(Bottom_Left,64,240,0,9 + 16 * level,7,7,-4,4),
            new TextureFragment(Bottom_Center,64,240,27 + 64 * level,11 + 16 * level,9,3, 0,3),
            new TextureFragment(Bottom_Right,64,240,57 + 64 * level,9 + 16 * level,7,7, 4,4)
        );
        textureManager.register("ZPM",ZPM);
        level++;
        UV = new TooltipsTexture(
            new ResourceLocation("bettertooltipbox","gui/GregTech.png"),
            new int[][]{{75,75,196, 240},{ 75,75,196, 240,}},
            new int[][]{
                {
                    29,29,76,255,
                    29,29,76,255,
                },
                {
                    29,29,76,255,
                    29,29,76,255,
                },
                {
                    29,29,76,255,
                    29,29,76,255,
                },
                {
                    29,29,76,255,
                    29,29,76,255,
                }},
            64,
            240
        );
        UV.addTextureFragment(
            new TextureFragment(Top_Left, 64,240,0,16 * level,7,7,-4, -4),
            new TextureFragment(Top_Center,64,240,24 + 64 * level,16 * level,16,8, 0,-8),
            new TextureFragment(Top_Right,64,240,57 + 64 * level,16 * level,7,7,3,-3),

            new TextureFragment(Bottom_Left,64,240,0,9 + 16 * level,7,7,-4,4),
            new TextureFragment(Bottom_Center,64,240,27 + 64 * level,11 + 16 * level,9,3, 0,3),
            new TextureFragment(Bottom_Right,64,240,57 + 64 * level,9 + 16 * level,7,7, 4,4)
        );
        textureManager.register("UV",UV);
        level++;
        UHV = new TooltipsTexture(
            new ResourceLocation("bettertooltipbox","gui/GregTech.png"),
            new int[][]{{207,207,207, 240},{ 207,207,207, 240,}},
            new int[][]{
                {
                    255,0,110,255,
                    255,0,110,255,
                },
                {
                    255,0,110,255,
                    255,0,110,255,
                },
                {
                    255,0,110,255,
                    255,0,110,255,
                },
                {
                    255,0,110,255,
                    255,0,110,255,
                }},
            64,
            240
        );
        UHV.addTextureFragment(
            new TextureFragment(Top_Left, 64,240,0,16 * level,7,7,-4, -4),
            new TextureFragment(Top_Center,64,240,24 + 64 * level,16 * level,16,8, 0,-8),
            new TextureFragment(Top_Right,64,240,57 + 64 * level,16 * level,7,7,3,-3),

            new TextureFragment(Bottom_Left,64,240,0,9 + 16 * level,7,7,-4,4),
            new TextureFragment(Bottom_Center,64,240,27 + 64 * level,11 + 16 * level,9,3, 0,3),
            new TextureFragment(Bottom_Right,64,240,57 + 64 * level,9 + 16 * level,7,7, 4,4)
        );
        textureManager.register("UHV",UHV);
        level++;
        UEV = new TooltipsTexture(
            new ResourceLocation("bettertooltipbox","gui/GregTech.png"),
            new int[][]{{182,255,0, 240},{ 182,255,0, 240,}},
            new int[][]{
                {
                    0,255,255,255,
                    0,255,255,255,
                },
                {
                    0,255,255,255,
                    0,255,255,255,
                },
                {
                    0,255,255,255,
                    0,255,255,255,
                },
                {
                    0,255,255,255,
                    0,255,255,255,
                }},
            64,
            240
        );
        UEV.addTextureFragment(
            new TextureFragment(Top_Left, 64,240,0,16 * level,7,7,-4, -4),
            new TextureFragment(Top_Center,64,240,24 + 64 * level,16 * level,16,8, 0,-8),
            new TextureFragment(Top_Right,64,240,57 + 64 * level,16 * level,7,7,3,-3),

            new TextureFragment(Bottom_Left,64,240,0,9 + 16 * level,7,7,-4,4),
            new TextureFragment(Bottom_Center,64,240,27 + 64 * level,11 + 16 * level,9,3, 0,3),
            new TextureFragment(Bottom_Right,64,240,57 + 64 * level,9 + 16 * level,7,7, 4,4)
        );
        textureManager.register("UEV",UEV);
        level++;
        UIV = new TooltipsTexture(
            new ResourceLocation("bettertooltipbox","gui/GregTech.png"),
            new int[][]{{91,88,90, 240},{ 91,88,90, 240,}},
            new int[][]{
                {
                    255,255,255,255,
                    255,255,255,255,
                },
                {
                    255,255,255,255,
                    255,255,255,255,
                },
                {
                    255,255,255,255,
                    255,255,255,255,
                },
                {
                    255,255,255,255,
                    255,255,255,255,
                }},
            64,
            240
        );
        UIV.addTextureFragment(
            new TextureFragment(Top_Left, 64,240,0,16 * level,7,7,-4, -4),
            new TextureFragment(Top_Center,64,240,24 + 64 * level,16 * level,16,8, 0,-8),
            new TextureFragment(Top_Right,64,240,57 + 64 * level,16 * level,7,7,3,-3),

            new TextureFragment(Bottom_Left,64,240,0,9 + 16 * level,7,7,-4,4),
            new TextureFragment(Bottom_Center,64,240,27 + 64 * level,11 + 16 * level,9,3, 0,3),
            new TextureFragment(Bottom_Right,64,240,57 + 64 * level,9 + 16 * level,7,7, 4,4)
        );
        textureManager.register("UIV",UIV);
        level++;
        UMV = new TooltipsTexture(
            new ResourceLocation("bettertooltipbox","gui/GregTech.png"),
            new int[][]{{161,127,255, 240},{ 161,127,255, 240,}},
            new int[][]{
                {
                    118,27,140,255,
                    118,27,140,255,
                },
                {
                    118,27,140,255,
                    118,27,140,255,
                },
                {
                    118,27,140,255,
                    118,27,140,255,
                },
                {
                    118,27,140,255,
                    118,27,140,255,
                }},
            64,
            240
        );
        UMV.addTextureFragment(
            new TextureFragment(Top_Left, 64,240,0,16 * level,7,7,-4, -4),
            new TextureFragment(Top_Center,64,240,24 + 64 * level,16 * level,16,8, 0,-8),
            new TextureFragment(Top_Right,64,240,57 + 64 * level,16 * level,7,7,3,-3),

            new TextureFragment(Bottom_Left,64,240,0,9 + 16 * level,7,7,-4,4),
            new TextureFragment(Bottom_Center,64,240,27 + 64 * level,11 + 16 * level,9,3, 0,3),
            new TextureFragment(Bottom_Right,64,240,57 + 64 * level,9 + 16 * level,7,7, 4,4)
        );
        textureManager.register("UMV",UMV);
        level++;
        UXV = new TooltipsTexture(
            new ResourceLocation("bettertooltipbox","gui/GregTech.png"),
            new int[][]{{137,59,11, 240},{ 137,59,11, 240,}},
            new int[][]{
                {
                    255,0,0,255,
                    255,0,0,255,
                },
                {
                    255,0,0,255,
                    255,0,0,255,
                },
                {
                    255,0,0,255,
                    255,0,0,255,
                },
                {
                    255,0,0,255,
                    255,0,0,255,
                }},
            64,
            240
        );
        UXV.addTextureFragment(
            new TextureFragment(Top_Left, 64,240,0,16 * level,7,7,-4, -4),
            new TextureFragment(Top_Center,64,240,24 + 64 * level,16 * level,16,8, 0,-8),
            new TextureFragment(Top_Right,64,240,57 + 64 * level,16 * level,7,7,3,-3),

            new TextureFragment(Bottom_Left,64,240,0,9 + 16 * level,7,7,-4,4),
            new TextureFragment(Bottom_Center,64,240,27 + 64 * level,11 + 16 * level,9,3, 0,3),
            new TextureFragment(Bottom_Right,64,240,57 + 64 * level,9 + 16 * level,7,7, 4,4)
        );
        textureManager.register("UXV",UXV);
        level++;
        MAX = new TooltipsTexture(
            new ResourceLocation("bettertooltipbox","gui/GregTech.png"),
            new int[][]{{112,105,112, 240},{ 112,105,112, 240,}},
            new int[][]{
                {
                    255,45,63,255,
                    255,45,63,255,
                },
                {
                    255,45,63,255,
                    255,45,63,255,
                },
                {
                    255,45,63,255,
                    255,45,63,255,
                },
                {
                    255,45,63,255,
                    255,45,63,255,
                }},
            64,
            240
        );
        MAX.addTextureFragment(
            new TextureFragment(Top_Left, 64,240,0,16 * level,7,7,-4, -4),
            new TextureFragment(Top_Center,64,240,24 + 64 * level,16 * level,16,8, 0,-8),
            new TextureFragment(Top_Right,64,240,57 + 64 * level,16 * level,7,7,3,-3),

            new TextureFragment(Bottom_Left,64,240,0,9 + 16 * level,7,7,-4,4),
            new TextureFragment(Bottom_Center,64,240,27 + 64 * level,11 + 16 * level,9,3, 0,3),
            new TextureFragment(Bottom_Right,64,240,57 + 64 * level,9 + 16 * level,7,7, 4,4)
        );
        textureManager.register("MAX",MAX);
    }

}
