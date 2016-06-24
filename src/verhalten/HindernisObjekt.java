package verhalten;

import static org.lwjgl.opengl.GL11.*;
import math.Vektor2D;
import math.Vektor3D;

public final class HindernisObjekt extends StatischesObjekt {

	public HindernisObjekt() {
		super();
	}

	public HindernisObjekt(Vektor2D pos, Vektor3D color) {
		super(pos, color);
	}

	public HindernisObjekt(Vektor2D pos) {
		super(pos);
	}

	public HindernisObjekt(int x, int y) {
		super(new Vektor2D(x, y));
	}

	public HindernisObjekt(Vektor3D color) {
		super(color);
	}

	@Override
	public void render() {
		glBegin(GL_POLYGON);
		glColor3d(0, 0, 0);
		drawOctagon(10);
		glEnd();
	}
}
