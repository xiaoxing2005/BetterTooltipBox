package com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Tooltip;

import static com.xiao_xing.BetterTooltipBox.Util.TooltipHelper.mc;
import static com.xiao_xing.BetterTooltipBox.client.render.shader.ShaderFactory.createProgram;
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

import net.minecraft.util.ResourceLocation;

import org.joml.Vector2f;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;

import com.xiao_xing.BetterTooltipBox.client.render.shader.ShaderProgram;

public class Tooltip extends TooltipBase {


    private static final ArrayList<Float> Vertices = new ArrayList<>();
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

    public Tooltip(String Name, ResourceLocation texture, Vector2f textureSize) {
        super(Name, texture, textureSize);

    }

    @Override
    public void drawTooltip(float x, float y, float width, float height) {

    }

    private void initVBO(FloatBuffer vertexBuffer) {
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, VBO);
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, vertexBuffer, GL15.GL_DYNAMIC_DRAW);
    }

    private void initMatrix(ShaderProgram shader) {
        FloatBuffer modelview = createFloatBuffer(16);
        FloatBuffer projection = createFloatBuffer(16);
        GL11.glGetFloat(GL11.GL_MODELVIEW_MATRIX, modelview);
        GL11.glGetFloat(GL11.GL_PROJECTION_MATRIX, projection);
        GL20.glUniformMatrix4(GL20.glGetUniformLocation(shader.getProgram(), "modelview"), false, modelview);
        GL20.glUniformMatrix4(GL20.glGetUniformLocation(shader.getProgram(), "projection"), false, projection);
    }

    private void drawWidgets(float x, float y, float width, float height) {
        int vertexCount = 0;

        GL13.glActiveTexture(GL13.GL_TEXTURE0);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
        mc.getTextureManager()
            .bindTexture(this.getTexture());

        FloatBuffer vertexBuffer = BufferUtils.createFloatBuffer(Vertices.size());
        for (float v : Vertices) {
            vertexBuffer.put(v);
        }
        vertexBuffer.flip();

        GL11.glPushMatrix();
        glDisable(GL_CULL_FACE);
        glEnable(GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        TextureShader.use();

        initMatrix(TextureShader);

        GL20.glUniform2f(GL20.glGetUniformLocation(TextureShader.getProgram(), "iResolution"), x + width, y + height);
        GL20.glUniform4f(GL20.glGetUniformLocation(TextureShader.getProgram(), "rectParams"), x, y, width, height);

        initVBO(vertexBuffer);
        GL20.glEnableVertexAttribArray(0);

        GL20.glVertexAttribPointer(0, 2, GL11.GL_FLOAT, false, 4 * 4, 0);
        GL20.glEnableVertexAttribArray(1);
        GL20.glVertexAttribPointer(1, 2, GL11.GL_FLOAT, false, 4 * 4, 2 * 4);

        GL11.glDrawArrays(GL_QUADS, 0, vertexCount);

        GL20.glDisableVertexAttribArray(0);
        GL20.glDisableVertexAttribArray(1);
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);

        TextureShader.clear();

        glEnable(GL_CULL_FACE);
        glDisable(GL_BLEND);

        GL11.glPopMatrix();

        Vertices.clear();
    }

    private void drawBackGround(float x, float y, float width, float height) {


        GL11.glPushMatrix();
        glDisable(GL_CULL_FACE);
        glEnable(GL_BLEND);
        glEnable(GL_DEPTH_TEST);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        SmoothShader.use();

        initMatrix(SmoothShader);

        GL20.glEnableVertexAttribArray(0);
        GL20.glVertexAttribPointer(0, 2, GL11.GL_FLOAT, false, 6 * Float.BYTES, 0);
        GL20.glEnableVertexAttribArray(1);
        GL20.glVertexAttribPointer(1, 4, GL11.GL_FLOAT, false, 6 * Float.BYTES, 2 * Float.BYTES);

        GL11.glDrawArrays(GL_QUADS, 0, 4);

        GL20.glDisableVertexAttribArray(0);
        GL20.glDisableVertexAttribArray(1);
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);

        SmoothShader.clear();

        glEnable(GL_CULL_FACE);
        glDisable(GL_DEPTH_TEST);

        GL11.glPopMatrix();

    }

    private void drawFrame( float x, float y, float width, float height) {
        int vertexCount = 0;


        FloatBuffer vertexBuffer = BufferUtils.createFloatBuffer(Vertices.size());
        for (float v : Vertices) {
            vertexBuffer.put(v);
        }
        vertexBuffer.flip();

        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, VBO);
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, vertexBuffer, GL15.GL_STATIC_DRAW);
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);

        GL11.glPushMatrix();
        glDisable(GL_CULL_FACE);
        glEnable(GL_BLEND);
        glEnable(GL_DEPTH_TEST);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        SmoothShader.use();

        initMatrix(SmoothShader);

        initVBO(vertexBuffer);
        GL20.glEnableVertexAttribArray(0);
        GL20.glVertexAttribPointer(0, 2, GL11.GL_FLOAT, false, 6 * Float.BYTES, 0);
        GL20.glEnableVertexAttribArray(1);
        GL20.glVertexAttribPointer(1, 4, GL11.GL_FLOAT, false, 6 * Float.BYTES, 2 * Float.BYTES);

        GL11.glDrawArrays(GL_QUADS, 0, vertexCount);

        GL20.glDisableVertexAttribArray(0);
        GL20.glDisableVertexAttribArray(1);
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);

        SmoothShader.clear();

        glEnable(GL_CULL_FACE);
        glDisable(GL_DEPTH_TEST);

        GL11.glPopMatrix();
        Vertices.clear();
    }

    private void DrawDividingLine(float x, float y, float width, float height) {



        GL11.glPushMatrix();
        glDisable(GL_CULL_FACE);
        glEnable(GL_BLEND);
        glEnable(GL_DEPTH_TEST);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        SmoothShader.use();

        initMatrix(SmoothShader);

        GL20.glEnableVertexAttribArray(0);
        GL20.glVertexAttribPointer(0, 2, GL11.GL_FLOAT, false, 6 * Float.BYTES, 0);
        GL20.glEnableVertexAttribArray(1);
        GL20.glVertexAttribPointer(1, 4, GL11.GL_FLOAT, false, 6 * Float.BYTES, 2 * Float.BYTES);

        GL11.glDrawArrays(GL_QUADS, 0, 8);

        GL20.glDisableVertexAttribArray(0);
        GL20.glDisableVertexAttribArray(1);
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);

        SmoothShader.clear();

        glEnable(GL_CULL_FACE);
        glDisable(GL_DEPTH_TEST);

        GL11.glPopMatrix();
    }

    private void addVertices(float... vertices) {
        for (float vs : vertices) {
            Vertices.add(vs);
        }
    }
}
