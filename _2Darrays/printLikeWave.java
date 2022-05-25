package _2Darrays;

import java.util.Scanner;

public class printLikeWave {
	
	public static void wavePrint(int mat[][]){
		//Your code goes here
        int m=mat.length;
        
        if(m>0){
          	int n=mat[0].length;
        
            for(int j=0;j<n;j++){
                if(j%2==0){
                    for(int i=0;i<m;i++)
                        System.out.print(mat[i][j]+" ");
                }
                else{
                    for(int i=m-1;i>=0;i--)
                        System.out.print(mat[i][j]+" ");
                }
            }  
        }
        
        else{
            return;
        }      
        
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int m= s.nextInt();
		int n=s.nextInt();
		int[][] mat= new int[m][n];
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				mat[i][j]=s.nextInt();
			}
		}
		
		wavePrint(mat);
		
	}

}
