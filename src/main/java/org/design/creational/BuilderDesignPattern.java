package org.design.creational;

// Product
class Computer {
    private String cpu;
    private String ram;
    private String storage;

    public void setCPU(String cpu) {
        this.cpu = cpu;
    }

    public void setRAM(String ram) {
        this.ram = ram;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public void displayInfo() {
        System.out.println("Computer Configuration:\nCPU: " + cpu + "\nRAM: " + ram + "\nStorage: " + storage + "\n");
    }
}

// Builder interface
interface Builder {
    void buildCPU();

    void buildRAM();

    void buildStorage();

    Computer getResult();
}

// ConcreteBuilder
class GamingComputerBuilder implements Builder {
    private final Computer computer = new Computer();

    @Override
    public void buildCPU() {
        computer.setCPU("Gaming CPU");
    }

    @Override
    public void buildRAM() {
        computer.setRAM("16GB DDR4");
    }

    @Override
    public void buildStorage() {
        computer.setStorage("1TB SSD");
    }

    @Override
    public Computer getResult() {
        return computer;
    }
}

// Director
class ComputerDirector {
    public void construct(Builder builder) {
        builder.buildCPU();
        builder.buildRAM();
        builder.buildStorage();
    }
}

// Client
public class BuilderDesignPattern {
    /*

    The Builder Design Pattern helps in creating complex objects step by step. It separates the construction of an object from
    its final representation, allowing the same construction process to create different types of objects.
    1. Product: The thing we want to build.
    2. Builder: The blueprint for building the product.
    3. ConcreteBuilder: The specific builder that puts the product together.
    4. Director: The manager that oversees the building process.
    5. Client: The one who starts the building process and gets the final product.

    When to use Builder Design Pattern:
    - For complex objects with many optional parts.
    - Step-by-step construction process.
    - To avoid constructors with too many parameters.
    - Creating immutable objects gradually.
    - Flexible object creation with different configurations.
    - Providing a common interface for multiple representations.

    When not to use Builder Design Pattern:
    - For simple object construction.
    - Performance-sensitive applications.
    - Immutable objects with final fields.
    - Increased code complexity.
    - Tight coupling with the product.

     */

    public static void main(String[] args) {
        GamingComputerBuilder gamingBuilder = new GamingComputerBuilder();
        ComputerDirector director = new ComputerDirector();
        director.construct(gamingBuilder);
        Computer gamingComputer = gamingBuilder.getResult();
        gamingComputer.displayInfo();
    }
}
