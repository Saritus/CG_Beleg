package program;

import static org.lwjgl.opengl.GL20.*;

import math.Function;

public class Shader {

	private static Shader instance;

	private int shaderProgramm = glCreateProgram();
	private int vertexShader = glCreateShader(GL_VERTEX_SHADER);
	private int fragmentShader = glCreateShader(GL_FRAGMENT_SHADER);

	private Shader() {
	}

	public static Shader getInstance() {
		if (instance == null)
			instance = new Shader();
		return instance;

	}

	public int getShaderProgramm() {
		return shaderProgramm;
	}

	public int getVertexShader() {
		return vertexShader;
	}

	public int getFragmentShader() {
		return fragmentShader;
	}

	public void createShaderProgram() {
		shaderProgramm = glCreateProgram();
		vertexShader = glCreateShader(GL_VERTEX_SHADER);
		fragmentShader = glCreateShader(GL_FRAGMENT_SHADER);
		attachShader("src/program/anzeige.vshader", vertexShader);
		attachShader("src/program/anzeige.fshader", fragmentShader);
		glLinkProgram(shaderProgramm);
		glValidateProgram(shaderProgramm);
		glUseProgram(shaderProgramm);
	}

	private void attachShader(String path, int shader) {
		glShaderSource(shader, Function.readFromFile(path));
		glCompileShader(shader);
		System.err.println(glGetShaderInfoLog(shader, 1024));
		glAttachShader(shaderProgramm, shader);
	}

	public void deleteShader() {
		glUseProgram(0);
		glDetachShader(shaderProgramm, vertexShader);
		glDetachShader(shaderProgramm, fragmentShader);
		glDeleteProgram(shaderProgramm);
		glDeleteShader(vertexShader);
		glDeleteShader(fragmentShader);
	}
}
