package verhalten;

import static org.lwjgl.opengl.GL11.glVertex2f;

import math.Vektor2D;
import math.Vektor3D;

public abstract class BasisObjekt {

	protected int id;
	protected Vektor2D pos;
	protected Vektor3D color;

	protected BasisObjekt(int id, Vektor2D pos, Vektor3D color) {
		setId(id);
		setPos(pos);
		setColor(color);
	}

	protected BasisObjekt(int id, Vektor2D pos) {
		this(id, pos, new Vektor3D());
	}

	protected BasisObjekt(int id, Vektor3D color) {
		this(id, new Vektor2D(), color);
	}

	protected BasisObjekt(Vektor2D pos, Vektor3D color) {
		this(-1, pos, color);
	}

	protected BasisObjekt(int id) {
		this(id, new Vektor2D(), new Vektor3D());
	}

	protected BasisObjekt(Vektor2D pos) {
		this(-1, pos, new Vektor3D());
	}

	protected BasisObjekt(Vektor3D color) {
		this(-1, new Vektor2D(), color);
	}

	protected BasisObjekt() {
		this(-1, new Vektor2D(), new Vektor3D());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Vektor2D getPos() {
		return pos;
	}

	public void setPos(Vektor2D pos) {
		this.pos = pos;
	}

	public Vektor3D getColor() {
		return color;
	}

	public void setColor(Vektor3D color) {
		this.color = color;
	}

	public abstract void render();
	
	protected void drawOctagon() {
		glVertex2f((float) pos.getX() + 2.5f, (float) pos.getY() + 6.0355f);
		glVertex2f((float) pos.getX() + 6.0355f, (float) pos.getY() + 2.5f);
		glVertex2f((float) pos.getX() + 6.0355f, (float) pos.getY() - 2.5f);
		glVertex2f((float) pos.getX() + 2.5f, (float) pos.getY() - 6.0355f);
		glVertex2f((float) pos.getX() - 2.5f, (float) pos.getY() - 6.0355f);
		glVertex2f((float) pos.getX() - 6.0355f, (float) pos.getY() - 2.5f);
		glVertex2f((float) pos.getX() - 6.0355f, (float) pos.getY() + 2.5f);
		glVertex2f((float) pos.getX() - 2.5f, (float) pos.getY() + 6.0355f);
	}

	protected void drawStaticTriangle() {
		glVertex2f((float) pos.getX(), (float) pos.getY() - 5f);
		glVertex2f((float) pos.getX() + 5f, (float) pos.getY() + 5f);
		glVertex2f((float) pos.getX() - 5f, (float) pos.getY() + 5f);
	}
}