import textprocessing.In;
import textprocessing.TST;

public class Task42
{
	public static void main(String[] args) {
		In input = new In("Protein.txt");
		String str = input.readAll();

		String[] tokens = str.split(" ");

		TST<Integer> st = new TST<Integer>();
		for (int i = 0; i < tokens.length; i++) {

			st.put(tokens[i], i);
		}

		String keys[] = { "protein", "complex", "PPI", "prediction", "network", "obligate", "of", "solvent" };
		for (int i = 0; i < keys.length; i++) {
			System.out.println("The Occurrence of " + keys[i] + ": " + st.get(keys[i]));
		}
	}
}
