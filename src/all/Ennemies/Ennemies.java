package all.Ennemies;

import all.Board;
import all.Combat;
import all.board.Box;
import all.hero.Hero;


public abstract class Ennemies implements Box {
    private final String name;

    private int health;

    public Ennemies(String name, int attackPower, int health){
        this.name=name;
        this.attackPower=attackPower;
        this.health=health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    private int attackPower;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    @Override
    public void interaction(Hero character, Board board) {
        Combat combat = new Combat(this,character,board);

        character.setHealth(character.getHealth() - getAttackPower());
    }
}
