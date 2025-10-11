package com.xiao_xing.BetterTooltipBox.Config;

import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.reader.ObjectReader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;

import java.lang.reflect.Type;

public class SpecialItemObjectReader implements ObjectReader<ItemStack> {
    @Override
    public ItemStack readObject(JSONReader jsonReader, Type fieldType, Object fieldName, long features) {
        if (jsonReader.readIfNull()) {
            return null;
        }
        String specialItemName = "";
        int meta = 0;
        jsonReader.nextIfObjectStart();
        while (!jsonReader.nextIfObjectEnd()) {
            specialItemName = jsonReader.readFieldName();
            meta = jsonReader.readInt32();
        }
        return new ItemStack(GameRegistry.findItem(specialItemName.split(":")[0], specialItemName.split(":")[1]),  meta);
    }
}
