package Arrays;

public class leadersInArray {
//An array element A[i] is called Leader, if all the elements following it
//(i.e. present at its right) are less than or equal to A[i].
//Print all the leader elements separated by space and in the same order
//they are present in the input array.
	
	public static void main(String[] args) {

		int[] input= {13, 17, 5, 4, 6, 0, -4};
		
		//time : O(n)
		//space: O(1)
		
		int n=input.length;
        int max = Integer.MIN_VALUE;
        String res="";
        
        for(int i=n-1;i>=0;i--){
            if(input[i]>=max){  //because less than or equal
                max=input[i];
                res=max+" "+res;
            }
        }
        System.out.println(res);
	}

}
