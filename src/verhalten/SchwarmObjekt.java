package verhalten;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.GL20;

import math.LineareAlgebra;
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
		} catch (Exception e) {
			e.printStackTrace();
		}

		glEnd();
	}
}
