import Character.Character;
import Ennemies.*;

public class DefaultBox implements Box {
    private final int index;
    private Character character;
    private Ennemies ennemies;
    private MysteryBox mysteryBox;

    public DefaultBox(int index) {
        this.index = index;
    }

    public Ennemies getEnnemies() {
        return ennemies;
    }

    public void setEnnemies(Ennemies ennemies) {
        this.ennemies = ennemies;
    }

    public MysteryBox getMysteryBox() {
        return mysteryBox;
    }

    public void setMysteryBox(MysteryBox mysteryBox) {
        this.mysteryBox = mysteryBox;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Character getCharacter() {
        return character;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return Integer.toString(index);
    }
}