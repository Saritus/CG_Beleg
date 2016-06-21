package verhalten;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.GL20;

import math.Vektor2D;

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

	@Override
	public void render() {
		glBegin(GL_TRIANGLE_FAN);
		glColor3f(1, (float) (this.maxSpeed - this.speed.length()), (float) (this.maxSpeed - this.speed.length()));
		glVertex2f((float) pos.getX(), (float) pos.getY() - 10);
		glVertex2f((float) pos.getX() + 10, (float) pos.getY() + 10);
		glVertex2f((float) pos.getX() - 10, (float) pos.getY() + 10);
		glEnd();
	}
}
