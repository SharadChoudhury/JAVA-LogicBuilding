package Recursion;

public class StringToInteger {

//	private static int conv(StringBuffer input, int power){
//		if(power<=0)
//			return input.charAt(0)-'0';
//		return (input.charAt(0)-'0')*(int)Math.pow(10,power) + conv(input.deleteCharAt(0),power-1);
//	}
//	
//	public static int convertStringToInt(String input){
//		// Write your code here		
//		StringBuffer sb = new StringBuffer(input);
//		int len = sb.length();
//		if(len>0)
//			return conv(sb,len-1);
//		else							//imp test case when String is empty --> return 0;
//			return 0;
//	}

	//without using string buffer
	public static int convertStringToInt(String input) {
		if(input.length()==0)
			return 0;
		if(input.length()==1)
			return input.charAt(0)-'0';
		int smallans=convertStringToInt(input.substring(0, input.length()-1));
		return smallans*10 + input.charAt(input.length()-1)-'0';
	}
	
	public static void main(String[] args) {
		System.out.println(convertStringToInt(""));
	}

}
