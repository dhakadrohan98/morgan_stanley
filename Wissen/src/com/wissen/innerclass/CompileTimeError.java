package com.wissen.innerclass;

//No compile error
class OuterClass2 {

	class InnerClass {

		static int x = 10;
		static void print() {}
	}
}

public class CompileTimeError {

	public static void main(String[] args) {
		OuterClass2 outerClass2Obj = new OuterClass2();
		OuterClass2.InnerClass innerClassObj = outerClass2Obj.new InnerClass();
	}

}
