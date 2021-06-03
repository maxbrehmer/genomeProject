import java.util.*;

public class Setdata {
	
	public Setdata() {
		//Constructor
	}
	
	public void hashfunction(ArrayList<String> inputList, Hashtable<String, Integer> ht) {
		int counter = 0;
		
		for (int i = 0; i < inputList.size(); i++) {
			String newVal = inputList.get(i);
			
			if (ht.containsKey(newVal) == false) {
				ht.put(newVal, ++counter);
			}
		}
	}
	
	public ArrayList<String> addInput() {
		ArrayList<String> inputList = new ArrayList<String>();
		
		try (Scanner myScanner = new Scanner(System.in)) {
			int current = 0;
			
			while (myScanner.hasNext()) {
				String s = myScanner.next();
				inputList.add(s);
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
