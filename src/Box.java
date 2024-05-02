import Character.Character;
import Ennemies.Ennemies;

public class Box {
    private final int index;
    private Character character;
    private Ennemies ennemies;
    private MysteryBox mysteryBox;


    public Ennemies getEnnemies() {
        return this.ennemies;
    }

    public void setEnnemies(Ennemies ennemies) {
        this.ennemies = ennemies;
    }

    public MysteryBox getMysteryBox() {
        return this.mysteryBox;
    }

    public void setMysteryBox(MysteryBox mysteryBox) {
        this.mysteryBox = mysteryBox;
    }

    public Box(int index) {
        this.index = index;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Character getCharacter() {
        return this.character;
    }


    public String toString() {
        return this.index +"";
    }
}