package com.xiao_xing.BetterTooltipBox.Util;

import static com.xiao_xing.BetterTooltipBox.BetterTooltipBox.ResourceID;
import static com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Texture.TextureLoader.defaultTexture;

import com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Texture.TooltipsTexture;
import com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.TooltipRender;
import cpw.mods.fml.common.Loader;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import squeek.applecore.client.TooltipOverlayHandler;

public class TooltipHelper {

    public static final Minecraft mc = Minecraft.getMinecraft();

    public static final ResourceLocation TEXTURE_TOOLTIP = new ResourceLocation(ResourceID + "gui/tooltip_borders.png");

    private static final ResourceLocation TEXTURE_TOOLTIP_BACKGROUND = new ResourceLocation(
        ResourceID + "gui/Tooltip_Background.png");

    public static int z;

    public static void AppleCoreDraw(int x, int y, int width, int height) {
        if (Loader.isModLoaded("AppleCore")) {
            TooltipOverlayHandler.toolTipX = x;
            TooltipOverlayHandler.toolTipY = y;
            TooltipOverlayHandler.toolTipW = width;
            TooltipOverlayHandler.toolTipH = height;
        }
    }

    public static void DrawTooltip(int x, int y, int width, int height) {
        TooltipRender.getInstance().drawTooltip(defaultTexture,x, y, width, height);
    }
    public static void DrawTooltip(TooltipsTexture texture, int x, int y, int width, int height) {
        TooltipRender.getInstance().drawTooltip(texture,x, y, width, height);
    }

}
