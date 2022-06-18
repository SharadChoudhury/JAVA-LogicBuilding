package Recursion;

public class All_Indexes_found {
	
	public static int[] allIndexes(int input[], int x) {
		return allIndexes(input,x,0,0);
	}
    
    private static int[] allIndexes(int input[],int x, int start, int size) {
        if(start == input.length){
            return new int[size];
        }
        
        if(input[start]==x){
            int[] smallans = allIndexes(input,x,start+1,size+1);
            smallans[size] = start;
            return smallans;
        }
         else{
            int[] smallans = allIndexes(input,x,start+1,size); 
             return smallans;
         }   

    }
	
	public static void main(String[] args) {
		int input[] = {8,5,2,5,2,5};
		int[] res=allIndexes(input,9);
		for(int k:res)
			System.out.print(k+" ");

	}

}
