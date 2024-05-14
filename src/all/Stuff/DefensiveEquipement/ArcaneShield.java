package all.Stuff.DefensiveEquipement;

import all.Stuff.DefensiveEquipment;
import all.hero.Hero;
import all.hero.Wizard;

public class ArcaneShield extends DefensiveEquipment {

    public ArcaneShield() {
        super("Bouclier","Bouclier arcanique", 2);
    }


    @Override
    public void equipHero(Hero character) {
        if (character instanceof Wizard) {
            character.setDefensiveEquipment(this);
        }
    }
}
