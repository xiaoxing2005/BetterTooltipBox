package com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.TooltipValidationHandler;

import java.util.ArrayList;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.registry.GameRegistry;

public abstract class ModIdValidationBase implements ITooltipValidationHandler {

    protected final ArrayList<ItemStack> ExtraItemStackList = new ArrayList<>();

    public abstract boolean modIdCheck(String modId, ItemStack itemStack);

    public void addExtraItemStack(ItemStack stack) {
        this.ExtraItemStackList.add(stack);
    }

    @Override
    public boolean TooltipValidation(ItemStack itemStack) {
        Item item = itemStack.getItem();
        var ui = GameRegistry.findUniqueIdentifierFor(item);
        if (ui != null) {
            String modId = ui.modId.split(":")[0];
            return modIdCheck(modId, itemStack);
        }
        return false;
    }
}
