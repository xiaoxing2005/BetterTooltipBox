#version 330 core
layout (location = 0) in vec2 aPos;
layout (location = 1) in vec2 aTexCoord;

uniform mat4 modelview;
uniform mat4 projection;

out vec3 position;
out vec2 TexCoord;

void main()
{
    gl_Position = projection * modelview * vec4(aPos.x, aPos.y, 400, 1.0);
    TexCoord = aTexCoord;
    position = gl_Position.xyz;
}
