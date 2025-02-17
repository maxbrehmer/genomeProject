import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		
		/*
		 *	HASH TABLE
		 */
		Setdata newHash = new Setdata();
		Hashtable<String, Integer> ht = new Hashtable<>();
		
		//Instructions
		if (args.length != 1) {
			System.out.println("Usage: java Main <overlap-filename>");
			return;
		}
		
		//Get filename from input
		String filename = args[0];
		
		//First iteration of input file
		try {
			//Progress counter
			int linecount = 0;
			
			FileInputStream fis = new FileInputStream(filename);
			Scanner dataScanner = new Scanner(fis);
			
			//Reading next line from file
			while (dataScanner.hasNextLine()) {
				String[] line = new String[12];
				
				for (int i=0; i<12; i++) {
					if (dataScanner.hasNext()) {
						String elem = dataScanner.next();
						line[i] = elem;
					}
				}
				
				//Adding elements to hash table
				if (line[0] != null && line[1] != null) {
					newHash.hashfunction(line, ht);
				}
				
				dataScanner.nextLine();
				
				//Counting lines in stderr
				linecount++;
				if (linecount%1000 == 0) {
					System.err.print("LINES SCANNED FOR HASH TABLE: " + linecount + "\r");
				}
			}
			System.err.println();
			
			dataScanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		 *	GRAPH
		 */
		Graph g = new Graph();
		
		//Adding all vertices to graph
		for (String key : ht.keySet()) {
			g.addVertex(ht.get(key));
		}
		
		//Second iteration of input file
		try {
			int linecount = 0;
			
			FileInputStream fis = new FileInputStream(filename);
			Scanner graphScanner = new Scanner(fis);
			
			//Reading next line from file
			while (graphScanner.hasNextLine()) {
				String[] line = new String[12];
				
				for (int i=0; i<12; i++) {
					if (graphScanner.hasNext()) {
						String elem = graphScanner.next();
						line[i] = elem;
					}
				}
				
				//Adding edges and removing overlapped contigs
				if (line[0] != null && line[1] != null && line[5] != null && line[6] != null && line[7] != null && line[9] != null && line[10] != null && line[11] != null) {
					if (Integer.parseInt(line[10]) - Integer.parseInt(line[9]) == Integer.parseInt(line[11])) {
						g.isAlive.set(ht.get(line[1]), false);
					} else if (Integer.parseInt(line[6]) - Integer.parseInt(line[5]) == Integer.parseInt(line[7])) {
						g.isAlive.set(ht.get(line[0]), false);
					}
					
					if (g.isAlive.get(ht.get(line[0])) == true && g.isAlive.get(ht.get(line[1])) == true) {
						g.addEdge(ht.get(line[0]), ht.get(line[1]));
					}
				}
				graphScanner.nextLine();
				
				//Counting lines in stderr
				linecount++;
				if (linecount%1000 == 0) {
					System.err.print("LINES SCANNED FOR GRAPH: " + linecount + "\r");
				}
			}
			graphScanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//STDOUT
		System.out.println("\nNumber of vertices: " + g.vertexCount());
		System.out.println("\nNumber of edges: " + g.edgeCount());
		
		System.out.println("\nNode degree distribution:");
		int[] ndd = g.nodeDegDist();
		for (int i = 1; i<=g.maxdeg; i++) {
			if (ndd[i] > 0) {
				System.out.println(i + " : " + ndd[i]);
			}
		}
		
		int noc = g.numberOfComps();
		System.out.println("\nNumber of components: " + noc);
		
		System.out.println("\nComponent size distribution:");
		int[] csd = g.compSizeDist();
		for (int i=0; i<csd.length; i++) {
			if (csd[i] > 0) {
				System.out.println(i + " : " + csd[i]);
			}
		}
		System.out.println();
		
	}
}
