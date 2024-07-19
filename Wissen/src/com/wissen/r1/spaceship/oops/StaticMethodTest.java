package com.wissen.r1.spaceship.oops;

class Parent2 {
    
    static void staticMethod() {
        System.out.println("Static method in Parent");
    }
}

class Child2 extends Parent2 {
    static void staticMethod() {
        System.out.println("Static method in Child");
    }
}

public class StaticMethodTest {
    public static void main(String[] args) {
        Parent2.staticMethod();
        Child2.staticMethod();
        Parent2 parent = new Child2();
        parent.staticMethod();
    }
} 