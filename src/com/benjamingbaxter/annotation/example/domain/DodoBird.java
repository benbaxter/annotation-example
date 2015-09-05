package com.benjamingbaxter.annotation.example.domain;

// "value = " is optional and assumed by default but you may add it if you prefer
// you can just do @AnimalKey("dodo") instead
@AnimalKey(value = "dodo")
public class DodoBird implements Animal {
    @Override
    public String numberOfLegs() {
        return "The dodo has 2 legs but who cases since it is extinct";
    }
}
