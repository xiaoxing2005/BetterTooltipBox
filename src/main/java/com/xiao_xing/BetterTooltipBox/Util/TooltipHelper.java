package com.xiao_xing.BetterTooltipBox.Util;

import static com.xiao_xing.BetterTooltipBox.BetterTooltipBox.ResourceID;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

public class TooltipHelper {

    public static final Minecraft mc = Minecraft.getMinecraft();

    public static final ResourceLocation TEXTURE_TOOLTIP = new ResourceLocation(ResourceID + "gui/tooltip_borders.png");

    private static final ResourceLocation TEXTURE_TOOLTIP_BACKGROUND = new ResourceLocation(
        ResourceID + "gui/Tooltip_Background.png");

    public static int z;

    public static void DrawTooltip(int x, int y, int width, int height) {
        // ArrayList<Widget> ts = new ArrayList<>();
        // ts.add(new Widget(TopLeft, new Vector2i(7), new Vector2i(0, 0), new Vector2i(7, 7), new Vector2i(-3, -3)));
        // ts.add(new Widget(TopRight, new Vector2i(7), new Vector2i(57, 0), new Vector2i(64, 7), new Vector2i(3, -3)));
        // ts.add(
        // new Widget(BottomLeft, new Vector2i(8, 7), new Vector2i(0, 9), new Vector2i(8, 16), new Vector2i(-3, 3)));
        // ts.add(new Widget(BottomRight, new Vector2i(7), new Vector2i(57, 9), new Vector2i(64, 16), new Vector2i(3,
        // 3)));
        // ts.add(
        // new Widget(TopCenter, new Vector2i(13, 8), new Vector2i(24, 0), new Vector2i(38, 8), new Vector2i(-7, -6)));
        // ts.add(
        // new Widget(
        // BottomCenter,
        // new Vector2i(9, 3),
        // new Vector2i(26, 10),
        // new Vector2i(36, 14),
        // new Vector2i(-5, 3)));
        // ArrayList<Frame> frames = new ArrayList<>();
        // frames
        // .add(new Frame(Frame.FrameType.ALL, new Vector4i(74, 70, 65, 255), new Vector4i(74, 70, 65, 255), 0, 0, 0));
        //// frames.add(
        //// new Frame(Frame.FrameType.Bottom, new Vector4i(74, 70, 65, 255), new Vector4i(74, 70, 65, 255), 0, 0, 0));
        //// frames.add(
        //// new Frame(Frame.FrameType.Left, new Vector4i(74, 70, 65, 255), new Vector4i(74, 70, 65, 255), 0, 0, 0));
        //// frames.add(
        //// new Frame(Frame.FrameType.Right, new Vector4i(74, 70, 65, 255), new Vector4i(74, 70, 65, 255), 0, 0, 0));
        // frames
        // .add(new Frame(Frame.FrameType.ALL, new Vector4i(20, 22, 30, 255), new Vector4i(20, 22, 30, 255), 0, 0, 1));
        //// frames.add(
        //// new Frame(Frame.FrameType.Bottom, new Vector4i(20, 22, 30, 255), new Vector4i(20, 22, 30, 255), 0, 0, 1));
        //// frames.add(
        //// new Frame(Frame.FrameType.Left, new Vector4i(20, 22, 30, 255), new Vector4i(20, 22, 30, 255), 0, 0, 1));
        //// frames.add(
        //// new Frame(Frame.FrameType.Right, new Vector4i(20, 22, 30, 255), new Vector4i(20, 22, 30, 255), 0, 0, 1));
        // new Tooltip(
        // "test",
        // TEXTURE_TOOLTIP,
        // new Vector2i(128, 128),
        // new BackGround(
        // new Vector4i(6, 9, 10, 255),
        // new Vector4i(6, 9, 10, 255),
        // new Vector4i(40, 39, 37, 255),
        // new Vector4i(40, 39, 37, 255)),
        // ts,
        // frames).drawTooltip(x, y, width, height);

        // DefaultTooltip.drawTooltip(x, y, width, height);
    }

}
