package com.wissen.math;

import java.util.Random;

public class RandomMethodTest {

	public static void main(String[] args) {
		Random random = new Random();
	
		for(int i=0; i<100; i++) {
			int n =random.nextInt(3);
			System.out.println(n);
		}

	}

}
