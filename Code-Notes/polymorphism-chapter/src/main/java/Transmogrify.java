/**
 * A better approach is to choose composition first, especially when it’s not obvious
 * which approach to use. Composition does not force a design into an inheritance
 * hierarchy. Composition is also more flexible because it’s possible to dynamically
 * choose a type (and thus behavior) when using composition, whereas inheritance
 * requires that an exact type be known at compile time.
 *
 * Dynamically changing the behavior of an object via composition (The "state" design pattern)
 */

class Actor {
    public void act() {}
}

class HappyActor extends Actor {
    @Override
    public void act() {
        System.out.println("HappyActor");
    }
}

class SadActor extends Actor {
    @Override
    public void act() {
        System.out.println("SadActor");
    }
}

/**
 * A Stage object contains a reference to an Actor, which is initialized to a HappyActor
 * object. This means performPlay() produces a particular behavior. Because a
 * reference can be re-bound to a different object at runtime, a reference for a SadActor
 * object can be substituted in actor, then the behavior produced by performPlay()
 * changes. Thus you gain dynamic flexibility at runtime. (This is also called the State
 * pattern). In contrast, you can’t decide to inherit differently at runtime; that must be
 * completely determined at compile time.
 */
class Stage {
    private Actor actor = new HappyActor();

    public void change() {
        actor = new SadActor();
    }

    public void performPlay() {
        actor.act();
    }
}

/**
 * A general guideline is “Use inheritance to express differences in behavior, and fields
 * to express variations in state.” In the preceding example, both are used; two different
 * classes are inherited to express the difference in the act() method, and Stage uses
 * composition to allow its state to be changed. Here, that change in state happens to
 * produce a change in behavior.
 */

public class Transmogrify {
    public static void main(String[] args) {
        Stage stage = new Stage();
        stage.performPlay();
        stage.change();
        stage.performPlay();
    }
}
