package callbacks_like_js;

import java.util.function.Consumer;

public class Callbacks {
    public static void main(String[] args) {
        hello("George", " ", callback -> {
            System.out.println("\nNo last name provided for " + callback);
        });

        hello("Fabio",
                "Akita",
                callback -> System.out.println("\nNo last name provided for " + callback));

        hello2("Ayrton",
                "Senna da Silva",
                () -> System.out.println("No last name provided"));
    }

    static void hello(String firstName, String lastName, Consumer<String> callback) {
        System.out.printf(firstName + " ");
        if (lastName.isEmpty() || lastName.isBlank()) {
            callback.accept(firstName);
        } else {
            System.out.println(lastName);
        }
    }

    static void hello2(String firstName, String lastName, Runnable callback) {
        System.out.printf(firstName + " ");
        if (lastName.isEmpty() || lastName.isBlank()) {
            callback.run();
        } else {
            System.out.println(lastName);
        }
    }


}


