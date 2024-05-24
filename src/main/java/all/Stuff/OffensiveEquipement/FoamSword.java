package all.Stuff.OffensiveEquipement;

import all.Stuff.OffensiveEquipment;
import all.hero.Hero;
import all.hero.Warrior;

public class FoamSword extends OffensiveEquipment {

    public FoamSword(){
        super("Épée","Épée en mousse",5);
    }


    @Override
    public void equipHero(Hero character) {
        if (character instanceof Warrior) {
            character.setOffensiveEquipment(this);
        }
    }

}
