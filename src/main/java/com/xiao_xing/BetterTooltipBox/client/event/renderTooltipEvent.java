package com.xiao_xing.BetterTooltipBox.client.event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
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

            int mcWidth = Minecraft.getMinecraft().displayWidth;
            int mcHeight = Minecraft.getMinecraft().displayHeight;

            int width = 0;
            for (String s : t) {
                int lineWidth = font.getStringWidth(s);
                if (lineWidth > width) {
                    width = lineWidth;
                }
            }

            int x = mouseX + 12;
            int y = mouseY - 12;
            int height = 8;

            if (t.size() > 1) {
                height += 2 + (t.size() - 1) * 10;
            }

            if (x + width > mcWidth) {
                x -= 28 + width;
            }

            if (y + height + 6 > mcHeight) {
                y = mcHeight - height - 6;
            }

            if (Loader.isModLoaded("AppleCore")) {
                TooltipOverlayHandler.toolTipX = x + 2;
                TooltipOverlayHandler.toolTipY = y + 2;
                TooltipOverlayHandler.toolTipW = width;
                TooltipOverlayHandler.toolTipH = height;
            }
            TooltipHelper.z = 300;
            TooltipHelper.DrawTooltip(x - 2, y - 2, width + 4, height + 4);

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
