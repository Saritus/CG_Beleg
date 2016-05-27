uniform vec2 speed;
varying vec3 color;

void main() {
	gl_Position = ftransform();
	//color.xy = gl_Position.xy;
	float colordif = 1. - 2.*(speed.x + speed.y);
	color.xyz = vec3(1, colordif, colordif);
}