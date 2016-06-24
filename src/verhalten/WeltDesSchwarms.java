package verhalten;

import math.Vektor2D;
import org.lwjgl.opengl.Display;
import static org.lwjgl.opengl.GL11.*;

public final class WeltDesSchwarms extends BasisFenster {
	private Shader shader;

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
		shader = Shader.getInstance();
		while (!Display.isCloseRequested()) {
			clearDisplay();
			shader.createShaderProgram();
			ObjektManager.getInstance().update();
			ObjektManager.getInstance().render();
			Display.update();
			shader.deleteShader();
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
