package com.xiao_xing.BetterTooltipBox.client;

import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;

public class KeyLoader {

    public static KeyBinding TooltipsRollingActivation;
    public static KeyBinding TooltipsUP;
    public static KeyBinding TooltipsDOWN;
    public static KeyBinding TooltipsLEFT;
    public static KeyBinding TooltipsRight;

    public static void init() {
        TooltipsRollingActivation = new KeyBinding(
            "key.bettertooltipbox.activation",
            Keyboard.KEY_TAB,
            "key.categories.bettertooltipbox");
        TooltipsUP = new KeyBinding("key.bettertooltipbox.up", Keyboard.KEY_UP, "key.categories.bettertooltipbox");
        TooltipsDOWN = new KeyBinding(
            "key.bettertooltipbox.down",
            Keyboard.KEY_DOWN,
            "key.categories.bettertooltipbox");
        TooltipsLEFT = new KeyBinding(
            "key.bettertooltipbox.left",
            Keyboard.KEY_LEFT,
            "key.categories.bettertooltipbox");
        TooltipsRight = new KeyBinding(
            "key.bettertooltipbox.right",
            Keyboard.KEY_RIGHT,
            "key.categories.bettertooltipbox");
        ClientRegistry.registerKeyBinding(TooltipsUP);
        ClientRegistry.registerKeyBinding(TooltipsDOWN);
        ClientRegistry.registerKeyBinding(TooltipsLEFT);
        ClientRegistry.registerKeyBinding(TooltipsRight);
    }

}
