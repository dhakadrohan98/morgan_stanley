package com.wissen.r1.spaceship;

class Parent111 {
    
    static void staticMethod() {
        System.out.println("Static method in Parent");
    }
}

class Child111 extends Parent111 {
    static void staticMethod() {
        System.out.println("Static method in Child");
    }
}

public class StaticMethodTest {
    public static void main(String[] args) {
    	Parent111.staticMethod();
    	Child111.staticMethod();
    	Parent111 parent = new Child111();
    	parent.staticMethod();
    }
    
}
