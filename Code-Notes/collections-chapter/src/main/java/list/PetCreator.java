package list;

import list.animals.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PetCreator extends Creator {
    // No try block needed.
    public static final
    List<Class<? extends Pet>> ALL_TYPES =
            Collections.unmodifiableList(Arrays.asList(
                    Pet.class, Dog.class, Cat.class, Rodent.class,
                    Mutt.class, Pug.class, EgyptianMau.class,
                    Manx.class, Cymric.class, Rat.class,
                    Mouse.class, Hamster.class));
    // Types for random creation:
    private static final
    List<Class<? extends Pet>> TYPES =
            ALL_TYPES.subList(
                    ALL_TYPES.indexOf(Mutt.class),
                    ALL_TYPES.size());
    @Override
    public List<Class<? extends Pet>> types() {
        return TYPES;
    }

    public static void main(String[] args) {
        System.out.println(TYPES);
        List<Pet> pets = new PetCreator().list(7);
        System.out.println(pets);
    }
}
/* Output:
[class reflection.pets.Mutt, class reflection.pets.Pug,
class reflection.pets.EgyptianMau, class
reflection.pets.Manx, class reflection.pets.Cymric, class
reflection.pets.Rat, class reflection.pets.Mouse, class
reflection.pets.Hamster]
[Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug]
*/
