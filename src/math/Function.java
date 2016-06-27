package math;

import java.io.BufferedReader;
import java.io.FileReader;

public class Function {
	public static void checkOverflow(double d) {
		if (d == Double.POSITIVE_INFINITY)
			throw new RuntimeException("Positive double overflow");
		if (d == Double.NEGATIVE_INFINITY)
			throw new RuntimeException("Negative double overflow");
	}

	public static void checkAddOverflow(double d1, double d2) {
		checkOverflow(d1 + d2);
	}

	public static void checkMultOverflow(double d1, double d2) {
		checkOverflow(d1 * d2);
	}

	public static void checkDimensions(int d1, int d2) {
		if (d1 != d2) {
			throw new RuntimeException("Vectors do not have the same dimension");
		}
	}

	public static String readFromFile(String name) {
		StringBuilder source = new StringBuilder();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(name));
			String line;
			while ((line = reader.readLine()) != null) {
				source.append(line).append("\n");
			}
			reader.close();
		} catch (Exception e) {
			System.err.println("Error loading source code: " + name);
			e.printStackTrace();
		}
		return source.toString();
	}

	public static Vektor3D getColorFromChar(char color) {
		Vektor3D result;
		switch (color) {
		case 'r':
			result = new Vektor3D(1, 0, 0);
			break;
		case 'g':
			result = new Vektor3D(0, 1, 0);
			break;
		case 'b':
			result = new Vektor3D(0, 0, 1);
			break;
		default:
			result = new Vektor3D(0, 0, 0);
			break;
		}
		return result;
	}
}
