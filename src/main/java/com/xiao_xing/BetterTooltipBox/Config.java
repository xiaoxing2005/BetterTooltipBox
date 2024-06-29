package com.xiao_xing.BetterTooltipBox;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

    public static boolean Enable_BetterTooltipBox = true;

    public static void synchronizeConfiguration(File configFile) {
        Configuration configuration = new Configuration(configFile);

        Enable_BetterTooltipBox = configuration.getBoolean(
            "Enable BetterTooltipBox",
            Configuration.CATEGORY_GENERAL,
            Enable_BetterTooltipBox,
            "Enable BetterTooltipBox");

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
