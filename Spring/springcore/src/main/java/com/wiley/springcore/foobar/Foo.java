package com.wiley.springcore.foobar;

public class Foo {
    private String message;

    
    private Foo(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    
    public static Foo createInstance(String message) {
        return new Foo(message);
    }
}