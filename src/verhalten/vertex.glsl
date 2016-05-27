varying vec3 color;

void main() {
	gl_Position = ftransform();
	color.x = gl_Position.x;
	color.y = gl_Position.y;
	color.z = 1.;
}