package org.design.structural;

// Subject
interface Image {
    void display();
}

// RealSubject
class RealImage implements Image {
    private final String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }

    public void loadImageFromDisk() {
        System.out.println("Loading image: " + filename);
    }

    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

// Proxy
class ProxyImage implements Image {
    private RealImage realImage;
    private final String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

public class ProxyDesignPattern {
    /*
    The Proxy Design Pattern acts as a substitute or placeholder for another object, allowing control over access
    to it. It's like having a middleman that regulates interactions with the real object.

    Think of a proxy like a debit card or a check: it stands in for your bank account and lets you access your
    money when needed, providing a layer of control over direct access to your funds.

    In essence, the Proxy Pattern manages access to the real object by intercepting requests and handling them
    appropriately. Just like a decorator pattern, proxies can be layered or chained together, giving the illusion
     to the client that they're interacting directly with the real object.
     */


    /*
    The Proxy Design Pattern simplifies access control, adds functionality, or optimizes performance by:
    - Lazy Loading: Delays object creation until needed for improved performance.
    - Access Control: Enforces security or permission checks.
    - Protection Proxy: Adds security layers to control access.
    - Caching: Stores and reuses results for faster operations.
    - Logging and Monitoring: Enables logging, tracking, or performance measurement.
     */

    public static void main(String[] args) {
        Image image = new ProxyImage("saurabh.jpg");

        // Image will be loaded from disk only when display() is called
        image.display();

        // Image will not be loaded again, as it has been cached in the Proxy
        image.display();
    }
}
