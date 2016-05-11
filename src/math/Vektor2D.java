package math;

public class Vektor2D extends Vektor {

	public Vektor2D(double[] array) {
		super(2, array);
	}

	public Vektor2D(double x, double y) {
		this(new double[] { x, y });
	}

	public Vektor2D() {
		this(new double[] { 0, 0 });
	}

	public Vektor2D(Vektor vec) {
		this(vec.array);
	}

	public Vektor2D clone() {
		try {
			return new Vektor2D(this);
		} catch (Exception e) {
			return null;
		}
	}

	public double getX() {
		return array[0];
	}

	public void setX(double x) {
		array[0] = x;
	}
	
	public double getY() {
		return array[1];
	}

	public void setY(double y) {
		array[0] = y;
	}
}