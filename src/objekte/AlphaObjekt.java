package objekte;

import static org.lwjgl.opengl.GL11.*;
import math.*;
import verhalten.AlphaVerhalten;
import verhalten.ObjektManager;

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
		this(pos, speed, masse, maxSpeed, Function.getColorFromChar(color));
	}

	public AlphaObjekt(Vektor2D pos, Vektor2D speed, double masse, char color) {
		this(pos, speed, masse, Function.getColorFromChar(color));
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
