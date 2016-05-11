package math;

public class Vektor3D extends Vektor {

	public Vektor3D(double[] array) {
		super(3, array);
	}

	public Vektor3D(double x, double y, double z) {
		this(new double[] { x, y, z });
	}

	public Vektor3D() {
		this(new double[] { 0, 0, 0 });
	}

	public Vektor3D(Vektor vec) {
		this(vec.array);
	}

	public Vektor3D clone() {
		try {
			return new Vektor3D(this);
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
		array[1] = y;
	}

	public double getZ() {
		return array[2];
	}

	public void setZ(double z) {
		array[2] = z;
	}
}
