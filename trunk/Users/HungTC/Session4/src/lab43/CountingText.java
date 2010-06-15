package lab43;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class CountingText {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader("sv.txt"));
		Hashtable<Character, Integer> hash = new Hashtable<Character, Integer>();
		int i = 0;
		while (reader.read() != -1) {
			i = reader.read();

			if (hash.get((char) i) != null) {
				hash.put((char) i, hash.get((char) i) + 1);
			} else {
				hash.put((char) i, 1);
			}

			System.out.println((char) i + ": " + hash.get((char) i));

		}

	}

}
