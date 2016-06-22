package verhalten;

import static org.lwjgl.opengl.GL11.*;
import math.*;

public class SchwarmObjekt extends BeweglichesObjekt {

	public SchwarmObjekt(int id, Vektor2D pos, Vektor2D speed, double masse, double maxSpeed) {
		super(id, pos, speed, masse, maxSpeed);
		ObjektManager.getInstance().add(this);
		behavior = new Schwarmverhalten(this);
	}

	public SchwarmObjekt(int id, Vektor2D pos, Vektor2D speed, double masse) {
		super(id, pos, speed, masse);
		ObjektManager.getInstance().add(this);
		behavior = new Schwarmverhalten(this);
	}

	public SchwarmObjekt(Vektor2D pos, Vektor2D speed, double masse, double maxSpeed) {
		super(pos, speed, masse, maxSpeed);
		ObjektManager.getInstance().add(this);
		behavior = new Schwarmverhalten(this);
	}

	public SchwarmObjekt(Vektor2D pos, Vektor2D speed, double masse) {
		super(pos, speed, masse);
		ObjektManager.getInstance().add(this);
		behavior = new Schwarmverhalten(this);
	}

	public Vektor3D getSchwarmColor(double abstand) {
		float anz = 0;
		for (int i = 0; i < this.abstand.length; i++) {
			if (this.abstand[i] < abstand) {
				anz++;
			}
		}
		float anteil = anz / this.abstand.length;
		if (anteil > 0.5) {
			return new Vektor3D(2 * anteil - 1, 2 - 2 * anteil, 0);
		} else {
			return new Vektor3D(0, 2 * anteil, 1 - 2 * anteil);
		}
	}

	public Vektor3D getAlphaColor(double abstand) throws Exception {
		AlphaObjekt[] alphas = ObjektManager.getInstance().getAlphas();
		Vektor3D color = new Vektor3D();
		for (int i = 0; i < alphas.length; i++) {
			if (LineareAlgebra.manhattanDistance(pos, alphas[i].pos) < abstand) {
				color.add(alphas[i].getColor());
			}
		}
		return color;
	}

	@Override
	public void render() {
		glBegin(GL_TRIANGLE_FAN);
		// glColor3f(1, 1f - (float) (this.speed.length() / this.maxSpeed),1f -
		// (float) (this.speed.length() / this.maxSpeed));
		Vektor3D color;
		try {
			color = getAlphaColor(200);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			color = new Vektor3D();
		}
		glColor3f((float) color.getX(), (float) color.getY(), (float) color.getZ());
		// glVertex2f((float) pos.getX(), (float) pos.getY() - 10);
		Vektor2D front;
		try {
			front = (Vektor2D) LineareAlgebra.normalize(speed).mult(15);
		} catch (Exception e) {
			front = null;
			e.printStackTrace();
		}
		try {
			glVertex2f((float) (pos.getX() + front.getX()), (float) (pos.getY() + front.getY()));
			front.div(2);
			glVertex2f((float) (pos.getX() + LineareAlgebra.turn(front, 2 * Math.PI / 3).getElem(0)),
					(float) (pos.getY() + LineareAlgebra.turn(front, 2 * Math.PI / 3).getElem(1)));
			glVertex2f((float) (pos.getX() + LineareAlgebra.turn(front, -2 * Math.PI / 3).getElem(0)),
					(float) (pos.getY() + LineareAlgebra.turn(front, -2 * Math.PI / 3).getElem(1)));
			// glVertex2f((float) pos.getX(), (float) pos.getY() - 10);
			// glVertex2f((float) pos.getX() - 10, (float) pos.getY() + 10);
			// glVertex2f((float) pos.getX() + 10, (float) pos.getY() + 10);
		} catch (Exception e) {
			e.printStackTrace();
		}

		glEnd();
	}
}
