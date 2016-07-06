package verhalten;

import math.Vektor2D;
import objekte.AlphaObjekt;
import objekte.SchwarmObjekt;

import org.lwjgl.opengl.Display;
import static org.lwjgl.opengl.GL11.*;

public final class WeltDesSchwarms extends BasisFenster {

	public WeltDesSchwarms() {
		super("Welt des Schwarms", 1024, 768);
		init();
	}

	private void init() {
		for (int i = 0; i < 150; i++) {
			new SchwarmObjekt(new Vektor2D(width * Math.random(), height * Math.random()), new Vektor2D(), 20000,
					0.25 * Math.random() + 0.25);
		}
		new AlphaObjekt(new Vektor2D(width * Math.random(), height * Math.random()), new Vektor2D(10, 10), 20000,
				0.25 * Math.random() + 0.25, 'r');
		new AlphaObjekt(new Vektor2D(width * Math.random(), height * Math.random()), new Vektor2D(10, 10), 20000,
				0.25 * Math.random() + 0.25, 'g');
		new AlphaObjekt(new Vektor2D(width * Math.random(), height * Math.random()), new Vektor2D(10, 10), 20000,
				0.25 * Math.random() + 0.25, 'b');
	}

	@Override
	public void renderLoop() {
		while (!Display.isCloseRequested()) {
			clearDisplay();
			Shader.getInstance().createShaderProgram();
			ObjektManager.getInstance().update();
			ObjektManager.getInstance().render();
			Display.update();
			Shader.getInstance().deleteShader();
		}
	}

	private void clearDisplay() {
		glClearColor(0.8f, 0.8f, 0.8f, 1);
		glClear(GL_COLOR_BUFFER_BIT);
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, width, height, 0, 0, 1);
		glMatrixMode(GL_MODELVIEW);
		glDisable(GL_DEPTH_TEST);
	}

	public static void main(String[] args) {
		new WeltDesSchwarms().start();
	}
}
