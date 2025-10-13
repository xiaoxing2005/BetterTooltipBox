package com.xiao_xing.BetterTooltipBox.client.render.shader;

import static com.xiao_xing.BetterTooltipBox.BetterTooltipBox.LOG;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL32;

public class ShaderProgram {

    public boolean isLoader = false;
    public boolean reload = false;
    private int program;
    public final int mode;
    public String name;
    public String domain;
    public String vertShaderFilename;
    public String geometryShaderFilename;
    public String fragShaderFilename;
    public static ArrayList<ShaderProgram> allShaderProgram = new ArrayList<>();

    protected ShaderProgram(String name, String domain, String vertShaderFilename, String fragShaderFilename) {
        this.name = name;
        int program;
        try {
            this.domain = domain;
            this.vertShaderFilename = vertShaderFilename;
            this.fragShaderFilename = fragShaderFilename;
            program = createProgram(this, domain, vertShaderFilename, fragShaderFilename);
        } catch (Exception e) {
            LOG.error("Could not initialize shader program!", e);
            isLoader = false;
            program = 0;
        }
        allShaderProgram.add(this);
        this.mode = 0;
        this.program = program;
    }

    protected ShaderProgram(String name, String domain, String vertShaderFilename, String geometryShaderFilename,
        String fragShaderFilename) {
        this.name = name;
        int program;
        try {
            this.domain = domain;
            this.vertShaderFilename = vertShaderFilename;
            this.geometryShaderFilename = geometryShaderFilename;
            this.fragShaderFilename = fragShaderFilename;
            program = createProgram(this, domain, vertShaderFilename, geometryShaderFilename, fragShaderFilename);
        } catch (Exception e) {
            LOG.error("Could not initialize shader program!", e);
            isLoader = false;
            program = 0;
        }
        allShaderProgram.add(this);
        this.mode = 1;
        this.program = program;
    }

    public void reload() {
        this.reload = true;
        GL20.glDeleteProgram(program);
        if (this.mode == 0) {
            this.program = createProgram(this, this.domain, this.vertShaderFilename, this.fragShaderFilename);
        } else this.program = createProgram(
            this,
            this.domain,
            this.vertShaderFilename,
            this.geometryShaderFilename,
            this.fragShaderFilename);
        this.reload = false;

    }

    private static String getProgramLogInfo(int obj) {
        return GL20.glGetProgramInfoLog(obj, GL20.glGetProgrami(obj, GL20.GL_INFO_LOG_LENGTH));
    }

    private static String getShaderLogInfo(int obj) {
        return GL20.glGetShaderInfoLog(obj, GL20.glGetShaderi(obj, GL20.GL_INFO_LOG_LENGTH));
    }

    private static int createProgram(ShaderProgram shaderProgram, String domain, String vertShaderFilename,
        String geometryShaderFilename, String fragShaderFilename) {
        if (!OpenGlHelper.shadersSupported) {
            return 0;
        }

        final int program = GL20.glCreateProgram();

        final int vertShader = loadAndCompileShader(
            shaderProgram,
            program,
            domain,
            vertShaderFilename,
            GL20.GL_VERTEX_SHADER);
        final int geometryShader = loadAndCompileShader(
            shaderProgram,
            program,
            domain,
            geometryShaderFilename,
            GL32.GL_GEOMETRY_SHADER);
        final int fragShader = loadAndCompileShader(
            shaderProgram,
            program,
            domain,
            fragShaderFilename,
            GL20.GL_FRAGMENT_SHADER);

        if (vertShader != 0) GL20.glAttachShader(program, vertShader);
        if (geometryShader != 0) GL20.glAttachShader(program, geometryShader);
        if (fragShader != 0) GL20.glAttachShader(program, fragShader);

        GL20.glLinkProgram(program);

        if (GL20.glGetProgrami(program, GL20.GL_LINK_STATUS) == GL11.GL_FALSE) {
            LOG.error("Could not link shader: {}", getProgramLogInfo(program));
            GL20.glDeleteProgram(program);
            shaderProgram.isLoader = false;
            return 0;
        }

        GL20.glValidateProgram(program);

        if (GL20.glGetProgrami(program, GL20.GL_VALIDATE_STATUS) == GL11.GL_FALSE) {
            LOG.error("Could not validate shader: {}", getProgramLogInfo(program));
            GL20.glDeleteProgram(program);
            shaderProgram.isLoader = false;
            return 0;
        }
        shaderProgram.isLoader = vertShader != 0 && geometryShader != 0 && fragShader != 0;
        GL20.glDeleteShader(vertShader);
        GL20.glDeleteShader(geometryShader);
        GL20.glDeleteShader(fragShader);
        return program;
    }

    private static int createProgram(ShaderProgram shaderProgram, String domain, String vertShaderFilename,
        String fragShaderFilename) {
        if (!OpenGlHelper.shadersSupported) {
            return 0;
        }

        final int program = GL20.glCreateProgram();

        final int vertShader = loadAndCompileShader(
            shaderProgram,
            program,
            domain,
            vertShaderFilename,
            GL20.GL_VERTEX_SHADER);
        final int fragShader = loadAndCompileShader(
            shaderProgram,
            program,
            domain,
            fragShaderFilename,
            GL20.GL_FRAGMENT_SHADER);

        if (vertShader != 0) GL20.glAttachShader(program, vertShader);
        if (fragShader != 0) GL20.glAttachShader(program, fragShader);

        GL20.glLinkProgram(program);

        if (GL20.glGetProgrami(program, GL20.GL_LINK_STATUS) == GL11.GL_FALSE) {
            LOG.error("Could not link shader: {}", getProgramLogInfo(program));
            shaderProgram.isLoader = false;
            GL20.glDeleteProgram(program);
            return 0;
        }

        GL20.glValidateProgram(program);

        if (GL20.glGetProgrami(program, GL20.GL_VALIDATE_STATUS) == GL11.GL_FALSE) {
            LOG.error("Could not validate shader: {}", getProgramLogInfo(program));
            shaderProgram.isLoader = false;
            GL20.glDeleteProgram(program);
            return 0;
        }
        shaderProgram.isLoader = vertShader != 0 && fragShader != 0;
        GL20.glDeleteShader(vertShader);
        GL20.glDeleteShader(fragShader);

        return program;
    }

    private static int loadAndCompileShader(ShaderProgram shaderProgram, int program, String domain, String filename,
        int shaderType) {
        if (filename == null) {
            return 0;
        }

        final int shader = GL20.glCreateShader(shaderType);

        if (shader == 0) {
            LOG.error(
                "Could not create shader of type {} from {}: {}",
                shaderType,
                filename,
                getProgramLogInfo(program));
            shaderProgram.isLoader = false;
            return 0;
        }

        final String code = loadFile(shaderProgram, new ResourceLocation(domain, filename));
        if (code == null) {
            GL20.glDeleteShader(shader);
            shaderProgram.isLoader = false;
            return 0;
        }

        GL20.glShaderSource(shader, code);
        GL20.glCompileShader(shader);

        if (GL20.glGetShaderi(shader, GL20.GL_COMPILE_STATUS) == GL11.GL_FALSE) {
            LOG.error("Could not compile shader {}: {}", filename, getShaderLogInfo(shader));
            shaderProgram.isLoader = false;
            GL20.glDeleteShader(shader);
            return 0;
        }

        return shader;
    }

    private static String loadFile(ShaderProgram shaderProgram, ResourceLocation resourceLocation) {
        try {
            final StringBuilder code = new StringBuilder();
            final InputStream inputStream = Minecraft.getMinecraft()
                .getResourceManager()
                .getResource(resourceLocation)
                .getInputStream();
            final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                code.append(line);
                code.append('\n');
            }
            reader.close();

            return code.toString();
        } catch (Exception e) {
            LOG.error("Could not load shader file!", e);
            shaderProgram.isLoader = false;
        }

        return null;
    }

    public int getProgram() {
        return this.program;
    }

    public void use() {
        GL20.glUseProgram(this.program);
    }

    public void clear() {
        GL20.glUseProgram(0);
    }

    public int getUniformLocation(String name) {
        final int index = GL20.glGetUniformLocation(this.program, name);

        if (index < 0) {
            throw new NullPointerException("No uniform exists with name: " + name);
        }

        return index;
    }

    public int getAttribLocation(String name) {
        final int index = GL20.glGetAttribLocation(this.program, name);

        if (index < 0) {
            throw new NullPointerException("No attribute exists with name: " + name);
        }

        return index;
    }
}
