package Graphs;
import java.util.*;

public class GraphConstruct {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);		
		int vertices = s.nextInt();
		int edges = s.nextInt(); 
		
		int[][] adjMat = new int[vertices][vertices];
		
		for(int i=0; i<edges ; i++) {
			int v1 = s.nextInt();
			int v2= s.nextInt();
			adjMat[v1][v2] = 1;
			adjMat[v2][v1] = 1;
		}
		
		BFStraversal.printBFS(adjMat);	
		int x = s.nextInt();
        int y = s.nextInt();
		System.out.println( hasPath.isPathDFS(adjMat, x, y) );
	}

}
