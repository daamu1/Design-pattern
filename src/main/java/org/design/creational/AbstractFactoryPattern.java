package org.design.creational;

// Abstract Factory Interface
interface CarFactory {
    Car createCar();

    CarSpecification createSpecification();
}

// Abstract Product Interface for Cars
interface Car {
    void assemble();
}

// Abstract Product Interface for Car Specifications
interface CarSpecification {
    void display();
}

class SouthIndia implements CarFactory {
    @Override
    public Car createCar() {
        return new Jeep();
    }

    @Override
    public CarSpecification createSpecification() {
        return new JeepSpecification();
    }
}

class NorthIndia implements CarFactory {
    @Override
    public Car createCar() {
        return new Max();
    }

    @Override
    public CarSpecification createSpecification() {
        return new MaxSpecification();
    }
}

class Max implements Car {

    @Override
    public void assemble() {
        System.out.println("Mahindra max is Ready to Run");
    }
}

class MaxSpecification implements CarSpecification {
    @Override
    public void display() {
        System.out.println("Mahindra Max is 8 Seater and it is used in Hill Area");
    }
}

class Jeep implements Car {

    @Override
    public void assemble() {
        System.out.println("Jeep is Ready to Run");
    }
}

class JeepSpecification implements CarSpecification {
    @Override
    public void display() {
        System.out.println("Jeep is used in Plains Area");
    }
}

// Client Code
public class AbstractFactoryPattern {
    /*
    The Abstract Factory Pattern is a way of organizing how you create groups of things that are related to each other. It provides a set of
    rules or instructions that let you create different types of things without knowing exactly what those things are. This helps you keep
     everything organized and lets you switch between different types easily, following the same set of rules.

    Abstract Factory pattern is almost similar to Factory Pattern and is considered as another layer of abstraction over factory pattern.
    Abstract factory patterns work around a super-factory which creates other factories.
    Abstract factory pattern implementation provides us with a framework that allows us to create objects that follow a general pattern.
    So at runtime, the abstract factory is coupled with any desired concrete factory which can create objects of the desired type.
     */

    public static void main(String[] args) {
        //Creating max for North India
        CarFactory northIndiaFactory = new NorthIndia();
        Car max = northIndiaFactory.createCar();
        CarSpecification carSpecification = northIndiaFactory.createSpecification();

        // Assemble the max
        max.assemble();

        // Display max specification
        carSpecification.display();

        //Creating max for South India
        CarFactory southCarFactory = new SouthIndia();
        Car jeep = southCarFactory.createCar();
        CarSpecification jeepDescription = southCarFactory.createSpecification();

        //Assemble the Jeep
        jeep.assemble();

        //Display Jeep Specification
        jeepDescription.display();

    }
}
