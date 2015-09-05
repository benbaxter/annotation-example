package com.benjamingbaxter.annotation.example.domain;

@AnimalKey("dog")
public class Dog implements Animal {

    @Override
    public String numberOfLegs() {
        return "A dog has 4 legs";
    }
}
