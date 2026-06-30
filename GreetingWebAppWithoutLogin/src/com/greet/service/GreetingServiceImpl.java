package com.greet.service;

import com.greet.model.Greeting;

public class GreetingServiceImpl implements GreetingService {

    private String prefix;

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public Greeting greet(String name) {
        return new Greeting(prefix + ", " + name + "!");
    }

    public void init() {
        System.out.println("GreetingService bean initialized");
    }

    public void destroy() {
        System.out.println("GreetingService bean destroyed");
    }
}