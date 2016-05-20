package Schwarmverhalten;

import math.Vektor2D;
import org.lwjgl.opengl.Display;
import org.omg.PortableServer.THREAD_POLICY_ID;
import java.lang.Thread.*;

import static org.lwjgl.opengl.GL11.*;

public class SchwarmObjekt extends BasisObjekt {

	public SchwarmObjekt() {
		super();
	}

	public SchwarmObjekt(Vektor2D pos, Vektor2D speed, double masse, double maxSpeed, ObjektManager om,
			Behavior behavior) {
		super(pos, speed, masse, maxSpeed, om, behavior);
	}

	public SchwarmObjekt(Vektor2D pos, Vektor2D speed, double masse, double maxSpeed, ObjektManager om) {
		super(pos, speed, masse, maxSpeed, om);
	}

	public SchwarmObjekt(Vektor2D pos, Vektor2D speed, double masse, double maxSpeed) {
		super(pos, speed, masse, maxSpeed);
	}

	public SchwarmObjekt(Vektor2D pos, Vektor2D speed, double masse) {
		super(pos, speed, masse);
	}

	public SchwarmObjekt(Vektor2D pos, Vektor2D speed) {
		super(pos, speed);
	}

	public SchwarmObjekt(Vektor2D pos) {
		super(pos);
	}

	@Override
	public void render() {
		// glColor3d(r, g, b);
		if ((pos.getX() > 5) && (pos.getY() > 5) && (pos.getX() < 1024 - 5) && (pos.getY() < 768 - 5)) {
			glBegin(GL_TRIANGLE_FAN);

			glVertex2f((float) pos.getX(), (float) pos.getY() - 10);
			glColor3d(0, 1, 0);
			glVertex2f((float) pos.getX() + 10, (float) pos.getY() + 10);
			glColor3d(1, 0, 0);
			glVertex2f((float) pos.getX() - 10, (float) pos.getY() + 10);

			glEnd();
		}
	}
}
