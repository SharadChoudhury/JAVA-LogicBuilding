package Recursion;
/*
	 1 <= |S| <= 50
	where |S| represents the length of string S. 
*/


//method 1: take input as StringBuffer and replace pi with 3.14 with replace method

public class ReplacePi {

//	private static String replace(StringBuffer input,int start){	
//		
//		if(start>=input.length()-2) {			
//			if(input.substring(start, input.length()).equals("pi")) 	
//				input.replace(start, input.length(), "3.14");		
//			
//			return input.toString();	
//		}
//		
//		if(input.substring(start, start+2).equals("pi")) { //this line is a blunder if we use
//			// substring != "pi" as this compares the address of object and not the content, 
//			//so use .equals() method		
//			input.replace(start, start+2 , "3.14");
//			start+=2;
//		}
//		else
//			start+=1;
//		
//		return replace(input, start);
//	}
//	
//	
//	public static String replace(String input){
//		// Write your code here
//		StringBuffer sb = new StringBuffer(input);
//		return replace(sb ,0);		
//	}


// method 2: Improved
	
	public static String replace(String input) {
		//time: O(n)  space: O(n)
		if(input.length()<=1)
			return input;
		String small=replace(input.substring(1));
		if(input.charAt(0)=='p' && small.charAt(0)=='i')
			return "3.14"+small.substring(1);  			// since 'i' has to be removed from result
		return input.charAt(0)+small;
	}
	
	public static void main(String[] args) {		
		System.out.println(replace("xpiop"));
	}

}
