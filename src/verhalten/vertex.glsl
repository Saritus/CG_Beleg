//uniform vec2 bew;
uniform float position[200];
uniform float speed[200];
uniform float obstacles[200];
uniform int objid;
varying vec3 color;

void main() {
	vec2 pos[100];
	for(int i=0; i<100; i++) {
		pos[i] = vec2(position[2*i], position[2*i + 1]);
	}
	vec2 spe[100];
	for(int i=0; i<100; i++) {
		spe[i] = vec2(speed[2*i], speed[2*i + 1]);
	}
	//gl_Position = vec3(position[2*objid], position[2*objid+1],0.0);
	vec4 vertex = gl_Vertex;
	gl_Position = gl_ProjectionMatrix * gl_ModelViewMatrix * vertex;
	//color.xyz = gl_Position.xyz;
	color.xyz = vec3(spe[objid].x, spe[objid].y, float(objid) / 100.);
}

vec2 getAverage(vec2 pos[100]) {
	vec2 result = vec2(0,0);
	for(int i=0; i<100; i++) {
		result += pos[i];
	}
	return result;
}