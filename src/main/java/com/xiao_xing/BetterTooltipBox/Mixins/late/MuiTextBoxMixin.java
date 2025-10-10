package com.xiao_xing.BetterTooltipBox.Mixins.late;

import com.gtnewhorizons.modularui.api.drawable.GuiHelper;
import com.gtnewhorizons.modularui.api.drawable.TextRenderer;
import com.llamalad7.mixinextras.sugar.Local;
import com.xiao_xing.BetterTooltipBox.Util.TooltipHelper;
import org.apache.commons.lang3.tuple.Pair;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.List;

@Mixin(value = GuiHelper.class,remap = false)
public class MuiTextBoxMixin {

    @Redirect(method = "drawHoveringTextFormatted(Ljava/util/List;Ljava/util/List;Lcom/gtnewhorizons/modularui/api/math/Pos2d;Lcom/gtnewhorizons/modularui/api/math/Size;IFZLcom/gtnewhorizons/modularui/api/math/Alignment;Z)V", at = @At(value = "INVOKE", target = "Lcom/gtnewhorizons/modularui/api/drawable/GuiHelper;drawGradientRect(FFFFFII)V", ordinal = 0, remap = false))
    private static void betterTooltipBox$drawHoveringTextFormatted0(float zLevel, float left, float top, float right, float bottom, int startColor, int endColor){}

    @Redirect(method = "drawHoveringTextFormatted(Ljava/util/List;Ljava/util/List;Lcom/gtnewhorizons/modularui/api/math/Pos2d;Lcom/gtnewhorizons/modularui/api/math/Size;IFZLcom/gtnewhorizons/modularui/api/math/Alignment;Z)V", at = @At(value = "INVOKE", target = "Lcom/gtnewhorizons/modularui/api/drawable/GuiHelper;drawGradientRect(FFFFFII)V", ordinal = 1, remap = false))
    private static void betterTooltipBox$drawHoveringTextFormatted1(float zLevel, float left, float top, float right, float bottom, int startColor, int endColor){}

    @Redirect(method = "drawHoveringTextFormatted(Ljava/util/List;Ljava/util/List;Lcom/gtnewhorizons/modularui/api/math/Pos2d;Lcom/gtnewhorizons/modularui/api/math/Size;IFZLcom/gtnewhorizons/modularui/api/math/Alignment;Z)V", at = @At(value = "INVOKE", target = "Lcom/gtnewhorizons/modularui/api/drawable/GuiHelper;drawGradientRect(FFFFFII)V", ordinal = 2, remap = false))
    private static void betterTooltipBox$drawHoveringTextFormatted2(float zLevel, float left, float top, float right, float bottom, int startColor, int endColor){}

    @Redirect(method = "drawHoveringTextFormatted(Ljava/util/List;Ljava/util/List;Lcom/gtnewhorizons/modularui/api/math/Pos2d;Lcom/gtnewhorizons/modularui/api/math/Size;IFZLcom/gtnewhorizons/modularui/api/math/Alignment;Z)V", at = @At(value = "INVOKE", target = "Lcom/gtnewhorizons/modularui/api/drawable/GuiHelper;drawGradientRect(FFFFFII)V", ordinal = 3, remap = false))
    private static void betterTooltipBox$drawHoveringTextFormatted3(float zLevel, float left, float top, float right, float bottom, int startColor, int endColor){}

    @Redirect(method = "drawHoveringTextFormatted(Ljava/util/List;Ljava/util/List;Lcom/gtnewhorizons/modularui/api/math/Pos2d;Lcom/gtnewhorizons/modularui/api/math/Size;IFZLcom/gtnewhorizons/modularui/api/math/Alignment;Z)V", at = @At(value = "INVOKE", target = "Lcom/gtnewhorizons/modularui/api/drawable/GuiHelper;drawGradientRect(FFFFFII)V", ordinal = 4, remap = false))
    private static void betterTooltipBox$drawHoveringTextFormatted4(float zLevel, float left, float top, float right, float bottom, int startColor, int endColor){}

    @Redirect(method = "drawHoveringTextFormatted(Ljava/util/List;Ljava/util/List;Lcom/gtnewhorizons/modularui/api/math/Pos2d;Lcom/gtnewhorizons/modularui/api/math/Size;IFZLcom/gtnewhorizons/modularui/api/math/Alignment;Z)V", at = @At(value = "INVOKE", target = "Lcom/gtnewhorizons/modularui/api/drawable/GuiHelper;drawGradientRect(FFFFFII)V", ordinal = 5, remap = false))
    private static void betterTooltipBox$drawHoveringTextFormatted5(float zLevel, float left, float top, float right, float bottom, int startColor, int endColor){}

    @Redirect(method = "drawHoveringTextFormatted(Ljava/util/List;Ljava/util/List;Lcom/gtnewhorizons/modularui/api/math/Pos2d;Lcom/gtnewhorizons/modularui/api/math/Size;IFZLcom/gtnewhorizons/modularui/api/math/Alignment;Z)V", at = @At(value = "INVOKE", target = "Lcom/gtnewhorizons/modularui/api/drawable/GuiHelper;drawGradientRect(FFFFFII)V", ordinal = 6, remap = false))
    private static void betterTooltipBox$drawHoveringTextFormatted6(float zLevel, float left, float top, float right, float bottom, int startColor, int endColor){}

    @Redirect(method = "drawHoveringTextFormatted(Ljava/util/List;Ljava/util/List;Lcom/gtnewhorizons/modularui/api/math/Pos2d;Lcom/gtnewhorizons/modularui/api/math/Size;IFZLcom/gtnewhorizons/modularui/api/math/Alignment;Z)V", at = @At(value = "INVOKE", target = "Lcom/gtnewhorizons/modularui/api/drawable/GuiHelper;drawGradientRect(FFFFFII)V", ordinal = 7, remap = false))
    private static void betterTooltipBox$drawHoveringTextFormatted7(float zLevel, float left, float top, float right, float bottom, int startColor, int endColor){}

    @Redirect(method = "drawHoveringTextFormatted(Ljava/util/List;Ljava/util/List;Lcom/gtnewhorizons/modularui/api/math/Pos2d;Lcom/gtnewhorizons/modularui/api/math/Size;IFZLcom/gtnewhorizons/modularui/api/math/Alignment;Z)V", at = @At(value = "INVOKE", target = "Lcom/gtnewhorizons/modularui/api/drawable/GuiHelper;drawGradientRect(FFFFFII)V", ordinal = 8, remap = false))
    private static void betterTooltipBox$drawHoveringTextFormatted8(float zLevel, float left, float top, float right, float bottom, int startColor, int endColor, @Local(name = "tooltipX") int tooltipX, @Local(name = "tooltipY") int tooltipY, @Local(name = "tooltipTextWidth") int tooltipTextWidth, @Local(name = "tooltipHeight") int tooltipHeight, @Local(name = "renderer") TextRenderer renderer, @Local(name = "measuredLines") List<Pair<String, Float>> measuredLines){
        TooltipHelper.DrawTooltip(tooltipX - 3, tooltipY - 5, tooltipTextWidth + 5, tooltipHeight + 9);
    }

}
