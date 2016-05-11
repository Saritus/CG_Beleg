package Schwarmverhalten;

import static org.lwjgl.opengl.GL11.*;
import math.*;

import org.lwjgl.opengl.Display;

public class WeltDesSchwarms extends BasisFenster {
	private ObjektManager om;

	public WeltDesSchwarms() {
		super("Welt des Schwarms", 1024, 680);
		om = new ObjektManager();
		init();
	}

	private void init() {
		new SchwarmObjekt(new Vektor2D(50, 50), new Vektor2D(20, -20), 2, 0.1, om);
		new SchwarmObjekt(new Vektor2D(200, 200), new Vektor2D(20, -20), 2, 0.1, om);
		new SchwarmObjekt(new Vektor2D(500, 500), new Vektor2D(20, -20), 2, 0.1, om);
	}

	@Override
	public void renderLoop() throws Exception {
		while (!Display.isCloseRequested()) {
			glClearColor(0.1f, 0.2f, 0.3f, 1);
			glClear(GL_COLOR_BUFFER_BIT);

			// ist ja 2d
			glMatrixMode(GL_PROJECTION);
			glLoadIdentity();
			glOrtho(0, 640, 480, 0, 0, 1);
			glMatrixMode(GL_MODELVIEW);
			glDisable(GL_DEPTH_TEST);

			om.update();
			om.render();

			Display.update();
		}
	}

	public static void main(String[] args) throws Exception {
		new WeltDesSchwarms().start();
	}
}
