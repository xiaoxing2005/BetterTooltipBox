package com.xiao_xing.BetterTooltipBox.Mixins.late;

import java.util.List;
import java.util.function.Function;

import net.minecraft.item.ItemStack;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.gtnewhorizons.modularui.common.internal.wrapper.ModularGui;
import com.xiao_xing.BetterTooltipBox.Util.TooltipHelper;

@Mixin(value = ModularGui.class, remap = false)
public class MixinModularGui {

    @Inject(method = "renderToolTip", at = @At("HEAD"))
    protected void betterTooltipBox$renderToolTip(ItemStack stack, int x, int y, List<String> extraLines,
        Function<List<String>, List<String>> overwriteItemStackTooltip, CallbackInfo ci) {
        TooltipHelper.NEIItemStack = stack;
    }

}
