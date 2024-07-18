package com.xiao_xing.BetterTooltipBox.Mixins;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import static com.xiao_xing.BetterTooltipBox.Config.Enable_SelectionBox;

@Mixin(RenderGlobal.class)
public class drawSelectionBoxMixin {
    @Redirect(
            method = "drawSelectionBox",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/renderer/RenderGlobal;drawOutlinedBoundingBox(Lnet/minecraft/util/AxisAlignedBB;I)V"))
    public void drawOutlinedBoundingBox(AxisAlignedBB p_147590_0_, int p_147590_1_) {
        if(Enable_SelectionBox){
            float time = (System.currentTimeMillis() % 5000L) / 5000.0f * (float) (2 * Math.PI);
            int color = (int) ((Math.sin(time) * 0.5f + 0.5f) * 255) << 16 |
                    (int) ((Math.cos(time) * 0.5f + 0.5f) * 255) << 8 |
                    128;
            RenderGlobal.drawOutlinedBoundingBox(p_147590_0_, color);
        }RenderGlobal.drawOutlinedBoundingBox(p_147590_0_, p_147590_1_);
    }
}
