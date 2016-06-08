varying vec3 color;
varying out float result;

void main() {
	gl_Position = gl_ProjectionMatrix * gl_ModelViewMatrix * gl_Vertex;
	color = gl_Position.xyz;
	result = color.x;
}