package oop2;

import oop1.Student;  // to access the public class Student from oop1 package

public class StudentUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s = new Student();
		s.roll= 45;
		System.out.println(s+" "+s.roll);
	}

}
