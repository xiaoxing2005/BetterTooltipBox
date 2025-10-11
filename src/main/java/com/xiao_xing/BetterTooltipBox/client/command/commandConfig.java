package com.xiao_xing.BetterTooltipBox.client.command;

import com.xiao_xing.BetterTooltipBox.Config.ConfigManager;
import com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Textrue.TextureManager;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class commandConfig extends CommandBase {
    @Override
    public String getCommandName() {
        return "bettertooltipbox";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "将手上的物品添加进特殊物品列表";
    }

    @Override
    public ArrayList<String> addTabCompletionOptions(ICommandSender sender, String[] args){
        if (args.length == 1)
        {
            String[] names = {"add","remove","save","reload"};
            return (ArrayList<String>) CommandBase.getListOfStringsMatchingLastWord(args, names);
        }
        return null;
    }

    @Override
    public int getRequiredPermissionLevel(){
        return 1;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        ItemStack itemStack = Minecraft.getMinecraft().thePlayer.getHeldItem();
        switch (args[0]) {
             case "add" -> {
                 if (itemStack != null) {
                     if (ConfigManager.Instance.SpecialItemList.containsKey(args[1])) {
                         ArrayList<String> list = ConfigManager.Instance.SpecialItemList.get(args[1]);
                         if (list.contains(Objects.requireNonNull(GameRegistry.findUniqueIdentifierFor(itemStack.getItem())) + ":" + itemStack.getItemDamage())) {
                             sender.addChatMessage(new ChatComponentText("该物品已存在于特殊物品列表中,无需重复添加!"));
                             return;
                         } else {
                             sender.addChatMessage(new ChatComponentText("成功添加!请在所有物品添加完成后使用 /btooltipbox save 来保存配置文件"));
                             list.add(Objects.requireNonNull(GameRegistry.findUniqueIdentifierFor(itemStack.getItem())) + ":" + itemStack.getItemDamage());
                             return;
                         }
                     } else {
                         sender.addChatMessage(new ChatComponentText("成功添加!请在所有物品添加完成后使用 /btooltipbox save 来保存配置文件"));
                         ArrayList<String> list = new ArrayList<>();
                         list.add(Objects.requireNonNull(GameRegistry.findUniqueIdentifierFor(itemStack.getItem())) + ":" + itemStack.getItemDamage());
                         ConfigManager.Instance.SpecialItemList.put(args[1], list);
                         return;
                     }
                 }
                 sender.addChatMessage(new ChatComponentText("请手持物品！"));
             }
             case "remove" -> {
                 if (itemStack != null) {
                     if (ConfigManager.Instance.SpecialItemList.containsKey(args[1])) {
                         ArrayList<String> list = ConfigManager.Instance.SpecialItemList.get(args[1]);
                         if (list.contains(Objects.requireNonNull(GameRegistry.findUniqueIdentifierFor(itemStack.getItem())) + ":" + itemStack.getItemDamage())) {
                             list.remove(Objects.requireNonNull(GameRegistry.findUniqueIdentifierFor(itemStack.getItem())) + ":" + itemStack.getItemDamage());
                             TextureManager.INSTANCE.removeSpecialItem(Objects.requireNonNull(GameRegistry.findUniqueIdentifierFor(itemStack.getItem())) + ":" + itemStack.getItemDamage());
                             sender.addChatMessage(new ChatComponentText("成功移除!请在所有物品移除完成后使用 /btooltipbox save 来保存配置文件"));
                             return;
                         }
                     }
                     sender.addChatMessage(new ChatComponentText("并没有在特殊物品列表里找到此物品"));
                 }else  sender.addChatMessage(new ChatComponentText("请手持物品！"));
             }
             case "save" -> {
                 ConfigManager.saveConfig();
                 sender.addChatMessage(new ChatComponentText("配置文件保存成功!"));
             }
             case "reload" -> {
                 ConfigManager.reloadConfig();
                 sender.addChatMessage(new ChatComponentText("配置文件重载成功!"));
             }
        }
    }
}
