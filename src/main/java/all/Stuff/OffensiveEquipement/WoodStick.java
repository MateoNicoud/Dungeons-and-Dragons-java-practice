package all.Stuff.OffensiveEquipement;

import all.Stuff.OffensiveEquipment;
import all.hero.Hero;
import all.hero.Wizard;

public class WoodStick extends OffensiveEquipment {

    public WoodStick(){
        super("Catalyseur","Une brindille",3);
    }

    @Override
    public void equipHero(Hero character) {
        if (character instanceof Wizard) {
            character.setOffensiveEquipment(this);
        }
    }
}
