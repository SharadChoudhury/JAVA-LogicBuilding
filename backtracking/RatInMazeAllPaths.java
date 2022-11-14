package backtracking;

public class RatInMazeAllPaths {

	static void ratInAMaze(int maze[][], int n) {
		int[][] visited = new int[n][n];
        solve(maze,0,0,visited,n);        
	}
    
    static void solve(int maze[][], int x, int y, int[][] visited, int n){
		if(x < 0 || x >= n || y < 0 || y >= n )
            return;
        
        if(x == n-1 && y == n-1){
            visited[x][y] = 1;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    System.out.print(visited[i][j]+" ");
                }
            }
            System.out.println();
        }
        
        if(maze[x][y] == 1 && visited[x][y] == 0){
            visited[x][y] = 1;
            
            solve(maze, x-1, y, visited,n);
            solve(maze, x+1, y, visited,n);
			solve(maze, x, y-1, visited,n);
			solve(maze, x, y+1, visited,n);
				
            visited[x][y] = 0;
        }
        

	}
	
}
