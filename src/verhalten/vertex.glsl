//uniform vec2 bew;
//layout ( location = 2) uniform vec2 position[200];
uniform int anArrayOfInts[3];
uniform float anArrayOfFloats[3];
varying vec3 color;

void main() {
	gl_Position = ftransform();
	//color.xyz = gl_Position.xyz;
	//float colordif = 1. - 2.*(bew.x + bew.y);
	color.xyz = vec3(anArrayOfFloats[0], anArrayOfFloats[1], anArrayOfFloats[2]);
}