package math;

public class Vektor2D extends Vektor {

	public Vektor2D(double[] array)  {
		super(2, array);
	}

	public Vektor2D(double x, double y)  {
		this(new double[] { x, y });
	}

	public Vektor2D()  {
		this(new double[] { 0, 0 });
	}

	public Vektor2D(Vektor vec)  {
		this(vec.array);
	}

	public Vektor2D clone() {
		try {
			return new Vektor2D(this);
		} catch (Exception e) {
			return null;
		}
	}
}