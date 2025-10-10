package com.xiao_xing.BetterTooltipBox.Mixins.plugin;

import com.gtnewhorizon.gtnhmixins.ILateMixinLoader;
import com.gtnewhorizon.gtnhmixins.LateMixin;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@LateMixin
public class lateMixinPlugin implements ILateMixinLoader {
    @Override
    public String getMixinConfig() {
        return "mixins.BetterTooltipBox.late.json";
    }

    @Override
    public @NotNull List<String> getMixins(Set<String> loadedMods) {
        ArrayList<String> list = new ArrayList<>();
        if (loadedMods.contains("modularui")) {
            list.add("MuiTextBoxMixin");
        }
        return list;
    }
}
