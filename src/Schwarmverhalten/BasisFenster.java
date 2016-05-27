package Schwarmverhalten;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.lwjgl.opengl.GL20.*;

public abstract class BasisFenster {
	private int width, height;
	private String title;

	public BasisFenster() {
		this("BasisFenster", 640, 480);
	}

	public BasisFenster(String title, int width, int height) {
		this.setWidth(width);
		this.setHeight(height);
		this.title = title;
	}

	public void initDisplay() {
		try {
			Display.setDisplayMode(new DisplayMode(getWidth(), getHeight()));
			Display.setTitle(title);
			Display.setInitialBackground(0.1f, 0.2f, 0.3f);
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}



	public abstract void renderLoop() throws Exception;

	public void start() throws Exception {
		initDisplay();
		renderLoop();


		Display.destroy();
		System.exit(0);

	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
