package com.benjamingbaxter.annotation.example.domain;


public class NullAnimal implements Animal {
    @Override
    public String numberOfLegs() {
        return "Animal is not in our zoo";
    }
}
