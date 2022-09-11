package operators;

class Dog {
    String name;
    String says;

    Dog(String name, String says) {
        this.name = name;
        this.says = says;
    }

    void getDog() {
        System.out.println(name + " says " + says);
    }
}

public class E05_Dogs {
    public static void main(String[] args) {
        Dog dog1 = new Dog("spot", "Ruff!");
        Dog dog2 = new Dog("scruffy", "Wurf!");
        Dog dog3 = dog1;

        dog1.getDog();
        dog2.getDog();
        dog3.getDog();

        System.out.println("\nComparing dog1 and dog3 Objects");
        System.out.println("dog1 == dog3: " + (dog1 == dog3));
        System.out.println("dog1 equals dog3: " + dog1.equals(dog3) + "\n");

        System.out.println("Comparing Objects.name");
        System.out.println("dog1.name equals dog3.name: " + (dog1.name.equals(dog3.name)) + "\n");

        System.out.println("Comparing Objects.says");
        System.out.println("dog1.says equals dog3.says: " + (dog1.says.equals(dog3.says)) + "\n");

        System.out.println("\nComparing dog2 and dog3 Objects");
        System.out.println("dog2 == dog3: " + (dog2 == dog3));
        System.out.println("dog2 equals dog3: " + dog2.equals(dog3) + "\n");

        System.out.println("Comparing Objects.name");
        System.out.println("dog2.name equals dog3.name: " + (dog2.name.equals(dog3.name)) + "\n");

        System.out.println("Comparing Objects.says");
        System.out.println("dog2.says equals dog3.says: " + (dog2.says.equals(dog3.says)) + "\n");
    }
}

/*
TODO
 ****************** Exercise 5 *****************
 * Create a class called Dog with two Strings:
 * name and says. In main(), create two dogs,
 * "spot" who says, "Ruff!", and "scruffy" who
 * says, "Wurf!". Then display their names and
 * what they say.
 * Following Exercise 5 assign, a new Dog
 * reference to spot's object. Test for comparison
 * using == and equals() for all references.
 ***********************************************
 */
