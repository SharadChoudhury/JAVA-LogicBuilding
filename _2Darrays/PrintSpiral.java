package _2Darrays;

import java.util.Scanner;

public class PrintSpiral {

	public static void spiralPrint(int matrix[][]){
		//Your code goes here
        int m=matrix.length;
        
        if(m>0){
            
            int n=matrix[0].length;
            int rs=0,re=m-1;
            int cs=0,ce=n-1;
            
            int count=0;
            
            while(count!=m*n){
                
                int i=rs;
                int j=cs;
                
                while(j<=ce){
                    System.out.print(matrix[i][j]+" ");
                    count++;
                    j++;
                }
                rs=rs+1;
                i=rs;
                j=j-1;
                
                while(i<=re){
                    System.out.print(matrix[i][j]+" ");
                    count++;
                    i++;
                }
                ce=ce-1;
                j=ce;
                i=i-1;
                
                while(j>=cs){
                    System.out.print(matrix[i][j]+" ");
                    count++;
                    j--;
                }
                re=re-1;
                i=re;
                j=j+1;
                
                while(i>=rs){
                    System.out.print(matrix[i][j]+" ");
                    count++;
                    i--;
                }
                cs=cs+1;
            
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
		
		spiralPrint(mat);
		
	}

}
