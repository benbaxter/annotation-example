package com.benjamingbaxter.annotation.example.domain;

@AnimalKey("whale")
public class Whale implements Animal {

    @Override
    public String numberOfLegs() {
        return "Whales do not have legs!";
    }
}
