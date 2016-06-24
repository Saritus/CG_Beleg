varying vec3 color;

void main() {
    color = gl_Color.rgb;
    gl_Position = gl_ProjectionMatrix * gl_ModelViewMatrix * gl_Vertex;
}