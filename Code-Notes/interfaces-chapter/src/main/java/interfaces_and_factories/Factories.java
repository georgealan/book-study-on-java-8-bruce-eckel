package interfaces_and_factories;

/*
An interface is a gateway to multiple implementations, and a typical way to produce
objects that fit the interface is the Factory Method design pattern. Instead of calling a
constructor directly, you call a creation method on a factory object which produces an
implementation of the interface—this way, in theory, your code is completely isolated
from the implementation of the interface, thus making it possible to transparently
swap one implementation for another. Here’s a demonstration showing the structure
of the Factory Method:

Without the Factory Method, your code must somewhere specify the exact type of
Service created, to call the appropriate constructor.

 */

interface Service {
    void method1();
    void method2();
}

interface ServiceFactory {
    Service getService();
}

class Service1 implements Service {
    Service1() {} // Package access

    @Override
    public void method1() {
        System.out.println("Service1 method1");
    }

    @Override
    public void method2() {
        System.out.println("Service1 method2");
    }
}

class Service1Factory implements ServiceFactory {

    @Override
    public Service getService() {
        return new Service1();
    }
}

class Service2 implements Service {
    Service2() {} // Package access

    @Override
    public void method1() {
       System.out.println("Service2 method1");
    }

    @Override
    public void method2() {
        System.out.println("Service2 method2");
    }
}

class Service2Factory implements ServiceFactory {

    @Override
    public Service getService() {
        return new Service2();
    }
}

public class Factories {
    public static void serviceConsumer(ServiceFactory fact) {
        Service s = fact.getService();
        s.method1();
        s.method2();
    }

    public static void main(String[] args) {
        serviceConsumer(new Service1Factory());
        // Services are completely interchangeable
        serviceConsumer(new Service2Factory());
    }
}
