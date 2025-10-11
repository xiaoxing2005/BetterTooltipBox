package com.xiao_xing.BetterTooltipBox.client.render.event;

import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;


import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class keyInputEvent {

    public keyInputEvent() {
        FMLCommonHandler.instance()
            .bus()
            .register(this);
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (Keyboard.isKeyDown(Keyboard.KEY_M)) {
            Minecraft mc = Minecraft.getMinecraft();
            if (mc.currentScreen == null && mc.theWorld != null) {

            }
        }
    }

}
