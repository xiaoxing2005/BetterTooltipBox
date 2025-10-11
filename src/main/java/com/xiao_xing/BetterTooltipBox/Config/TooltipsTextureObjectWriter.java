package com.xiao_xing.BetterTooltipBox.Config;

import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.writer.ObjectWriter;
import com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Textrue.TooltipsTexture;

import java.lang.reflect.Type;

public class TooltipsTextureObjectWriter implements ObjectWriter<TooltipsTexture> {
    @Override
    public void write(JSONWriter jsonWriter, Object object, Object fieldName, Type fieldType, long features) {

        if (object == null) {
            jsonWriter.writeNull();
            return;
        }

        TooltipsTexture texture = (TooltipsTexture) object;

        jsonWriter.startObject();

        jsonWriter.writeName("TextureName");
        jsonWriter.writeColon();
        jsonWriter.writeString(texture.getTextureName());

        jsonWriter.writeName("ResourceLocation");
        jsonWriter.writeColon();
        jsonWriter.writeString(texture.getResourceLocation().toString());

        jsonWriter.writeName("TextureSize");
        jsonWriter.writeColon();
        jsonWriter.writeInt32(new int[]{(int) texture.getWidth(), (int) texture.getHeight()});

        jsonWriter.writeName("BackgroundColor");
        jsonWriter.writeColon();
        jsonWriter.startObject();
        jsonWriter.writeName("StartColor");
        jsonWriter.writeColon();
        jsonWriter.writeInt32(new int[]{
            texture.getBackgroundColor()[0][0], texture.getBackgroundColor()[0][1], texture.getBackgroundColor()[0][2], texture.getBackgroundColor()[0][3]
        });
        jsonWriter.writeName("EndColor");
        jsonWriter.writeColon();
        jsonWriter.writeInt32(new int[]{
            texture.getBackgroundColor()[1][0], texture.getBackgroundColor()[1][1], texture.getBackgroundColor()[1][2], texture.getBackgroundColor()[1][3]
        });
        jsonWriter.endObject();

        jsonWriter.writeName("LineColor");
        jsonWriter.writeColon();
        jsonWriter.startObject();

        jsonWriter.writeName("Top");
        jsonWriter.writeColon();
        jsonWriter.startObject();
        jsonWriter.writeName("StartColor");
        jsonWriter.writeColon();
        jsonWriter.writeInt32(new int[]{
                texture.getLineColor()[0][0], texture.getLineColor()[0][1], texture.getLineColor()[0][2], texture.getLineColor()[0][3]
        });
        jsonWriter.writeName("EndColor");
        jsonWriter.writeColon();
        jsonWriter.writeInt32(new int[]{
            texture.getLineColor()[0][4], texture.getLineColor()[0][5], texture.getLineColor()[0][6], texture.getLineColor()[0][7]
        });
        jsonWriter.endObject();

        jsonWriter.writeName("Bottom");
        jsonWriter.writeColon();
        jsonWriter.startObject();
        jsonWriter.writeName("StartColor");
        jsonWriter.writeColon();
        jsonWriter.writeInt32(new int[]{
                texture.getLineColor()[1][0], texture.getLineColor()[1][1], texture.getLineColor()[1][2], texture.getLineColor()[1][3]}
        );
        jsonWriter.writeName("EndColor");
        jsonWriter.writeColon();
        jsonWriter.writeInt32(new int[]{
                texture.getLineColor()[1][4], texture.getLineColor()[1][5], texture.getLineColor()[1][6], texture.getLineColor()[1][7]}
        );
        jsonWriter.endObject();

        jsonWriter.writeName("Left");
        jsonWriter.writeColon();
        jsonWriter.startObject();
        jsonWriter.writeName("StartColor");
        jsonWriter.writeColon();
        jsonWriter.writeInt32(new int[]{
                texture.getLineColor()[2][0], texture.getLineColor()[2][1], texture.getLineColor()[2][2], texture.getLineColor()[2][3]}
        );
        jsonWriter.writeName("EndColor");
        jsonWriter.writeColon();
        jsonWriter.writeInt32(new int[]{
                texture.getLineColor()[2][4], texture.getLineColor()[2][5], texture.getLineColor()[2][6], texture.getLineColor()[2][7]}
        );
        jsonWriter.endObject();

        jsonWriter.writeName("Right");
        jsonWriter.writeColon();
        jsonWriter.startObject();
        jsonWriter.writeName("StartColor");
        jsonWriter.writeColon();
        jsonWriter.writeInt32(new int[]{
                texture.getLineColor()[3][0], texture.getLineColor()[3][1], texture.getLineColor()[3][2], texture.getLineColor()[3][3]}
        );
        jsonWriter.writeName("EndColor");
        jsonWriter.writeColon();
        jsonWriter.writeInt32(new int[]{
                texture.getLineColor()[3][4], texture.getLineColor()[3][5], texture.getLineColor()[3][6], texture.getLineColor()[3][7]}
        );
        jsonWriter.endObject();
        jsonWriter.writeName("Center");
        jsonWriter.writeColon();
        jsonWriter.startObject();
        jsonWriter.writeName("StartColor");
        jsonWriter.writeColon();
        jsonWriter.writeInt32(new int[]{
                texture.getLineColor()[4][0], texture.getLineColor()[4][1], texture.getLineColor()[4][2], texture.getLineColor()[4][3]
        });
        jsonWriter.writeName("EndColor");
        jsonWriter.writeColon();
        jsonWriter.writeInt32(new int[]{
                texture.getLineColor()[4][4], texture.getLineColor()[4][5], texture.getLineColor()[4][6], texture.getLineColor()[4][7]}
        );
        jsonWriter.endObject();

        jsonWriter.endObject();
        jsonWriter.writeName("FragmentList");
        jsonWriter.writeColon();
        jsonWriter.startObject();
        for (TooltipsTexture.TextureFragment fragment : texture.getTextureFragments()) {
            jsonWriter.writeName(fragment.getFragmentType().name());
            jsonWriter.writeColon();
            jsonWriter.startObject();
            jsonWriter.writeName("X");
            jsonWriter.writeColon();
            jsonWriter.writeInt32((int) fragment.getFragmentX());
            jsonWriter.writeName("Y");
            jsonWriter.writeColon();
            jsonWriter.writeInt32((int) fragment.getFragmentY());
            jsonWriter.writeName("Width");
            jsonWriter.writeColon();
            jsonWriter.writeFloat(fragment.getWidth());
            jsonWriter.writeName("Height");
            jsonWriter.writeColon();
            jsonWriter.writeFloat(fragment.getHeight());
            jsonWriter.writeName("Offset");
            jsonWriter.writeColon();
            jsonWriter.writeInt32(fragment.getOffset());
            jsonWriter.endObject();
        }
        jsonWriter.endObject();

        jsonWriter.endObject();

    }
}
