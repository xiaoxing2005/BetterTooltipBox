package com.xiao_xing.BetterTooltipBox.client.event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.common.MinecraftForge;

import com.gtnewhorizon.gtnhlib.client.event.RenderTooltipEvent;
import com.xiao_xing.BetterTooltipBox.Util.TooltipHelper;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import squeek.applecore.client.TooltipOverlayHandler;

public class renderTooltipEvent {

    public renderTooltipEvent() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void renderTooltip(RenderTooltipEvent event) {
        // event.setCanceled(false);

        event.alternativeRenderer = (t) -> {

            int mouseX = event.x;
            int mouseY = event.y;
            FontRenderer font = event.font;

            ScaledResolution scaledresolution = new ScaledResolution(Minecraft.getMinecraft(), Minecraft.getMinecraft().displayWidth,
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
            }

            if (y + fontHeight + 6 > height) {
                y = height - fontHeight - 6;
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
