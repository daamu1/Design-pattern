package org.design.structural;

// Target Interface
interface Printer {
    void print();
}

// Adapted
class LegacyPrinter {
    void printDocument() {
        System.out.println("Legacy Printer is printing a document.");
    }
}

// Adapter
class PrinterAdapter implements Printer {
    private final LegacyPrinter legacyPrinter;

    public PrinterAdapter() {
        this.legacyPrinter = new LegacyPrinter();
    }

    @Override
    public void print() {
        legacyPrinter.printDocument();
    }
}

// Client Code
public class AdapterDesignPattern {

    /*
    The Adapter design pattern is a structural pattern that allows the interface of an existing class to be used as another interface.
    It acts as a bridge between two incompatible interfaces, making them work together. This pattern involves a single class,
    known as the adapter, which is responsible for joining functionalities of independent or incompatible interfaces.
     */
    public static void clientCode(Printer printer) {
        printer.print();
    }

    public static void main(String[] args) {
        // Using the Adapter
        PrinterAdapter adapter = new PrinterAdapter();
        clientCode(adapter);
    }
    /*
    Adapter Design Pattern works by allowing two incompatible interfaces to work together. Here's how it simplifies the process:

    1. Client Request:
   - The client makes a request to the adapter using the target interface. It's like placing an order at a restaurant.

    2.Adapter Translation:
   - The adapter translates or converts the client's request into a format that the adapter understands. It's like translating your
    order into the language the chef understands.

    3.Adapted Execution:
   - The adapter, which has the necessary functionality, executes the request received from the adapter. It's like the chef preparing
   the dish based on the translated order.

    4.Result to Client:
   -The result of the execution is returned to the client through the adapter. The client remains unaware of the adapter's presence or
   the specific details of the adapter. It's like receiving your dish at the table without knowing the behind-the-scenes translation and
   cooking process.
     */
}
