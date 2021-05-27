import java.util.Scanner;

public class SetData {
	
	public void Setdata() {
		//Constructor
	}
	
	public static void hashFunction(int arraySize) {
		String[] identifiers = new String[arraySize];
		try (Scanner myScanner = new Scanner(System.in)) {
			int current = 0;
			
			while (myScanner.hasNext()) {
				String s = myScanner.next();
				if (s.charAt(0) == 'f') {
					identifiers[current] = s;
					current++;
				}
			}
		}
		System.out.println(identifiers[1]);
	}
}
