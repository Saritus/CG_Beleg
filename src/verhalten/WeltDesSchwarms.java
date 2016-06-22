package verhalten;

import math.Vektor2D;
import org.lwjgl.opengl.Display;
import static org.lwjgl.opengl.GL11.*;

public class WeltDesSchwarms extends BasisFenster {
	private ObjektManager om;
	public Shader shader;

	public WeltDesSchwarms() {
		super("Welt des Schwarms", 1024, 768);
		om = ObjektManager.getInstance();
		init();
	}

	private void init() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				new SchwarmObjekt(new Vektor2D(50 * i, 50 * j), new Vektor2D(), 20000, 0.25 * Math.random() + 0.25);
			}
		}
		new AlphaObjekt(new Vektor2D(9, 9), new Vektor2D(1, 1), 20000, 0.25 * Math.random() + 0.25, 'r');
		new AlphaObjekt(new Vektor2D(18, 18), new Vektor2D(1, 1), 20000, 0.25 * Math.random() + 0.25, 'g');
		new AlphaObjekt(new Vektor2D(27, 27), new Vektor2D(1, 1), 20000, 0.25 * Math.random() + 0.25, 'b');
	}

	@Override
	public void renderLoop() throws Exception {
		shader = Shader.getInstance();
		while (!Display.isCloseRequested()) {
			glClearColor(0.9f, 0.9f, 0.9f, 1);
			glClear(GL_COLOR_BUFFER_BIT);

			glMatrixMode(GL_PROJECTION);
			glLoadIdentity();
			glOrtho(0, width, height, 0, 0, 1);
			glMatrixMode(GL_MODELVIEW);
			glDisable(GL_DEPTH_TEST);

			shader.createShaderProgramm();
			om.update();
			om.render();

			Display.update();
			shader.deleteShader();
		}
	}

	public static void main(String[] args) throws Exception {
		new WeltDesSchwarms().start();
	}
}
