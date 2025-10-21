package com.xiao_xing.BetterTooltipBox.client.render.event;

import static com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.TooltipValidationHandler.ITooltipValidationHandler.getTooltipValidation;

import java.awt.Dimension;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

import org.lwjgl.input.Keyboard;

import com.gtnewhorizon.gtnhlib.client.event.RenderTooltipEvent;
import com.xiao_xing.BetterTooltipBox.Util.TooltipHelper;
import com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Textrue.TextureManager;
import com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Textrue.TooltipsTexture;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import squeek.applecore.client.TooltipOverlayHandler;

public class renderTooltipEvent {

    // 用于记录上一次渲染的物品
    private static ItemStack lastRenderItemStack = null;
    private static int offsetY = 0;

    // NEI 反射相关
    private static boolean isLoaderNei = true;
    private static String TOOLTIP_HANDLER = null;
    private static String TOOLTIP_LINESPACE = null;
    private static Method getTipLineMethod = null;
    private static Method getSizeMethod = null;
    private static Method drawMethod = null;

    static {
        try {
            // 反射获取 GuiDraw 类
            Class<?> guiDrawClass = Class.forName("codechicken.lib.gui.GuiDraw");

            // 获取静态字段
            Field tooltipHandlerField = guiDrawClass.getField("TOOLTIP_HANDLER");
            TOOLTIP_HANDLER = (String) tooltipHandlerField.get(null);

            Field tooltipLinespaceField = guiDrawClass.getField("TOOLTIP_LINESPACE");
            TOOLTIP_LINESPACE = (String) tooltipLinespaceField.get(null);

            // 获取 getTipLine 方法
            getTipLineMethod = guiDrawClass.getMethod("getTipLine", String.class);

            // 获取 ITooltipLineHandler 接口
            Class<?> iTooltipLineHandlerClass = Class.forName("codechicken.lib.gui.GuiDraw$ITooltipLineHandler");

            // 获取 ITooltipLineHandler 的方法
            getSizeMethod = iTooltipLineHandlerClass.getMethod("getSize");
            drawMethod = iTooltipLineHandlerClass.getMethod("draw", int.class, int.class);

        } catch (Exception e) {
            // 反射失败，设置标志为 false
            isLoaderNei = false;
        }
    }

    public renderTooltipEvent() {
        MinecraftForge.EVENT_BUS.register(this);
        FMLCommonHandler.instance()
            .bus()
            .register(this);
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

            int scaledWidth = scaledresolution.getScaledWidth();
            int scaledHeight = scaledresolution.getScaledHeight();

            int fontWidth = 0;
            int fontHeight = 0;

            for (String s : t) {
                // NEI Handler 行处理
                if (isLoaderNei && s.startsWith(TOOLTIP_HANDLER)) {
                    try {
                        Object tipLine = getTipLineMethod.invoke(null, s);
                        Dimension size = (Dimension) getSizeMethod.invoke(tipLine);
                        fontWidth = Math.max(fontWidth, size.width);
                        fontHeight += size.height + 4;
                        continue;
                    } catch (Exception e) {
                        // 反射调用失败，按正常文本处理
                    }
                }

                int l = font.getStringWidth(s);

                if (l > fontWidth) {
                    fontWidth = l;
                }
                fontHeight += (isLoaderNei && s.endsWith(TOOLTIP_LINESPACE)) ? 12 : 10;
            }

            int x = mouseX + 12;
            int y = mouseY - 12;

            // if (t.size() > 1) {
            // height += 2 + (t.size() - 1) * 10;
            // }

            if (x + fontWidth > scaledWidth) {
                x -= 28 + fontWidth;
                // 判定是否超出游戏画面
                if (x < 0) {
                    // 居中
                    x = (scaledWidth / 2) - (fontWidth / 2);
                    // 居中后依旧小于0，那么将调整为左侧对齐
                    if (x < 0) {
                        x = 2;
                    }
                }
            }

            if (y + fontHeight + 6 > scaledHeight) {
                y = scaledHeight - fontHeight - 6;
                if (y < 0) {

                    y = (scaledHeight / 2) - (fontHeight / 2);

                    // 如果居中后依旧小于0，那么将调整为指定坐标
                    if (y < 0) {
                        // 方向键调整偏移
                        if (Keyboard.isKeyDown(Keyboard.KEY_TAB)) {
                            if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
                                offsetY = Math.min(0, offsetY + 4);
                            } else if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
                                offsetY -= 4;
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
            TooltipsTexture texture = TextureManager.getInstance()
                .fromItemTexture(event.itemStack);
            if (texture == null) {
                texture = getTooltipValidation(
                    Objects.requireNonNull(GameRegistry.findUniqueIdentifierFor(event.itemStack.getItem())).modId,
                    event.itemStack);
            }
            if (texture != null) {
                TooltipHelper.DrawTooltip(texture, x - 3, y - 5, fontWidth + 5, fontHeight + 9, true);
            } else {
                TooltipHelper.DrawTooltip(x - 3, y - 5, fontWidth + 5, fontHeight + 9, true);
            }
            for (int i = 0; i < t.size(); i++) {
                String s = t.get(i);
                if (isLoaderNei && s.startsWith(TOOLTIP_HANDLER)) {
                    try {
                        Object tipLine = getTipLineMethod.invoke(null, s);
                        drawMethod.invoke(tipLine, x, y);
                        Dimension size = (Dimension) getSizeMethod.invoke(tipLine);
                        y += size.height + 4;
                        continue;
                    } catch (Exception e) {
                        // 反射调用失败，按正常文本处理
                    }
                }
                if (!(Minecraft.getMinecraft().currentScreen instanceof GuiMultiplayer) && i == 0
                    && font.getStringWidth(s) < fontWidth) {
                    if (s.contains(event.itemStack.getDisplayName())) {
                        int nameX = x + ((fontWidth - font.getStringWidth(s)) / 2);
                        font.drawStringWithShadow(s, nameX, y, -1);
                    } else {
                        font.drawStringWithShadow(s, x, y, -1);
                    }
                } else {
                    font.drawStringWithShadow(s, x, y, -1);
                }

                if (i == 0) {
                    y += 2;
                }
                y += (isLoaderNei && s.endsWith(TOOLTIP_LINESPACE)) ? 12 : 10;
            }
        };
    }
}
