package all.Stuff.OffensiveEquipement;

import all.Stuff.OffensiveEquipment;
import all.hero.Hero;
import all.hero.Wizard;

public class EldritchStaff extends OffensiveEquipment {
    public EldritchStaff(){
        super("Catalyseur","Bâton mystique",30);
    }

    @Override
    public void equipHero(Hero character) {
        if (character instanceof Wizard) {
            character.setOffensiveEquipment(this);
        }
    }
}
