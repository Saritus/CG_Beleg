package verhalten;

import static org.lwjgl.opengl.GL11.*;

import math.Vektor2D;

public class HindernisObjekt extends StatischesObjekt {

	public HindernisObjekt() {
		super();
	}

	public HindernisObjekt(int id, Vektor2D pos) {
		super(id, pos);
	}

	public HindernisObjekt(int id) {
		super(id);
	}

	public HindernisObjekt(Vektor2D pos) {
		super(pos);
	}

	public HindernisObjekt(double x, double y) {
		super(new Vektor2D(x, y));
	}

	@Override
	public void render() {
		glBegin(GL_LINE_LOOP);
		glColor3d(1, 1, 1);
		glVertex2f((float) pos.getX(), (float) pos.getY() - 5);
		glVertex2f((float) pos.getX() + 5, (float) pos.getY() + 5);
		glVertex2f((float) pos.getX() - 5, (float) pos.getY() + 5);
		glEnd();
	}
}
