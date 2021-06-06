import java.util.*;
import java.io.*;

public class Graph {
	//GRAPH
	boolean visited;
	
	public Graph() {
		//Constructor
	}
	
	//Use hashmap to store edges in graph
	private Map<Integer, List<Integer> > map = new HashMap<>();
	
	//Adds new vertex to graph
	public void addVertex(int identifier) {
		map.put(identifier, new LinkedList<Integer>());
	}
	
	public void addEdge(int source, int dest) {
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
	
	public int vertexCount() {
		return map.keySet().size();
	}
	
	public int edgeCount() {
		int counter = 0;
		int edges;
		for (int vertex : map.keySet()) {
			counter += map.get(vertex).size();
		}
		
		//Halve or edges are counted double
		edges = counter/2;
		return + edges;
	}
	
	public boolean hasEdge(int source, int dest) {
		if (map.get(source).contains(dest)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void nodeDegDist() {
		int[] dist = new int[map.size()];
		int maxdeg = 0;
		for (Integer vertex : map.keySet()) {
			int counter = 0;
			for (Integer edge : map.get(vertex)) {
				counter++;
			}
			dist[counter] += 1;
			if (counter > maxdeg) {
				maxdeg = counter;
			}
		}
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
	
	public void bfs(int root) {
		//TODO
		ArrayList<Boolean> visited = new ArrayList<Boolean>();
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		for (int i=0; i<=map.size(); i++) {
			visited.add(false);
		}
		visited.set(root, true);
		queue.add(root);
		
		while (queue.size() > 0) {
			root = queue.poll();
			System.out.print(root + " ");
			
			Iterator<Integer> i = map.get(root).listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited.get(n)) {
					visited.set(n, true);
					queue.add(n);
				}
			}
		}
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		for (Integer vertex : map.keySet()) {
			builder.append(vertex.toString() + ": [");
			for (Integer edge : map.get(vertex))  {
				builder.append(edge.toString() + " ");
			}
			builder.append("]\n");
		}
		
		return (builder.toString());
	}
	
	public static void main(String[] args) {
		
	}
}
