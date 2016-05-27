uniform vec2 speed;
varying vec3 color;

void main() {
	gl_Position = ftransform();
	//color.xy = gl_Position.xy;
}