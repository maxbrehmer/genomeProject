import java.util.*;

public class Graph<T> {
	//GRAPH
	
	public Graph() {
		//Constructor
	}
	
	//Use hashmap to store edges in graph
	private Map<T, List<T> > map = new HashMap<>();
	
	//Adds new vertex to graph
	public void addVertex(T identifier) {
		map.put(identifier, new LinkedList<T>());
	}
	
	public void addEdge(T source, T dest) {
		if (!map.containsKey(source)) { 
			addVertex(source);
		}
		
		if (!map.containsKey(dest)) {
			addVertex(dest);
		}
		
		if (!map.get(source).contains(dest)) {
			map.get(source).add(dest);
		}
		
		if (!map.get(dest).contains(source)) {
			map.get(dest).add(source);
		}
		
	}
	
	public void vertexCount() {
		System.out.println("Number of verticies: " + map.keySet().size());
	}
	
	public void edgeCount() {
		int counter = 0;
		int edges;
		for (T vertex : map.keySet()) {
			counter += map.get(vertex).size();
		}
		
		//Halve or edges are counted double
		edges = counter/2;
		System.out.println("Number of edges: " + edges);
	}
	
	public void nodeDegDist() {
		int[] dist = new int[map.size()];
		int maxdeg = 0;
		for (T vertex : map.keySet()) {
			int counter = 0;
			for (T edge : map.get(vertex)) {
				counter++;
			}
			dist[counter] += 1;
			if (counter > maxdeg) {
				maxdeg = counter;
			}
		}
		System.out.println("\nNode degree distribution: ");
		for (int i = 1; i<=maxdeg; i++) {
			System.out.println(i + " : " + dist[i]);
		}
	}
	
	public void numberOfComps() {
		//TODO
	}
	
	public void compSizeDist() {
		//TODO
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		for (T vertex : map.keySet()) {
			builder.append(vertex.toString() + ": [");
			for (T edge : map.get(vertex))  {
				builder.append(edge.toString() + " ");
			}
			builder.append("]\n");
		}
		
		return (builder.toString());
	}
}


