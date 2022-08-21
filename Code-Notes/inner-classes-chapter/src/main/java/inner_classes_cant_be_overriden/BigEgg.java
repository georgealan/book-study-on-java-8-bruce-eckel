package inner_classes_cant_be_overriden;

/*
    What happens when you create an inner class, then inherit from the enclosing class
    and redefine the inner class? That is, is it possible to override the entire inner
    class? This seems like a powerful concept, but overriding an inner class as if it
    were another method of the outer class doesn’t really do anything:
 */

class Egg {
    private Yolk y;
    protected class Yolk {
        public Yolk() {
            System.out.println("Egg.Yolk()");
        }
    }

    Egg() {
        System.out.println("New Egg()");
        y = new Yolk();
    }
}

/*
The zero-argument constructor is synthesized automatically by the compiler, and
this calls the base-class zero-argument constructor. You might think that, because a
BigEgg is created, the overridden version of Yolk is used, but this is not the case,
as you see from the output.
 */
public class BigEgg extends Egg {
    public class Yolk {
        public Yolk() {
            System.out.println("BigEgg.Yolk()");
        }
    }

    public static void main(String[] args) {
        new BigEgg();
    }

}
