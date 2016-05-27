uniform vec2 speed;
varying vec3 color;

void main() {
	gl_Position = ftransform();
	//color.xy = gl_Position.xy;
	color.x = 0;
	color.yz = 1.-2*(speed.x + speed.y);
}