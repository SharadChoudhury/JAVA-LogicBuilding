package Graphs;
import java.util.*;

/*
	Given an undirected, connected and weighted graph G(V, E) with V number of vertices 
	(which are numbered from 0 to V-1) and E number of edges.
	Find and print the Minimum Spanning Tree (MST) using Kruskal's algorithm.
	
	For printing MST follow the steps -
	1. 	In one line, print an edge which is part of MST in the format - 
		v1 v2 w
		where, v1 and v2 are the vertices of the edge which is included in MST and whose weight is w.
 		And v1  <= v2 i.e. print the smaller vertex first while printing an edge.
	2. 	Print V-1 edges in above format in different lines.
	
	Note : Order of different edges doesn't matter.
	
	Input Format :
		Line 1: Two Integers V and E (separated by space)
		Next E lines : Three integers ei, ej and wi, denoting that there exists an edge between vertex ei and vertex ej with weight wi (separated by space)
*/




class Edge implements Comparable<Edge>{  //if we implement comparable interface here directly then 
	// we need not create any other class to override comparator and while calling Arrays.sort()
	// or Collections.sort() the sorting is done automatically without passing any extra parameter
    int sv;
    int ev;
    int weight;
    
	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}  
}


public class kruskalAlgo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		ArrayList<Edge> input = new ArrayList<Edge>();
		ArrayList<Edge> output = new ArrayList<Edge>();
		int[] parents = new int[V];
		
		//taking input
		for(int i=0; i<E; i++) {
			Edge e = new Edge();
			int x = sc.nextInt();
			int y = sc.nextInt();
            e.sv = Math.min(x,y);
            e.ev = Math.max(x,y);
			e.weight = sc.nextInt();
			input.add(e);
		}
		
		//initializing parents array
		for(int i=0; i<V; i++) {
			parents[i] = i;
		}
		
		//sort input list of edges so that weights are in sorted order
		Collections.sort(input);
		
		//count of edges
		int count = 0;
		int i=0;
		
		//union find algo implementation
		while(count != V-1) {
			Edge current = input.get(i);
			int v1= current.sv;
			int v2 = current.ev;
			
			while(parents[v1] != v1) {
				v1 = parents[v1];
			}
			while(parents[v2] != v2) {
				v2 = parents[v2];
			}
			
			//after the while loops, v1 = parent[v1]  and  v2 = parent[v2]			
			//add edge to spanning tree or output only if top parents are different,
			//i.e they are connected (they have a path between them)
			if(v1 != v2) { 
				output.add(current);
				count++;  //increment count each time we add an edge
				parents[v1] = v2;  //update parent of any of v1 or v2 (very important step)
			}
			
			//move to next edge in input edges list
			i++;			
		}
		

		for(Edge v: output) {
			System.out.println(v.sv + " "+ v.ev + " "+ v.weight);
		}
		
	}
}