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
		glBegin(GL_POLYGON);
		glColor3d(0.3, 0.3, 0.3);
		glVertex2f((float) pos.getX() + 2.5f, (float) pos.getY() + 6.0355f);
		glVertex2f((float) pos.getX() + 6.0355f, (float) pos.getY() + 2.5f);
		glVertex2f((float) pos.getX() + 6.0355f, (float) pos.getY() - 2.5f);
		glVertex2f((float) pos.getX() + 2.5f, (float) pos.getY() - 6.0355f);
		glVertex2f((float) pos.getX() - 2.5f, (float) pos.getY() - 6.0355f);
		glVertex2f((float) pos.getX() - 6.0355f, (float) pos.getY() - 2.5f);
		glVertex2f((float) pos.getX() - 6.0355f, (float) pos.getY() + 2.5f);
		glVertex2f((float) pos.getX() - 2.5f, (float) pos.getY() + 6.0355f);
		glEnd();
	}
}
