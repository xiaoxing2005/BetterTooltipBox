package com.xiao_xing.BetterTooltipBox.Mixins.late;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import com.xiao_xing.BetterTooltipBox.Mixins.Interface.IMixinMultiBlockHandler;

import blockrenderer6343.integration.nei.GuiMultiblockHandler;
import blockrenderer6343.integration.nei.MultiblockHandler;

@Mixin(value = MultiblockHandler.class, remap = false)
public class MixinMultiBlockHandler implements IMixinMultiBlockHandler {

    @Shadow
    protected GuiMultiblockHandler guiHandler;

    @Override
    public GuiMultiblockHandler betterTooltipBox$getGuiMultiBlockHandler() {
        return guiHandler;
    }
}
