import java.util.*;

public class Graph {
	//GRAPH
	public ArrayList<Boolean> mark = new ArrayList<Boolean>();
	public ArrayList<Integer> sizeDist = new ArrayList<Integer>();
	public ArrayList<Boolean> isAlive = new ArrayList<Boolean>();
	public int maxdeg;
	
	public Graph() {
		//Constructor
		isAlive.add(false);	//isAlive element 0
		
		maxdeg = 0;
	}
	
	//Initialize hash map to store edges in graph
	private Map<Integer, List<Integer> > map = new HashMap<>();
	
	public void addVertex(int identifier) {
		//Adds new vertex to graph
		
		map.put(identifier, new LinkedList<Integer>());
		isAlive.add(true); 
	}
	
	public void addEdge(int source, int dest) {
		//Adding destination element as edge to source element and vice versa
		
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
		//Returns the amount of vertices in the graph
		
		return map.keySet().size();
	}
	
	public int edgeCount() {
		//Returns the amount of edges in the graph
		
		int counter = 0;
		for (int vertex : map.keySet()) {
			counter += map.get(vertex).size();
		}
		
		int edges = counter/2;	//Edges are counted double since they go both ways
		return edges;
	}
	
	public boolean hasEdge(int source, int dest) {
		//Does this edge exist? (true/false)
		
		if (map.get(source).contains(dest)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int[] nodeDegDist() {
		//Array representing amount of vertices containing x number of edges
		
		int[] dist = new int[map.size()];
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
		return dist;
	}
	
	public int numberOfComps() {
		//Counts amount of times we enter a new component
		
		int counter = 0;
		for (int i=0; i<=map.size(); i++) {
			mark.add(false);
		}
		
		for (int n : map.keySet()) {
			if (mark.get(n).booleanValue() == false) {
				if (!map.get(n).isEmpty()) {
					counter++;
					bfs(n);
				}
			}
		}
		return counter;
	}
	
	public int[] compSizeDist() {
		//Array representing amount of components containing x number of vertices
		
		int[] c = new int[sizeDist.size()];
		for (int i=0; i<c.length; i++) {
			c[i] = sizeDist.get(i);
		}
		
		return c;
	}
	
	public void bfs(int root) {
		//Breadth first search algorithm
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		mark.set(root, true);
		queue.add(root);
		int sizeCounter = 1;
		
		while (queue.size() > 0) {
			root = queue.poll();
			
			Iterator<Integer> i = map.get(root).listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!mark.get(n)) {
					mark.set(n, true);
					queue.add(n);
					sizeCounter++;
				}
			}
		}
		
		if (sizeCounter >= sizeDist.size()) {
			for (int i=sizeDist.size(); i<=sizeCounter; i++) {
				sizeDist.add(0);
			}
			sizeDist.set(sizeCounter, 1);
		} else {
			sizeDist.set(sizeCounter, sizeDist.get(sizeCounter)+1);
		}
	}
}
