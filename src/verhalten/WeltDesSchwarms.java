package verhalten;

import math.Vektor2D;
import org.lwjgl.opengl.Display;
import static org.lwjgl.opengl.GL11.*;

public class WeltDesSchwarms extends BasisFenster {
	private ObjektManager om;

	public WeltDesSchwarms() {
		super("Welt des Schwarms", 1024, 768);
		om = new ObjektManager();
		init();
	}

	private void init() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				new SchwarmObjekt(new Vektor2D(50 * i, 50 * j), new Vektor2D(), 10000, 0.25 * Math.random() + 0.25, om);
			}
		}
	}

	@Override
	public void renderLoop() throws Exception {
		Shader shader = new Shader();
		while (!Display.isCloseRequested()) {
			glClearColor(0.1f, 0.2f, 0.3f, 1);
			glClear(GL_COLOR_BUFFER_BIT);

			glMatrixMode(GL_PROJECTION);
			glLoadIdentity();
			glOrtho(0, width, height, 0, 0, 1);
			glMatrixMode(GL_MODELVIEW);
			glDisable(GL_DEPTH_TEST);

			shader.getShaderProgramm();
			om.update();
			om.render(shader);

			Display.update();
			shader.deleteShader();
		}
	}

	public static void main(String[] args) throws Exception {
		new WeltDesSchwarms().start();
	}
}
