uniform vec2 positions[200];
uniform vec2 speed[200];
uniform vec2 obstacles[200];
uniform vec2 bew;
varying vec3 color;

void main() {
	gl_Position = ftransform();
	//color.xy = gl_Position.xy;
	float colordif = 1. - 2.*(bew.x + bew.y);
	color.xyz = vec3(1, colordif, colordif);
}