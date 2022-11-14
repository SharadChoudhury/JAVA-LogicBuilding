package Graphs;

public class connectingSameColorDots {

	//all edges means up, down , left and right
    //all edges and corners mean up, down ,left ,right and all 4 diagonal corners
	//To find a cycle containing all same chars
    int solve(String[] board, int N, int M)
	{	//Time:  O(M*N)				Space:O(M*N)
    	
        char[][] grid = new char[N][M];
        for(int i=0; i<N; i++){
            grid[i] = board[i].toCharArray();
        }
        
        boolean[][] visited = new boolean[N][M];  //very important to keep visited array here
    // if during DFS traversal of one particular colored dot, no cycle is found, then the visited dots 
    // should be marked UNVISITED after the calls are done on that cell because if we visit them again 
    // from some other starting vertex(starti,startj) then cycles might be found

        /* Eg:  3 6
				AAAAAA	    Here no cycle found from (0,0), but cycle found from (0,3) for dots of color A
				ABBABA		So it is necessary that dots traversed for (0,0) are marked unvisited also 
				BBBAAA		so that they can be used to find cycle from (0,3)
         */
        
        for(int i=0; i<N; i++){											//	O(M*N)
            for(int j=0; j<M; j++){
                boolean ans = search(grid,N,M,i,j,i,j,1, visited); 
                //System.out.println(i+" "+j+" "+ans);
                if( ans == true){
                    return 1;
                }                   
            }
        }
        
        return 0;
	}
    
    boolean search (char[][] grid, int N, int M, int i, int j,int starti, int startj,int k, boolean[][] visited){
    	//we need to keep the starti and startj so that when we reach that index during traversal
        //again with k >= 4, means we have found a proper cycle
    	if(i == starti && j == startj && k>=4)
            return true;
        
    	//out of bounds means no cycle found as we could not reach the start vertex again
        if(i<0 || i>=N || j<0 || j>=M)   
            return false;
           
        if(!visited[i][j] && grid[i][j] == grid[starti][startj]){ //same color dot at (i,j) as the start vertex
            visited[i][j] = true; 
            
            boolean res = 
                search(grid, N,M, i-1, j, starti, startj, k+1, visited) || 
                search(grid, N,M, i,   j-1, starti, startj, k+1, visited) ||
                search(grid, N,M, i,   j+1, starti, startj, k+1, visited) ||
                search(grid, N,M, i+1, j,  starti, startj, k+1, visited) ;
              
            visited[i][j] = false;        //marking unvisited
            return res;
        }
        
        return false;  //if the color of the dot is different then return false, as it will not be considered
        // for a cycle
    }
	
}
