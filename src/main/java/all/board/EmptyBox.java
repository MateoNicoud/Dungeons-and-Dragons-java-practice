package all.board;

import all.Board;
import all.hero.Hero;

public class EmptyBox implements Box {
    private Hero character;
    @Override
    public String toString() {
        return Integer.toString(0);
    }

    @Override
    public void interaction(Hero character, Board board) {

    }

    @Override
    public Hero getCharacter() {
        return this.character;
    }

    @Override public void setCharacter(Hero character){
        this.character = character;
    }
}