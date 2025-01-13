package org.recursion;

public class RecursionQuizesCP {

	private void fun6(int n) {
		//base case
		if(n == 0) return;
		fun6(n-1);
		for(int i=0; i < n; i++) {
			System.out.println(i);
		}
		fun6(n-1);
	}
	
	private void fun5(int n) {
		//base case
		if(n == 0) return;
		fun5(n/2);
		fun5(n/2);
		for(int i=0; i < n; i++) {
			System.out.println(i);
		}
	}
	
	private void fun4(int n) {
		if(n == 0) return;
		fun4(n/2);
		fun4(n/2);
	}
	
	private void fun3(int n) {
		if(n == 0) return;
		fun3(n/2);
	}
	
	private void fun2(int n) {
		if(n == 0) return;
		fun2(n-1);
		fun2(n-1);
	}
	
	private void fun1(int n) {
		if(n == 0) return;
		fun1(n-1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
