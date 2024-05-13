package all.board;

import all.Board;
import all.hero.Hero;

public class EmptyBox implements Box {

    @Override
    public String toString() {
        return Integer.toString(0);
    }

    @Override
    public void interaction(Hero character, Board board) {

    }
}