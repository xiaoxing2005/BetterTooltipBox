package com.xiao_xing.BetterTooltipBox.Config;

import java.lang.reflect.Type;
import java.util.Objects;

import net.minecraft.item.ItemStack;

import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.writer.ObjectWriter;

import cpw.mods.fml.common.registry.GameRegistry;

public class SpecialItemObjectWriter implements ObjectWriter<ItemStack> {

    @Override
    public void write(JSONWriter jsonWriter, Object object, Object fieldName, Type fieldType, long features) {
        if (object == null) {
            jsonWriter.writeNull();
            return;
        }
        ItemStack itemStack = (ItemStack) object;
        jsonWriter.startObject();
        jsonWriter.writeName(
            Objects.requireNonNull(GameRegistry.findUniqueIdentifierFor(itemStack.getItem()))
                .toString());
        jsonWriter.writeColon();
        jsonWriter.writeInt32(itemStack.getItemDamage());
        jsonWriter.endObject();
    }
}
