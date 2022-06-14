package Strings;

public class StringStoragedemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1="abc";   // in string pool
		String str2="abc";	 // in string pool
		String str3=new String("abc");			// not in string pool
		
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		System.out.println(System.identityHashCode(str3));
		System.out.println(str1==str2);
		System.out.println(str1==str3);
		
		
	}

}
