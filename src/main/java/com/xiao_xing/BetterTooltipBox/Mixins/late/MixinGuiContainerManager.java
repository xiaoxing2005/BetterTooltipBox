package com.xiao_xing.BetterTooltipBox.Mixins.late;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.llamalad7.mixinextras.sugar.Local;
import com.xiao_xing.BetterTooltipBox.Mixins.Interface.IMixinGuiMultiBlockHandler;
import com.xiao_xing.BetterTooltipBox.Mixins.Interface.IMixinInputHandler;
import com.xiao_xing.BetterTooltipBox.Mixins.Interface.IMixinMultiBlockHandler;
import com.xiao_xing.BetterTooltipBox.Util.TooltipHelper;

import blockrenderer6343.integration.nei.InputHandler;
import codechicken.nei.guihook.GuiContainerManager;
import codechicken.nei.guihook.IContainerTooltipHandler;

@Mixin(value = GuiContainerManager.class, remap = false)
public class MixinGuiContainerManager {

    @Inject(
        method = "renderToolTips",
        at = @At(
            value = "INVOKE",
            target = "Lcodechicken/nei/guihook/IContainerTooltipHandler;handleTooltip(Lnet/minecraft/client/gui/inventory/GuiContainer;IILjava/util/List;)Ljava/util/List;"),
        remap = false)
    public void betterTooltipBox$renderToolTips(int mousex, int mousey, CallbackInfo ci,
        @Local IContainerTooltipHandler handler) {
        if (handler instanceof InputHandler inputHandler
            && inputHandler instanceof IMixinInputHandler iMixinInputHandler) {
            if (iMixinInputHandler
                .betterTooltipBox$getMultiblockHandler() instanceof IMixinMultiBlockHandler iMixinMultiBlockHandler) {
                TooltipHelper.NEIItemStack = ((IMixinGuiMultiBlockHandler) iMixinMultiBlockHandler
                    .betterTooltipBox$getGuiMultiBlockHandler()).betterTooltipBox$getTooltipBlockStack();
            }
        }
    }

}
