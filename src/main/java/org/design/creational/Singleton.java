package org.design.creational;

public class Singleton {
/*
The Singleton method or Singleton Design pattern is one of the simplest design patterns.
 It ensures a class only has one instance, and provides a global point of access to it.
 */

    private static Singleton singleton;

    private Singleton() {
        System.out.println("Hey Singleton how are you ?");
    }

    private static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    private String doSomething(String name) {
        return "Hey " + name + " do Something";
    }

    public static class Test
    {
        public static void main(String[] args) {
            Singleton singleton1=new Singleton();
            System.out.println(singleton1.doSomething("Saurabh"));
        }
    }
}
