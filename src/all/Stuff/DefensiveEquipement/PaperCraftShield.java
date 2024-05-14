package all.Stuff.DefensiveEquipement;

import all.Stuff.DefensiveEquipment;
import all.hero.Hero;
import all.hero.Warrior;

public class PaperCraftShield extends DefensiveEquipment {

    public PaperCraftShield() {
        super("Bouclier","Bouclier en papier mâché",3);
    }


    @Override
    public void equipHero(Hero character) {
        if (character instanceof Warrior) {
            character.setDefensiveEquipment(this);
        }
    }

}