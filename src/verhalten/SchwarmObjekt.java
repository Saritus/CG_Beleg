package verhalten;

import static org.lwjgl.opengl.GL11.*;
import math.Vektor2D;

public class SchwarmObjekt extends BeweglichesObjekt {

	public SchwarmObjekt(int id, Vektor2D pos, Vektor2D speed, double masse, double maxSpeed, ObjektManager om) {
		super(id, pos, speed, masse, maxSpeed);
		om.add(this);
		behavior = new Schwarmverhalten(this);
	}

	public SchwarmObjekt(int id, Vektor2D pos, Vektor2D speed, double masse, ObjektManager om) {
		super(id, pos, speed, masse);
		om.add(this);
		behavior = new Schwarmverhalten(this);
	}

	public SchwarmObjekt(Vektor2D pos, Vektor2D speed, double masse, double maxSpeed, ObjektManager om) {
		super(pos, speed, masse, maxSpeed);
		om.add(this);
		behavior = new Schwarmverhalten(this);
	}

	public SchwarmObjekt(Vektor2D pos, Vektor2D speed, double masse, ObjektManager om) {
		super(pos, speed, masse);
		om.add(this);
		behavior = new Schwarmverhalten(this);
	}

	public SchwarmObjekt(int id, Vektor2D pos, Vektor2D speed, double masse, double maxSpeed) {
		super(id, pos, speed, masse, maxSpeed);
		behavior = new Schwarmverhalten(this);
	}

	public SchwarmObjekt(int id, Vektor2D pos, Vektor2D speed, double masse) {
		super(id, pos, speed, masse);
		behavior = new Schwarmverhalten(this);
	}

	public SchwarmObjekt(Vektor2D pos, Vektor2D speed, double masse, double maxSpeed) {
		super(pos, speed, masse, maxSpeed);
		behavior = new Schwarmverhalten(this);
	}

	public SchwarmObjekt(Vektor2D pos, Vektor2D speed, double masse) {
		super(pos, speed, masse);
		behavior = new Schwarmverhalten(this);
	}

	@Override
	public void render(Shader shader) {
		shader.setUniformVariables(speed);		
		glBegin(GL_TRIANGLE_FAN);
		glVertex2f((float) pos.getX(), (float) pos.getY() - 10);
		glVertex2f((float) pos.getX() + 10, (float) pos.getY() + 10);
		glVertex2f((float) pos.getX() - 10, (float) pos.getY() + 10);

		glEnd();

		/*
		 * Speed glBegin(GL_LINE_STRIP); glColor3d(1, 1, 1);
		 * glVertex2d(pos.getX(), pos.getY()); glVertex2d(pos.getX() +
		 * speed.getX() * 20, pos.getY() + speed.getY() * 20); glEnd();
		 */
	}
}
