package com.xiao_xing.BetterTooltipBox.client.render.tooltipRender;

import static com.xiao_xing.BetterTooltipBox.Util.TooltipHelper.mc;
import static com.xiao_xing.BetterTooltipBox.client.render.shader.ShaderFactory.createProgram;
import static com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Textrue.TooltipsTexture.TextureFragmentType.Bottom_Center;
import static com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Textrue.TooltipsTexture.TextureFragmentType.Top_Center;
import static org.lwjgl.BufferUtils.createFloatBuffer;
import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_CULL_FACE;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_NEAREST;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MAG_FILTER;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MIN_FILTER;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glTexParameteri;

import java.nio.FloatBuffer;
import java.util.ArrayList;

import com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Textrue.TooltipsTexture;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;

import com.xiao_xing.BetterTooltipBox.client.render.shader.ShaderProgram;

public class TooltipRender {

    public static TooltipRender Instance = new TooltipRender();
    private static final int VBO = GL15.glGenBuffers();

    private static final ShaderProgram TextureShader = createProgram(
        "TextureShader",
        "bettertooltipbox",
        "shader/Texture.vert",
        "shader/Texture.frag");
    private static final ShaderProgram SmoothShader = createProgram(
        "SmoothShader",
        "bettertooltipbox",
        "shader/Smooth.vert",
        "shader/Smooth.frag");

    public TooltipRender(){}

    public static TooltipRender getInstance() {
        return Instance;
    }

    public void drawTooltip(TooltipsTexture texture, float x, float y, float width, float height) {
        DrawBackgroundAndLines(texture, x, y, width, height);
        DrawFrame(texture, x, y, width, height);
    }

    private void DrawBackgroundAndLines(TooltipsTexture texture, float x, float y, float width, float height){
        assert SmoothShader != null;
        // Draw Background and Lines
        // Draw Background
        boolean isRenderNameUnderscore = height > 20;
        int capacity = 24 + (24 * 4);
        if (isRenderNameUnderscore){
            capacity += 48;
        }
        FloatBuffer VertexBuffer = BufferUtils.createFloatBuffer(capacity);
        int[][] bgColor = texture.getBackgroundColor();
        int[][] lineColor = texture.getLineColor();
        VertexBuffer.put(new  float[] {
            x, y, bgColor[0][0], bgColor[0][1], bgColor[0][2], bgColor[0][3],
            x + width, y, bgColor[0][0], bgColor[0][1], bgColor[0][2], bgColor[0][3],
            x + width, y + height, bgColor[1][0], bgColor[1][1], bgColor[1][2], bgColor[1][3],
            x, y + height, bgColor[1][0], bgColor[1][1], bgColor[1][2], bgColor[1][3]
        });
        // Draw Lines
        VertexBuffer.put(new float[]{
            // Top
            x, y, lineColor[0][0], lineColor[0][1], lineColor[0][2], lineColor[0][3],
            x + width, y, lineColor[0][4], lineColor[0][5], lineColor[0][6], lineColor[0][7],
            x + width, y + 1, lineColor[0][4], lineColor[0][5], lineColor[0][6], lineColor[0][7],
            x, y + 1, lineColor[0][0], lineColor[0][1], lineColor[0][2], lineColor[0][3],
            // Bottom
            x, y + height - 1, lineColor[1][0], lineColor[1][1], lineColor[1][2], lineColor[1][3],
            x + width, y + height - 1, lineColor[1][4], lineColor[1][5], lineColor[1][6], lineColor[1][7],
            x + width, y + height, lineColor[1][4], lineColor[1][5], lineColor[1][6], lineColor[1][7],
            x, y + height, lineColor[1][0], lineColor[1][1], lineColor[1][2], lineColor[1][3],
            // Left
            x, y, lineColor[2][0], lineColor[2][1], lineColor[2][2], lineColor[2][3],
            x + 1, y, lineColor[2][0], lineColor[2][1], lineColor[2][2], lineColor[2][3],
            x + 1, y + height, lineColor[2][4], lineColor[2][5], lineColor[2][6], lineColor[2][7],
            x, y + height, lineColor[2][4], lineColor[2][5], lineColor[2][6], lineColor[2][7],
            // Right
            x + width - 1, y, lineColor[3][0], lineColor[3][1], lineColor[3][2], lineColor[3][3],
            x + width, y, lineColor[3][0], lineColor[3][1], lineColor[3][2], lineColor[3][3],
            x + width, y + height, lineColor[3][4], lineColor[3][5], lineColor[3][6], lineColor[3][7],
            x + width - 1, y + height,lineColor[3][4], lineColor[3][5], lineColor[3][6], lineColor[3][7],

        });
        if (isRenderNameUnderscore){
            VertexBuffer.put(
                new float[]{
                    // Name underscore
                    x, y + 14, lineColor[4][0], lineColor[4][1], lineColor[4][2], lineColor[4][3],
                    x + width / 2, y + 14, lineColor[4][4], lineColor[4][5], lineColor[4][6], lineColor[4][7],
                    x + width / 2, y + 15, lineColor[4][4], lineColor[4][5], lineColor[4][6], lineColor[4][7],
                    x, y + 15, lineColor[4][0], lineColor[4][1], lineColor[4][2], lineColor[4][3],

                    x + width / 2, y + 14, lineColor[4][4], lineColor[4][5], lineColor[4][6], lineColor[4][7],
                    x + width, y + 14, lineColor[4][0], lineColor[4][1], lineColor[4][2], lineColor[4][3],
                    x + width, y + 15, lineColor[4][0], lineColor[4][1], lineColor[4][2], lineColor[4][3],
                    x + width / 2, y + 15, lineColor[4][4], lineColor[4][5], lineColor[4][6], lineColor[4][7],
                }
            );
        }
        VertexBuffer.flip();

        GL11.glPushMatrix();
        glEnable(GL_BLEND);
        glDisable(GL_CULL_FACE);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        SmoothShader.use();

        subMatrix(SmoothShader);

        fillVBO(VertexBuffer);

        GL20.glEnableVertexAttribArray(0);

        GL20.glVertexAttribPointer(0, 2, GL11.GL_FLOAT, false, 4 * 6, 0);
        GL20.glEnableVertexAttribArray(1);
        GL20.glVertexAttribPointer(1, 4, GL11.GL_FLOAT, false, 4 * 6, 2 * 4);

        GL11.glDrawArrays(GL_QUADS, 0, isRenderNameUnderscore ? 28 : 20);

        GL20.glDisableVertexAttribArray(0);
        GL20.glDisableVertexAttribArray(1);
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);

        SmoothShader.clear();

        glDisable(GL_BLEND);
        glEnable(GL_CULL_FACE);
        GL11.glPopMatrix();
        VertexBuffer.clear();
    }

    private void DrawFrame(TooltipsTexture texture, float x, float y, float width, float height){
        assert TextureShader != null;
        ArrayList<TooltipsTexture.TextureFragment> frame = texture.getTextureFragments();
        boolean isRenderCenter = width > texture.CenterFragmentWidth;
        int capacity = isRenderCenter ? frame.size()  : frame.size() - texture.CenterFragmentAmount;
        FloatBuffer VertexBuffer = BufferUtils.createFloatBuffer(capacity * 16);
        for (TooltipsTexture.TextureFragment fragment : frame) {
            if (!isRenderCenter) {
                if (fragment.getFragmentType() == Top_Center || fragment.getFragmentType() == Bottom_Center) {
                    continue;
                }
            }
            float[] vertices = fragment.generateVertex(x, y, width, height);
            VertexBuffer.put(vertices);
        }
        VertexBuffer.flip();

        GL11.glPushMatrix();
        GL13.glActiveTexture(GL13.GL_TEXTURE0);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
        glEnable(GL_BLEND);
        glDisable(GL_CULL_FACE);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        mc.getTextureManager()
            .bindTexture(texture.getResourceLocation());

        TextureShader.use();

        subMatrix(TextureShader);

        fillVBO(VertexBuffer);

        GL20.glEnableVertexAttribArray(0);

        GL20.glVertexAttribPointer(0, 2, GL11.GL_FLOAT, false, 4 * 4, 0);
        GL20.glEnableVertexAttribArray(1);
        GL20.glVertexAttribPointer(1, 2, GL11.GL_FLOAT, false, 4 * 4, 2 * 4);

        GL11.glDrawArrays(GL_QUADS, 0, capacity * 4);

        GL20.glDisableVertexAttribArray(0);
        GL20.glDisableVertexAttribArray(1);
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);

        TextureShader.clear();

        glDisable(GL_BLEND);
        glEnable(GL_CULL_FACE);
        GL11.glPopMatrix();
        VertexBuffer.clear();
    }

    private void fillVBO(FloatBuffer vertexBuffer) {
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, VBO);
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, vertexBuffer, GL15.GL_DYNAMIC_DRAW);
    }

    private void subMatrix(ShaderProgram shader) {
        FloatBuffer modelview = createFloatBuffer(16);
        FloatBuffer projection = createFloatBuffer(16);
        GL11.glGetFloat(GL11.GL_MODELVIEW_MATRIX, modelview);
        GL11.glGetFloat(GL11.GL_PROJECTION_MATRIX, projection);
        GL20.glUniformMatrix4(GL20.glGetUniformLocation(shader.getProgram(), "modelview"), false, modelview);
        GL20.glUniformMatrix4(GL20.glGetUniformLocation(shader.getProgram(), "projection"), false, projection);
    }


}
