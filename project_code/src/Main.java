import java.util.*;

public class Main {
	public static void main(String[] args) {
		/*
		 *	HASH TABLE
		 */
		Setdata newHash = new Setdata();
		Hashtable<String, Integer> ht = new Hashtable<>();
		
		ArrayList<String[]> inputList = newHash.addInput();
		
		newHash.hashfunction(inputList, ht);
		
		Set<String> keys = ht.keySet();
		for (String key : keys) {
			System.out.println("Key: " + key + " -> Value: " + ht.get(key) + " | hashcode: " + key.hashCode());
		}
		
		/*
		 *	GRAPH
		 */
		Graph<Integer> g = new Graph<Integer>();
		
		for (int i=1; i<=ht.size(); i++) {
			g.addVertex(i);
		}
		
		System.out.println("\nGraph:\n" + g.toString());
	}
}
