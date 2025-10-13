package com.xiao_xing.BetterTooltipBox.Mixins.late;

import blockrenderer6343.integration.nei.GuiMultiblockHandler;
import com.xiao_xing.BetterTooltipBox.Mixins.Interface.IMixinGuiMultiBlockHandler;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = GuiMultiblockHandler.class,remap = false)
public class MixinGuiMultiBlockHandler implements IMixinGuiMultiBlockHandler {

    @Shadow
    protected ItemStack tooltipBlockStack;

    @Override
    public ItemStack betterTooltipBox$getTooltipBlockStack() {
        return tooltipBlockStack;
    }
}
