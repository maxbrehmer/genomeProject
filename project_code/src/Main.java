import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		/*
		 *	HASH TABLE
		 */
		Setdata newHash = new Setdata();
		Hashtable<String, Integer> ht = new Hashtable<>();
		
		//Replace with desired input file
		String filename = "../../data_folder/lines_100k.txt";
		
		try {
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
			}
			
			dataScanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Hash table size: " + ht.size());
		
		/*
		 *	GRAPH
		 */
		Graph g = new Graph();
		
		for (String key : ht.keySet()) {
			g.addVertex(ht.get(key));
		}
		
		try {
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
			}
			graphScanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//System.out.println("\nGraph:\n" + g.toString());
		
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
