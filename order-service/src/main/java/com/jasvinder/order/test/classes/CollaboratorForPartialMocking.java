package com.jasvinder.order.test.classes;

public class CollaboratorForPartialMocking {

    public static String staticMethod() {
        return "Hello world!";
    }

    public final String finalMethod() {
        return "Hello world!";
    }

    private String privateMethod() {
        return "Hello world!";
    }

    public String privateMethodCaller() {
        return privateMethod() + " Welcome to the Java world.";
    }
}