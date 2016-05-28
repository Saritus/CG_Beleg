uniform vec2 bew;
//layout ( location = 2) uniform vec2 position[200];
varying vec3 color;

void main() {
	gl_Position = ftransform();
	//color.xyz = gl_Position.xyz;
	float colordif = 1. - 2.*(bew.x + bew.y);
	color.xyz = vec3(1, colordif,colordif);
}