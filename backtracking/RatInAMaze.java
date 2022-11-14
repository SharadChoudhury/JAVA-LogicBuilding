package backtracking;

public class RatInAMaze {

	public static boolean ratInAMaze(int maze[][]){
	    int[][] visited = new int[maze.length][maze[0].length];
	    return solve(maze,0,0,visited);
	}
	    
	public static boolean solve(int maze[][], int x, int y, int[][] visited){
		if(x < 0 || x >= maze.length || y < 0 || y >= maze[0].length )
            return false;
        
        if(x == maze.length-1 && y == maze[0].length-1)
            return true;
        
        boolean ans = false;
        if(maze[x][y] == 1 && visited[x][y] == 0){
            visited[x][y] = 1;
            
            if(solve(maze, x-1, y, visited))
                ans = true;
            else if(solve(maze, x, y-1, visited))
                ans = true;
            else if(solve(maze, x, y+1, visited))
                ans =true;
			else if(solve(maze, x+1, y, visited)) 
                ans = true;
        }
        
        return ans;

	}
	
}
