package org.design.creational;

// Java program to demonstrate factory method design pattern
enum VehicleType {
    VT_TwoWheeler,
    VT_ThreeWheeler,
    VT_FourWheeler
}

abstract class Vehicle {
    abstract void run();
}

class TwoWheeler extends Vehicle {
    @Override
    void run() {
        System.out.println("Yamaha SZR is Running");
    }
}

class TheeWheeler extends Vehicle {
    @Override
    void run() {
        System.out.println("Tuktuk is Running");
    }
}

class FourWheeler extends Vehicle {

    @Override
    void run() {
        System.out.println("Hyundai i20 is Running");
    }
}

// Class Vehicle Factory with a single responsibility to
// construct Vehicles according to the clients requests.
// PS: This class can be extended to TwoWheelerFactory,
// ThreeWheelerFactory and so on.
public class FactoryMethod {
    /*
    The factory method is a creation design pattern, i.e., related to object creation. The Factory Method pattern is used to create objects
     without specifying the exact class of object that will be created. This pattern is useful when you need to decouple the creation of an
     object from its implementation.
     */

    /*
    The idea is to create a factory class with a single responsibility to create objects, hiding the details of class modules from the user.
    A factory pattern is one of the core design principles to create an object, allowing clients to create objects of a library(explained below)
    in a way such that it doesn’t have a tight coupling with the class hierarchy of the library.
     */

    Vehicle build(VehicleType vehicleType) {
        if (VehicleType.VT_FourWheeler.equals(vehicleType)) {
            return new FourWheeler();
        } else if (VehicleType.VT_TwoWheeler.equals(vehicleType)) {
            return new TwoWheeler();
        } else if (VehicleType.VT_ThreeWheeler.equals(vehicleType)) {
            return new TheeWheeler();
        } else {
            return null;
        }
    }

    // Client class. The client object will ask the factory to
// build vehicles.
    static class Client {
        private Vehicle pVehicle;

        Client() {
            pVehicle = null;
        }

        void BuildVehicle(VehicleType vehicleType) {
            FactoryMethod vf = new FactoryMethod();
            pVehicle = vf.build(vehicleType);
        }

        Vehicle getVehicle() {
            return pVehicle;
        }
    }

    static class Test {
        public static void main(String[] args) {
            Client client = new Client();
            client.BuildVehicle(VehicleType.VT_TwoWheeler);
            client.getVehicle().run();

            client.BuildVehicle(VehicleType.VT_ThreeWheeler);
            client.getVehicle().run();

            client.BuildVehicle(VehicleType.VT_FourWheeler);
            client.getVehicle().run();
        }
    }

}
