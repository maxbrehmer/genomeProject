import java.util.*;

public class Setdata {
	
	public Setdata() {
		//Constructor
	}
	
	public void hashfunction(ArrayList<String> inputList, Hashtable<Integer, String> ht) {
		int current;
		
		for (int i = 0; i < inputList.size(); i++) {
			String newVal = inputList.get(i);
			current = newVal.hashCode();
			
			if (ht.containsValue(newVal) == false) {
				ht.put(current, newVal);
				System.out.println("Added " + newVal + " to index " + current);
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
		Hashtable<Integer, String> ht = new Hashtable<>();
		
		ArrayList<String> inputList = newHash.addInput();
		System.out.println("\n" + inputList);
		
		newHash.hashfunction(inputList, ht);
	}
}
