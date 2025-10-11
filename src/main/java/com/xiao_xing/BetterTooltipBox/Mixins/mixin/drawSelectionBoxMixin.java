package com.xiao_xing.BetterTooltipBox.Mixins.mixin;


import com.xiao_xing.BetterTooltipBox.Config.ConfigManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.util.AxisAlignedBB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(RenderGlobal.class)
public class drawSelectionBoxMixin {

    @Redirect(
        method = "drawSelectionBox",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/renderer/RenderGlobal;drawOutlinedBoundingBox(Lnet/minecraft/util/AxisAlignedBB;I)V"))
    public void drawOutlinedBoundingBox(AxisAlignedBB p_147590_0_, int p_147590_1_) {
        if (ConfigManager.Instance.Enable_SelectionBox) {
            float time = (System.currentTimeMillis() % 5000L) / 5000.0f * (float) (2 * Math.PI);
            int color = (int) ((Math.sin(time) * 0.5f + 0.5f) * 255) << 16
                | (int) ((Math.cos(time) * 0.5f + 0.5f) * 255) << 8
                | 128;
            RenderGlobal.drawOutlinedBoundingBox(p_147590_0_, color);
        }
        RenderGlobal.drawOutlinedBoundingBox(p_147590_0_, p_147590_1_);
    }
}
