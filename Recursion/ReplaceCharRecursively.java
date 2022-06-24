package Recursion;
/*
 * Given an input string S and two characters c1 and c2, you need to replace every occurrence 
 * of character c1 with character c2 in the given string.
 *     1 <= Length of String S <= 10^6
 */
public class ReplaceCharRecursively {
	//time:O(n)			space:O(n)
	public static String replaceCharacter(String input, char c1, char c2) {
		if(input.length()==0)
			return input;
		if(input.charAt(0)==c1)
			return c2 + replaceCharacter(input.substring(1),c1,c2);
		return input.charAt(0) + replaceCharacter(input.substring(1),c1,c2);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(replaceCharacter("dahaags", 'a', 'x'));
	}

}
