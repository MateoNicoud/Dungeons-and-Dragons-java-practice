package all.Stuff;

import all.hero.Hero;

public abstract class Items {
    private String name;
    private String type;
    private final int power;

    public Items(String type, String name,int power) {
        this.name = name;
        this.type = type;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPower() {
        return this.power;
    }

    public abstract void equipHero(Hero character);
}
