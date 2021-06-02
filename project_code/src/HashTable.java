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
	
	public void hashFunction(String[] inputArray, String[] tableArray) {
		int current;
		
		for (int i = 0; i < inputArray.length; i++) {
			String newVal = inputArray[i];
			current = Math.abs(newVal.hashCode()) % inputArray.length;
			
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
	
	public static ArrayList<String> addInput() {
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
		
		String[] inputArray = {"fp3.luci_01A01.ctg.ctg7180000038386", "fp3.luci_02C06.ctg.ctg7180000060335", "fp3.luci_02C06.ctg.ctg7180000085546", "fp3.luci_02C06.ctg.ctg7180000085693", " ", "alfons åberg", "a", "3"};
		newHash.hashFunction(inputArray, newHash.tableArray);
		
		System.out.println("\nTest");
		for (int i=0; i<inputArray.length; i++) {
			System.out.println(inputArray[i].hashCode());
		}
		
		ArrayList<String> inputList = addInput();
		System.out.println(inputList);
	}
	
}
