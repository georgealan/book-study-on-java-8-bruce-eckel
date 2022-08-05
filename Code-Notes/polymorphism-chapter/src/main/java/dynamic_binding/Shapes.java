package dynamic_binding;

import java.util.Random;

class Shape {
    public void draw() {};
    public void erase() {};
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Circle draw()");
    }

    @Override
    public void erase() {
        System.out.println("Circle erase()");
    }
}

class Square extends Shape {
    @Override
    public void draw() {
        System.out.println("Square draw()");
    }

    @Override
    public void erase() {
        System.out.println("Square erase()");
    }
}

class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Triangle draw()");
    }

    @Override
    public void erase() {
        System.out.println("Triangle erase()");
    }
}

class RandomShapes {
    private Random rand = new Random(47);

    public Shape get() {
        switch (rand.nextInt(3)) {
            default:
            case 0: return new Circle();
            case 1: return new Square();
            case 2: return new Triangle();
        }
    }

    public Shape[] array(int sz) {
        Shape[] shapes = new Shape[sz];

        for (int i = 0; i < shapes.length; i++) {
            shapes[i] = get();
        }
        return shapes;
    }
}

/**
 * Now you know you have Shapes, but you don’t know anything more specific
 * (and neither does the compiler). However, when you step through this array and call draw()
 * for each one, the correct type-specific behavior magically occurs,
 * as you see from the output when you run the program.
 *
 * The point of creating the shapes randomly is to drive home the understanding that
 * the compiler can have no special knowledge that allows it to make the correct calls
 * at compile time. All the calls to draw() must be made through dynamic binding.
 */
public class Shapes {
    public static void main(String[] args) {
        RandomShapes gen = new RandomShapes();

        for (Shape shape : gen.array(9)) {
            shape.draw();
        }
    }
}
