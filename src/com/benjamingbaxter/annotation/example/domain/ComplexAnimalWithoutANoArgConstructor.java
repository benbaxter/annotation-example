package com.benjamingbaxter.annotation.example.domain;

@AnimalKey("complex")
public class ComplexAnimalWithoutANoArgConstructor implements Animal {

    private String name;
    private String numOfLegs;

    public ComplexAnimalWithoutANoArgConstructor(String name, String numOfLegs) {
        this.name = name;
        this.numOfLegs = numOfLegs;
    }

    @Override
    public String numberOfLegs() {
        return "A " + name + " has " + numOfLegs + " number of legs";
    }
}
