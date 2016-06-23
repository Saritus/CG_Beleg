package verhalten;

import static org.lwjgl.opengl.GL11.*;
import math.*;

public class AlphaObjekt extends BeweglichesObjekt {

	public AlphaObjekt(int id, Vektor2D pos, Vektor2D speed, double masse, double maxSpeed, Vektor3D color) {
		this(id, pos, speed, masse, maxSpeed);
		this.color = color;
	}

	public AlphaObjekt(int id, Vektor2D pos, Vektor2D speed, double masse, Vektor3D color) {
		this(id, pos, speed, masse);
		this.color = color;
	}

	public AlphaObjekt(Vektor2D pos, Vektor2D speed, double masse, double maxSpeed, Vektor3D color) {
		this(pos, speed, masse, maxSpeed);
		this.color = color;
	}

	public AlphaObjekt(Vektor2D pos, Vektor2D speed, double masse, Vektor3D color) {
		this(pos, speed, masse);
		this.color = color;
	}

	public AlphaObjekt(int id, Vektor2D pos, Vektor2D speed, double masse, double maxSpeed, char color) {
		this(id, pos, speed, masse, maxSpeed, getColorFromChar(color));
	}

	public AlphaObjekt(int id, Vektor2D pos, Vektor2D speed, double masse, char color) {
		this(id, pos, speed, masse, getColorFromChar(color));
	}

	public AlphaObjekt(Vektor2D pos, Vektor2D speed, double masse, double maxSpeed, char color) {
		this(pos, speed, masse, maxSpeed, getColorFromChar(color));
	}

	public AlphaObjekt(Vektor2D pos, Vektor2D speed, double masse, char color) {
		this(pos, speed, masse, getColorFromChar(color));
	}

	public AlphaObjekt(int id, Vektor2D pos, Vektor2D speed, double masse, double maxSpeed) {
		super(id, pos, speed, masse, maxSpeed);
		ObjektManager.getInstance().add(this);
		behavior = new Alphaverhalten(this);
		color = new Vektor3D(0, 0, 0);
	}

	public AlphaObjekt(int id, Vektor2D pos, Vektor2D speed, double masse) {
		super(id, pos, speed, masse);
		ObjektManager.getInstance().add(this);
		behavior = new Alphaverhalten(this);
		color = new Vektor3D(0, 0, 0);
	}

	public AlphaObjekt(Vektor2D pos, Vektor2D speed, double masse, double maxSpeed) {
		super(pos, speed, masse, maxSpeed);
		ObjektManager.getInstance().add(this);
		behavior = new Alphaverhalten(this);
		color = new Vektor3D(0, 0, 0);
	}

	public AlphaObjekt(Vektor2D pos, Vektor2D speed, double masse) {
		super(pos, speed, masse);
		ObjektManager.getInstance().add(this);
		behavior = new Alphaverhalten(this);
		color = new Vektor3D(0, 0, 0);
	}

	public static Vektor3D getColorFromChar(char color) {
		Vektor3D result;
		switch (color) {
		case 'r':
			result = new Vektor3D(1, 0, 0);
			break;
		case 'g':
			result = new Vektor3D(0, 1, 0);
			break;
		case 'b':
			result = new Vektor3D(0, 0, 1);
			break;
		default:
			result = new Vektor3D(0, 0, 0);
			break;
		}
		return result;
	}

	@Override
	public void render() {

		Vektor2D front;
		Vektor2D right;
		Vektor2D left;
		try {
			front = (Vektor2D) LineareAlgebra.normalize(speed).mult(25);
			right = (Vektor2D) LineareAlgebra.turn(front, 2 * Math.PI / 3).div(2);
			left = (Vektor2D) LineareAlgebra.turn(front, -2 * Math.PI / 3).div(2);
		} catch (Exception e) {
			front = right = left = new Vektor2D();
			e.printStackTrace();
		}

		glBegin(GL_TRIANGLE_FAN);
		glColor3f((float) color.getX(), (float) color.getY(), (float) color.getZ());
		glVertex2f((float) (pos.getX() + front.getX()), (float) (pos.getY() + front.getY()));
		glVertex2f((float) (pos.getX() + right.getX()), (float) (pos.getY() + right.getY()));
		glVertex2f((float) (pos.getX() + left.getX()), (float) (pos.getY() + left.getY()));
		glEnd();

		glBegin(GL_LINE_LOOP);
		glColor3f(0, 0, 0);
		glVertex2f((float) (pos.getX() + front.getX()), (float) (pos.getY() + front.getY()));
		glVertex2f((float) (pos.getX() + right.getX()), (float) (pos.getY() + right.getY()));
		glVertex2f((float) (pos.getX() + left.getX()), (float) (pos.getY() + left.getY()));
		glEnd();
	}
}
