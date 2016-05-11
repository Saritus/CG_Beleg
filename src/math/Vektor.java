package math;

import help.*;

public class Vektor {
	protected double[] array;
	protected int dimension;

	private Vektor() {
	}

	public Vektor(int dimension, double[] array) throws Exception {
		this.dimension = dimension;
		this.array = new double[dimension];
		setPosition(array);
	}

	public Vektor(double[] array, int dimension) throws Exception {
		this(dimension, array);
	}

	public Vektor(Vektor vec) throws Exception {
		this(vec.dimension, vec.array);
	}

	public int getDimension() {
		return dimension;
	}

	public double[] getArray() {
		return array;
	}

	public double getElem(int dimension) throws Exception {
		if ((dimension >= this.dimension) || (dimension < 0)) {
			throw new Exception("Invalid dimension");
		}
		return array[dimension];
	}

	public void setPosition(double... array) throws Exception {
		if (array.length == dimension) {
			for (int i = 0; i < dimension; i++) {
				this.array[i] = array[i];
			}
		} else {
			throw new Exception("Array does not have the right length");
		}
	}

	public boolean isNullVector() {
		return lengthsquare() == 0;
	}

	public Vektor add(Vektor vec) throws Exception {
		Function.CheckDimensions(vec.dimension, dimension);
		for (int i = 0; i < dimension; i++) {
			Function.CheckAddOverflow(array[i], vec.array[i]);
			array[i] += vec.array[i];
		}
		return this;
	}

	public Vektor sub(Vektor vec) throws Exception {
		return add((vec.clone()).negate());
	}

	public Vektor mult(double d) throws Exception {
		for (int i = 0; i < dimension; i++) {
			Function.CheckMultOverflow(array[i], d);
			array[i] *= d;
		}
		return this;
	}

	public Vektor div(double d) throws Exception {
		if (d == 0) {
			throw new Exception("Cannot divide by zero");
		} else {
			return mult(1. / d);
		}
	}

	public boolean isEqual(Vektor vec) {
		if (this.dimension != vec.dimension) {
			return false;
		}
		for (int i = 0; i < dimension; i++) {
			if (this.array[i] != vec.array[i]) {
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
		double length = 0;
		for (int i = 0; i < dimension; i++) {
			length += array[i] * array[i];
		}
		return length;
	}

	public Vektor normalize() throws Exception {
		if (!isNullVector())
			return div(length());
		else
			throw new Exception("Nullvector cannot be normalized");
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

	public Vektor negate() throws Exception {
		return mult(-1);
	}
}