package Graphs;
import java.util.*;

public class GetPathBFS {

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
        
        ArrayList<Integer> res = getPathBFS(adjMat, x, y);
		if(res != null){
            for(int i: res)
                System.out.print(i+" ");
        }

	}
	
	//BFS path is the shortest path
	public static ArrayList<Integer> getPathBFS(int[][] edges, int v1, int v2) {
		//visited array is always required to prevent cycles and infinite looping
		boolean[] visited = new boolean[edges.length];  		
		return getPathBFS(edges, visited, v1, v2);
	}
	
	public static ArrayList<Integer> getPathBFS(int[][] edges, boolean[] visited, int v1, int v2) {
		HashMap<Integer,Integer> map = new HashMap<>();  //to keep track of parent of each vertex(the parent
		//vertex that pushed this vertex into the queue
		Queue<Integer> q  = new LinkedList<Integer>();
        
		q.add(v1);
		visited[v1] = true;
        
		while(!q.isEmpty()) {
			int vertex = q.poll();
			
			for(int j=0; j<edges.length; j++) {
				if(edges[vertex][j] == 1 && !visited[j]) {
					q.add(j);
					visited[j] = true;
					map.put(j,vertex);			//vertex is the parent of j
					
					if(j == v2) {				//found the destination vertex
						ArrayList<Integer> res = new ArrayList<>();
						res.add(j);
			            while(j != v1) {
			            	res.add(map.get(j));
			            	j = map.get(j);
			            }
			            return res;
					}
				}				
			}
		}
		
		return null;
		
	}

}
