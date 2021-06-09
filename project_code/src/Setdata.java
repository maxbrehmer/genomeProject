import java.util.*;

public class Setdata {
	
	public Setdata() {
		//Constructor
	}
	
	//Function to put new keys to the hash table
	public void hashfunction(String[] inputRow, Hashtable<String, Integer> ht) {
		int counter = 0;
		
		for (int j=0; j<2; j++) {
			String newVal = inputRow[j];
			
			if (ht.containsKey(newVal) == false) {
				ht.put(newVal, ht.size());
			}
		}
	}
}
