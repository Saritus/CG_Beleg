package objekte;

import static org.lwjgl.opengl.GL11.glVertex2f;

import math.LineareAlgebra;
import math.Vektor2D;
import math.Vektor3D;

public abstract class BasisObjekt {

	protected int id = -1;
	protected Vektor2D pos;
	protected Vektor3D color;

	protected BasisObjekt(Vektor2D pos, Vektor3D color) {
		setPos(pos);
		setColor(color);
	}

	protected BasisObjekt(Vektor2D pos) {
		this(pos, new Vektor3D());
	}

	protected BasisObjekt(Vektor3D color) {
		this(new Vektor2D(), color);
	}

	protected BasisObjekt() {
		this(new Vektor2D(), new Vektor3D());
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

	protected void drawOctagon(float size) {
		glVertex2f((float) pos.getX() + size / 4, (float) pos.getY() + 0.60355f * size);
		glVertex2f((float) pos.getX() + 0.60355f * size, (float) pos.getY() + size / 4);
		glVertex2f((float) pos.getX() + 0.60355f * size, (float) pos.getY() - size / 4);
		glVertex2f((float) pos.getX() + size / 4, (float) pos.getY() - 0.60355f * size);
		glVertex2f((float) pos.getX() - size / 4, (float) pos.getY() - 0.60355f * size);
		glVertex2f((float) pos.getX() - 0.60355f * size, (float) pos.getY() - size / 4);
		glVertex2f((float) pos.getX() - 0.60355f * size, (float) pos.getY() + size / 4);
		glVertex2f((float) pos.getX() - size / 4, (float) pos.getY() + 0.60355f * size);
	}

	protected void drawStaticTriangle(float size) {
		glVertex2f((float) pos.getX(), (float) pos.getY() - size);
		glVertex2f((float) pos.getX() + 0.866f * size, (float) pos.getY() + size / 2);
		glVertex2f((float) pos.getX() - 0.866f * size, (float) pos.getY() + size / 2);
	}

	protected void drawDynamicTriangle(float size, Vektor2D direction) {
		Vektor2D right, left, front;
		try {
			front = (Vektor2D) LineareAlgebra.normalize(direction).mult(size);
			right = (Vektor2D) LineareAlgebra.turn120(front).div(2);
			left = (Vektor2D) LineareAlgebra.turn240(front).div(2);
		} catch (Exception e) {
			front = right = left = new Vektor2D();
			e.printStackTrace();
		}

		glVertex2f((float) (pos.getX() + front.getX()), (float) (pos.getY() + front.getY()));
		glVertex2f((float) (pos.getX() + right.getX()), (float) (pos.getY() + right.getY()));
		glVertex2f((float) (pos.getX() + left.getX()), (float) (pos.getY() + left.getY()));
	}
}