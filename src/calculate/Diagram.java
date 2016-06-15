package calculate;

public class Diagram {

	public static double max_dif = 100;
	public static double abstand = 30;

	public static void main(String[] args) {
		for (double i = 0; i < max_dif; i += 0.1) {
			if (i < abstand) {
				System.out.println(i + " " + i / (i * i));
			} else {
				System.out.println(i + " " + 0);
			}
		}
	}

}
