package com.wissen.innerclass;

//No compile error

//If you have static members in your Static Inner class then there is no need to create the inner class 
//object.

class OuterClass2 {

	class InnerClass {

		static int x = 10;
		static void print() {}
		
		public void sum(int a, int b) {
			System.out.println(a+b);
		}
	}
}

public class StaticMemberInStaticInnerClass {

	public static void main(String[] args) {
		OuterClass2 outerClass2Obj = new OuterClass2();
		OuterClass2.InnerClass innerClassObj = outerClass2Obj.new InnerClass();
		innerClassObj.sum(5, 7);
	}

}
