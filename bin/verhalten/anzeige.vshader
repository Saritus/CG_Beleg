varying vec3 color;

void main() {
    color = gl_Color.rgb;
	vec4 vert = gl_Vertex;
    gl_Position = gl_ProjectionMatrix * gl_ModelViewMatrix * vert;
}