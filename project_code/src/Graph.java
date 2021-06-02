import java.util.*;

public class Graph {
	//GRAPH
	//Function to add edge
	public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
		
		if (adj.get(u).contains(v) == false) {
			adj.get(u).add(v);
			adj.get(v).add(u);
		}
	}
	
	//Function to print the graphs edges
	public static void printGraph(ArrayList<ArrayList<Integer>> adj) {
		for (int i = 0; i < adj.size(); i++) {
			System.out.println("\nAdjacency list of vertex " + i);
			System.out.print("head");
			for (int j = 0; j < adj.get(i).size(); j++) {
				System.out.print(" -> " + adj.get(i).get(j));
			}
			System.out.println();
		}
	}
}
