package Basics;
import java.util.*;
public class char_pattern {
	public static void main(String[] args) {
		//Your code goes here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for(int i =1 ; i<=n ; i++){
            char c = (char)('A'+n-i);
            for(int j=1;j<=i;j++){
                System.out.print(c);
                c = (char)(c +1);
            }
            System.out.println();
        }
	}
}