package com.xiao_xing.BetterTooltipBox.Mixins.late;

import blockrenderer6343.integration.nei.InputHandler;
import blockrenderer6343.integration.nei.MultiblockHandler;
import com.xiao_xing.BetterTooltipBox.Mixins.Interface.IMixinInputHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = InputHandler.class,remap = false)
public class MixinInputHandler implements IMixinInputHandler {

    @Shadow
    private MultiblockHandler activeHandler;

    @Override
    public MultiblockHandler betterTooltipBox$getMultiblockHandler() {
        return activeHandler;
    }
}
