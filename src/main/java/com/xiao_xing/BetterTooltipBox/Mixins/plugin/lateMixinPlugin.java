package com.xiao_xing.BetterTooltipBox.Mixins.plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jetbrains.annotations.NotNull;

import com.gtnewhorizon.gtnhmixins.ILateMixinLoader;
import com.gtnewhorizon.gtnhmixins.LateMixin;

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
            list.add("MixinModularGui");
        }
        if (loadedMods.contains("CodeChickenCore") && loadedMods.contains("blockrenderer6343")) {
            list.add("MixinMultiBlockHandler");
            list.add("MixinGuiMultiBlockHandler");
            list.add("MixinInputHandler");
            list.add("MixinGuiContainerManager");
        }
        // ChromaticTooltipsCompat can overwrite doRenderOverlay without calling drawTooltipBox.
        // Leave Waila rendering to it rather than injecting into the replaced method.
        if (loadedMods.contains("Waila") && !loadedMods.contains("chromatictooltipscompat")) {
            list.add("MixinOverlayRenderer");
            list.add("MixinTooltip");
        }
        return list;
    }
}
