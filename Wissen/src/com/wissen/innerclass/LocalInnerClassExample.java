package com.wissen.innerclass;

class OuterClass3 {
	int outer_x = 10;
	static int outer_y = 20;
	private String outer_name = "Mike";

	public void print() {
		int non_final_block_level_j = 30;
		final int final_block_level_k = 40;
		
//------------------------------------------------------------------------------------------
		// Local inner class
		class Inner {
			public void display() {
				System.out.println("outer_x : " + outer_x);
				System.out.println("outer_y : " + outer_y);
				System.out.println("outer_name : " + outer_name);

				System.out.println("non_final_blok_level_j : " + non_final_block_level_j);
				System.out.println("non_final_block_level_j : " + final_block_level_k);
			}
		}
//-------------------------------------------------------------------------------------------------
		
		Inner inner = new Inner();
		inner.display();
	}

}

public class LocalInnerClassExample {

	public static void main(String[] args) {
		OuterClass3 outerClass = new OuterClass3();
		outerClass.print();
	}
}
