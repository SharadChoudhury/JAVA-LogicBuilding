package Recursion;

//	1 <= |S| <= 10^3

public class RemoveX {

//	private static String removeX(String input,StringBuffer sb,int start){
//		if(input.charAt(start)!='x')
//			sb.append(input.charAt(start));
//		if(start==input.length()-1)
//			return sb.toString();
//		start+=1;
//		return removeX(input,sb,start);
//
//	}
//	
//	public static String removeX(String input){
//		// Write your code here
//		StringBuffer sb = new StringBuffer();
//		return removeX(input,sb,0);
//	}
	
	public static String removeX(String input) {
		//time: O(n)  space: O(n)
		if(input.length()==0)
			return "";
		if(input.charAt(0)=='x')
			return removeX(input.substring(1));
		return input.charAt(0)+ removeX(input.substring(1));
	}
	
	public static void main(String[] args) {
		System.out.println(removeX("xyuxdx"));
	}

}
