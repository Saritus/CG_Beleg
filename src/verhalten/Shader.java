package verhalten;

import help.Function;
import math.*;

import static org.lwjgl.opengl.GL20.*;

import java.nio.*;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

/**
 * Created by Matze on 27.05.16.
 */

public class Shader {
	private int shaderProgramm = glCreateProgram();
	private int vertexShader = glCreateShader(GL_VERTEX_SHADER);
	private int fragmentShader = glCreateShader(GL_FRAGMENT_SHADER);

	public int getShaderProgrammVar() {
		return shaderProgramm;
	}

	public int getVertexShader() {
		return vertexShader;
	}

	public int getFragmentShader() {
		return fragmentShader;
	}

	public void getShaderProgramm() {

		shaderProgramm = glCreateProgram();
		vertexShader = glCreateShader(GL_VERTEX_SHADER);
		fragmentShader = glCreateShader(GL_FRAGMENT_SHADER);

		String vertexShaderSource = Function.readFromFile("src/verhalten/vertex.glsl");
		String fragmentShaderSource = Function.readFromFile("src/verhalten/fragment.glsl");

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

	public void setUniformVariables(float[] positions, float[] speed, float[] obstacles) {
		setFloatArray("position", positions);
		setFloatArray("speed", speed);
	}

	public void setFloatArray(String desc, FloatBuffer buffer) {
		int id = GL20.glGetUniformLocation(shaderProgramm, desc);
		if (id != -1) {
			GL20.glUniform1(id, buffer);
		}
	}

	public void setFloatArray(FloatBuffer buffer, String desc) {
		setFloatArray(desc, buffer);
	}

	public void setFloatArray(String desc, float[] array) {
		FloatBuffer buffer = BufferUtils.createFloatBuffer(array.length);
		buffer.put(array);
		buffer.rewind();
		setFloatArray(desc, buffer);
	}

	public void setFloatArray(float[] array, String desc) {
		setFloatArray(desc, array);
	}
	
	public void getFloatArray() {
		GL30.glBindFragDataLocation(shaderProgramm, 0, "colorOut");
	}

}
