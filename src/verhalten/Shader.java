package verhalten;

import help.Function;
import math.*;

import static org.lwjgl.opengl.GL20.*;

import java.nio.*;

import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

import com.sun.corba.se.impl.logging.OMGSystemException;

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
		int bewLoc = GL20.glGetUniformLocation(shaderProgramm, "bew");
		System.out.println(bewLoc);
		GL20.glUniform2f(bewLoc, speed[0], speed[1]);

		int posLoc = GL20.glGetUniformLocation(shaderProgramm, "positions[200]");
		System.out.println(posLoc);
		GL20.glUniform2(2, toFloatBuffer(positions));

		int speedLoc = GL20.glGetUniformLocation(shaderProgramm, "speed[200]");
		System.out.println(speedLoc);
		GL20.glUniform2(speedLoc, toFloatBuffer(speed));

		int obstacleLoc = GL20.glGetUniformLocation(shaderProgramm, "obstacles[200]");
		System.out.println(obstacleLoc);
		GL20.glUniform2(obstacleLoc, toFloatBuffer(obstacles));
	}

	public static FloatBuffer toFloatBuffer(float[] v) {
		ByteBuffer buf = ByteBuffer.allocateDirect(v.length * 4);
		buf.order(ByteOrder.nativeOrder());
		FloatBuffer buffer = buf.asFloatBuffer();
		buffer.put(v);
		buffer.position(0);
		return buffer;
	}

}
