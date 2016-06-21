package calculate;

public class Threads {

	static int[] z1;
	static int[] z2;
	static int[] erg = new int[10];
	static int count = 0;

	public static void main(String[] args) {
		z1 = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		z2 = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		addiere(z1, z2);
		for (int i = 0; i < erg.length; i++) {
			System.out.print(erg[i] + " ");
		}

	}

	public static void addiere(int[] z1, int[] z2) {
		for (int i = 0; i < z1.length; i++) {
			final int j = i;
			new Thread(new Runnable() {
				public void run() {
					erg[j] = z1[j] + z2[j];
					count++;
				}
			}).start();
		}
		while (count != z1.length) {
			System.out.println(count);
		}
	}
}
