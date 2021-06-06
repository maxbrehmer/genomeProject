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
		Graph g = new Graph();
		
		for (int i=1; i<=ht.size(); i++) {
			g.addVertex(i);
		}
		for (int i=0; i<ht.size(); i++) {
			if (i < inputList.size()) {
				g.addEdge(ht.get(inputList.get(i)[0]), ht.get(inputList.get(i)[1]));
			}
		}
		
		System.out.println("\nGraph:\n" + g.toString());
		
		System.out.println("\nNode degree distribution: ");
		g.nodeDegDist();
		
		System.out.println("\nBFS:");
		int noc = g.numberOfComps();
		System.out.println("\nNumber of components: " + noc);
		
		int[] csd = g.compSizeDist();
		System.out.print("\n<");
		for (int i=0; i<csd.length; i++) {
			System.out.print(csd[i] + " ");
		}
		System.out.print(">\n");
	}
}
