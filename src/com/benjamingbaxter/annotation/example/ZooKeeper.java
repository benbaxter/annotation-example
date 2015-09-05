package com.benjamingbaxter.annotation.example;

import com.benjamingbaxter.annotation.example.domain.*;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ZooKeeper {

    private static final String QUIT = "quit";

    private static final List<Class<? extends Animal>> animals = Arrays.asList(Dog.class, DodoBird.class, Whale.class, ComplexAnimalWithoutANoArgConstructor.class);

    public static void main(String[] args) {

        String input = "";
        while(! input.equals(QUIT)) {
            input = JOptionPane.showInputDialog("Input an animal to see how many legs they have. (type " + QUIT + " to exit)");
            //double check, if they hit quit, do not show any animal stuff
            if( ! input.equals(QUIT) ) {
                Animal animal = createAnimal(input);
                JOptionPane.showMessageDialog(null, animal.numberOfLegs());
            }
        }

    }

    private static Animal createAnimal(final String input) {
        Optional<Class<? extends Animal>> optional = animals.stream()
                .filter(c -> {
                    AnimalKey annotaion = c.getAnnotation(AnimalKey.class);
                    return annotaion.value().equals(input);
                }).findFirst();

        Animal animal;
        if( optional.isPresent() ) {
            Class<? extends Animal> animalClass = optional.get();
            try {
                //create an instance of the class assuming that the class has a no-arg constructor
                //if it does not have a no-arg constructor (like the complex animal) then it will
                //throw an exception.
                animal = animalClass.newInstance();
            } catch (InstantiationException | IllegalAccessException  e) {
                System.out.println("cannot create animal " + animalClass.getSimpleName());
                //because Animal is annotated with @FunctionalInterface and has only one method,
                //we can create a new animal class on the fly. This is called a lambda expression
                //Basically we are creating a dynamic animal only when we need to
                //the '()' represents the no-arg function we have, the '->' states do this for the numOfLegs()
                //method and lastly, since we have a one line method, we can just create our string
                //and java will know that is the returned value for the numOfLegs() method
                animal = () -> input + " is not wanting to come out and show us how many legs it has.";
            }
        } else {
            animal = new NullAnimal();
        }
        return animal;
    }
}
