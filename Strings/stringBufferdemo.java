package Strings;
import java.util.*;
public class stringBufferdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer("hello");
		int[] arr= {1, 2, 3, 9};
		System.out.println(Arrays.toString(arr));
		String str="hello";
		sb=sb.append(78.4);
		sb.append(false);
		sb.deleteCharAt(3);
		System.out.println(sb);
		System.out.println(String.valueOf(665659));
	}

}
