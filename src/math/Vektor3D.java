package math;

public class Vektor3D extends Vektor {
	
	public Vektor3D(double[] array) throws Exception {
		super(3, array);
	}

	public Vektor3D(double x, double y, double z) throws Exception {
		this(new double[] { x, y, z });
	}

	public Vektor3D() throws Exception {
		this(new double[] { 0, 0, 0 });
	}

	public Vektor3D(Vektor vec) throws Exception {
		this(vec.array);
	}

	public Vektor3D clone() {
		try {
			return new Vektor3D(this);
		} catch (Exception e) {
			return null;
		}
	}
}
