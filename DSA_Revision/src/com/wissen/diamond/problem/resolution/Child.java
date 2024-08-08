package com.wissen.diamond.problem.resolution;

interface Parent1 {
    default void show() {
        System.out.println("Parent1");
    }
}

interface Parent2 {
    default void show() {
        System.out.println("Parent2");
    }
}

class Child implements Parent1, Parent2 {
    @Override
    public void show() {
        // Resolving the diamond problem by specifying which parent's method to call
        Parent1.super.show();
        Parent2.super.show();
    }

    public static void main(String[] args) {
        Child child = new Child();
        child.show();
    }
}

