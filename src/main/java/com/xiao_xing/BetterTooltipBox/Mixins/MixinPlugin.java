package com.xiao_xing.BetterTooltipBox.Mixins;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import cpw.mods.fml.common.Mod;

public class MixinPlugin implements IMixinConfigPlugin {

    public static boolean isLoaderGTNHlib = false;

    @Override
    public void onLoad(String mixinPackage) {

    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        return true;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {

    }

    @Override
    public List<String> getMixins() {
        List<String> MixinClass = new ArrayList<>();
        try {
            boolean hasAnnotation = Class.forName("com.gtnewhorizon.gtnhlib.GTNHLib")
                .isAnnotationPresent(Mod.class);
            if (hasAnnotation) {
                Mod mod = Class.forName("com.gtnewhorizon.gtnhlib.GTNHLib")
                    .getAnnotation(Mod.class);
                if (compareVersion(mod.version(), "0.6.0") == -1) {
                    try {
                        Class.forName("com.gtnewhorizon.gtnhlib.client.event.RenderTooltipEvent");
                        isLoaderGTNHlib = true;
                        MixinClass.add("NotItemStackTooltipMixin");
                        MixinClass.add("drawSelectionBoxMixin");
                        return MixinClass;
                    } catch (ClassNotFoundException ignored) {}
                }
                // System.out.println("id" + mod.version());
            }
        } catch (ClassNotFoundException ignored) {
            ignored.printStackTrace();
        }

        try {
            Class.forName("squeek.applecore.AppleCore");
            MixinClass.add("TooltipMixin");
        } catch (ClassNotFoundException ignored) {}
        MixinClass.add("ItemTooltipMixin");
        MixinClass.add("drawSelectionBoxMixin");
        return MixinClass;
    }

    @Override
    public void preApply(String s, ClassNode classNode, String s1, IMixinInfo iMixinInfo) {

    }

    @Override
    public void postApply(String s, ClassNode classNode, String s1, IMixinInfo iMixinInfo) {

    }

    public static int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");

        int length = Math.max(nums1.length, nums2.length);

        for (int i = 0; i < length; i++) {
            // 获取当前比对的数字，若不存在则视为0
            int v1 = i < nums1.length ? Integer.parseInt(nums1[i]) : 0;
            int v2 = i < nums2.length ? Integer.parseInt(nums2[i]) : 0;

            if (v1 < v2) {
                return -1; // version1 < version2
            }
            if (v1 > v2) {
                return 1; // version1 > version2
            }
        }
        return 0; // 两个版本号相同
    }
}
