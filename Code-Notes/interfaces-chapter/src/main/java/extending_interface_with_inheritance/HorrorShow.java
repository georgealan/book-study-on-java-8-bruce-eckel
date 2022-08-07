package extending_interface_with_inheritance;

/*
    Extending an interface with inheritance

    You can easily add new method declarations to an interface by using inheritance,
    and you can also combine several interfaces into a new interface with inheritance.
    In both cases you get a new interface
 */

interface Monster {
    void menace();
}

interface DangerousMonster extends Monster {
    void destroy();
}

interface Lethal {
    void kill();
}

class DragonZilla implements DangerousMonster {
    @Override
    public void menace() {}

    @Override
    public void destroy() {}
}

interface Vampire extends DangerousMonster, Lethal {
    void drinkBlood();
}

class VeryBadVampire implements Vampire {

    @Override
    public void menace() {}


    @Override
    public void destroy() {}


    @Override
    public void kill() {}


    @Override
    public void drinkBlood() {}

}

public class HorrorShow {
    static void u(Monster b) { b.menace(); }

    static void v(DangerousMonster d) {
        d.menace();
        d.destroy();
    }

    static void w(Lethal l) { l.kill(); }

    public static void main(String[] args) {
        DangerousMonster barney = new DragonZilla();
        u(barney);
        v(barney);

        Vampire vlad = new VeryBadVampire();
        u(vlad);
        v(vlad);
        w(vlad);
    }
}
