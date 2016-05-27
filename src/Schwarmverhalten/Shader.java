package Schwarmverhalten;

import org.lwjgl.opengl.Display;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.lwjgl.opengl.GL20.*;

/**
 * Created by Matze on 27.05.16.
 */
public class Shader {
	int shaderProgramm = glCreateProgram();
	int vertexShader = glCreateShader(GL_VERTEX_SHADER);
	int fragmentShader = glCreateShader(GL_FRAGMENT_SHADER);

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

		String vertexShaderSource = readFromFile("src/Schwarmverhalten/vert.shader");
		String fragmentShaderSource = readFromFile("src/Schwarmverhalten/frag.shader");

		// Lets go
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

	}

	public void useShaderBeforeGL_Begin() {
		glUseProgram(shaderProgramm);
	}

	public void useShaderAfterGL_End() {
		glUseProgram(shaderProgramm);
	}

	public void deleteShader() {

		glDetachShader(shaderProgramm, vertexShader);
		glDetachShader(shaderProgramm, fragmentShader);
		glDeleteProgram(shaderProgramm);
		glDeleteShader(vertexShader);
		glDeleteShader(fragmentShader);
	}

	public static String readFromFile(String name) {
		StringBuilder source = new StringBuilder();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(name));

			String line;
			while ((line = reader.readLine()) != null) {
				source.append(line).append("\n");
			}

			reader.close();
		} catch (Exception e) {
			System.err.println("Error loading source code: " + name);
			e.printStackTrace();
		}

		return source.toString();
	}

}
