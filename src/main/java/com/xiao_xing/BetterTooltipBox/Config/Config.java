package com.xiao_xing.BetterTooltipBox.Config;

import static com.xiao_xing.BetterTooltipBox.BetterTooltipBox.LOG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import net.minecraft.item.ItemStack;

import com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Textrue.TextureLoader;
import com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Textrue.TextureManager;
import com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Textrue.TooltipsTexture;

import cpw.mods.fml.common.registry.GameRegistry;

public class Config {

    public boolean Enable_SelectionBox;

    public float SelectionBoxLineWidth = 1.0f;

    public boolean Enable_TooltipsOverwrite;

    public boolean Enable_WailaOverwrite;

    public String WailaTooltipTexture;
    // 存储从配置文件中读取的特殊处理物品
    public final HashMap<String, ArrayList<String>> SpecialItemList;
    // 存储从配置文件中读取的TooltipsTexture
    public final HashMap<String, TooltipsTexture> TooltipsTextureList;

    public Config() {
        // 设置默认值
        Enable_SelectionBox = true;
        Enable_WailaOverwrite = true;
        Enable_TooltipsOverwrite = false;
        WailaTooltipTexture = "defaultTexture";
        TooltipsTextureList = new HashMap<>();
        SpecialItemList = new HashMap<>();
    }

    public void registerTooltipsTexture() {
        for (TooltipsTexture texture : TooltipsTextureList.values()) {
            if (texture != null) {
                TextureManager.getInstance()
                    .register(texture);
            } else {
                LOG.error("TooltipsTextureList 中有一个空的 TooltipsTexture 对象，跳过注册。");
            }
        }
    }

    public void reloadTooltipsTexture() {
        for (TooltipsTexture texture : TooltipsTextureList.values()) {
            if (texture != null) {
                TextureManager.getInstance()
                    .reload(texture);
            } else {
                LOG.error("TooltipsTextureList 中有一个空的 TooltipsTexture 对象，跳过注册。");
            }
        }
        TextureLoader.defaultTexture = TextureManager.getInstance()
            .getTexture("defaultTexture");
    }

    public void registerSpecialItemList() {
        if (SpecialItemList.isEmpty()) {
            LOG.warn("SpecialItemList 为空，跳过注册。");

        } else {
            for (Map.Entry<String, ArrayList<String>> entry : SpecialItemList.entrySet()) {
                String textureName = entry.getKey();
                ArrayList<String> itemStacks = entry.getValue();
                TooltipsTexture texture = TextureManager.getInstance()
                    .getTexture(textureName);
                if (texture == null) {
                    LOG.error("无法为特殊物品注册TooltipsTexture {}，因为TooltipsTexture未找到。", textureName);
                    continue;
                }
                for (String itemStack : itemStacks) {
                    if (itemStack != null) {
                        TextureManager.getInstance()
                            .registerSpecialItem(itemStack, texture);
                    } else {
                        LOG.error("{} 中有一个空的 ItemStack 对象，跳过注册。", textureName);
                    }
                }
            }
        }

    }

    public void addSpecialItem(String name, ItemStack... itemStack) {
        ArrayList<String> list = SpecialItemList.get(name);
        if (list == null) {
            list = new ArrayList<>();
            for (ItemStack stack : itemStack) {
                if (stack != null) {
                    list.add(
                        Objects.requireNonNull(GameRegistry.findUniqueIdentifierFor(stack.getItem())) + ":"
                            + stack.getItemDamage());
                }
            }
            SpecialItemList.put(name, list);
        } else {
            for (ItemStack stack : itemStack) {
                if (stack != null && !list.contains(
                    Objects.requireNonNull(GameRegistry.findUniqueIdentifierFor(stack.getItem())) + ":"
                        + stack.getItemDamage())) {
                    SpecialItemList.get(name)
                        .add(
                            Objects.requireNonNull(GameRegistry.findUniqueIdentifierFor(stack.getItem())) + ":"
                                + stack.getItemDamage());
                }
            }
        }
    }

    public void addSpecialItem(String name, ArrayList<ItemStack> itemStacks) {
        ArrayList<String> list = SpecialItemList.get(name);
        if (list == null) {
            list = new ArrayList<>();
            for (ItemStack stack : itemStacks) {
                if (stack != null) {
                    list.add(
                        Objects.requireNonNull(GameRegistry.findUniqueIdentifierFor(stack.getItem())) + ":"
                            + stack.getItemDamage());
                }
            }
            SpecialItemList.put(name, list);
        } else {
            for (ItemStack stack : itemStacks) {
                if (stack != null && !list.contains(
                    Objects.requireNonNull(GameRegistry.findUniqueIdentifierFor(stack.getItem())) + ":"
                        + stack.getItemDamage())) {
                    SpecialItemList.get(name)
                        .add(
                            Objects.requireNonNull(GameRegistry.findUniqueIdentifierFor(stack.getItem())) + ":"
                                + stack.getItemDamage());
                } else {
                    if (stack != null) {
                        LOG.warn(
                            "SpecialItemList 中已经存在该物品，跳过添加: {}",
                            Objects.requireNonNull(GameRegistry.findUniqueIdentifierFor(stack.getItem())) + ":"
                                + stack.getItemDamage());
                    }
                }
            }
        }
    }
}
