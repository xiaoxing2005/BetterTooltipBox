package com.xiao_xing.BetterTooltipBox.Mixins.late;

import static com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Textrue.TextureLoader.WailaTexture;

import net.minecraft.client.Minecraft;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.xiao_xing.BetterTooltipBox.Mixins.Interface.IMixinTooltip;
import com.xiao_xing.BetterTooltipBox.Util.TooltipHelper;
import com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Textrue.TooltipsTexture;

import mcp.mobius.waila.overlay.OverlayRenderer;
import mcp.mobius.waila.overlay.Tooltip;

@Mixin(value = OverlayRenderer.class, remap = false)
public class MixinOverlayRenderer {

    @Unique
    private static int Y = 0;

    @Inject(method = "drawTooltipBox", at = @At(value = "HEAD"), remap = false, cancellable = true)
    private static void drawTooltipBox(int x, int y, int w, int h, int bg, int grad1, int grad2, CallbackInfo ci) {
        float TopCenterHeight = 0;
        float BottomCenterHeight = 0;
        Y = y;
        int W = y + w;
        for (var Fragment : WailaTexture.getTextureFragments()) {
            TooltipsTexture.TextureFragmentType fragmentType = Fragment.getFragmentType();
            switch (fragmentType) {
                case Top_Center -> TopCenterHeight = Fragment.getHeight();
                case Bottom_Center -> BottomCenterHeight = Fragment.getHeight();
            }
        }
        if (Y - TopCenterHeight < 0) {
            Y -= (int) (Y - TopCenterHeight);
        }
        if (W + BottomCenterHeight > Minecraft.getMinecraft().displayHeight) {
            Y += (int) (W + BottomCenterHeight - Minecraft.getMinecraft().displayHeight);
        }
        TooltipHelper.DrawTooltip(WailaTexture, x, Y, w, h);
        ci.cancel();
    }

    @Inject(
        method = "doRenderOverlay",
        at = @At(
            value = "INVOKE",
            target = "Lmcp/mobius/waila/overlay/OverlayRenderer;drawTooltipBox(IIIIIII)V",
            shift = At.Shift.AFTER),
        remap = false)
    private static void doRenderOverlay(Tooltip tooltip, CallbackInfo ci) {
        if (tooltip instanceof IMixinTooltip iMixinTooltip) {
            iMixinTooltip.betterTooltipBox$setTooltipY(Y);
        }
    }

}
