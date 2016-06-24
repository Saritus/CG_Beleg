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

	public Vektor3D setSchwarmColor(double abstand) {
		float anz = 0;
		for (int i = 0; i < this.abstand.length; i++) {
			if (this.abstand[i] < abstand) {
				anz++;
			}
		}
		float anteil = anz / this.abstand.length;
		if (anteil > 0.5) {
			return color = new Vektor3D(2 * anteil - 1, 2 - 2 * anteil, 0);
		} else {
			return color = new Vektor3D(0, 2 * anteil, 1 - 2 * anteil);
		}
	}

	public Vektor3D setAlphaColor(double abstand) throws Exception {
		AlphaObjekt[] alphas = ObjektManager.getInstance().getAlphas();

		for (int i = 0; i < alphas.length; i++) {
			if (LineareAlgebra.manhattanDistance(pos, alphas[i].pos) < abstand) {
				color.add(alphas[i].getColor());
			}
		}

		for (int i = 0; i < this.abstand.length; i++) {
			if (this.abstand[i] < abstand) {
				color.add(ObjektManager.getInstance().getObjects()[i].getColor());
			}
		}

		if (!color.isNullVector()) {
			color.normalize();
		}

		return color;
	}

	@Override
	public void render() {

		try {
			setAlphaColor(200);
		} catch (Exception e) {
			e.printStackTrace();
		}

		glBegin(GL_TRIANGLE_FAN);
		glColor3f((float) color.getX(), (float) color.getY(), (float) color.getZ());
		drawDynamicTriangle(15, speed);
		glEnd();
	}
}
