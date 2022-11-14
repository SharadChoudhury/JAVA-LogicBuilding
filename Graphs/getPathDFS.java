package Graphs;
import java.util.*;

public class getPathDFS {

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
        
        int x = s.nextInt();
        int y = s.nextInt();
        
        ArrayList<Integer> res = getPath(adjMat, x, y);
		if(res != null){
            for(int i: res)
                System.out.print(i+" ");
        }

	}
    
    
    public static ArrayList<Integer> getPath(int[][] edges, int v1, int v2) {
		boolean[] visited = new boolean[edges.length];  
		return getPath(edges,visited,v1,v2);
	}
	
    
	public static ArrayList<Integer> getPath(int[][] edges, boolean[] visited, int v1, int v2) {
		
        if(v1 == v2){
            ArrayList<Integer> res = new ArrayList<>();
            res.add(v1);
            return res;
        }
        
        visited[v1] = true; 
        
		for(int j=0; j<edges.length; j++) {
			if(edges[v1][j] == 1 && !visited[j]){
                ArrayList<Integer> res = getPath(edges, visited, j, v2);
                if(res != null){
                    res.add(v1);
                    return res;
                }  
            }				
		}
        
        return null;
	}
	
}
