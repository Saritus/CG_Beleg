varying vec3 color;

void main() {
	gl_Position = gl_ProjectionMatrix * gl_ModelViewMatrix * gl_Vertex;
	color.xyz = gl_Position.xyz;
}