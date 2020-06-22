import textprocessing.BoyerMoore;
import textprocessing.BruteForceMatch;
import textprocessing.In;
import textprocessing.KMP;

public class Task41
{
	public static void main(String[] args) {

		In input = new In("Hard disk.txt");
		String str = input.readAll();
		String pattern[] = { "hard", "disk", "hard disk", "hard drive", "hard dist", "xltpru" }; 
		
		int sourceIndex, output, offset; 
		String newStr;
		double t1, t2;

		// Brute Force Match
		System.out.println("The Brute Force Match\n");
		for (int i = 0; i < pattern.length; i++) {

			t1 = System.currentTimeMillis();
			for (int j = 0; j < 100; j++) {
				sourceIndex = 0;
				output = 0;
				do {
					newStr = str.substring(sourceIndex);
					offset = BruteForceMatch.search1(pattern[i], newStr);
					if (offset + sourceIndex < str.length()) {

						output++;
						sourceIndex += offset + pattern[i].length();
					}

				} while (offset != newStr.length());

				output = 0;
			}
			t2 = System.currentTimeMillis();
			System.out.println("The CPU Time for finding all the occurences of \"" + pattern[i] + "\" : "
					+ (t2 - t1) / 100 + " milli second" + "\n");
		}

		// Boyer Moore
		System.out.println("\nBoyerMoore\n");
		for (int i = 0; i < pattern.length; i++) {

			BoyerMoore bm = new BoyerMoore(pattern[i]);
			t1 = System.currentTimeMillis();
			for (int j = 0; j < 100; j++) {
				sourceIndex = 0;
				output = 0;
				do {
					newStr = str.substring(sourceIndex);
					offset = bm.search(newStr);
					if (offset + sourceIndex < str.length()) {

						output++;
						sourceIndex += offset + pattern[i].length();
					}

				} while (offset != newStr.length());

				output = 0;
			}
			t2 = System.currentTimeMillis();
			System.out.println("The CPU Time for finding all the occurences of \"" + pattern[i] + "\" : "
					+ (t2 - t1) / 100 + " milli second" + "\n");
		}

		// KMP
		System.out.println("\nKMP\n");
		for (int i = 0; i < pattern.length; i++) {

			KMP kmp = new KMP(pattern[i]);
			t1 = System.currentTimeMillis();
			for (int j = 0; j < 100; j++) {
				sourceIndex = 0;
				output = 0;
				do {
					newStr = str.substring(sourceIndex);
					offset = kmp.search(newStr);
					if (offset + sourceIndex < str.length()) {

						output++;
						sourceIndex += offset + pattern[i].length();
					}

				} while (offset != newStr.length());
//						
				output = 0;
			}
			t2 = System.currentTimeMillis();
			System.out.println("The CPU Time for finding all the occurences of \"" + pattern[i] + "\" : "
					+ (t2 - t1) / 100 + " milli second" + "\n");

		}

	}
}