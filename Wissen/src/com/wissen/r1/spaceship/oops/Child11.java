package com.wissen.r1.spaceship.oops;

//class Parent {
//	
//    Parent (String s){
//        System.out.println("Parent Class Param  "+s);
//    }
//}

public class Child11 extends Parent {

    Child11 (){
        this("Constructor");
        System.out.println("Child Class Default Constructor");
    }

    Child11 (String s){
//    	super(s);
        System.out.println("Child Class Param Constructor "+s);
    }

    public static void main(String[] args) {
        Child11 obj = new Child11();
    }

}
