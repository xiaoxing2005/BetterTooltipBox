package com.xiao_xing.BetterTooltipBox.client.render.shader;

import static com.xiao_xing.BetterTooltipBox.BetterTooltipBox.LOG;

import java.util.HashMap;

public class ShaderFactory {

    private static final HashMap<String, ShaderProgram> ShaderMap = new HashMap<>();
    private static final byte NORMALSHADER = 2;
    private static final byte GEOMETRYSHADER = 3;

    public static ShaderProgram createProgram(String Name, String domain, String... ShaderFile) {
        if (ShaderMap.containsKey(Name)) {
            return ShaderMap.get(Name);
        } else {
            switch (ShaderFile.length) {
                case NORMALSHADER -> {
                    ShaderProgram shaderProgram = new ShaderProgram(Name, domain, ShaderFile[0], ShaderFile[1]);
                    if (!shaderProgram.isLoader) {
                        break;
                    }
                    ShaderMap.put(Name, shaderProgram);
                    return shaderProgram;
                }
                case GEOMETRYSHADER -> {
                    ShaderProgram shaderProgram = new ShaderProgram(
                        Name,
                        domain,
                        ShaderFile[0],
                        ShaderFile[1],
                        ShaderFile[2]);
                    if (!shaderProgram.isLoader) {
                        break;
                    }
                    ShaderMap.put(Name, shaderProgram);
                    return shaderProgram;
                }
            }
        }
        LOG.error("Invalid shader program");
        return null;
    }

    public static ShaderProgram getShaderProgram(String Name) {
        if (ShaderMap.containsKey(Name)) {
            return ShaderMap.get(Name);
        }
        return null;
    }

}
