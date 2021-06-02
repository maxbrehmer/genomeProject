import java.util.*;
import java.lang.Math;

public class HashTable {
	
	String[] tableArray;
	int arraySize;
	
	public HashTable(int size) {
		//Constructor
		arraySize = size;
		tableArray = new String[size];
	}
	
	public void hashFunction(ArrayList<String> inputList, String[] tableArray) {
		int current;
		
		for (int i = 0; i < inputList.size(); i++) {
			String newVal = inputList.get(i);
			current = Math.abs(newVal.hashCode()) % tableArray.length;
			
			while (true) {
				if (tableArray[current] == null) {
					tableArray[current] = newVal;
					break;
				}
				else {
					current++;
					if (current >= tableArray.length) {
						current = 0;
					}
				}
			}
			
			System.out.println("Added " + newVal + " to index " + current);
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
		HashTable newHash = new HashTable(10);
		
		ArrayList<String> inputList = newHash.addInput();
		System.out.println(inputList);
		
		newHash.hashFunction(inputList, newHash.tableArray);
		for (int j = 0; j < inputList.size(); j++) {
			System.out.println(inputList.get(j).hashCode());
		}
	}
	
}
