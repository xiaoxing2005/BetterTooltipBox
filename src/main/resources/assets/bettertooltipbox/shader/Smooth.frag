#version 330 core
out vec4 FragColor;

uniform float alpha;

in vec4 color;

void main()
{
    FragColor = color;
    FragColor.a *= alpha;
}
