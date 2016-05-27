package help;

import java.io.BufferedReader;
import java.io.FileReader;

public class Function {
	public static void CheckOverflow(double d) throws Exception {
		if (d == Double.POSITIVE_INFINITY)
			throw new Exception("Positive double overflow");
		if (d == Double.NEGATIVE_INFINITY)
			throw new Exception("Negative double overflow");
	}

	public static void CheckAddOverflow(double d1, double d2) throws Exception {
		CheckOverflow(d1 + d2);
	}

	public static void CheckMultOverflow(double d1, double d2) throws Exception {
		CheckOverflow(d1 * d2);
	}

	public static void CheckDimensions(int d1, int d2) throws Exception {
		if (d1 != d2) {
			throw new Exception("Vectors do not have the same dimension");
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
}
