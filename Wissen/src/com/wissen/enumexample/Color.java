package com.wissen.enumexample;

public enum Color {
	
	RED, GREEEN, BLUE, BLACK;
	
	private Color() {
		System.out.println("Constructor called for: " + this.toString());
	}
	
	public static void main(String[] args) {
		for(Color c : Color.values()) {
			System.out.println(c + " at index : " + c.ordinal());
		}
	}
}
