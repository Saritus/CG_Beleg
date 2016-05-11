package Schwarmverhalten;

import math.Vektor2D;
import org.lwjgl.opengl.Display;
import org.omg.PortableServer.THREAD_POLICY_ID;
import java.lang.Thread.*;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by Matze on 10.05.16.
 */
public class Fonzies extends BasisObjekt {

	public Fonzies() {
		super();
	}

	public Fonzies(Vektor2D pos, Vektor2D speed, double masse, ObjektManager om, Behavior behavior) {
		super(pos, speed, masse, om, behavior);
	}

	public Fonzies(Vektor2D pos, Vektor2D speed, double masse, ObjektManager om) {
		super(pos, speed, masse, om);
	}

	public Fonzies(Vektor2D pos, Vektor2D speed, double masse) {
		super(pos, speed, masse);
	}

	public Fonzies(Vektor2D pos, Vektor2D speed) {
		super(pos, speed);
	}

	public Fonzies(Vektor2D pos) {
		super(pos);
	}

	@Override
	public void render() {
		// glColor3d(r, g, b);
		glBegin(GL_TRIANGLE_FAN);

		glVertex2f((float) pos.getX() + 50, (float) pos.getY() - 30);
		glColor3d(0, 1, 0);
		glVertex2f((float) pos.getX() + 50, (float) pos.getY() + 100);
		glColor3d(1, 0, 0);
		glVertex2f((float) pos.getX() - 50, (float) pos.getY() + 10);

		glEnd();
	}
}
