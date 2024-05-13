package all.Stuff;

import all.hero.Hero;

public abstract class Consumable extends Items{
    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    private int heal;

    public Consumable(String type, String name, int heal) {
        super(type,name,heal);
        this.heal = heal;
    }

    @Override
    public void equipHero(Hero character) {
        character.setHealth(character.getHealth() + heal);
    }
}
