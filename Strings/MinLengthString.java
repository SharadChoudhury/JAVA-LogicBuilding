package Strings;

public class MinLengthString {
// If multiple words are of same length, then answer will be first minimum length word in the string.
//	Words are separated by single space only
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			 String input=" thdgs jhfstwk jf";
			 
//trimming is done otherwise arr[0]="" ( 0 length) and minStr will be "" 
	
		        int min=Integer.MAX_VALUE;
		        String minStr="";

		 //method 1 :using built-in "split" function
		        
//				String[] arr= input.trim().split(" "); 
//		        for(int i=0;i<arr.length;i++){
//		            if(arr[i].length() < min){
//		                 min= arr[i].length();
//		                 minStr= arr[i];
//		            }                        
//		        }
		        
		       
		      //method 2 : Naive approach	
		        input=input.trim();
		        for(int i=0;i<input.length();) {
		        	int len=0;
		        	String s="";
		        	while(i<input.length() && input.charAt(i)!=' ') {
		        		len++;
		        		s+=input.charAt(i);
		        		i++;
		        	}
		        	if(len<min) {
		        		min=len;
		        		minStr=s;
		        	}
		        	i=i+1;
		        }
		        
		        
		        System.out.println(minStr);

		}

}
