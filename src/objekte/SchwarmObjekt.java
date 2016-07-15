package objekte;

import static org.lwjgl.opengl.GL11.*;
import math.*;
import program.ObjektManager;
import verhalten.SchwarmVerhalten;

public final class SchwarmObjekt extends BeweglichesObjekt {

	public SchwarmObjekt(Vektor2D pos, Vektor2D speed, double masse, double maxSpeed) {
		super(pos, speed, masse, maxSpeed);
		ObjektManager.getInstance().add(this);
		behavior = new SchwarmVerhalten(this);
	}

	public SchwarmObjekt(Vektor2D pos, Vektor2D speed, double masse) {
		super(pos, speed, masse);
		ObjektManager.getInstance().add(this);
		behavior = new SchwarmVerhalten(this);
	}

	public Vektor3D getSchwarmColor(double abstand) {
		Vektor3D result = new Vektor3D();
		result.add(getAlphaColor(abstand));
		result.add(getNearColor(abstand));
		if (!result.isNullVector()) {
			result.normalize();
		}
		return result;
	}

	public Vektor3D getAlphaColor(double abstand) {
		Vektor3D result = new Vektor3D();
		AlphaObjekt[] alphas = ObjektManager.getInstance().getAlphas();
		for (int i = 0; i < alphas.length; i++) {
			if (LineareAlgebra.manhattanDistance(pos, alphas[i].pos) < abstand) {
				result.add(alphas[i].getColor());
			}
		}
		return result;
	}

	public Vektor3D getNearColor(double abstand) {
		Vektor3D result = new Vektor3D();
		for (int i = 0; i < this.abstand.length; i++) {
			if (this.abstand[i] < abstand) {
				result.add(ObjektManager.getInstance().getObjects()[i].getColor());
			}
		}
		return result;
	}

	@Override
	public void render() {

		try {
			setColor(getSchwarmColor(200));
		} catch (Exception e) {
			e.printStackTrace();
		}

		glBegin(GL_TRIANGLE_FAN);
		glColor3f((float) color.getX(), (float) color.getY(), (float) color.getZ());
		drawDynamicTriangle(15, speed);
		glEnd();
	}
}
