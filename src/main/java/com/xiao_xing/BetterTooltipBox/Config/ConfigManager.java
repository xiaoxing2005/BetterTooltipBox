package com.xiao_xing.BetterTooltipBox.Config;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Textrue.TooltipsTexture;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static com.xiao_xing.BetterTooltipBox.BetterTooltipBox.LOG;

public class ConfigManager {

    public static Config Instance;
    private static File configFile;
    private static File modConfigDir;

    static {
        JSON.register(TooltipsTexture.class,new TooltipsTextureObjectWriter());
        JSON.register(TooltipsTexture.class,new TooltipsTextureObjectReader());
        //JSON.register(ItemStack.class,new SpecialItemObjectWriter());
        //JSON.register(ItemStack.class,new SpecialItemObjectReader());
    }

    public static void init(File configDir) {

        modConfigDir = new File(configDir,"BetterTooltipBox" );
        if (!modConfigDir.exists()) {
            if (!modConfigDir.mkdirs()){
                LOG.error("配置文件夹加载失败!");
            };
        }
        configFile = new File(modConfigDir, "config.json");

        loadConfig();
    }

    public static void loadConfig() {
        if (configFile.exists()) {
            try (FileReader reader = new FileReader(configFile)) {
                Instance = JSON.parseObject(reader, Config.class);
                if (Instance == null) {
                    LOG.error("配置文件为空或损坏.");
                    createDefaultConfig();
                }else {
                    Instance.registerTooltipsTexture();
                }
            } catch (IOException e) {
                LOG.error("加载 BetterTooltipBox 的配置文件时出错！使用默认值",e);
                createDefaultConfig();
            }
        }else {
            System.out.println("找不到配置文件，创建一个具有默认值的新文件。");
            createDefaultConfig();
        }
        saveConfig();
    }

    public static void reloadConfig() {
        if (!modConfigDir.exists()) {
            if (!modConfigDir.mkdirs()){
                LOG.error("配置文件夹加载失败!");
            };
        }
        configFile = new File(modConfigDir, "config.json");
        if (configFile.exists()) {
            try (FileReader reader = new FileReader(configFile)) {
                Instance = JSON.parseObject(reader, Config.class);
                if (Instance == null) {
                    LOG.error("配置文件为空或损坏.");
                }else {
                    Instance.reloadTooltipsTexture();
                }
            } catch (IOException e) {
                LOG.error("加载 BetterTooltipBox 的配置文件时出错！",e);
            }
        }else {
            System.out.println("找不到配置文件。");
        }
        registerSpecialItemList();
        saveConfig();
    }

    public static void saveConfig() {
        try (FileWriter writer = new FileWriter(configFile)) {
            // 使用 Gson 将我们的 config 对象序列化为 JSON 字符串，并写入文件
            String json = JSON.toJSONString(Instance, JSONWriter.Feature.PrettyFormat);
            writer.write(json);
            LOG.info("成功保存配置文件");
        } catch (IOException e) {
            LOG.error("保存配置文件时出错!",e);
        }
    }

    public static void registerSpecialItemList(){
        Instance.registerSpecialItemList();
        saveConfig();
    }

    private static void createDefaultConfig() {
        Instance = new Config();
        saveConfig();
    }
}
