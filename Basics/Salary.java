package Basics;
// totalSalary = basic + hra + da + allow – pf
        
        /*hra   = 20% of basic
		da    = 50% of basic
		allow = 1700 if grade = ‘A’
		allow = 1500 if grade = ‘B’
		allow = 1300 if grade = ‘C' or any other character
		pf    = 11% of basic. */

import java.util.*;
import java.lang.Math;
public class Salary {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
        int basic = s.nextInt();
        char grade = s.next().charAt(0);
        float hra = 0.2f * basic;
        float da = 0.5f * basic;
        int allow;
        if(grade=='A') {
        	allow = 1700;
        }
        else if(grade=='B') {
        	allow = 1500;
        }
        else {
        	allow= 1300;
        }
        float pf = 0.11f * basic;
        int salary = Math.round(basic+hra+da+allow-pf);
        System.out.println(salary);
	}

}
