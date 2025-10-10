package com.xiao_xing.BetterTooltipBox.Mixins.plugin;

import com.gtnewhorizon.gtnhmixins.IEarlyMixinLoader;

import java.util.List;
import java.util.Set;

public class earlyMixinPlugin implements IEarlyMixinLoader {
    @Override
    public String getMixinConfig() {
        return "";
    }

    @Override
    public List<String> getMixins(Set<String> loadedCoreMods) {
        return null;
    }
}
