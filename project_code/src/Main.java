import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		
		
		//if (args.length > 0) {
			//System.out.println(Arrays.toString(args));
			//return;
		//}
		/*
		 *	HASH TABLE
		 */
		Setdata newHash = new Setdata();
		Hashtable<String, Integer> ht = new Hashtable<>();
		
		//Replace with desired input file
		String filename = args[0];
		
		try {
			//Progress counter
			int linecount = 0;
			
			FileInputStream fis = new FileInputStream(filename);
			Scanner dataScanner = new Scanner(fis);
			
			while (dataScanner.hasNextLine()) {
				String[] line = new String[12];
				
				for (int i=0; i<12; i++) {
					if (dataScanner.hasNext()) {
						String elem = dataScanner.next();
						line[i] = elem;
					}
				}
				if (line[0] != null && line[1] != null) {
					newHash.hashfunction(line, ht);
				}
				
				dataScanner.nextLine();
				linecount++;
				if (linecount%1000 == 0) {
					System.err.print("LINES SCANNED: " + linecount + "\r");
				}
			}
			System.err.println("\n");
			
			dataScanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		/*
		 *	GRAPH
		 */
		Graph g = new Graph();
		
		for (String key : ht.keySet()) {
			g.addVertex(ht.get(key));
		}
		
		try {
			int linecount = 0;
			
			FileInputStream fis = new FileInputStream(filename);
			Scanner graphScanner = new Scanner(fis);
			
			while (graphScanner.hasNextLine()) {
				String[] line = new String[12];
				
				for (int i=0; i<12; i++) {
					if (graphScanner.hasNext()) {
						String elem = graphScanner.next();
						line[i] = elem;
					}
				}
				
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
				
				linecount++;
				if (linecount%1000 == 0) {
					System.err.print("LINES SCD: " + linecount + "\r");
				}
			}
			graphScanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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
		System.out.print("\n");
		
	}
}
