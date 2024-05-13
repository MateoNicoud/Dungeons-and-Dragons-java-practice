package all.board;

import all.Board;
import all.hero.Hero;

public interface Box {
//    Ennemies getEnnemies();
//    void setEnnemies(Ennemies ennemies);
//    MysteryBox getMysteryBox();
//    void setMysteryBox(MysteryBox mysteryBox);
//    void setCharacter(Character character);
//    Character getCharacter();
//    int getIndex();
//    String toString();

    void interaction(Hero character, Board board);
}