package calculate;

import java.util.Date;

public class Threads {

	static int[] z1;
	static int[] z2;
	static int[] erg;

	public static void main(String[] args) {
		int anzahl = 5000;
		// System.out.println("Anzahl: " + anzahl);
		for (int i = 0; i < 1000; i++) {
			System.out.print(starteThreads(anzahl) + ",");
		}
	}

	public static long starteThreads(int anzahl) {
		z1 = new int[anzahl];
		z2 = new int[anzahl];
		erg = new int[anzahl];
		Date start = new Date();
		addiere(z1, z2);
		while (java.lang.Thread.activeCount() > 1) {

		}
		Date ende = new Date();
		return (ende.getTime() - start.getTime());
	}

	public static void addiere(int[] z1, int[] z2) {
		for (int i = 0; i < z1.length; i++) {
			final int j = i;
			new Thread(new Runnable() {
				public void run() {
					erg[j] = z1[j] + z2[j];
				}
			}).start();
			// System.out.println(java.lang.Thread.activeCount());
		}
	}
}
