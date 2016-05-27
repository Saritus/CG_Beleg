package verhalten;

import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

import static org.lwjgl.glfw.GLFW.*; // allows us to create windows
import static org.lwjgl.opengl.GL11.*; // gives us access to things like "GL_TRUE" which we'll need 
import static org.lwjgl.system.MemoryUtil.*; // allows us to use 'NULL' in our code, note this is slightly different from java's 'null'
import java.nio.ByteBuffer; // Used for getting the primary monitor later on.

public abstract class BasisFenster implements Runnable {

	protected int width, height;
	protected String title;
	protected Thread thread;
	public boolean running = true;
	protected long window;
	public int mouseX;
	public int mouseY;
	public GLFWCursorPosCallback cursorPosCallback;

	public BasisFenster() {
		this("BasisFenster", 640, 480);
	}

	public BasisFenster(String title, int width, int height) {
		this.setWidth(width);
		this.setHeight(height);
		this.title = title;
	}

	public void initDisplay() {
		// Initializes our window creator library - GLFW
		// This basically means, if this glfwInit() doesn't run properlly
		// print an error to the console
		if (glfwInit() != GL_TRUE) {
			// Throw an error.
			System.err.println("GLFW initialization failed!");
		}

		// Allows our window to be resizable
		glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);

		// Creates our window. You'll need to declare private long window at the
		// top of the class though.
		// We pass the width and height of the game we want as well as the title
		// for
		// the window. The last 2 NULL parameters are for more advanced uses and
		// you
		// shouldn't worry about them right now.
		window = glfwCreateWindow(width, height, "Endless Runner", NULL, NULL);

		// This code performs the appropriate checks to ensure that the
		// window was successfully created.
		// If not then it prints an error to the console
		if (window == NULL) {
			// Throw an Error
			System.err.println("Could not create our Window!");
		}

		// creates a bytebuffer object 'vidmode' which then queries
		// to see what the primary monitor is.
		GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		// Sets the initial position of our game window.
		glfwSetWindowPos(window, 100, 100);
		// Sets the context of GLFW, this is vital for our program to work.
		glfwMakeContextCurrent(window);
		// finally shows our created window in all it's glory.
		glfwShowWindow(window);
	}

	public void update() {
		// Polls for any window events such as the window closing etc.
		glfwPollEvents();
	}

	public abstract void renderLoop() throws Exception;

	public void start() throws Exception {
		running = true;
		thread = new Thread(this, "EndlessRunner");
		thread.start();
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
