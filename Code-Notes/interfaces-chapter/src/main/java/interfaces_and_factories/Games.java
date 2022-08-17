package interfaces_and_factories;

/*
If the Games class represents a complex piece of code, this approach means you can
reuse that code with different types of games. You can imagine more elaborate games
that can benefit from this pattern.

In the next chapter, you’ll see a more elegant way to implement factories using
anonymous inner classes.
 */

interface Game { boolean move(); }
interface GameFactory { Game getGame(); }

class Checkers implements Game {
    public int moves = 0;
    private static final int MOVES = 3;

    @Override
    public boolean move() {
        System.out.println("Checkers move" + moves);
        return ++moves != MOVES;
    }
}

class CheckersFactory implements GameFactory {

    @Override
    public Game getGame() {
        return new Checkers();
    }
}

class Chess implements Game {
    private int moves = 0;
    private static final int MOVES = 4;

    @Override
    public boolean move() {
        System.out.println("Chess move " + moves);
        return ++moves != MOVES;
    }
}

class ChessFactory implements GameFactory {

    @Override
    public Game getGame() {
        return new Chess();
    }
}

public class Games {
    public static void playGame(GameFactory factory) {
        Game s = factory.getGame();
        while (s.move()){
            ;
        }
    }

    public static void main(String[] args) {
        playGame(new CheckersFactory());
        playGame(new ChessFactory());
    }
}
