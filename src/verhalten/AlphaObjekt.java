package verhalten;

import static org.lwjgl.opengl.GL11.*;
import math.*;

public final class AlphaObjekt extends BeweglichesObjekt {

	public AlphaObjekt(Vektor2D pos, Vektor2D speed, double masse, double maxSpeed, Vektor3D color) {
		this(pos, speed, masse, maxSpeed);
		this.color = color;
	}

	public AlphaObjekt(Vektor2D pos, Vektor2D speed, double masse, Vektor3D color) {
		this(pos, speed, masse);
		this.color = color;
	}

	public AlphaObjekt(Vektor2D pos, Vektor2D speed, double masse, double maxSpeed, char color) {
		this(pos, speed, masse, maxSpeed, getColorFromChar(color));
	}

	public AlphaObjekt(Vektor2D pos, Vektor2D speed, double masse, char color) {
		this(pos, speed, masse, getColorFromChar(color));
	}

	public AlphaObjekt(Vektor2D pos, Vektor2D speed, double masse, double maxSpeed) {
		super(pos, speed, masse, maxSpeed);
		ObjektManager.getInstance().add(this);
		behavior = new AlphaVerhalten(this);
		color = new Vektor3D(0, 0, 0);
	}

	public AlphaObjekt(Vektor2D pos, Vektor2D speed, double masse) {
		super(pos, speed, masse);
		ObjektManager.getInstance().add(this);
		behavior = new AlphaVerhalten(this);
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

		glBegin(GL_TRIANGLE_FAN);
		glColor3f((float) color.getX(), (float) color.getY(), (float) color.getZ());
		drawDynamicTriangle(25, speed);
		glEnd();

		glBegin(GL_LINE_LOOP);
		glColor3f(0, 0, 0);
		drawDynamicTriangle(25, speed);
		glEnd();
	}
}
