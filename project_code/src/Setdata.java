import java.util.*;

public class Setdata {
	
	public Setdata() {
		//Constructor
	}
	
	//Function to put new keys to the hash table
	public void hashfunction(ArrayList<String[]> inputList, Hashtable<String, Integer> ht) {
		int counter = 0;
		
		for (int i = 0; i < inputList.size(); i++) {
			String newVal = inputList.get(i)[0];
			
			if (ht.containsKey(newVal) == false) {
				ht.put(newVal, ++counter);
			}
		}
	}
	
	//Getting verticies from standard input
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
		StringBuilder builder = new StringBuilder();
		
		builder.append("[");
		for (String[] row : inputList) {
			builder.append(" [");
			for (String e : row)  {
				builder.append(e + " ");
			}
			builder.append("]\n");
		}
		builder.append("]");
		
		return (builder.toString());
	}
	
	public static void main(String[] args) {
		Setdata newHash = new Setdata();
		Hashtable<String, Integer> ht = new Hashtable<>();
		
		ArrayList<String[]> inputList = newHash.addInput();
		System.out.println("\n" + newHash.toString(inputList));
		
		newHash.hashfunction(inputList, ht);
		
		Set<String> keys = ht.keySet();
		for (String key : keys) {
			System.out.println("Key: " + key + " -> Value: " + ht.get(key) + " | hashcode: " + key.hashCode());
		}
	}
}
