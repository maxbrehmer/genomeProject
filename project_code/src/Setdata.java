import java.util.*;

public class Setdata {
	
	public Setdata() {
		//Constructor
	}
	
	//Function to put new keys to the hash table
	public void hashfunction(ArrayList<String> inputList, Hashtable<String, Integer> ht) {
		int counter = 0;
		
		for (int i = 0; i < inputList.size(); i++) {
			String newVal = inputList.get(i);
			
			if (ht.containsKey(newVal) == false) {
				ht.put(newVal, ++counter);
			}
		}
	}
	
	//Getting verticies from standard input
	public ArrayList<String> addInput() {
		ArrayList<String> inputList = new ArrayList<String>();
		
		try (Scanner myScanner = new Scanner(System.in)) {
			int current = 0;
			
			while (myScanner.hasNext()) {
				String s = myScanner.next();
				
				//New row (identifier) every 12 inputs
				if ((current)%12 == 0) {
					inputList.add(s);
				}
				current++;
			}
		}
		
		return inputList;
	}
	
	public static void main(String[] args) {
		Setdata newHash = new Setdata();
		Hashtable<String, Integer> ht = new Hashtable<>();
		
		ArrayList<String> inputList = newHash.addInput();
		System.out.println("\n" + inputList);
		
		newHash.hashfunction(inputList, ht);
		
		Set<String> keys = ht.keySet();
		for (String key : keys) {
			System.out.println("Key: " + key + " -> Value: " + ht.get(key) + " | hashcode: " + key.hashCode());
		}
	}
}
