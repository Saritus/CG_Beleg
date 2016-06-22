package math;

import help.*;

public class Vektor {
	protected double[] array;
	protected int dimension;

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

	public double getElem(int dimension) throws Exception {
		if ((this.dimension <= dimension) || (dimension < 0)) {
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

	public Vektor truncate(double maxLength) throws Exception {
		if (length() > maxLength) {
			normalize();
			mult(maxLength);
		}
		return this;
	}

	public Vektor truncate(double... maxValues) throws Exception {
		Function.CheckDimensions(dimension, maxValues.length);
		for (int i = 0; i < dimension; i++) {
			array[i] = array[i] > maxValues[i] ? maxValues[i] : array[i];
		}
		return this;
	}

	public Vektor modulo(double... values) throws Exception {
		Function.CheckDimensions(dimension, values.length);
		for (int i = 0; i < dimension; i++) {
			while (array[i] < 0) {
				array[i] += values[i];
			}
			array[i] %= values[i];
		}
		return this;
	}

	public Vektor turn(double angle) {
		Vektor result;
		switch (dimension) {
		case 2:
			double x = array[0] * Math.cos(angle) - array[1] * Math.sin(angle);
			double y = array[0] * Math.sin(angle) + array[1] * Math.cos(angle);
			result = new Vektor2D(x, y);
			break;
		case 3:
			result = null;
			break;
		default:
			result = null;
			break;
		}
		return result;
	}
}