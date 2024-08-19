package com.wissen.string;

public class SplitStringMethodExamples {

	public static void main(String[] args) {
		String str = "/a/b/c";
		String[] split = str.split("/");
		for(String s : split) {
			System.out.print(s +" ");
		}

	}

}
