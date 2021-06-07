import java.util.*;

public class Setdata {
	
	public Setdata() {
		//Constructor
	}
	
	//Function to put new keys to the hash table
	public void hashfunction(ArrayList<String[]> inputList, Hashtable<String, Integer> ht) {
		int counter = 0;
		
		for (int i = 0; i < inputList.size(); i++) {
			for (int j=0; j<2; j++) {
				String newVal = inputList.get(i)[j];
				
				if (ht.containsKey(newVal) == false) {
					ht.put(newVal, ++counter);
				}
			}
		}
	}
	
	//Getting vertices from standard input
	public ArrayList<String[]> addInput() {
		ArrayList<String[]> inputList = new ArrayList<String[]>();
		
		try (Scanner myScanner = new Scanner(System.in)) {
			int current = 0;
			
			while (myScanner.hasNext()) {
				String[] row = new String[12];
				
				inputList.add(row);
				for (int i=0; i<12; i++) {
					if (myScanner.hasNext()) {
						String s = myScanner.next();
						inputList.get(current)[i] = s;
					}
				}
				current++;
			}
		}
		
		return inputList;
	}
	
	public String toString(ArrayList<String[]> inputList) {
		//Representing input list as a string
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("[");
		for (String[] row : inputList) {
			builder.append(" [");
			for (String e : row)  {
				builder.append(e + " ");
			}
			builder.append("] ");
		}
		builder.append("]");
		
		return (builder.toString());
	}
}
