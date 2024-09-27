package com.wissen.innerclass;

class OuterClass {
//	static int outer_x = 10;
//	int outer_y = 20;
//	private int outer_z = 30;
	
	class InnerClass {
		
		static int y = 7; 
		
		static void print() {
//			System.out.println("outer_x " + outer_x);
//			System.out.println("outer_y " + outer_y);
//			System.out.println("outer_z " + outer_z);
		}
	}
}

public class NonStaticInnerClassEx {
	
	public static void main(String[] args) {
		OuterClass outerClassObj = new OuterClass();
		OuterClass.InnerClass innerClassObj = outerClassObj.new InnerClass();
		innerClassObj.print();
	}

}
