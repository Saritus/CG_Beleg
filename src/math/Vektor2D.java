package math;

public final class Vektor2D extends Vektor {

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

	public void setPosition(double x, double y) {
		try {
			super.setPosition(x, y);
		} catch (Exception e) {
			e.printStackTrace();
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
		array[1] = y;
	}

	public Vektor2D turn(double angle) {

		double x = array[0] * Math.cos(angle) - array[1] * Math.sin(angle);
		double y = array[0] * Math.sin(angle) + array[1] * Math.cos(angle);
		setPosition(x, y);
		return this;
	}

	public Vektor2D turn120() {
		double newx = array[0] * (-0.5) - array[1] * (0.866);
		double newy = array[0] * (0.866) + array[1] * (-0.5);
		try {
			setPosition(newx, newy);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public Vektor2D turn240() {
		double newx = array[0] * (-0.5) - array[1] * (-0.866);
		double newy = array[0] * (-0.866) + array[1] * (-0.5);
		try {
			setPosition(newx, newy);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
}