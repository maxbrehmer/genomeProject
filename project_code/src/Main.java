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
				
				if (Integer.parseInt(inputList.get(i)[10]) - Integer.parseInt(inputList.get(i)[9]) == Integer.parseInt(inputList.get(i)[11])) {
					g.isAlive.set(ht.get(inputList.get(i)[1]), false);
				} else if (Integer.parseInt(inputList.get(i)[6]) - Integer.parseInt(inputList.get(i)[5]) == Integer.parseInt(inputList.get(i)[7])) {
					g.isAlive.set(ht.get(inputList.get(i)[0]), false);
				}
				
				if ((g.isAlive.get(ht.get(inputList.get(i)[0])) == true) && (g.isAlive.get(ht.get(inputList.get(i)[1])) == true)) {
					g.addEdge(ht.get(inputList.get(i)[0]), ht.get(inputList.get(i)[1]));
				}
			}
		}
		
		System.out.println("\nGraph:\n" + g.toString());
		
		System.out.println("\nNode degree distribution:");
		int[] ndd = g.nodeDegDist();
		for (int i = 1; i<=g.maxdeg; i++) {
			System.out.println(i + " : " + ndd[i]);
		}
		
		int noc = g.numberOfComps();
		System.out.println("\nNumber of components: " + noc);
		
		System.out.println("\nComponent size distribution:");
		int[] csd = g.compSizeDist();
		for (int i=0; i<csd.length; i++) {
			System.out.println(i + " : " + csd[i]);
		}
		System.out.print("\n");
	}
}
