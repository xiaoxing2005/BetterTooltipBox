package com.xiao_xing.BetterTooltipBox.Util;

import static com.xiao_xing.BetterTooltipBox.BetterTooltipBox.ResourceID;
import static com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Textrue.TextureLoader.defaultTexture;
import static com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.TooltipValidationHandler.ITooltipValidationHandler.getTooltipValidation;

import java.util.Objects;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Textrue.TextureManager;
import com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Textrue.TooltipsTexture;
import com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.TooltipRender;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import squeek.applecore.client.TooltipOverlayHandler;

public class TooltipHelper {

    public static final Minecraft mc = Minecraft.getMinecraft();

    public static ItemStack NEIItemStack = null;

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
        TooltipRender.getInstance()
            .drawTooltip(defaultTexture, x, y, width, height, false);
    }

    public static void NEIDrawTooltip(int x, int y, int width, int height) {
        TooltipsTexture texture = null;
        if (NEIItemStack != null) {
            texture = TextureManager.getInstance()
                .fromItemTexture(NEIItemStack);
            if (texture == null) {
                texture = getTooltipValidation(
                    Objects.requireNonNull(GameRegistry.findUniqueIdentifierFor(NEIItemStack.getItem())).modId,
                    NEIItemStack);
            }
        }
        if (texture == null) {
            DrawTooltip(x, y, width, height);
        } else DrawTooltip(texture, x, y, width, height);
        NEIItemStack = null;
    }

    public static void DrawTooltip(int x, int y, int width, int height, boolean isRenderNameUnderscore) {
        TooltipRender.getInstance()
            .drawTooltip(defaultTexture, x, y, width, height, isRenderNameUnderscore);
    }

    public static void DrawTooltip(TooltipsTexture texture, int x, int y, int width, int height) {
        TooltipRender.getInstance()
            .drawTooltip(texture, x, y, width, height, false);
    }

    public static void DrawTooltip(TooltipsTexture texture, int x, int y, int width, int height,
        boolean isRenderNameUnderscore) {
        TooltipRender.getInstance()
            .drawTooltip(texture, x, y, width, height, isRenderNameUnderscore);
    }

}
