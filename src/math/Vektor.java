package math;

public class Vektor {
	protected double[] array;
	private int dimension;

	@SuppressWarnings("unused")
	private Vektor() {
	}

	public Vektor(int dimension, double[] array) {
		this.dimension = dimension;
		this.array = new double[dimension];
		try {
			setPosition(array);
		} catch (Exception e) {
		}
	}

	public Vektor(double[] array, int dimension) {
		this(dimension, array);
	}

	public Vektor(Vektor vec) {
		this(vec.dimension, vec.array);
	}

	public int getDimension() {
		return dimension;
	}

	public double[] getArray() {
		return array;
	}

	public double getElem(int dimension) {
		if ((this.dimension <= dimension) || (dimension < 0)) {
			throw new RuntimeException("Invalid dimension");
		}
		return array[dimension];
	}

	public void setPosition(double... array) {
		if (array.length == dimension) {
			for (int i = 0; i < dimension; i++) {
				this.array[i] = array[i];
			}
		} else {
			throw new RuntimeException("Array does not have the right length");
		}
	}

	public boolean isNullVector() {
		return lengthsquare() == 0;
	}

	public Vektor add(Vektor vec) {
		Function.checkDimensions(vec.dimension, dimension);
		for (int i = 0; i < dimension; i++) {
			Function.checkAddOverflow(array[i], vec.array[i]);
			array[i] += vec.array[i];
		}
		return this;
	}

	public Vektor sub(Vektor vec) {
		return add((vec.clone()).negate());
	}

	public Vektor mult(double d) {
		for (int i = 0; i < dimension; i++) {
			Function.checkMultOverflow(array[i], d);
			array[i] *= d;
		}
		return this;
	}

	public Vektor div(double d) {
		if (d == 0) {
			throw new RuntimeException("Cannot divide by zero");
		} else {
			return mult(1. / d);
		}
	}

	public boolean isEqual(Vektor vec) {
		if (dimension != vec.dimension) {
			return false;
		}
		for (int i = 0; i < dimension; i++) {
			if (array[i] != vec.array[i]) {
				return false;
			}
		}
		return true;
	}

	public boolean isNotEqual(Vektor vec) {
		return !isEqual(vec);
	}

	public double length() {
		return Math.sqrt(lengthsquare());
	}

	public double lengthsquare() {
		double lengthsquare = 0;
		for (int i = 0; i < dimension; i++) {
			lengthsquare += array[i] * array[i];
		}
		return lengthsquare;
	}

	public Vektor normalize() {
		if (!isNullVector())
			return div(length());
		else
			throw new RuntimeException("Nullvector cannot be normalized");
	}

	public String toString() {
		StringBuilder result = new StringBuilder("( " + array[0]);
		for (int i = 1; i < dimension; i++) {
			result.append(", " + array[i]);
		}
		result.append(" )");
		return (result.toString());
	}

	public Vektor clone() {
		try {
			return new Vektor(this);
		} catch (Exception e) {
			return null;
		}
	}

	public Vektor abs() {
		for (int i = 0; i < dimension; i++) {
			array[i] = Math.abs(array[i]);
		}
		return this;
	}

	public Vektor negate() {
		return mult(-1);
	}

	public Vektor truncate(double maxLength) {
		if (length() > maxLength) {
			normalize();
			mult(maxLength);
		}
		return this;
	}

	public Vektor truncate(double... maxValues) {
		Function.checkDimensions(dimension, maxValues.length);
		for (int i = 0; i < dimension; i++) {
			array[i] = array[i] > maxValues[i] ? maxValues[i] : array[i];
		}
		return this;
	}

	public Vektor modulo(double... values) {
		Function.checkDimensions(dimension, values.length);
		for (int i = 0; i < dimension; i++) {
			while (array[i] < 0) {
				array[i] += values[i];
			}
			array[i] %= values[i];
		}
		return this;
	}
}