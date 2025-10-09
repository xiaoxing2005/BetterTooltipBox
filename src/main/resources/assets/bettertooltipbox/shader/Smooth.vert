#version 330 core
layout (location = 0) in vec2 aPos;
layout (location = 1) in vec4 aColor;

uniform mat4 modelview;
uniform mat4 projection;

out vec4 color;

void main()
{
    gl_Position = projection * modelview * vec4(aPos.x, aPos.y, 400, 1.0);
    color = aColor / 255;
}
