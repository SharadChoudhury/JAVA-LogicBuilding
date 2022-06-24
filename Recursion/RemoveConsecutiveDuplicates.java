package Recursion;

public class RemoveConsecutiveDuplicates {

	public static String removeConsecutiveDuplicates(String s) {
		//time:O(n)  space:O(n)
		if(s.length()<=1)
			return s;
		String small=removeConsecutiveDuplicates(s.substring(1));
		if(s.charAt(0)==small.charAt(0))
			return small;
		return s.charAt(0)+small;
	}
	
	public static void main(String[] args) {
		System.out.println(removeConsecutiveDuplicates("aapdgg"));
	}

}
