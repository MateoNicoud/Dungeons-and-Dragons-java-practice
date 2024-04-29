import Character.Character;

public class Box {
    private final int index;
    private Character character;

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