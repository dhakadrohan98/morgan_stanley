package com.wissen.bitmanipulation;

public class SetKBit {

	//left shift operator and OR operation
	public static void main(String[] args) {
		int n = 9;
		int k = 2;
		int second_desired_num = 1 << k;
		int res = n | second_desired_num;
		System.out.println(res);
		
		int n2 = 13;
		int k2 = 2;
		int second_desired_num2 = 1 << k2;
		int res2 = n2 | second_desired_num2;
		System.out.println(res2);

	}

}
