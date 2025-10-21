#version 330 core
out vec4 FragColor;

uniform sampler2D Texture;
uniform float alpha;

in vec2 TexCoord;

void main()
{
    FragColor = texture(Texture,TexCoord);
    FragColor.a *= alpha;
}
