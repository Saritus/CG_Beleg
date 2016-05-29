//uniform vec2 bew;
uniform float position[200];
uniform float speed[200];
uniform float obstacles[200];
uniform int objid;
varying vec3 color;

void main() {
	gl_Position = ftransform();
	//color.xyz = gl_Position.xyz;
	color.xyz = vec3(speed[2*objid], speed[2*objid+1], 0);
}