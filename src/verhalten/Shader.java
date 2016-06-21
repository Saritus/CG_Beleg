package verhalten;

import help.Function;
import math.*;

import static org.lwjgl.opengl.GL20.*;

import java.nio.*;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

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

	public void createShaderProgramm() {

		shaderProgramm = glCreateProgram();
		vertexShader = glCreateShader(GL_VERTEX_SHADER);
		fragmentShader = glCreateShader(GL_FRAGMENT_SHADER);

		String vertexShaderSource = Function.readFromFile("src/verhalten/anzeige.vshader");
		String fragmentShaderSource = Function.readFromFile("src/verhalten/anzeige.fshader");

		glShaderSource(vertexShader, vertexShaderSource);
		glCompileShader(vertexShader);
		System.out.println(glGetShaderInfoLog(vertexShader, 1024));

		glShaderSource(fragmentShader, fragmentShaderSource);
		glCompileShader(fragmentShader);
		System.out.println(glGetShaderInfoLog(fragmentShader, 1024));

		glAttachShader(shaderProgramm, vertexShader);
		glAttachShader(shaderProgramm, fragmentShader);

		glLinkProgram(shaderProgramm);
		glValidateProgram(shaderProgramm);
		glUseProgram(shaderProgramm);
	}

	public void useShaderBeforeGL_Begin() {
		glUseProgram(shaderProgramm);
	}

	public void useShaderAfterGL_End() {
		glUseProgram(0);
	}

	public void deleteShader() {
		glDetachShader(shaderProgramm, vertexShader);
		glDetachShader(shaderProgramm, fragmentShader);
		glDeleteProgram(shaderProgramm);
		glDeleteShader(vertexShader);
		glDeleteShader(fragmentShader);
	}
}
