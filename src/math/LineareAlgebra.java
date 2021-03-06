package math;

public abstract class LineareAlgebra {

	private LineareAlgebra() {
	}

	public static Vektor add(Vektor v1, Vektor v2) {
		return (v1.clone()).add(v2);
	}

	public static Vektor add(Vektor v1, Vektor... v2) {
		Vektor result = v1.clone();
		for (int i = 0; i < v2.length; i++) {
			result.add(v2[i]);
		}
		return result;
	}

	public static Vektor sub(Vektor v1, Vektor v2) {
		return add(v1, negate(v2));
	}

	public static Vektor mult(Vektor vec, double d) {
		return (vec.clone()).mult(d);
	}

	public static Vektor mult(double d, Vektor vec) {
		return mult(vec, d);
	}

	public static Vektor div(Vektor vec, double d) {
		return (vec.clone()).div(d);
	}

	public static Vektor div(double d, Vektor vec) {
		return div(vec, d);
	}

	public static boolean isEqual(Vektor v1, Vektor v2) {
		return v1.isEqual(v2);
	}

	public static boolean isNotEqual(Vektor v1, Vektor v2) {
		return !isEqual(v1, v2);
	}

	public static double length(Vektor vec) {
		return vec.length();
	}

	public static Vektor normalize(Vektor vec) {
		return (vec.clone()).normalize();
	}

	public static double euklDistance(Vektor v1, Vektor v2) {
		return sub(v1, v2).length();
	}

	public static double manhattanDistance(Vektor v1, Vektor v2) {
		Function.checkDimensions(v1.getDimension(), v2.getDimension());
		double result = 0;
		for (int i = 0; i < v1.getDimension(); i++) {
			result += Math.abs(v1.getElem(i) - v2.getElem(i));
		}
		return result;
	}

	public static Vektor crossProduct(Vektor u, Vektor v) {
		Function.checkDimensions(u.getDimension(), v.getDimension());
		int dim = u.getDimension();
		double[] values;
		switch (dim) {
		case 2:
			values = new double[1];
			// values[0]=u.getElem(0)*v.getElem(1)-v.getElem(0)*u.getElem(1);<
			values[0] = determinante(u, v);
			return new Vektor(1, values);
		case 3:
			values = new double[3];
			values[0] = u.getElem(1) * v.getElem(2) - u.getElem(2) * v.getElem(1);
			values[1] = u.getElem(2) * v.getElem(0) - u.getElem(0) * v.getElem(2);
			values[2] = u.getElem(0) * v.getElem(1) - u.getElem(1) * v.getElem(0);
			return new Vektor3D(values);
		default:
			throw new RuntimeException("crossProduct is only implemented for 2x2 and 3x3 matrices");
		}

	}

	public static double dotProduct(Vektor v1, Vektor v2) {
		Function.checkDimensions(v1.getDimension(), v2.getDimension());
		double result = 0;
		for (int i = 0; i < v1.getDimension(); i++) {
			result += v1.getElem(i) * v2.getElem(i);
		}
		Function.checkOverflow(result);
		return result;
	}

	public static double cosEquation(Vektor v1, Vektor v2) {
		return dotProduct(v1, v2) / (v1.length() * v2.length());
	}

	public static double sinEquation(Vektor v1, Vektor v2) {
		return crossProduct(v1, v2).length() / (v1.length() * v2.length());
	}

	public static double angleRad(double d, String trig) {
		switch (trig) {
		case "sin":
			return Math.asin(d);
		case "cos":
			return Math.acos(d);
		case "tan":
			return Math.atan(d);
		default:
			throw new RuntimeException("Invalid trigonometric function");
		}
	}

	public static double angleRad(String trig, double d) {
		return angleRad(d, trig);
	}

	public static double angleDegree(double d, String trig) {
		return radToDegree(angleRad(d, trig));
	}

	public static double angleDegree(String trig, double d) {
		return angleDegree(d, trig);
	}

	public static double radToDegree(double rad) {
		return rad * 180 / Math.PI;
	}

	public static double degreeToRad(double degree) {
		return degree * Math.PI / 180;
	}

	public static double determinante(Vektor... vec) {
		for (int i = 0; i < vec.length; i++) {
			Function.checkDimensions(vec[i].getDimension(), vec.length);
		}
		double result = 0;
		switch (vec.length) {
		case 2:
			result = vec[0].getElem(0) * vec[1].getElem(1) - vec[0].getElem(1) * vec[1].getElem(0);
			break;
		case 3:
			result = vec[0].getElem(0)
					* (vec[1].getElem(1) * vec[2].getElem(2) - vec[2].getElem(1) * vec[1].getElem(2));
			result -= vec[1].getElem(0)
					* (vec[0].getElem(1) * vec[2].getElem(2) - vec[2].getElem(1) * vec[0].getElem(2));
			result += vec[2].getElem(0)
					* (vec[0].getElem(1) * vec[1].getElem(2) - vec[1].getElem(1) * vec[0].getElem(2));
			break;
		default:
			throw new RuntimeException("Determinante is only implemented for 2x2 and 3x3 matrices");
		}
		return result;
	}

	public static Vektor abs(Vektor vec) {
		return (vec.clone()).abs();
	}

	public static void show(Vektor vec) {
		System.out.println(vec.toString());
	}

	public static Vektor negate(Vektor vec) {
		return (vec.clone()).negate();
	}

	public static Vektor truncate(Vektor vec, double maxLength) {
		return (vec.clone()).truncate(maxLength);
	}

	public static Vektor truncate(double maxLength, Vektor vec) {
		return truncate(vec, maxLength);
	}

	public static Vektor modulo(Vektor vec, double... values) {
		return (vec.clone()).modulo(values);
	}

	public static Vektor2D turn(Vektor2D vec, double angle) {
		return vec.clone().turn(angle);
	}

	public static Vektor2D turn(double angle, Vektor2D vec) {
		return turn(vec, angle);
	}

	public static Vektor2D turn120(Vektor2D vec) {
		return vec.clone().turn120();
	}

	public static Vektor2D turn240(Vektor2D vec) {
		return vec.clone().turn240();
	}
}
