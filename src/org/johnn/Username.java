/**
 * 
 */
package org.johnn;

import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

import javax.swing.SwingUtilities;

/**
 * @author John
 *
 */
public class Username {

	public static String[] alphaCAP = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
			"Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
	public static String[] alphaLOW = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
			"q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };

	public static String[] num = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

	public static String SEED = "";
	public static int MAX = 14;
	public static int MIN = 3;

	public static boolean ayyy = true;

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TextAreaOutputStreamTest.createAndShowGui();
			}
		});
		
		runthis();
	}

	public boolean isVowel(String l) {
		if (l.equalsIgnoreCase(""))
			return true;
		else
			return false;
	}

	public boolean isConsanant(String l) {
		if (l.equalsIgnoreCase(""))
			return true;
		else
			return false;
	}

	public static void runthis() {
		int l = alphaCAP.length;
		int l2 = alphaLOW.length;
		int l3 = num.length;

		while (ayyy) {
			Random rand = new Random();
			int r = rand.nextInt(MAX);

			UUID uuid = UUID.randomUUID();

			SecureRandom random = new SecureRandom();
			byte[] s = random.generateSeed(r);
			random.setSeed(UUID.randomUUID().toString().getBytes());

			// random.setSeed(SEED.getBytes());
			int length = random.nextInt(MAX);

			StringBuilder builder = new StringBuilder();

			builder.append(alphaCAP[rand.nextInt(l)]);
			for (int i = 1; i < length + 1; i++) {

				SecureRandom ran = new SecureRandom();
				byte[] see = ran.generateSeed(r);
				random.setSeed(UUID.randomUUID().toString().getBytes());

				// random.setSeed(SEED.getBytes());
				int len = random.nextInt(l2);
				builder.append(alphaLOW[len]);
				// System.out.println("Count: " + i + " Length: " +
				// length + "
				// Letter: " + alphaLOW[len]);
			}

			SecureRandom ranad = new SecureRandom();
			byte[] se3wefe = ranad.generateSeed(r);
			ranad.setSeed(UUID.randomUUID().toString().getBytes());

			// random.setSeed(SEED.getBytes());
			int len = random.nextInt(l2);

			boolean numbers = rand.nextBoolean();
			String nums = "";
			if (numbers) {
				for (int i = 1; i < rand.nextInt(5); i++) {

					SecureRandom rat4n = new SecureRandom();
					byte[] seye = rat4n.generateSeed(r);
					random.setSeed(UUID.randomUUID().toString().getBytes());

					// random.setSeed(SEED.getBytes());
					int lsen = random.nextInt(l3);
					nums += num[lsen];
					// System.out.println("Count: " + i + " Length: " +
					// length + "
					// Letter: " + alphaLOW[len]);
				}
				builder.append(nums);
			}

			String fin = builder.toString();

			System.out.println(fin);

			if (fin.equalsIgnoreCase("Overwatch")) {
				System.out.println("holy shit");
				System.exit(0);
			} else if (fin.equalsIgnoreCase("Tracer")) {
				System.out.println("life complete");
				System.exit(0);
			}

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
