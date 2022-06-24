package Recursion;

public class StaircaseWays {
    public static int staircase(int n) {
    	if(n<0)
    		return 0;
//n=0 is important case. When you are at stair 0 and total steps are 0, there is 1 way to 
//achieve that by just standing at step 0.
    	if(n==1 || n==0 ) 
    		return 1;
    	int x =staircase(n-1);
    	int y= staircase(n-2);
    	int z= staircase(n-3);
    	return x+y+z;
    	
    }
	
	
	public static void main(String[] args) {
		System.out.println(staircase(5));
	}

}
