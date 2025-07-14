package com.xiao_xing.BetterTooltipBox.client.event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

import org.lwjgl.input.Mouse;

import com.gtnewhorizon.gtnhlib.client.event.RenderTooltipEvent;
import com.xiao_xing.BetterTooltipBox.Util.TooltipHelper;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import squeek.applecore.client.TooltipOverlayHandler;

public class renderTooltipEvent {

    // 用于记录上一次渲染的物品
    private static ItemStack lastRenderItemStack = null;
    private static int offsetY = 0;

    public renderTooltipEvent() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void renderTooltip(RenderTooltipEvent event) {
        // event.setCanceled(false);

        event.alternativeRenderer = (t) -> {
            if (lastRenderItemStack == null) {
                lastRenderItemStack = event.itemStack;
            } else if (!lastRenderItemStack.isItemEqual(event.itemStack)) {
                offsetY = 0;
                lastRenderItemStack = event.itemStack;
            }

            int mouseX = event.x;
            int mouseY = event.y;
            FontRenderer font = event.font;

            ScaledResolution scaledresolution = new ScaledResolution(
                Minecraft.getMinecraft(),
                Minecraft.getMinecraft().displayWidth,
                Minecraft.getMinecraft().displayHeight);

            int width = scaledresolution.getScaledWidth();
            int height = scaledresolution.getScaledHeight();

            int fontWidth = 0;

            for (String s : t) {
                int l = font.getStringWidth(s);

                if (l > fontWidth) {
                    fontWidth = l;
                }
            }

            int x = mouseX + 12;
            int y = mouseY - 12;
            int fontHeight = 8;

            if (t.size() > 1) {
                fontHeight += 2 + (t.size() - 1) * 10;
            }

            if (x + fontWidth > width) {
                x -= 28 + fontWidth;
                // 判定是否超出游戏画面
                if (x < 0) {
                    // 居中
                    x = (width / 2) - (fontWidth / 2);
                }
            }

            if (y + fontHeight + 6 > height) {
                y = height - fontHeight - 6;
                if (y < 0) {

                    y = (height / 2) - (fontHeight / 2);

                    // 如果居中后依旧小于0，那么将调整为指定坐标
                    if (y < 0) {
                        // 滚轮调整偏移
                        if (Mouse.isCreated()) {
                            while (Mouse.next()) {
                                int wheel = Mouse.getEventDWheel();
                                if (wheel != 0) {
                                    if (wheel > 0) { // 上限位
                                        offsetY = Math.min(0, offsetY + 8);
                                    } else {
                                        offsetY -= 8;
                                    }
                                }
                            }
                        }
                        y = 14 + offsetY; // 这里的14为恰好露出logo并与画面顶端间隔1格像素
                    }
                }
            }

            if (Loader.isModLoaded("AppleCore")) {
                TooltipOverlayHandler.toolTipX = x + 2;
                TooltipOverlayHandler.toolTipY = y + 2;
                TooltipOverlayHandler.toolTipW = fontWidth;
                TooltipOverlayHandler.toolTipH = fontHeight;
            }
            TooltipHelper.z = 300;
            TooltipHelper.DrawTooltip(x - 2, y - 2, fontWidth + 4, fontHeight + 4);

            for (int i = 0; i < t.size(); i++) {
                String s = t.get(i);
                font.drawStringWithShadow(s, x, y, -1);

                if (i == 0) {
                    y += 2;
                }
                y += 10;
            }
        };
    }
}
