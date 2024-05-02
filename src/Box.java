import Character.Character;
import Ennemies.Ennemies;

public interface Box {
    Ennemies getEnnemies();
    void setEnnemies(Ennemies ennemies);
    MysteryBox getMysteryBox();
    void setMysteryBox(MysteryBox mysteryBox);
    void setCharacter(Character character);
    Character getCharacter();
    int getIndex();
    String toString();
}